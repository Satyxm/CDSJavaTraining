import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDiamondPattern(n);
        sc.close();
    }

    public static void printDiamondPattern(int size) {
        int i = 1;
        int j;

        do {
            j = 1;

            do {
                System.out.print(" ");
            } while (++j <= size - i + 1);

            j = 1;

            do {
                System.out.print("*");
            } while (++j <= i * 2 - 1);

            System.out.println();
        } while (++i <= size);

        i = size - 1;

        do {
            j = 1;

            do {
                System.out.print(" ");
            } while (++j <= size - i + 1);

            j = 1;

            do {
                System.out.print("*");
            } while (++j <= i * 2 - 1);

            System.out.println();
        } while (--i > 0);
    }
}
