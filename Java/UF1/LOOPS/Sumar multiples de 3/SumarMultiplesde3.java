import java.util.Scanner;
public class SumarMultiplesde3{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int ResultatFinal = 0;
		//iniciem el bucle que mante l'activitat activa.
		boolean activitat_Activa = true;
		while (activitat_Activa) {
			//li demane al usuari que introdueixi el nombre fins el que vol contar
			System.out.println("Introdueix el valor fins el que es tenen de sumar multiples de 3: ");
			String Limit = scan.nextLine();
			try{
				int limitInt = Integer.parseInt(Limit);
				//iniciem el bucle que es repetira fins arribar al numero desitjat
				for (int i=0;i<=limitInt;i+=3) {
				System.out.println("Afegim " + i);
				ResultatFinal = ResultatFinal + i;
				}
				System.out.println("El resultat final es " + ResultatFinal);
				//preguntem al usuari si vol continuar amb l'aplicacio
				System.out.println("\nVols continuar: y/n");
				String respostaContinuar = scan.nextLine();
				if (respostaContinuar.equals("y")||respostaContinuar.equals("yes")){
					activitat_Activa = true;
				}
				else{
					activitat_Activa = false;
				}
			}
			//control d'errors
			catch (NumberFormatException ex) {
				System.out.println("Selecciona un nombre enter valid:");
			}
		}
	}
}