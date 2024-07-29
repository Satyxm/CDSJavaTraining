package JavaPrograms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {
    public static void main(String[] args) {
        System.out.println("Currency Converter GUI Application");
        JFrame jFrame = new JFrame("Currency Converter");

        JLabel userDollarLabel = new JLabel("Enter the Amount in Dollars: ");
        userDollarLabel.setBounds(40, 40, 300, 40);

        JTextField userDollarTextField = new JTextField();
        userDollarTextField.setBounds(250, 40, 60, 40);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(40, 100, 300, 40);

        JButton currencyButton = new JButton("Click to convert currency");
        currencyButton.setBounds(200, 200, 200, 50);

        jFrame.add(currencyButton);
        jFrame.add(userDollarTextField);
        jFrame.add(userDollarLabel);
        jFrame.add(resultLabel);

        currencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float dollar = Float.parseFloat(userDollarTextField.getText().toString());
                float inr = dollar * 83.78f;
                resultLabel.setText("INR: " + inr);
            }
        });

        jFrame.setLayout(null);
        jFrame.setSize(600, 600);
        jFrame.setVisible(true);

    }
}
