package JavaPrograms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OTPGeneratorGUI {
    public static void main(String[] args) {
        System.out.println("This is an OTP Generator GUI Application");
        JFrame jFrame = new JFrame(("OTP Generator"));

        JButton otpButton = new JButton("Click to Generate OTP");
        otpButton.setBounds(200, 200, 200, 50);

        jFrame.add(otpButton);

        otpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();

                int myOTP = random.nextInt(100000);
                otpButton.setText(String.valueOf(myOTP));
            }
        });

        jFrame.setLayout(null);
        jFrame.setSize(600, 600);
        jFrame.setVisible(true);

    }
}
