package uebung2;
import java.util.Scanner; // makes scanner useable in this class
public class a1 {
    static String digits= new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public static void main(String[] args) { // main method
        Scanner bin = new Scanner(System.in);    // new scanner
        System.out.println("Bitte eine ganze Zahl eingeben um sie in Binaer umgewandelt zu bekommen"); //input
        int zahl = bin.nextInt(); //uses the input, assigns varable
        System.out.println("das Ergebnis ist binaer   "+berechneBin(zahl));
        System.out.println("der binaere Gray code ist "+berechneGray(zahl));
        System.out.println("das Ergebnis ist hexadezimal "+berechneHex(zahl));

        System.out.println("And now ...\nfor Something Completely Different");
        Int2Digits[] converters = new Int2Digits[] {
                new Int2Digits(2),
                new Int2Digits(4),
                new Int2Digits(5),
                new Int2Digits(8),
                new Int2Digits(10),
                new Int2Digits(16),
                new Int2Digits(36)
        };
        for (Int2Digits converter : converters )
        {
            System.out.println("The number "+
                zahl+
                " in base "+
                converter.getBase()+
                " is "+
                converter.int2string(zahl));
            System.out.println(" "+
                zahl+ 
                " in base "+
                converter.getBase()+
                " Gray code is "+
                converter.digitArray2string(converter.digitArray2Gray(converter.int2digitArray(zahl))));
        }
    }
    // how to make it recursive, assingning the zahl variable again and again till a zero is reached
    static String dec2bin(int dez)
    {
        String result= new String("");
        if (dez != 0)
        {
            result= dec2bin(dez>>>1)+(dez&1); 
        }
        return result;
    }
    static String berechneBin(int dez)
    {
        return dez==0? "0" : dec2bin(dez);
    }
    static String dec2hex(int dez)
    {
        String result= new String("");
        if (dez != 0)
        {
            result= dec2hex(dez>>>4)+digits.charAt(dez&15);
        }
        return result;
    }
    static String berechneHex(int dez)
    {
        return dez==0? "0" : dec2hex(dez);
    }
    static String berechneGray(int dez)
    {
        return berechneBin(dez ^ dez>>>1);
    }
}
