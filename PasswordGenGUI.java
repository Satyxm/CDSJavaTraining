import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGenGUI {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Password Generator");

        JButton generateButton = new JButton("Click to Generate Password");
        generateButton.setBounds(200, 100, 300, 50);

        JLabel passwordLabel = new JLabel("Your Password is: ");
        passwordLabel.setBounds(200, 200, 250, 50);

        jFrame.add(generateButton);
        jFrame.add(passwordLabel);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int length = 8;
                String generatedPassword = generatePassword(length);
                passwordLabel.setText("Your Password is: " + generatedPassword);
            }
        });

        jFrame.setLayout(null);
        jFrame.setSize(600, 600);
        jFrame.setVisible(true);
    }

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
}
