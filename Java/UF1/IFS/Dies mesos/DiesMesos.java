import java.util.Scanner;
import java.util.ArrayList;
public class DiesMesos{
	public static void main(String[] args){
	
	System.out.print("\033[H\033[2J");
	
	Scanner scan = new Scanner(System.in);
	
	ArrayList<String> LListaMesos = new ArrayList<String>();
	
	LListaMesos.add("gener");
	LListaMesos.add("febrer");
	LListaMesos.add("març");
	LListaMesos.add("abril");
	LListaMesos.add("maig");
	LListaMesos.add("juny");
	LListaMesos.add("juliol");
	LListaMesos.add("agost");
	LListaMesos.add("setembre");
	LListaMesos.add("octubre");
	LListaMesos.add("novembre");
	LListaMesos.add("decembre");
	
	System.out.println("\nSelecciona un mes:\n\n1. Gener\n2. Febrer\n3. Març\n4. Abril\n5. Maig\n6. Juny \n7. Juliol\n8. Agost\n9. Setembre\n10. Octubre\n11. Novembre\n12. Decembre\n\n");
	String seleccioMes = scan.nextLine();
	if(LListaMesos.contains(seleccioMes.toLowerCase())){
		if(seleccioMes.equals()||seleccioMes.equals()||seleccioMes.equals()){
			
		}
		System.out.println("chocho");
	}
	else{
		System.out.println("pene");
	}
	}
}