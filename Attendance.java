import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.util.*;

public class Attendance implements ActionListener {
  JFrame frame;
  JPanel panel;
  JButton button;
  JTextField attended, total;
  JLabel attendan, label1, label2, message;
  
  public static void main(String[] args) {
   Attendance attendance = new Attendance();
   attendance.go();
  }
  
  public void go() {
   frame = new JFrame("Attendance Register");
   panel = new JPanel();
   
   button = new JButton("Submit");
   button.addActionListener(this);
   
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().add(panel);
   frame.setSize(325,300);
   frame.setVisible(true);
   
   attended = new JTextField(20);
   total = new JTextField(20);
   label1= new JLabel("Number of classes attended: ");
   label2= new JLabel("Total number of classes attended: ");
   attendan = new JLabel("Your attendance: ");
   message = new JLabel("Please enter valid input to get your attendance.");
   
   panel.add(label1);
   panel.add(attended);
   panel.add(label2);
   panel.add(total);
   panel.add(attendan);
   panel.add(message);
   panel.add(button);
   
  }
  
  public void actionPerformed(ActionEvent event) {
   int temp1 = Integer.parseInt(attended.getText());
   int temp2 = Integer.parseInt(total.getText());
   int temp3 = temp1/temp2;
   double temp4 = ((double)temp1*100)/(double)temp2;
   String attends = String.valueOf(temp4);
   String finals = "Your attendance: " + attends;
   if(temp4 >= 75) {
   message.setText("Congratulations! You're eligible to write the final exams.");
   attendan.setText(finals);
   }
   else {
   message.setText("Sorry! Not eligible to write the final exams.");
   attendan.setText(finals);
   }
   
  }
}