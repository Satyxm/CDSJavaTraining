package JavaPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class quizGame {
    private static JLabel questionLabel;
    private static JRadioButton[] optionRadioButtons;
    private static JLabel resultLabel;
    private static JLabel scoreLabel;
    private static JLabel correctAnswerLabel;
    private static int score;
    private static List<Question> questions;
    private static Question currentQuestion;
    private static int timeLeft = 30;
    private static ButtonGroup optionsGroup;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Game");

        questionLabel = new JLabel();
        questionLabel.setBounds(40, 40, 800, 40);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(questionLabel);

        optionRadioButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i] = new JRadioButton("");
            optionRadioButtons[i].setBounds(40, 100 + i * 50, 400, 40);
            optionRadioButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            optionsGroup.add(optionRadioButtons[i]);
            frame.add(optionRadioButtons[i]);
        }

        JButton submitButton = new JButton("Submit Answer");
        submitButton.setBounds(40, 300, 200, 40);
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(submitButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(40, 350, 400, 40);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(resultLabel);

        correctAnswerLabel = new JLabel();
        correctAnswerLabel.setBounds(40, 400, 800, 40);
        correctAnswerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(correctAnswerLabel);

        JLabel timerLabel = new JLabel("Time left: 30 seconds");
        timerLabel.setBounds(40, 450, 300, 40);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(timerLabel);

        score = 0;
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(40, 500, 300, 40);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(scoreLabel);

        questions = Question.getSampleQuestions();
        Collections.shuffle(questions);

        showNextQuestion();

        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft > 0) {
                    timerLabel.setText("Time left: " + timeLeft + " seconds");
                } else {
                    ((Timer) e.getSource()).stop();
                    timerLabel.setText("Time's up!");
                    submitButton.setEnabled(false);
                    for (JRadioButton radioButton : optionRadioButtons) {
                        radioButton.setEnabled(false);
                    }
                }
            }
        });
        countdownTimer.start();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                optionsGroup.clearSelection();
                resultLabel.setText("");

                if (questions.size() > 0 && timeLeft > 0) {
                    showNextQuestion();
                } else {
                    resultLabel.setText("Quiz finished! Your Total score: " + score);
                    submitButton.setEnabled(false);
                }
            }
        });

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void showNextQuestion() {
        if (questions.isEmpty()) return;

        currentQuestion = questions.remove(0);
        questionLabel.setText(currentQuestion.getQuestion());
        List<String> options = new ArrayList<>(currentQuestion.getOptions());
        Collections.shuffle(options);

        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i].setText(options.get(i));
            optionRadioButtons[i].setEnabled(true);
        }

        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
        currentQuestion.setCorrectOptionIndex(options.indexOf(currentQuestion.getOptions().get(correctAnswerIndex)));

        correctAnswerLabel.setText("");
    }

    private static void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionRadioButtons[i].isSelected()) {
                if (i == currentQuestion.getCorrectOptionIndex()) {
                    resultLabel.setText("Correct Answer!");
                    score++;
                } else {
                    resultLabel.setText("Wrong Answer!");
                }
                scoreLabel.setText("Score: " + score);

                correctAnswerLabel.setText("Correct Answer: " + currentQuestion.getOptions().get(currentQuestion.getCorrectAnswerIndex()));
                return;
            }
        }
        resultLabel.setText("Please select an option.");
    }
}

class Question {
    private String question;
    private List<String> options;
    private int correctAnswerIndex;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int index) {
        this.correctOptionIndex = index;
    }

    public static List<Question> getSampleQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(createQuestion("What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(createQuestion("What is 2 + 2?",
                Arrays.asList("3", "4", "5", "6"), 1));
        questions.add(createQuestion("What is the largest planet in our solar system?",
                Arrays.asList("Earth", "Jupiter", "Mars", "Saturn"), 1));
        questions.add(createQuestion("Which element has the chemical symbol 'O'?",
                Arrays.asList("Gold", "Oxygen", "Silver", "Iron"), 1));
        questions.add(createQuestion("Who wrote 'To Kill a Mockingbird'?",
                Arrays.asList("Harper Lee", "Mark Twain", "Ernest Hemingway", "J.K. Rowling"), 0));
        questions.add(createQuestion("What is the hardest natural substance on Earth?",
                Arrays.asList("Gold", "Iron", "Diamond", "Platinum"), 2));
        questions.add(createQuestion("Which country is known as the Land of the Rising Sun?",
                Arrays.asList("China", "Japan", "Thailand", "South Korea"), 1));
        questions.add(createQuestion("What is the smallest prime number?",
                Arrays.asList("1", "2", "3", "5"), 1));
        questions.add(createQuestion("What is the main ingredient in guacamole?",
                Arrays.asList("Tomato", "Avocado", "Onion", "Pepper"), 1));
        questions.add(createQuestion("In which year did the Titanic sink?",
                Arrays.asList("1905", "1912", "1915", "1923"), 1));
        return questions;
    }

    private static Question createQuestion(String question, List<String> options, int correctAnswerIndex) {
        Question q = new Question(question, options, correctAnswerIndex);
        List<String> shuffledOptions = new ArrayList<>(options);
        Collections.shuffle(shuffledOptions);
        q.setCorrectOptionIndex(shuffledOptions.indexOf(options.get(correctAnswerIndex)));
        return q;
    }
}
