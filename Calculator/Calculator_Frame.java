package org.example.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_Frame extends JFrame {
    private JTextField display;

    private JButton[] buttons;

    private double firstNumber;
    private double secondNumber;
    private String operator;

    public Calculator_Frame(){
        setTitle("Calculator");

        setSize(400,600);

        setResizable(false);

        setLocationRelativeTo(null); // It helps to give the gui screen at the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null); // Jframe have already has a layout manager who knows where to put things.

        display = new JTextField();
        display.setBounds(20,20,345,50);
        display.setEditable(false);// we do not want to use to edit or type it from the keyboard.
        add(display);


        buttons = new JButton[16];
        String[] values={
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "C","0","=","+"
        };
        int x = 20;
        int y = 90;

        int width = 80;
        int height = 60;

        int gap = 5;
        for (int i = 0;i<buttons.length;i++){
            buttons[i] = new JButton(values[i]);// it helps to put the buttons one by one using loop
            buttons[i].setBounds(x,y,width,height);

            buttons[i].addActionListener(new ActionListener() {  // it attaches listener to the button.
                @Override
                public void actionPerformed(ActionEvent e) { // this method is automatically called by java while clicking on the button you never call iy
          // Here e contains information about what caused the event, from which we can ask which button is clicked!

                    JButton clickedButton = (JButton) e.getSource();// This tells us which button is clicked
                    String text = clickedButton.getText();// Then we use getText() to read the text written on that button
                    if(text.equals("C")){
                        display.setText("");
                    }
                    // It will check what which button is clicked and when it is equals to C then it will display "".

                    else if (text.equals("+")) {
                        firstNumber=Double.parseDouble(display.getText());// Converting the text into numbers.
                        display.setText("");// It will clear the display after pressing the operator
                        operator = "+";

                    } else if (text.equals("-")) {
                        firstNumber = Double.parseDouble(display.getText());
                        display.setText("");
                        operator = "-";

                    } else if (text.equals("*")) {
                        firstNumber = Double.parseDouble(display.getText());
                        display.setText("");
                        operator ="*";

                    } else if (text.equals("/")) {
                        firstNumber = Double.parseDouble(display.getText());
                        display.setText("");
                        operator="/";

                    } else if (text.equals("=")) {
                        secondNumber = Double.parseDouble(display.getText());// The second number is currently
                        // on the display, and we need to save it into the secondNumber variable by converting it.

                        double answer= firstNumber+secondNumber;
                        display.setText(String.valueOf(answer));

                        double answer1 = firstNumber - secondNumber;
                        display.setText(String.valueOf(answer1));

                        double answer2 = firstNumber * secondNumber;
                        display.setText(String.valueOf(answer2));

                        double answer3 = secondNumber / firstNumber;
                        display.setText(String.valueOf(answer3));

                    } else{
                        String current= display.getText();
                        display.setText(current+text);
                    }
            // The above code basically means that it will add the currentText to the text we clicked before and display it.

                }
            });

            add(buttons[i]);
            x=x+width+gap; // It helps to set the button with perfect width at correct position.

            if((i+1)%4==0){
                x=20;
                y=y+height+gap;
            }
        }


        setVisible(true);

    }
}
