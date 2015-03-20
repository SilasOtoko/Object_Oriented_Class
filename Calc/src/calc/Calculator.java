package calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	JFrame calc = new JFrame("My Awesome Calculator");
	
	//create some panels
	JPanel topPanel;
		JTextField lcd, lcd2, lcd3;
	JPanel keyPanel;
		JButton[]btn = new JButton[12];
		
	
	//constructor
	public Calculator(){
		//set up the top panel
		topPanel = new JPanel();
		//set the panels layout manager
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		
		//add the lcds to the topPanel
		lcd = new JTextField(20);
		lcd.setText("LCD");
		lcd.setHorizontalAlignment(JTextField.RIGHT);
		lcd2 = new JTextField(20);
		lcd2.setText("LCD2");
		lcd2.setHorizontalAlignment(JTextField.RIGHT);
		lcd3 = new JTextField(20);
		lcd3.setText("LCD3");
		lcd3.setHorizontalAlignment(JTextField.RIGHT);
		
		//add lcds to the panel
		topPanel.add(lcd3);
		topPanel.add(lcd2);
		topPanel.add(lcd);
		
		//add topPanel to the Frame
		calc.add(topPanel,BorderLayout.NORTH);
		
		
		//set up the keyPanel
		keyPanel = new JPanel(new GridLayout(4, 3, 5, 5));
		
		//make the buttons
		for(int k=0; k<10; k++)
			btn[k] = new JButton("" + k);
		btn[10] = new JButton(".");
		btn[11] = new JButton("00");
		
		//add the buttons to the keyPanel
		keyPanel.add(btn[7]);
		keyPanel.add(btn[8]);
		keyPanel.add(btn[9]);
		
		keyPanel.add(btn[4]);
		keyPanel.add(btn[5]);
		keyPanel.add(btn[6]);
		
		keyPanel.add(btn[1]);
		keyPanel.add(btn[2]);
		keyPanel.add(btn[3]);
		
		keyPanel.add(btn[0]);
		keyPanel.add(btn[10]);
		keyPanel.add(btn[11]);
		
		//attach keyPanel to frame
		calc.add(keyPanel, BorderLayout.CENTER);
		
		
		
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setSize(600, 400);
		calc.setVisible(true);
	}
}
