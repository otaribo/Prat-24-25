import java.util.Scanner;

public class MaxMinMitjana {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double[] lista = new double[5];
        //Introduim tots els valors
        for(int i = 0; i<lista.length;i++){
            lista[i] = NoErrorInput(scan);
        }
        System.out.println("Enhorabona, has introduit tots els valors satisfactoriament ets un/a crack!!");

        //Preguntem al usuari que vol fer
        int seleccio = seleccio(scan);
        double valor = 0;
        if(seleccio == 1){
            valor = max(lista);
            System.out.println("El valor mes gran es: " + valor + ".");
        }
        else if(seleccio == 2){
            valor = min(lista);
            System.out.println("El valor mes petit es: " + valor + ".");
        }
        else{
            valor = mitjana(lista);
            System.out.println("El valor de la mitjana es: " + valor + ".");
        }
    }

    //Calculem el valor mes alt
    public static double max(double[] lista){
        double valor = lista[0];
        for(int i = 1; i<lista.length;i++){
            if(lista[i]>valor){
                valor = lista[i];
            }
        }
        return valor;
    }

    //Calculem el valor mes petit
    public static double min(double[] lista){
        double valor = lista[0];
        for(int i = 1; i<lista.length;i++){
            if(lista[i]<valor){
                valor = lista[i];
            }
        }
        return valor;
    }

    //Calculem la mitjana
    public static double mitjana(double[] lista){
        double valor = 0;
        for(int i = 0; i<lista.length;i++){
            valor += lista[i];
        }
        return (valor/lista.length);
    }
    
    //Amb aquesta funcio recollim la seleccio del usuari
    public static int seleccio(Scanner scan){
        do{
            System.out.println("Que vols fer?\n1. veure el nombre mes gran\n2. Veure el nombre mes petit\n3. veure la mitjana");
            System.out.print("Introdueix una opcio [1][2][3]: ");
            if(scan.hasNextInt()){
                int seleccio = scan.nextInt();
                return seleccio;
            }
            else{scan.next();System.out.println("Opcio no valida. ");}
        }while(true);
    }
    
    // Aquesta funcio serveix per introduir un valor y que aquest sigui valid
    public static double NoErrorInput(Scanner scan){
        float valor = 0;
        boolean novalid = true;
        do{
            try{
                System.out.print("Introdueix un valor: ");
                String numerointroduit = scan.nextLine();
                valor = Float.parseFloat(numerointroduit);
                novalid = false;
            }

            catch(NumberFormatException ex){
                    System.out.println("valor no valid ");
            } 
        }
        while(novalid);
        return valor;
    }
}
