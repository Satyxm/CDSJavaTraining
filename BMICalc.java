import java.util.Scanner;

public class BMICalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight in kgs: ");
        float weight = sc.nextFloat();
        System.out.println("Enter the height in metre: ");
        float height = sc.nextFloat();
        float result = weight/(height*height) ;

        System.out.println("BMI is: " + result + " kg/m^2");

        if(result <= 18.5){
            System.out.println("You are Underweight!");
        } else if(result >= 18.5 && result <= 25) {
            System.out.println("You are Normal!");
        } else if (result > 25) {
            System.out.println("You are Overweight!");
        }
    }
}
