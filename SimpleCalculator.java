/*
 * Simple Calculator in Java
 * 
 * Description:
 * A Simple Calculator is a basic application designed to perform fundamental arithmetic 
 * operations such as addition, subtraction, multiplication, and division. It features 
 * a user-friendly interface where users can input numbers and select operations, 
 * displaying the results in real-time.
 * 
 * Author: [Your Name]
 * Date: [Submission Date]
 * Repository: https://github.com/yourusername/Simple-Calculator-Java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    // Components of the calculator
    JTextField inputField;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, equButton, clrButton;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public SimpleCalculator() {
        // Frame settings
        setTitle("Simple Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Input field
        inputField = new JTextField();
        inputField.setBounds(30, 25, 270, 40);
        inputField.setEditable(false);
        add(inputField);

        // Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equButton.addActionListener(this);
        clrButton.addActionListener(this);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Panel to hold buttons
        panel = new JPanel();
        panel.setBounds(30, 80, 270, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                inputField.setText(inputField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '+';
            inputField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '-';
            inputField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '*';
            inputField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '/';
            inputField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(inputField.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        inputField.setText("Error: Divide by 0");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            inputField.setText(String.valueOf(result));
        }

        if (e.getSource() == clrButton) {
            inputField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
