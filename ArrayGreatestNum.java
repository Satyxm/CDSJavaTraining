import java.util.Scanner;

public class ArrayGreatestNum {
    public static int Greatest(int[] arr) {
        int Greatest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > Greatest) {
                Greatest = arr[i];
            }
        }
        return Greatest;
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

        System.out.println("Greatest element is " + Greatest(arr));
    }
}



