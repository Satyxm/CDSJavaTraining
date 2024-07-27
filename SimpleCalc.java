import javax.swing.*;
import java.awt.*;

public class SimpleCalc {
    public static void main(String[] args) {

        //GUI Window
        JFrame jFrame = new JFrame("Simple Calculator");
        jFrame.setSize(600, 600);
        jFrame.setLayout(null);

        //setting visibility of JFrame to true
        jFrame.setVisible(true);

        //Display Bar
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setBounds(50, 25, 300, 50);
        jFrame.add(display);

        //Num Buttons
        JButton[] numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFocusable(false);
            int finalI = i;
            numButtons[i].addActionListener(e -> display.setText(display.getText().concat(String.valueOf(finalI))));
        }

        //Operations Buttons
        JButton sumButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton decButton = new JButton(".");
        JButton equButton = new JButton("=");
        JButton delButton = new JButton("del");
        JButton clrButton = new JButton("clr");

        //GUI Panel
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //Adding Buttons to Panel
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(sumButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        //Adding Panel to JFrame
        jFrame.add(panel);

        //Setting Bounds del, clr
        delButton.setBounds(50, 400, 100, 50);
        clrButton.setBounds(250, 400, 100, 50);

        //Adding del, clr to Frame
        jFrame.add(delButton);
        jFrame.add(clrButton);


    }
}