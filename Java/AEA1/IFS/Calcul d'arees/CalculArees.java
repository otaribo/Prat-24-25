import java.util.Scanner;
import java.util.ArrayList;
public class CalculArees{
	static void scan() {
		Scanner Scan = new Scanner(System.in);
		String Scanned = Scan.next();
	}
	
	public static void main(String[] args){
		
	ArrayList<String> ListaFiguras = new ArrayList<String>();
	ListaFiguras.add("triangle");
	ListaFiguras.add("quadrat");
	ListaFiguras.add("rectangle");
	ListaFiguras.add("trapezi");
	ListaFiguras.add("rombe");
	ListaFiguras.add("paralelogram");
	ListaFiguras.add("cercle");
	
	//Aqui mostro les diferentes opcions a elegir i guardo la que es seleccionada a la variable EleccioFigura
	System.out.println("Selecciona una figura:\nTriangle\nQuadrat\nRectangle\nTrapezi\nRombe\nParalelogram\nCercle");
	Scanner ScanEleccioFigura = new Scanner(System.in);
	String EleccioFigura = ScanEleccioFigura.next();
	
	boolean Esta_a_la_llista = ListaFiguras.contains(EleccioFigura.toLowerCase());
	
	if (Esta_a_la_llista == true){
		System.out.println("Has seleccionat: " + EleccioFigura.toLowerCase());
			if (EleccioFigura == ("triangle")){
				System.out.println("Introdueix la base:");
				Scanner ScanBase = new Scanner(System.in);
				double Base = ScanBase.nextDouble();
				System.out.println("Introdueix la altura:");
				Scanner ScanAltura = new Scanner(System.in);
				double Altura = ScanAltura.nextDouble();
			}
			else if (EleccioFigura == ("quadrat")||EleccioFigura == ("rombe")||EleccioFigura == ("rectangle")||EleccioFigura == ("trapezi")){
				System.out.println("Introdueix la base:");
				Scanner ScanBase = new Scanner(System.in);
				double Base = ScanBase.nextDouble();
				System.out.println("Introdueix la altura:");
				Scanner ScanAltura = new Scanner(System.in);
				double Altura = ScanAltura.nextDouble();
			}
			else if (EleccioFigura == ("paralelogram")){
				
			}
			else if (EleccioFigura == ("cercle")){
				
			}
	}
		else {
				System.out.println("tus muertos a caballo, no funciona");
		}
	
	}
}