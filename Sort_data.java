package Random_Data;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sort_data {
    public static void main(String[] args) {
        System.out.println("Selamat Datang di Program Simulasi");
        System.out.println("Menu : ");
        
        
        int menuInt = ShowMenu();
        if(menuInt > 5)
        return;
        
        int[] hasilRandom;
        Scanner scanInt = new Scanner(System.in);
        System.out.println("Tentukan Angka Batas Bawah : ");
        int angkaBawah = scanInt.nextInt();
        System.out.println("Tentukan Angka Batas Atas : ");
        int angkaAtas = scanInt.nextInt();
        int panjang = 5;

        if (menuInt == 1) {
            hasilRandom = creatRandomNumber(panjang, angkaBawah, angkaAtas);
            System.out.println("5 Angka Random :");
            printArray(hasilRandom);

        } else if (menuInt == 2) {
            int[] angkaRandom = creatRandomNumber(panjang, angkaBawah, angkaAtas);
            System.out.println("Hasil Data Random:");
            printArray(angkaRandom);
            int[] hasilBubbleSort = bubbleSort(angkaRandom, true);
            System.out.println("");
            System.out.println("Result Bubble Sort ascending:");
            printArray(hasilBubbleSort);

        } else if (menuInt == 3) {
            int[] angkaRandom = creatRandomNumber(panjang, angkaBawah, angkaAtas);
            System.out.println("Hasil Data Random:");
            printArray(angkaRandom);

            int[] hasilSelectionSort = selectionSort(angkaRandom, true);
            System.out.println("");
            System.out.println("Result selection sort ascending:");
            printArray(hasilSelectionSort);

        } else if (menuInt == 4) {
            int[] angkaRandom = creatRandomNumber(panjang, angkaBawah, angkaAtas);
            System.out.println("Hasil Data Random:");
            printArray(angkaRandom);
            int[] hasilBubbleSort = bubbleSort(angkaRandom, false);
            System.out.println("");
            System.out.println("Result Bubble Sort ascending:");
            printArray(hasilBubbleSort);

        } else if (menuInt == 5) {
            int[] angkaRandom = creatRandomNumber(panjang, angkaBawah, angkaAtas);
            System.out.println("Hasil Data Random:");
            printArray(angkaRandom);

            int[] hasilSelectionSort = selectionSort(angkaRandom, false);
            System.out.println("");
            System.out.println("Result selection sort ascending:");
            printArray(hasilSelectionSort);
        } 
    }

    public static int ShowMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort = Ascending");
        System.out.println("3. Simulasi Selection Sort = Ascending");
        System.out.println("4. Simulasi Bubble Sort = Descending");
        System.out.println("5. Simulasi Selection Sort = Descending");
        System.out.println("6. Keluar");
        System.out.println("");
        System.out.println("Masukan Pilihan anda : ");
        return scanner.nextInt();
    }

    public static int[] creatRandomNumber(int length, int min, int max) {
        Random rd = new Random();
        int[] listRandom = new int[length];

        for (int i = 0; i < length; i++) {
            listRandom[i] = rd.nextInt(max - min + 1) + min;
        }
        return listRandom;
    }

    public static int[] bubbleSort(int[] arr, boolean isAscending) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            System.out.println("\nPass " + (i + 1) + ":");

            for (int j = 0; j < n - i - 1; j++) {
                boolean isvalid = isAscending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1];

                if (isvalid) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

                printArray(arr);

            }

            // Print the array after each pass
            System.out.println("\nResult of Pass " + (i + 1) + ":");
            printArray(arr);

            // If no two elements were swapped in the inner loop, the array is already
            // sorted
            if (!swapped) {
                break;
            }

        }

        return arr;
    }

    public static int[] selectionSort(int[] arr, boolean isAscending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nPass " + (i + 1) + ":");
            int index = i;
            for (int j = i + 1; j < n; j++) {
                boolean isvalid = isAscending ? arr[j] < arr[index] : arr[j] > arr[index];
                if (isvalid) {
                    index = j;// searching for lowest index
                    // printArray(arr);
                }
                printArray(arr);
            }
            System.out.println("\nResult of Pass " + (i + 1) + ":");
            printArray(arr);

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
