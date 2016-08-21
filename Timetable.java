import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Timetable implements ListSelectionListener {
   String sport;
   JList list;
   JFrame frame;
   JPanel panel;
   JLabel timings, batch;
   
   public void go() {
    frame = new JFrame("Timetable Generator");
    panel = new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
   
    frame.getContentPane().add(panel);
	
	String[] listEntries = {"Hockey", "Cricket", "Football", "Swimming", "Basketball" };
	list = new JList(listEntries);
	
	JScrollPane scroller = new JScrollPane(list);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	panel.add(scroller);
	
	list.setVisibleRowCount(3);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.addListSelectionListener(this);
	
	timings = new JLabel("Please select your sport");
	batch = new JLabel("Get the timings and batch for your sport");
	
	panel.add(timings);
	panel.add(batch);
   
    frame.setSize(300,150);
    frame.setVisible(true);
   }
   
   public static void main(String[] args) {
    Timetable table = new Timetable();
	table.go();
   }	
   
   public void valueChanged(ListSelectionEvent lse) {
     if(!lse.getValueIsAdjusting()) {
	    String selection = (String) list.getSelectedValue();
        System.out.println(selection);	
		switch(selection) {
		  case "Hockey": timings.setText("Time: Monday, 5.00-8.30 pm");
		                 batch.setText("Batch: H");
						 break;
		  case "Basketball": timings.setText("Time: Tuesday, 5.00-8.30 pm");
		                 batch.setText("Batch: B");
						 break;
		  case "Cricket": timings.setText("Time: Wednesday, 5.00-8.30 pm");
		                 batch.setText("Batch: C");
						 break;
		  case "Swimming": timings.setText("Time: Thursday, 5.00-8.30 pm");
		                 batch.setText("Batch: S");
						 break;
		  case "Football": timings.setText("Time: Friday, 5.00-8.30 pm");
		                 batch.setText("Batch: F");
						 break;
		   default: timings.setText("Please select your sport");
		            batch.setText("Get the timings and batch for your sport");
		}
	 }
    }
   
   
   
}