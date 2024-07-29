package JavaPrograms;

import java.util.Scanner;

public class TernaryOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        
        System.out.println(age >= 18 ? "You are eligible to vote" : "You are not eligible to vote");
        
        sc.close();
    }
}
