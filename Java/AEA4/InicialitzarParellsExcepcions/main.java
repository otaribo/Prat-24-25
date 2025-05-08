public class main {
  public static void main(String[] args) {
    //Caldrà emmagatzemar 100 enters.
    int[] arrayParells = new int[100];
    //Anem omplint cada posici .
    for(int i = 0; i < arrayParells.length; i++) {
      arrayParells[i] = 2*i;
    }
    for(int i = 0; i < arrayParells.length;i++){
        System.out.prinln(i);
    }
  }
}
