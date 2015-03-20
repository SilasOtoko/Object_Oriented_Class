package calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		Kpress keyPressed = new Kpress();
	JPanel opPanel;
		JButton[]blt = new JButton[8];
		Opress opPressed = new Opress();
		
	
	//constructor
	public Calculator(){
		//set up the top panel
		topPanel = new JPanel();
		//set the panels layout manager
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		
		//add the lcds to the topPanel
		lcd = new JTextField(20);
		lcd.setHorizontalAlignment(JTextField.RIGHT);
		lcd2 = new JTextField(20);
		lcd2.setHorizontalAlignment(JTextField.RIGHT);
		lcd3 = new JTextField(20);
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
		
		//attach listener to the buttons
		for(int k = 0; k < 12; k++)
			btn[k].addActionListener(keyPressed);
		
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
		
		//create the opPanel
		opPanel = new JPanel(new GridLayout(4, 2, 5, 5));
		
		//create the buttons
			blt[0] = new JButton("+");
			blt[1] = new JButton(".");
			blt[2] = new JButton("*");
			blt[3] = new JButton("/");
			blt[4] = new JButton("CA");
			blt[5] = new JButton("CE");
			blt[6] = new JButton("BS");
			blt[7] = new JButton("=");
			
		
			for(int k = 0; k < 8; k++){
				opPanel.add(blt[0]);
				//attach action listener
				//blt[k].addActionListener(opPressed);
				//place buttons on the opPanel
				opPanel.add(blt[k]);
			}
			
			//put the opPanel on the frame
				calc.add(opPanel, BorderLayout.EAST);
			
		
		
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setSize(600, 400);
		calc.setVisible(true);
	}
	
	private class Kpress implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String key = e.getActionCommand();
			String temp = lcd.getText();
			if(key.equals(".")){
				if(!temp.contains("."))
					temp = temp + key;
			}
			else
				temp = temp + key;
			lcd.setText(temp);
		}
	}
	
	private class Opress implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String action = e.getActionCommand();
			
			//get values of the lcds
			String temp = lcd.getText();
			double registerA;
			try{
				registerA = Double.parseDouble(temp);
			}
			catch(Exception ex){
				registerA = 0;
			}
			
		}
	}
}
