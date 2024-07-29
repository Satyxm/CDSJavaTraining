package JavaPrograms;

import java.util.Scanner;

public class InvertedTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printInvertedTrianglePattern(n);
        sc.close();
    }

    public static void printInvertedTrianglePattern(int size) {
        int i, j;

        for (i = size; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
