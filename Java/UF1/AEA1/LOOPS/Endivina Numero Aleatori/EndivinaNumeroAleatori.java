import java.util.Scanner;
import java.util.Random;
public class EndivinaNumeroAleatori {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		boolean activitatActiva = true;
		boolean encertat = true
		boolean error = true;
		int seleccioUsuari = 0;
		while (activitatActiva){
			int numeroRandom = random.nextInt(10)+1;
			System.out.println(numeroRandom);
			do{
				do{
					try{
						System.out.print("Introdueix un numero: ");
						seleccioUsuari = scan.nextInt();
						error = false;
					}catch(Exception e){
						System.out.print("Introdueix un numero: ");
						seleccioUsuari = scan.nextInt();
					}
				}while(error);
				
				if (seleccioUsuari == numeroRandom){
				System.out.println("Enhorabona has encertat el numero: " + numeroRandom);
				activitatActiva = false;
				}
				
			}while(encertat);
		}
	}
}