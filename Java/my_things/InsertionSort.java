package Java.my_things;
public class InsertionSort {

    void sort(int arr[]){
        int length = arr.length;
        for (int i = 1; i < length; ++i) {
            int objeto1 = arr[i];
            int objeto2 = i - 1;

            while (objeto2 >= 0 && arr[objeto2] > objeto1) {
                arr[objeto2 + 1] = arr[objeto2];
                objeto2 = objeto2 - 1;
            }
            arr[objeto2 + 1] = objeto1;
        }
    }

    static void printArray(int arr[]){
        int length = arr.length;
        for (int i = 0; i < length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}