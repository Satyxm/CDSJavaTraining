import java.util.Scanner;

public class BMICalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight in kgs: ");
        float weight = sc.nextFloat();
        System.out.println("Enter the height in cm: ");
        float height = sc.nextFloat();
        height = height/100;
        float result = weight/(height*height) ;

        System.out.println("BMI is: " + result);
    }
}
