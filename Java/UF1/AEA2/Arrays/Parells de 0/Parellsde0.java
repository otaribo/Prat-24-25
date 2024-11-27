public class Parellsde0{
    public static void main(String[] args){
		int[] numerosParells = new int[101];
        for(int i=(0);i<=200;i++){
            if(i%2==0 || i==0){
				numerosParells[i/2] = i;
            }
        }
		for(int numero:numerosParells){
			System.out.print(numero + " ");
		}
		System.out.println();
    }
}