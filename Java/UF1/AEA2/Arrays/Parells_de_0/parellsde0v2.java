public class parellsde0v2{
    public static void main(String[] args){
        int[] nombresparells = new int[51];
        int[] nombresimparells = new int[51];
        int[] total = new int[51];
        for(int i = 0;i<=100;i++){
            if(i==0){
                
            }
            else if(i%2==0){
                nombresparells[i/2] = i;
            }
             else if(i%2!=0){
                 nombresimparells[nombresimparells.length - ((i+1)/2)-1] = i;
            }
            total[i/2] = nombresparells[i/2] + nombresimparells[i/2];
        }
        Print(nombresparells, 1);
        System.out.println();
        Print(nombresimparells, 0);
        System.out.println();
        Print(total, 3);
    }
    public static void Print(int[] lista, int color){
        for(int element:lista){
            if(color!=3){
                System.out.print(((color == 1) ?"\u001B[34m":"\u001B[31m") + "["+element+"]" + " ");
            }
            else{
                System.out.print("\u001B[32m" + "["+element+"]" + " ");
            }
        }
    }
}

