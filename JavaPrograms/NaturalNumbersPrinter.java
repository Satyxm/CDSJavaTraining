package JavaPrograms;

import java.util.Scanner;

public class NaturalNumbersPrinter {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        int num = 1;
        while (num <= 10) {
            System.out.print(num + " ");
            num++;
        }
        System.out.println();

        num = 10;
        while (num >= 1) {
            System.out.print(num + " ");
            num--;
        }
        System.out.println();

        num = 1;
        do {
            System.out.print(num + " ");
            num++;
        } while (num <= 10);
        System.out.println();

        num = 10;
        do {
            System.out.print(num + " ");
            num--;
        } while (num >= 1);
        System.out.println();
    }
}
