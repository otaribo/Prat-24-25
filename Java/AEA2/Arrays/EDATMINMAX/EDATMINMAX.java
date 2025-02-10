import java.util.Arrays;
public class EDATMINMAX {
    public static void main(String[] var0) {
        // An array storing different ages
        int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
        Arrays.sort(ages);
        float avg, sum = 0;

        // Get the length of the array
        int length = ages.length;
        int edatmax = -999999999;
        int edatmin = 999999999;

        // Loop through the elements of the array
        for (int age : ages){
            sum += age;
            //amb aquest if's guardem el l'edat com a maxima o com a minima
            if(age >= edatmax){
                edatmax = age;
            }
            else if(age <= edatmin){
                edatmin = age;
            }
        }

        // Calculate the average by dividing the sum by the length
        avg = sum / length;

        // Print the average
        System.out.println("The average age is: " + avg);
        //imprimim l'edat maximai minima
        System.out.println("La edat mes alta es " + edatmax);
        System.out.println("La edat mes baixa es " + edatmin);
        //calculem la diferencia de edat
        System.out.println("La diferencia de edat es " + (edatmax-edatmin));
    }
}
