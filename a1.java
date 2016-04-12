package uebung2;
import java.util.Scanner; // makes scanner useable in this class
public class a1 {

	public static void main(String[] args) { // main method
	Scanner bin = new Scanner(System.in);	 // new scanner
	System.out.println("Bitte eine ganze zahl eingeben um sie in Binär umgewandelt zu bekommen"); //input
	int zahl = bin.nextInt(); //uses the input, assigns varable
	berechneBin(zahl);
	}
	public static void berechneBin(int dez){
		
	// how to make it recursive, assingning the zahl variable again and again till a zero is reached?
	int rest= (dez %2);
	int ergebniss = dez/2;//divides input by 2 and checks for a rest.
	if (dez% 2==1){  // checks for rest
		System.out.print(1); //shows a 1 if there is a rest
	}
	
		else{
		System.out.print(0);	//shows  a zero if no rest
		}
	System.out.println("das ist das"+ ergebniss); 

	}

}
