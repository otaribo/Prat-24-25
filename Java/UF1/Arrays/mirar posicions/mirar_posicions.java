public class mirar_posicions {
    public static void main (String[] args){
        int Llista[]={1, 15, 23, 75, 10, 22, 4};
        int counter = 0;
        for(int i:Llista){
            counter++;
            if(i == 10){
                break;
            }
        }
        System.out.println("En la posicio " + counter + " hi ha un 10");
    }    
}