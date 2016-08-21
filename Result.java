import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.util.*;

public class Result implements ActionListener {
  String name;
  int score;
  JFrame frame;
  JPanel panel;
  JButton button;
  JTextField namef, scoref;
  JLabel namel, scorel;
  
  public static void main(String[] args) {
   Result result  = new Result();
   result.go();
  }
  
  public void go() {
   frame = new JFrame("Results");
   panel = new JPanel();
   
   button = new JButton("Submit Score");
   button.addActionListener(this);
   
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().add(panel);
   frame.setSize(325,300);
   frame.setVisible(true);
   
   namef = new JTextField(20);
   scoref = new JTextField(20);
   namel = new JLabel("Enter your name: ");
   scorel = new JLabel("Enter marks secured: ");
   
   panel.add(namel);
   panel.add(namef);
   panel.add(scorel);
   panel.add(scoref);
   panel.add(button);
   
  }
  
  public void actionPerformed(ActionEvent event) {
   name = namef.getText();
   score = Integer.parseInt(scoref.getText());
   button.setText("It works!");
   if(score < 25) {
    JOptionPane.showMessageDialog(null, "Sorry! You didn't qualify.", "Message", JOptionPane.PLAIN_MESSAGE);	
   }
   else {
    JOptionPane.showMessageDialog(null, "Congrats! You qualified", "Message", JOptionPane.PLAIN_MESSAGE);
	try {
    FileWriter writer = new FileWriter("Qualified.txt", true);
	BufferedWriter buffer = new BufferedWriter(writer);
	PrintWriter out = new PrintWriter(buffer);
	out.println(name);
	out.close();
   }
   catch (Exception ex) {
     System.out.println("Oops! Something went wrong.");
	 ex.printStackTrace();
   }
	Medical medical = new Medical();
	medical.go(name);
  }  
 }
}

class Medical implements ActionListener {
 JFrame frame;
 JPanel panel;
 JList list;
 JTextArea text;
 JButton button;
 JLabel heightl, weightl, listl, textl;
 JTextField heightf, weightf;
 int height, weight;
 String name;
 
 public void go(String theName) {
   frame = new JFrame("Medical Reports");
   panel = new JPanel();
   name = theName;
   
   button = new JButton("Submit Report");
   button.addActionListener(this);
   
   String[] listEntries = {"Yes", "No"};
   list = new JList(listEntries);
   
   JScrollPane scroller = new JScrollPane(list);
   scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
   list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
   text = new JTextArea(10,20);
   
   JScrollPane scroller1 = new JScrollPane(text);
   text.setLineWrap(true);
   
   scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   scroller1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   
   heightf = new JTextField(20);
   weightf = new JTextField(20);
   
   panel.add(new JLabel("Enter your height (in cm): "));
   panel.add(heightf);
   panel.add(new JLabel("Enter your weight (in kg): "));
   panel.add(weightf);
   panel.add(new JLabel("Do you have any chronic diseases?" ));
   panel.add(scroller);
   panel.add(new JLabel("List your allergies: "));
   panel.add(scroller1);
   panel.add(button);
   
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().add(panel);
   frame.setSize(325,600);
   frame.setVisible(true);
 }
 
 public void actionPerformed(ActionEvent event) {
  button.setText("It works!");
  height = Integer.parseInt(heightf.getText());
  weight = Integer.parseInt(weightf.getText());
  double bmi = ((double)weight)/(((double)height/100)*((double)height/100));
  if(bmi < 20 || bmi > 35 || list.getSelectedValue().equals("Yes")) {
   JOptionPane.showMessageDialog(null, "Sorry! Not eligible for academy." , "Message", JOptionPane.PLAIN_MESSAGE);   
  }
  else {
   JOptionPane.showMessageDialog(null, "Congrats! You're eligible.", "Message", JOptionPane.PLAIN_MESSAGE);
   Enrolled enrolled = new Enrolled();
   enrolled.go(name);
  } 
 }
}


 
class Enrolled implements ActionListener {
  String name, age, dob, sex, father, city;
  JFrame frame;
  JPanel panel;
  JButton button;
  JTextField namef, agef, dobf, sexf, fatherf, cityf;
  JLabel namel, agel, dobl, sexl, fatherl, cityl, info;
  JTextArea text;
  
  
  public void go(String theName) {
   frame = new JFrame("Enrolment Form");
   panel = new JPanel();
   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
   
   
   button = new JButton("Submit");
   button.addActionListener(this);
   
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().add(panel);
   frame.setSize(385,410);
   frame.setVisible(true);
   
   namef = new JTextField(20);
   namef.setText(theName);
   agef = new JTextField(20);
   dobf = new JTextField(20);
   sexf = new JTextField(20);
   fatherf = new JTextField(20);
   cityf = new JTextField(20);
   
   namel= new JLabel("Name: ");
   agel= new JLabel("Age: ");
   dobl = new JLabel("Date of Birth: ");
   sexl = new JLabel("Sex: ");
   fatherl = new JLabel("Father's name: ");
   cityl = new JLabel("City: ");
   info = new JLabel("Highlight your achievements and medals won in this box: ");
   
   text = new JTextArea(10,20);
   JScrollPane scroller = new JScrollPane(text);
   text.setLineWrap(true);
   scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   
   panel.add(namel);
   panel.add(namef);
   panel.add(agel);
   panel.add(agef);
   panel.add(dobl);
   panel.add(dobf);
   panel.add(sexl);
   panel.add(sexf);
   panel.add(fatherl);
   panel.add(fatherf);
   panel.add(cityl);
   panel.add(cityf);
   panel.add(info);
   panel.add(scroller);
   panel.add(button);
   
  }
  
  public void actionPerformed(ActionEvent event) {
   name = namef.getText();
   age = agef.getText();
   sex = sexf.getText();
   dob = dobf.getText();
   father = fatherf.getText();
   city = cityf.getText();

   try {
    FileWriter writer = new FileWriter("Enrolled.txt", true);
	BufferedWriter buffer = new BufferedWriter(writer);
	PrintWriter out = new PrintWriter(buffer);
	out.println(name + ", " + age + ", " + sex + ", " + dob + ", " + father + ", " + city);
	out.close();
   }
   catch (Exception ex) {
     System.out.println("Oops! Something went wrong.");
	 ex.printStackTrace();
   }
   
   JFrame frame = new JFrame("ID Card");
   JPanel panel = new JPanel();
   MyDrawPanel drawPanel = new MyDrawPanel();
   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
   
   frame.getContentPane().add(panel);
   
   frame.setSize(300,280);
   frame.setVisible(true);
   
   panel.add(drawPanel);
   panel.add(new JLabel("Name: " + name));
   panel.add(new JLabel("Age: " + age));
   panel.add(new JLabel("Sex: " + sex));
   panel.add(new JLabel("Date of Birth: " + dob));
   panel.add(new JLabel("Father's Name: " + father));
   panel.add(new JLabel("City: " + city));
   panel.add(new JLabel("Test Date: 25th December, 2014 "));
   panel.add(new JLabel("Address: IIT Roorkee, Uttarakhand"));
      
  }
}

class MyDrawPanel extends JPanel {
   public void paintComponent(Graphics g) {
    Image image = new ImageIcon("DP.jpg").getImage();
	g.drawImage(image, 100, 10, this);
   }
}   