public class cambiarvalorscolumnesifiles {
    public static void main(String[] args){
        int[][] llista = new int[30][30];
        for(int i = 0;i<llista.length;i++){
            for(int j = 0;j<llista.length;j++){
                //columna parella i fila parella
                if(i%2==0&&j%2==0){
                    llista[i][j] = 1;
                    System.out.print("\u001B[31m" + "[" + llista[i][j] + "]" + "\u001B[0m");
                }
                //columna parella i fila imparelles
                else if(i%2!=0&&j%2==0){
                    llista[i][j] = 3;
                    System.out.print("\u001B[32m" + "[" + llista[i][j] + "]" + "\u001B[0m");
                }
                //columna parella i fila imparella
                else if(i%2==0&&j%2!=0){
                    llista[i][j] = 2;
                    System.out.print("\u001B[34m" + "[" + llista[i][j] + "]" + "\u001B[0m");
                }
                //fila imparella i columna imparella
                else if(i%2!=0&&j%2!=0){
                    llista[i][j] = 4;
                    System.out.print("\u001B[33m" + "[" + llista[i][j] + "]" + "\u001B[0m");
                }
            }
            System.out.println();
        }
    }    
}
