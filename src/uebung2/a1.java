package uebung2;
import java.util.Scanner; // makes scanner useable in this class
public class a1 {

    public static void main(String[] args) { // main method
    Scanner bin = new Scanner(System.in);    // new scanner
    System.out.println("Bitte eine ganze Zahl eingeben um sie in Binaer umgewandelt zu bekommen"); //input
    int zahl = bin.nextInt(); //uses the input, assigns varable
    System.out.println("das Ergebnis ist binaer "+berechneBin(zahl));
    System.out.println("der Gray code ist "+berechneGray(zahl));
    }
    // how to make it recursive, assingning the zahl variable again and again till a zero is reached
    static String dec2bin(int dez){
        String result= new String("");
        if (dez != 0)
        {
            result= dec2bin(dez>>>1)+(dez&1); 
        }
        return result;
    }
    static String berechneBin(int dez){
        return dez==0? "0" : dec2bin(dez);
    }
    static String berechneGray(int dez){
        return berechneBin(dez ^ dez>>>1);
    }
}
