package Java.UF1.AEA3.Element_mes_petit_de_un_array;

public class Elementmespetit {
    public static void main(String[] args){
        int[] lista = {40,97,136,2017,591,5,99,100};
        int ultimoValor, cambio;
        for (int i = 0;i<lista.length;){
            ultimoValor = (lista[lista.length-1]);
            System.out.println(ultimoValor);
            if(i-1 == -1){
                cambio = lista[i];
                lista[i] = ultimoValor;
                lista[lista.length-1] = cambio;
                i++;
            }
            else if(ultimoValor>lista[i-1]){
                cambio = lista[i];
                lista[i] = ultimoValor;
                lista[lista.length-1] = cambio;
                i++;
            }
        }
        for(int i = 0;i<lista.length;i++){
            System.out.print(lista[i]);
        }
        System.out.println();
    }
}
