package Java.UF1.AEA2.Arrays.Parells_de_0;
public class parellsde0v2{
    public static void main(String[] args){
        int[] nombresparells = new int[52];
        int[] nombresimparells = new int[52];
        int[] total = new int[100]; 
        int volta = 0;
        for(int i = 1;i<100;i++){
            if(i%2==0){
                nombresparells[volta]=i;
                volta++;
            }
            else{
                nombresimparells[nombresimparells.length-volta]=i;
            }
        }
        print(nombresparells);
        print(nombresimparells);
    }

    public static void print(int[] lista){
        for(int i = 0;i<lista.length;i++){
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
}