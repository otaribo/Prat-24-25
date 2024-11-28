import java.util.Scanner;
public class examen {
    public static void main(String[] args){
        //Definim el scanner i les diferents variabls que s'usaran.
        Scanner scan = new Scanner(System.in);
        double preu = 0;
        double preu_final = 0;
        int volta = 0;
        //Obrim el while que fara tantes voltes com productes.
        while(volta<5){
            System.out.println("Introdueix el preu del producte " + (volta + 1) + ":");
            //Comprobem si el valor es un numero valid.
            if(scan.hasNextDouble()){
                preu = scan.nextDouble();
                //Mirem si el preu es major a 50 per aplicar descompte.
                if(preu>50){
                    if(preu*0.06>15){
                        preu_final += (preu -= 15);
                        System.out.println("El preu del producte es " + preu + " euros. S'ha afegit a la compra.");
                    }
                    else{
                        preu_final += (preu -= preu*0.06);
                        System.out.println("El preu del producte es " + preu + " euros. S'ha afegit a la compra.");
                    }
                }
                //Amb aquesta condicio podem evitar l'us de numeros negatius com a preu del producte.
                else if(preu<=0){
                    System.out.println("Els preus negatius o nuls no son valids.");
                    //Resto 1 a volta per a que no conti com a producte i es torni a repetir desde on s'ha quedat.
                    volta--;
                }
                //Donat que no queden opcions ja que si es menor que 0 ja hi ha una opcio i si es major de 50 tambe sol queden els valors entre 0.1 i 49.9.
                else{
                    preu_final += preu;
                    System.out.println("El preu del producte es " + preu + " euros. S'ha afegit a la compra.");
                }
                //Aqui sumem 1 a la variable volta que un cop arribi a 5 s'encargara de tancar el bucle
                volta++;
            }
            //Si el valor introduit per l'usuari no es un double fem que el torni a introduir.
            else{
                System.out.println("Numero no valid torna a introduir-lo.");
                scan.next();
            }
        }
        //mostrem el preu final de la compra.
        System.out.println("El preu final es " + preu_final + " euros.");
        scan.close();
    }
}