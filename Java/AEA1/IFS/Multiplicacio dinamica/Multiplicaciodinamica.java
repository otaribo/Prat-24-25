import java.util.Scanner;
public class Multiplicaciodinamica{
	public static void main(String[] args){
		Scanner escaneo1 = new Scanner(System.in);
		System.out.println("Introdueix el primer numero");
		double numero1 = escaneo1.nextDouble();
		
		Scanner escaneo2 = new Scanner(System.in);
		System.out.println("Introdueix el segon numero");
		double numero2 = escaneo2.nextDouble();

		
		double resultado = numero1*numero2;
	System.out.println("El resultado es " + resultado);
	}
}