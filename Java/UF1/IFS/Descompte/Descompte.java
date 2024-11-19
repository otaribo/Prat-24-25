import java.util.Scanner;
public class Descompte{
	public static void main(String[] args){
		double descompte = 0.15;
		double preuminim = 30;
		Scanner preuintoduit = new Scanner(System.in);
		System.out.println("Introdueix el preu: ");
		double preu = preuintoduit.nextDouble();
		
		if (preu < preuminim){
			System.out.println("No hi ha descompte el preu es " + preu);
		}else{
			double preufinal = preu-preu*descompte;
			System.out.println("El preu final es " + preufinal);
		}
	}
}