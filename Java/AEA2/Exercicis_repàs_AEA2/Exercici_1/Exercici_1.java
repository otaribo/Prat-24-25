import java.util.ArrayList;
public class Exercici_1 {
    public static int[][] lista = new int [5][5];
    public static void main(String[] args){
        //Aquesta funcio posa els valors random a cada posicio de la matriu
        InicialitzacioRandoms();
        //Aqui mostrem la llista amb els valors ja cambiats
        MostrarLista();
        //Calculem la mitjana
        mitjana();
        //Revisem el numero mes gran i el numero de cops que es repeteix
        numeromesgran();
        //Busquem els numeros primers que surten a la llista
        numerosprimers();
        //mostrem els numeros parells de la llista
        numerosparells();
        //Aquesta funcio mostra el resultat de  sumar la diagonal de dreta a esquerra i la ultima fila
        sumar();
    }
    public static void MostrarLista(){
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                System.out.print("[" + lista[i][j] + "]");
            }
            System.out.println();
        }
    }
    public static void InicialitzacioRandoms(){
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                lista[i][j] = (int)(Math.random()*100);
            }
        }
    }
    public static void mitjana(){
        int mitjana = 0;
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                mitjana += lista[i][j]/(lista.length*lista[i].length);
            }
        }
        System.out.println("La mitjana de la llista es " + mitjana);
    }
    public static void numeromesgran(){
        int numeromesgran = 0;
        int repeticions = 0;
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                if(lista[i][j]>numeromesgran){
                    numeromesgran = lista[i][j];
                    repeticions++;
                }
            }
        }
        System.out.println("El numero mes gran es " + numeromesgran + " que es repeteix " + repeticions + " cops.");
    }
    public static void numerosprimers(){
        ArrayList<Integer> numerosprimers = new ArrayList<>();
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                for(int divisor = 1;divisor<=lista[i][j];divisor++){
                    if(lista[i][j]%divisor==0){
                        divisors.add(divisor);
                    }
                }
                if(divisors.size()<=2){
                    numerosprimers.add(lista[i][j]);
                }
                divisors.clear();
            }
        }
        System.out.print("Els numeros primers son ");
        System.out.println(numerosprimers);
    }
    public static void numerosparells(){
        ArrayList<Integer> numerosparells = new ArrayList<>();
        for(int i = 0;i<lista.length;i++){
            for(int j = 0;j<lista[i].length;j++){
                if(lista[i][j]%2==0){
                    numerosparells.add(lista[i][j]);
                }
            }
        }
        System.out.println("Els numeros parells son " + numerosparells);
    }
    public static void sumar(){
        int sumadiagonal = 0;
        int sumaultimafila = 0;
        for(int i = 0;i<lista.length;i++){
            sumadiagonal+=lista[i][i];
        }
        for(int i = 0; i<lista.length;i++){
            sumaultimafila+=lista[(lista.length-1)][i];
        }
        System.out.println("La suma de la diagonal es " + sumadiagonal);   
        System.out.println("La suma de la ultima fila es " + sumaultimafila);    
    }
}