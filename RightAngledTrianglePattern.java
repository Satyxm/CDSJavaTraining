import java.util.Scanner;

public class RightAngledTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printRightAngledTrianglePattern(n);
        sc.close();
    }

    public static void printRightAngledTrianglePattern(int size) {
        int i, j;

        for (i = 1; i <= size; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
