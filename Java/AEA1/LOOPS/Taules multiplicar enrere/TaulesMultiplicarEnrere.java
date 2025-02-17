import java.util.Scanner;
public class TaulesMultiplicarEnrere{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//Aquest while es per mantenir la activita activa
		boolean activitat_Activa = true;
		while (activitat_Activa) {
			//fem un clean que estara desactivat per fer les comprovacions de l'activitat
			//System.out.print("\033[H\033[2J");
			//li demanem al usuari que introdueixi un nombre enter
			System.out.println("Introdueix el nombre enter del que vols la taula de multiplicar:");
			String numeroSeleccionat = scan.nextLine();
			try{
				//comprovem que el numero introduit per l'usuari es un int  i el guardem a la variable numeroSeleccionatInt
				int numeroSeleccionatInt = Integer.parseInt(numeroSeleccionat);
				//fem un loop que es repeteixi 10 cops, un per cada una de les taules de multiplicar
				for(int i=10;i>=1;i--) {
					//fem un print amb la taula de multiplicar
					System.out.println(numeroSeleccionatInt + " * " + i + " = " + (numeroSeleccionatInt*i));
				}
				//apaguem el bucle de l'activitat
				activitat_Activa = false;
				//preguntem al usuari si vol continuar
				System.out.println("\nVols continuar: y/n");
				String respostaContinuar = scan.nextLine();
				if (respostaContinuar.equals("y")||respostaContinuar.equals("yes")){
					activitat_Activa = true;
				}
				else{
					activitat_Activa = false;
				}
			}
			//si el numero enter per l'usuari no es valid fem que el torni a introduir
			catch (NumberFormatException ex) {
				System.out.println("Selecciona un nombre enter valid:");
			}
		}
	}
}