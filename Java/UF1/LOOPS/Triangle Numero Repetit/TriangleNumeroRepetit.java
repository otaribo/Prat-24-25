import java.util.Scanner;
public class TriangleNumeroRepetit {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Cuantes files vols: ");
		int numeroFiles = scan.nextInt();
		for (int i = 1; i <= numeroFiles; i++){
			System.out.println(String.valueOf(numeroFiles).repeat(i));
		}
	}
}