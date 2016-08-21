import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.util.*;

public class Admission implements ActionListener {
  String name, age, dob, sex, father, city;
  JFrame frame;
  JPanel panel;
  JButton button;
  JTextField namef, agef, dobf, sexf, fatherf, cityf;
  JLabel namel, agel, dobl, sexl, fatherl, cityl, info;
  JTextArea text;
  
  public static void main(String[] args) {
   Admission admission = new Admission();
   admission.go();
  }
  
  public void go() {
   frame = new JFrame("Admission Form");
   panel = new JPanel();
   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
   
   
   button = new JButton("Submit");
   button.addActionListener(this);
   
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().add(panel);
   frame.setSize(385,410);
   frame.setVisible(true);
   
   namef = new JTextField(20);
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
    FileWriter writer = new FileWriter("Register.txt", true);
	BufferedWriter buffer = new BufferedWriter(writer);
	PrintWriter out = new PrintWriter(buffer);
	out.println(name + ", " + age + ", " + sex + ", " + dob + ", " + father + ", " + city);
	out.close();
   }
   catch (Exception ex) {
     System.out.println("Oops! Something went wrong.");
	 ex.printStackTrace();
   }
   
   JFrame frame = new JFrame("Admit Card");
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