package JavaPrograms;

import java.util.Scanner;

public class ReverseArray {

    public static void reverseArr(String[] arr, int n) {
        int i = 0;
        int j = n - 1;

        while (i < j) {

            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String[] theBoys = {"Homelander", "Butcher", "Hughie", "Deep"};
        int n = theBoys.length;

        for (int i = 0; i < theBoys.length; i++){
            System.out.println(theBoys[i]);
        }

        reverseArr(theBoys, n);

        System.out.println("Reversed Array: ");
        
        for (int i = 0; i < theBoys.length; i++){
            System.out.println(theBoys[i]);
        }
    }
}
