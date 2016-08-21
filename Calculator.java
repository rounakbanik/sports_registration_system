import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.util.*;

public class Calculator implements ActionListener {
  JFrame frame;
  JPanel panel;
  JButton button;
  JTextField marks, income;
  JLabel calc, label1, label2, message;
  
  public static void main(String[] args) {
   Calculator calculator = new Calculator();
   calculator.go();
  }
  
  public void go() {
   frame = new JFrame("Financial Aid Calculator");
   panel = new JPanel();
   
   button = new JButton("Submit");
   button.addActionListener(this);
   
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().add(panel);
   frame.setSize(325,300);
   frame.setVisible(true);
   
   marks = new JTextField(20);
   income = new JTextField(20);
   label1= new JLabel("Enter marks secured in test: ");
   label2= new JLabel("Enter family income: ");
   calc = new JLabel("Scholarship secured: Rs. 0 ");
   message = new JLabel("Please enter valid input to get your scholarship.");
   
   panel.add(label1);
   panel.add(marks);
   panel.add(label2);
   panel.add(income);
   panel.add(calc);
   panel.add(message);
   panel.add(button);
   
  }
  
  public void actionPerformed(ActionEvent event) {
   int temp1 = Integer.parseInt(marks.getText());
   int temp2 = Integer.parseInt(income.getText());
   if(temp1 < 25 || temp2 > 1000000) {
    calc.setText("Scholarship: Not Applicable");
	message.setText("Sorry! You're not eligible for any scholarship.");
   }
   else {
    int scholar = temp1*1000 + (25000000-temp2*25)/1000;
	String forNow = String.valueOf(scholar);
	forNow = "Scholarship: Rs. " + forNow;
	calc.setText(forNow);
	message.setText("Congratulations! You're eligible for scholarship.");
   }
   
   
   
  }
}