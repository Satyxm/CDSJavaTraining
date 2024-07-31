package JavaPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameDev {
    private static JLabel number1Label;
    private static int sum;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Arithmetic Game");

        JLabel questionLabel = new JLabel("What will be the sum of the following numbers? You have 30 seconds to answer.");
        questionLabel.setBounds(40, 40, 1000, 40);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(questionLabel);

        JTextField answerTextField = new JTextField();
        answerTextField.setBounds(40, 150, 200, 40);
        answerTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        jFrame.add(answerTextField);

        number1Label = new JLabel();
        number1Label.setBounds(40, 100, 400, 40);
        number1Label.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(number1Label);

        JButton submitButton = new JButton("Submit Answer");
        submitButton.setBounds(40, 200, 200, 40);
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(submitButton);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(40, 250, 400, 40);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(resultLabel);

        JLabel resultLabel2 = new JLabel();
        resultLabel2.setBounds(40, 300, 400, 40);
        resultLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(resultLabel2);

        JLabel timerLabel = new JLabel("Time left: 30 seconds");
        timerLabel.setBounds(40, 350, 300, 40);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(timerLabel);

        int[] score = {0};
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(40, 400, 300, 40);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jFrame.add(scoreLabel);

        int[] secondsLeft = {30};
        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft[0]--;
                if (secondsLeft[0] > 0) {
                    timerLabel.setText("Time left: " + secondsLeft[0] + " seconds");
                } else {
                    ((Timer) e.getSource()).stop();
                    timerLabel.setText("Time's up!");
                    submitButton.setEnabled(false);
                }
            }
        });
        countdownTimer.start();

        sum = updateNumbers();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft[0] > 0) {
                    int userAnswer = Integer.parseInt(answerTextField.getText());
                    if (sum == userAnswer) {
                        resultLabel.setText("Correct Answer");
                        score[0]++;
                    } else {
                        resultLabel.setText("Incorrect Answer");
                    }
                    scoreLabel.setText("Total Score: " + score[0]);
                    sum = updateNumbers();
                }
            }
        });

        jFrame.setSize(1000, 1000);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    private static int updateNumbers() {
        int randomNum1 = (int) (Math.random() * 1000);
        int randomNum2 = (int) (Math.random() * 1000);
        int sum = randomNum1 + randomNum2;
        number1Label.setText(randomNum1 + " + " + randomNum2);
        return sum;
    }
}
