import java.util.Scanner;

public class CurrencyConvertor {
    public static void main(String[] args) {
        System.out.println("Choose 1, For USD to INR");
        System.out.println("Choose 2, For INR to USD");
        System.out.println("Your Choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                USDTOINR();
                break;

            case 2:
                INRTOUSD();
                break;

            default:
                System.out.println("Invalid Choice");

        }


    }

    public static void USDTOINR(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount in USD: ");
        float usdAmount = sc.nextFloat();
        float usdPrice = 83.78f;
        System.out.println(usdAmount + " USD = " + usdAmount*usdPrice + " INR");
    }

    public static void INRTOUSD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount in INR: ");
        float inrAmount = sc.nextFloat();
        float usdPrice = 83.78f;
        System.out.println(inrAmount + " INR = " + inrAmount/usdPrice + " USD");
    }
}
