import java.util.Scanner;
public class TriangleNombre {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Cuantes files vols: ");
		int numeroFiles = scan.nextInt();
		for (int i = 1; i <= numeroFiles; i++){
			for (int x = 1; x<=i; x++){
				System.out.print(x);
			}
			System.out.println();
		}
	}
}