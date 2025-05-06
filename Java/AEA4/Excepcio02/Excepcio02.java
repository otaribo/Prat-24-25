package Java.AEA4.Excepcio02;

public class Excepcio02{
    public static void main(String[] args){
        String[] t={"Hola","Adeu","Fins dema"};
        try{
            System.out.println("Abans d'executar el for");
            for(int i = 0; i<=t.length;i++){
                System.out.println("Posicio " + i + ": " + t[i]);
            }
            System.out.println("Despres d'executar el for");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, putita");
        
        }
        finally{
            System.out.println("Finally?");
        }
    }
}