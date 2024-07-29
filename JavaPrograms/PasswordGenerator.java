package JavaPrograms;

import java.util.Random;

public class PasswordGenerator {

    public static String generatePassword(int length) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String allCharacters = upperCase + lowerCase + numbers;

        if (length < 8) {
            System.out.println("Password length must be at least 8 characters.");
            return null;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        for (int i = 3; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        for (int i = 0; i < password.length(); i++) {
            int randomIndex = random.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int length = 8;
        String generatedPassword = generatePassword(length);
        System.out.println("Generated Password: " + generatedPassword);
    }
}
