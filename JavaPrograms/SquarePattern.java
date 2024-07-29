package JavaPrograms;

import java.util.Scanner;

public class SquarePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printSquarePattern(n);
        sc.close();
    }

    public static void printSquarePattern(int size) {
        int i, j;

        for (i = 1; i <= size; i++) {
            for (j = 1; j <= size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
