public class parellsde0v3 {
    public static void main(String[] args){
        int[][] taula = new int[50][2];
        int volta = 0;
        for(int i = 0; i<50;){
            if(volta%2!=0){
                taula[i][1] = volta;
                i++;
            }
            else{
                taula[i][0] = volta;
            }
            volta++;
        }
        Print(taula);
    }
    public static void Print(int[][] lista){
        for(int i = 0;i<lista.length;i++){
            System.out.print("\u001B[31m" + "["+lista[i][0]+"]" + " ");
        }
        System.out.println();
        for(int i = 0; i<lista.length;i++){
            System.out.print("\u001B[34m" + "["+lista[i][1]+"]" + " ");
        }
        System.out.println();
    }
}
