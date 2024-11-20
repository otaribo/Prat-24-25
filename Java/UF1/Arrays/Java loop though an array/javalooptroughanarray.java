import java.util.Scanner;
public class javalooptroughanarray{    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String cars[] = new String[4]; 
        for(int i = 0; i<cars.length; i++){
            System.out.print("Introdueix un coche: ");
            cars[i] = scan.nextLine();
        }
        System.out.println("Els coches en la llista son els següents: ");
        for(int i = 0; i<cars.length; i++){
            System.out.print(cars[i] + ", ");
        }
        System.out.println();
    }
}