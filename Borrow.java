import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Borrow implements ActionListener {
   JList list;
   JFrame frame;
   JPanel panel;
   JButton button;
   JLabel dateSub, fine;
   
   public void go() {
    frame = new JFrame("Sports Equipment Borrowing Forum");
    panel = new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
   
    frame.getContentPane().add(panel);
	
	button = new JButton("Borrow it");
	button.addActionListener(this);
	
	
	String[] listEntries = {"Hockey Bat", "Cricket Bat", "Football", "Swimming Suit", "Basketball", "Gloves", "Pads", "Goggles" };
	list = new JList(listEntries);
	
	JScrollPane scroller = new JScrollPane(list);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panel.add(scroller);
	
	list.setVisibleRowCount(3);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	dateSub = new JLabel("Please select your sport equipment");
	fine = new JLabel("Get the due date and fine for your equipment");
	
	panel.add(dateSub);
	panel.add(fine);
	panel.add(button);
   
    frame.setSize(400,250);
    frame.setVisible(true);
   }
   
   public static void main(String[] args) {
    Borrow borrow = new Borrow();
	borrow.go();
   }	
   
   public void actionPerformed(ActionEvent event) {
    String sport = (String) list.getSelectedValue();
	switch(sport) {
		  case "Hockey Bat": dateSub.setText("Date of Submission: December 20th, 2014");
		                 fine.setText("Fine: Rs. 150");
						 break;
		  case "Basketball": dateSub.setText("Date of Submission: December 21st, 2014");
		                 fine.setText("Fine: Rs. 200");
						 break;
		  case "Cricket Bat": dateSub.setText("Date of Submission: December 22nd, 2014");
		                 fine.setText("Fine: Rs. 100");
						 break;
		  case "Swimming Suit": dateSub.setText("Date of Submission: December 23rd, 2014");
		                 fine.setText("Fine: Rs. 350");
						 break;
		  case "Football": dateSub.setText("Date of Submission: December 24th, 2014");
		                 fine.setText("Fine: Rs. 250");
						 break;
		  case "Gloves": dateSub.setText("Date of Submission: December 25th, 2014");
		                 fine.setText("Fine: Rs. 125");
						 break;
		  case "Goggles": dateSub.setText("Date of Submission: December 26th, 2014");
		                 fine.setText("Fine: Rs. 25");
						 break;
		  case "Pads": dateSub.setText("Date of Submission: December 27th, 2014");
		                 fine.setText("Fine: Rs. 320");
						 break;
		   default: dateSub.setText("Please select your sport");
		            fine.setText("Get the timings and batch for your sport");
		}
	
    }
   
   
   
   
}