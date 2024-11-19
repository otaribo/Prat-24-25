import java.util.Scanner;
public class AreaTriangle {
  public static void main (String args[]){
	
	//Aqui guardo a dins de la variable BaseTriangle el valor obtingut a traves del primer scan	
    Scanner ScanBaseTriangle = new Scanner(System.in);
	System.out.println("Introdueix el valor de la base del triangle: ");
	double BaseTriangle = ScanBaseTriangle.nextDouble();
	
	//Aqui guardo a dins de la variable AlturaTriangle el valor obtingut a traves del segon scan	
	Scanner ScanAlturaTriangle = new Scanner(System.in);
	System.out.println("Introdueix el valor de la altura del triangle: ");
	double AlturaTriangle = ScanAlturaTriangle.nextDouble();
	
	//Aqui faig l'operació per calcular l'area del triangle a partir dels valors proporcionats per l'usuari
	double Resultat = (BaseTriangle*AlturaTriangle)/2;
    //Imprimim a la terminal el calcul
	System.out.println("La area del triangle és: " + Resultat);
  }
}
