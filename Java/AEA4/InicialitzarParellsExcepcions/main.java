public class main {
  public static void main(String[] args) {
    //Caldrà emmagatzemar 100 enters.
    int[] arrayParells = new int[100];
    //Anem omplint cada posici .
    for(int i = -7; i < arrayParells.length+6; i++) {
      try{
        arrayParells[i] = 2*i;
        System.out.println("Posicio " + i + ": " + arrayParells[i]);
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Ha ocorregut un error a la iteracio " + i + " del bucle");
      }finally{
        if(i>=arrayParells.length){
          System.out.println("Fora del array.");
        }else{System.out.println("Següent iteracio:");}
      }
    }
  }
}
