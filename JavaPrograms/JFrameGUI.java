package JavaPrograms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameGUI {
    public static void main(String[] args) {
        System.out.println("JFrame is used to build GUI Java Application");
        JFrame jFrame = new JFrame("BMI Calc");

        //To get the input from User JTextField
        //To Display any message to user JLabel
        //To Perform any action by clicking on the button JButton

        JLabel userWeightLabel = new JLabel("Enter your Weight in KG: ");

        // Giving Size and Position to label
        userWeightLabel.setBounds(40, 40, 200, 40);

        //UserInput
        JTextField userWeightTextField = new JTextField();
        //size
        userWeightTextField.setBounds(250, 40, 60, 40);

        jFrame.add(userWeightLabel);
        jFrame.add(userWeightTextField);

        //Phase 2

        JLabel userHeightLabel = new JLabel("Enter your Height in Metres: ");

        // Giving Size and Position to label
        userHeightLabel.setBounds(40, 80, 250, 40);

        //UserInput
        JTextField userHeightTextField = new JTextField();
        //size
        userHeightTextField.setBounds(250, 80, 60, 40);
        JButton calcBMI = new JButton("Calculate BMI: ");
        calcBMI.setBounds(200, 250, 150, 50);

        jFrame.add(userHeightLabel);
        jFrame.add(userHeightTextField);
        jFrame.add(calcBMI);

        //On Click - Action Listener
        calcBMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {

                float weight = Float.parseFloat(userWeightTextField.getText().toString());
                float height = Float.parseFloat(userHeightTextField.getText().toString());
                float bmiVal = weight/(height*height);
                calcBMI.setText(String.valueOf(bmiVal));
            }
        });

        //Logic: Height in Metre and Weight in Kgs
        //Formula: Weight / (Height * Height)

        //to use the default layout
        jFrame.setLayout(null);

        //to add the size in frame
        jFrame.setSize(500, 500);

        //Set Visible the Frame
        jFrame.setVisible(true);
    }
}
