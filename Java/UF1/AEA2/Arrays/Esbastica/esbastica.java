public class esbastica {
    public static void main(String[] args){
        int[][] esbastica = {{1,1,0,0,1,1,1,1,1,1},{1,1,0,0,1,1,1,1,1,1},{1,1,0,0,1,1,0,0,0,0},{1,1,0,0,1,1,0,0,0,0},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{0,0,0,0,1,1,0,0,1,1},{0,0,0,0,1,1,0,0,1,1},{1,1,1,1,1,1,0,0,1,1},{1,1,1,1,1,1,0,0,1,1}};
        for(int i = 0; i < esbastica.length; i++){
            for(int j = 0; j < esbastica.length; j++){
                if(esbastica[i][j] == 1){
                    System.out.print("\033[31m" + "[" +  esbastica[i][j] + "]" + "\033[0m");
                }
                else{
                    System.out.print("\033[97m" + "[" + esbastica[i][j] + "]" + "\033[0m");
                }
            }
            System.out.println();
        }
    }    
}
