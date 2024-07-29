package JavaPrograms;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Billy Butcher";
        String reversedStr = reverseString(str);
        System.out.println("Reversed String: " + reversedStr);
    }

    public static String reverseString(String str) {
        String rev = " ";
        for (int i = str.length() - 1; i >= 0; i--){
           rev += str.charAt(i);

        }
        return rev.trim();

    }
}
