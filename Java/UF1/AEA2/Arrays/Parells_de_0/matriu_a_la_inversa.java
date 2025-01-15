public class matriu_a_la_inversa {
    public static void main(String[] args){
        int[][] tabla = new int[15][7];
        int volta = (tabla.length*tabla[0].length);
        for(int i = 0; i<tabla.length;i++){
            for(int j = 0; j<tabla[i].length;j++){
                tabla[tabla.length-1-i][tabla[i].length-1-j] = (volta);
                volta--;
            }
        }
        for(int i = 0; i<tabla.length;i++){
            for(int j = 0; j<tabla[i].length;j++){
                System.out.print("["+tabla[tabla.length-1-i][tabla[i].length-1-j]+"]");
            }
            System.out.println();
        }
    }
}
