/**
 * 
 */
package uebung3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner; // makes scanner useable in this class

/**
 * @author cmaier
 *
 */
public class Tsp {
    static String browser= "firefox";
    SecureRandom random= new SecureRandom();
    private int cities;
    private double distances[][];
    private int[] tour;

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        Tsp route= new Tsp();
        Scanner bin = new Scanner(System.in);
        System.out.print("Wie viele Städte? ");
        int cities = bin.nextInt(); //uses the input, assigns varable
        bin.close();
        route.distMatrixInit(cities);
        route.distMatrixFill();
        route.distMatrixPrint();
        File feile = File.createTempFile("entfernungen", ".txt");
        route.distMatrixPrint(feile);
        System.out.println("Entfernungstabelle nach "+ feile.getCanonicalPath() +" exportiert");
        String[] arguments= new String[] {browser, feile.getCanonicalPath()};
        Runtime runtime= Runtime.getRuntime();
        runtime.exec(arguments);
        System.out.println(browser +" gestartet");
        route.tourInit();
        System.out.print("seeded ");
        route.tourPrint();
        int verbosity= 1 | 4;   // print accepted swaps and inverse temperature
        int[] shortest= route.anneal(0.4, 100.0, 1000, verbosity);
        System.out.println("End result of annealing");
        route.tourPrint();
        System.out.println("Kürzeste Tour");
        route.tourPrint(shortest,true);
    }

    public double getDistance(int from, int to)
    {
        double distance;
        if (from == to)
            distance= 0.0;
        else
        {
            int lo= Math.min(from, to);
            int hi= Math.max(from, to)-lo-1;
            distance= distances[lo][hi];
        }
        return distance;
    }    
    public double getDistance(int[] path)
    {
        int pathlength= path.length;
        double distance= getDistance(path[pathlength-1],0);
        for (int station= 0; station<pathlength-1; station++)
        {
            distance+= getDistance(path[station],path[station+1]);
        }
        return distance;
    }
    
    public void swapCities(int[] tour, int city1, int city2)
    {
        int c= tour[city2];
        tour[city2]= tour[city1];
        tour[city1]= c;
    }
    public void swapCities(int[] tour)
    {
        int city1= random.nextInt(tour.length);
        int city2= random.nextInt(tour.length-1);
        if (city2 >= city1)
            city2+= 1;
        swapCities(tour, city1, city2);
    }

    public boolean anneal(int[] tour, double beta, int verbosity)
    {
        int[] newtour= Arrays.copyOf(tour, tour.length);
        swapCities(newtour);
        double difference= getDistance(tour)-getDistance(newtour);
        boolean accept= difference>0 || Math.exp(beta*difference)>random.nextDouble();
        if (accept)
        {
            System.arraycopy(newtour, 0, tour, 0, tour.length);
            if ((1 & verbosity) != 0)
            {
                if ((4 & verbosity) != 0)
                {
                    System.out.printf("beta=%8.4f: ", beta);
                }
                System.out.print("accept ");
                tourPrint(newtour, true);
            }
        }
        else if ((2 & verbosity) != 0)
        {
            if ((4 & verbosity) != 0)
            {
                System.out.printf("beta=%8.4f: ", beta);
            }
            System.out.print("reject ");
            tourPrint(newtour, true);
        }
        return accept;
    }
    public int[] anneal(double betastart, double betaend, int iterations, int verbosity)
    {
        int[] shortest= Arrays.copyOf(tour, tour.length);
        double shortestTour= getDistance(shortest);
        if (betastart > betaend)
        {
            double betaswap= betastart;
            betastart= betaend;
            betaend= betaswap;
        }
        double betastep= (betaend-betastart)/iterations;
        for (double beta=betastart; beta<betaend; beta+=betastep)
        {
            if (anneal(tour, beta, verbosity))
            {
                double newdist= getDistance(tour);
                if (newdist < shortestTour)
                {
                    System.arraycopy(tour, 0, shortest, 0, tour.length);
                    shortestTour= newdist;
                }
            }
        }
        return shortest;
    }

    public void distMatrixInit(int cities)
    {
        this.cities= cities;
        distances= new double[cities-1][];
        for (int city=0; city<this.cities-1; city++)
        {
            distances[city]= new double[--cities];
        }
    }

    public void distMatrixFill()
    {
        for (int x= 0; x<distances.length; x++)
            for (int y= 0; y<distances[x].length; y++)
                distances[x][y]= random.nextDouble();                
    }

    public void distMatrixPrint()
    {
        for (int x= 0; x<cities; x++)
        {
            for (int y= 0; y<cities; y++)
            {
                System.out.printf("d(%d,%d)=%6.4f\t", x, y, getDistance(x,y));
            }
            System.out.print("\n");
        }
    }
    public void distMatrixPrint(File file) throws FileNotFoundException
    /*
     * see http://www.homeandlearn.co.uk/java/write_to_textfile.html
     */
    {
        PrintWriter table= new PrintWriter(file);
        for (int x= 0; x<cities; x++)
        {
            for (int y= 0; y<cities; y++)
            {
                table.printf("d(%2d,%2d)=%6.4f\t", x, y, getDistance(x,y));
            }
            table.print("\n");
        }
        table.flush();
        table.close();
    }

    public int[] tourInit(int length)
    {
        double[] test= distances[length-2]; // this will fail if (length > cities)
        int[] tour= new int[length];
        boolean[] occupied= new boolean[length];
        for (int i= 0; i<length; i++)
            occupied[i]= false;
        for (int station= 0; station<length; station++)
        {
            int city;
            do
            {
                city= random.nextInt(cities);                
            }
            while (occupied[city]);
            occupied[city]= true;
            tour[station]= city;
        }
        return tour;
    }
    public void tourInit()
    {
        tour= tourInit(cities);
    }

    public void tourPrint(int[] tour, boolean printDist)
    {
        System.out.print("(");
        for (int station= 0; station<tour.length; station++)
        {
            System.out.print(tour[station]);
            System.out.print(", ");
        }
        System.out.print(tour[0]);
        System.out.print(")");
        if (printDist)
        {
            System.out.printf(", Strecke=%7.4f", getDistance(tour));
        }
        System.out.print('\n');
    }
    public void tourPrint(boolean printDist)
    {
        tourPrint(tour, printDist);
    }
    public void tourPrint()
    {
        tourPrint(true);
    }
}
