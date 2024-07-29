package JavaPrograms;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        JFrame calculatorFrame = new JFrame("Simple Calculator");
        calculatorFrame.setSize(420, 550);
        calculatorFrame.setLayout(null);

        JTextField inputField = new JTextField();
        inputField.setBounds(50, 25, 300, 50);
        inputField.setEditable(false);
        calculatorFrame.add(inputField);

        JButton[] digitButtons = new JButton[10];
        for (int num = 0; num < 10; num++) {
            digitButtons[num] = new JButton(String.valueOf(num));
            digitButtons[num].setFocusable(false);
            int finalNum = num;
            digitButtons[num].addActionListener(e -> inputField.setText(inputField.getText() + finalNum));
        }

        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton decimalButton = new JButton(".");
        JButton equalsButton = new JButton("=");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(50, 100, 300, 300);
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(plusButton);
        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(minusButton);
        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(decimalButton);
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(divideButton);

        calculatorFrame.add(buttonPanel);

        deleteButton.setBounds(50, 430, 145, 50);
        clearButton.setBounds(205, 430, 145, 50);
        calculatorFrame.add(deleteButton);
        calculatorFrame.add(clearButton);

        calculatorFrame.setVisible(true);

        final double[] firstOperand = {0};
        final double[] secondOperand = {0};
        final double[] calculationResult = {0};
        final char[] currentOperator = new char[1];

        plusButton.addActionListener(e -> {
            firstOperand[0] = Double.parseDouble(inputField.getText());
            currentOperator[0] = '+';
            inputField.setText(inputField.getText() + " + ");
        });

        minusButton.addActionListener(e -> {
            firstOperand[0] = Double.parseDouble(inputField.getText());
            currentOperator[0] = '-';
            inputField.setText(inputField.getText() + " - ");
        });

        multiplyButton.addActionListener(e -> {
            firstOperand[0] = Double.parseDouble(inputField.getText());
            currentOperator[0] = '*';
            inputField.setText(inputField.getText() + " * ");
        });

        divideButton.addActionListener(e -> {
            firstOperand[0] = Double.parseDouble(inputField.getText());
            currentOperator[0] = '/';
            inputField.setText(inputField.getText() + " / ");
        });

        equalsButton.addActionListener(e -> {
            String[] parts = inputField.getText().split(" ");
            if (parts.length == 3) {
                secondOperand[0] = Double.parseDouble(parts[2]);

                switch (currentOperator[0]) {
                    case '+':
                        calculationResult[0] = firstOperand[0] + secondOperand[0];
                        break;
                    case '-':
                        calculationResult[0] = firstOperand[0] - secondOperand[0];
                        break;
                    case '*':
                        calculationResult[0] = firstOperand[0] * secondOperand[0];
                        break;
                    case '/':
                        calculationResult[0] = firstOperand[0] / secondOperand[0];
                        break;
                }
                inputField.setText(String.valueOf(calculationResult[0]));
                firstOperand[0] = calculationResult[0];
            }
        });

        clearButton.addActionListener(e -> inputField.setText(""));

        deleteButton.addActionListener(e -> {
            String currentText = inputField.getText();
            if (currentText.length() > 0) {
                inputField.setText(currentText.substring(0, currentText.length() - 1));
            }
        });
    }
}
