public class notasdam1 {
    public static void main(String[] args) {

        boolean check = false;
        int total= 0;
        int[][] listas = {{9,2,8,10},{1,0,3,5,6},{9,4,10,6,7}};

        for(int x = 0;x<listas.length;x++){
            for (int y = 0; y < listas[x].length; y++){
                if (listas[x][y] == 10){
                    total++;
                }
            }
        }
        System.out.println("hi ha " + total + " deu");
    }
}

