import java.util.Scanner;
import java.util.ArrayList;
public class CalculArees{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
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
		
		String EleccioFigura = "";
		boolean Esta_a_la_llista = false;
		do{
			 EleccioFigura = (scan.next()).toLowerCase();
			 Esta_a_la_llista = ListaFiguras.contains(EleccioFigura.toLowerCase());
		}
		while(!Esta_a_la_llista);

		double base_petita = 0;
		double base_gran = 0;
		double altura = 0;
		double radi = 0;
		if(EleccioFigura.equals("triangle")){
			base_gran = NoErrorInput(scan);
			altura = NoErrorInput(scan);
			System.out.println(Triangle(base_gran, altura));
		}
		else if(EleccioFigura.equals("quadrat")){
			base_gran = NoErrorInput(scan);
			altura = NoErrorInput(scan);
			System.out.println(BasexAltura(base_gran, altura));
		}
		else if(EleccioFigura.equals("rectangle")){
			base_gran = NoErrorInput(scan);
			altura = NoErrorInput(scan);
			System.out.println(BasexAltura(base_gran, altura));
		}
		else if(EleccioFigura.equals("rombe")){
			base_gran = NoErrorInput(scan);
			altura = NoErrorInput(scan);
			System.out.println(BasexAltura(base_gran, altura));
		}
		else if(EleccioFigura.equals("paralelogram")){
			base_gran = NoErrorInput(scan);
			altura = NoErrorInput(scan);
			System.out.println(BasexAltura(base_gran, altura));
		}
		else if(EleccioFigura.equals("cercle")){
			radi = NoErrorInput(scan);
			System.out.println(Cercle(radi));
		}
		else if(EleccioFigura.equals("trapezi")){
			base_petita = NoErrorInput(scan);
			base_gran = NoErrorInput(scan);
			altura = NoErrorInput(scan);
			System.out.println(Trapezi(base_petita, base_gran, altura));
		}	
	}

	public static double BasexAltura(double Base, double Altura){
		return (Base * Altura);
	}
	public static double Triangle(double Base, double Altura){
		return ((Base*Altura)/2);
	}
	public static double Cercle(double radi){
		return (radi*radi*3.14);
	}
	public static double Trapezi(double BasePetita, double BaseGran, double Altura){
		return (((BaseGran + BasePetita)*Altura)/2);
	}

	public static double NoErrorInput(Scanner scan){
        double valor = 0;
        boolean novalid = true;
        do{
            try{
                System.out.print("Introdueix un valor: ");
                String numerointroduit = scan.nextLine();
                valor = Double.parseDouble(numerointroduit);
                novalid = false;
            }

            catch(NumberFormatException ex){
                    System.out.println("valor no valid");
            } 
        }
        while(novalid);
        return valor;
    }
}