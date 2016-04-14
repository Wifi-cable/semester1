//package uebung2;
import java.util.Scanner; // makes scanner useable in this class
public class a1 {

	public static void main(String[] args) { // main method
	Scanner bin = new Scanner(System.in);	 // new scanner
	System.out.println("Bitte eine ganze Zahl eingeben um sie in Binaer umgewandelt zu bekommen"); //input
	int zahl = bin.nextInt(); //uses the input, assigns varable
	System.out.println("das Ergebnis ist "+berechneBin(zahl));
	}
	// how to make it recursive, assingning the zahl variable again and again till a zero is reached
	static String berechneBin(int dez){
		String result= new String("");
        if (dez > 0)
        {
            result= berechneBin(dez>>1)+(dez&1); 
        }
        return result;
	}
}
