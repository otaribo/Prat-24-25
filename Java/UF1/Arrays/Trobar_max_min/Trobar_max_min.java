public class Trobar_max_min{
    public static void main(String[] args){
        int[] vector = {12, 3, 45, -3, 65, -5, 88, 99, 2, 23, 54, 33, 27, 53, 96, 0};
        int max = vector[0];
        int min = vector[0];
        for(int i=0;i<vector.length;i++){
            if(vector[i] < min){
                min = vector[i];
            }
            else if(vector[i] > max){
                max = vector[i];
            }
        }
        System.out.println("El numero mes gran es " + max);
        System.out.println("El numero mes petit es " + min);
    }
}