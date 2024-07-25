import java.util.Scanner;

public class ArraySmallestNum {
    public static int Smallest(int[] arr) {
        int Smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < Smallest) {
                Smallest = arr[i];
            }
        }
        return Smallest;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of Array: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Smallest element is " + Smallest(arr));
    }
}



