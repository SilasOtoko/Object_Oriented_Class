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
		JButton[]blt = new JButton[10];
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
		opPanel = new JPanel(new GridLayout(5, 2, 5, 5));
		
		//create the buttons
			blt[0] = new JButton("+");
			blt[1] = new JButton("-");
			blt[2] = new JButton("*");
			blt[3] = new JButton("/");
			blt[4] = new JButton("CA");
			blt[5] = new JButton("CE");
			blt[6] = new JButton("SQR");
			blt[7] = new JButton("=");
			blt[8] = new JButton("BS");
			blt[9] = new JButton("BIN");
			
		
			for(int k = 0; k < 10; k++){
				//attach action listener
				blt[k].addActionListener(opPressed);
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
		public void actionPerformed(ActionEvent e)
		{
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
			int eFlag = 0;
			String eMess = "Error";
			
			//get values of the lcds
			String temp = lcd.getText();
			double registerA;
			try{
				registerA = Double.parseDouble(temp);
			}
			catch(Exception ex){
				registerA = 0;
			}
			temp = lcd3.getText();
			double registerB;
			try{
				registerB = Double.parseDouble(temp);
			}
			catch(Exception ex){
				registerB = 0;
			}
			
			
			String registerOP;
			registerOP = lcd2.getText();
			
			if(action.equals("CA"))
			{
				 lcd.setText("");
	             lcd2.setText("");
	             lcd3.setText("");
			}
			else if(action.equals("BS"))
			{
				String t = lcd.getText();
				int length = t.length();
				if(length > 0)
				{
					t = t.substring(0, (length-1));
					lcd.setText(t);
				}
			}
			else if(action.equals("CE"))
			{
				lcd.setText("");
			}
			else if(registerOP.equalsIgnoreCase("SQR"))
			{
				if(registerA > 0)
				{
					registerB = Math.sqrt(registerA);
				}
				else if(registerB > 0)
				{
					registerB = Math.sqrt(registerB);
				}
				else
				{
					registerB = 0;
				}
				lcd3.setText("" + registerB);
			}
			else if(action.equalsIgnoreCase("BIN"))
			{
				double d = 1;
				double n;
				String t = "";
				if(registerA > 0)
				{
					n = registerA;
				}
				else if(registerB > 0)
				{
					n = registerB;
				}
				else
				{
					n = 0;
				}
				//determine highest necessary divisor
				while(d < n)
				{
					d = d * 2;
				}
				//loop to create the string output
				while(d > 1)
				{
					if(d > n)
					{
						t = t + "0";
					}
					else
					{
						t = t + "1";
						n = n - d;
					}
					d = d / 2;
				}
				lcd3.setText(t);
				lcd2.setText("");
				lcd.setText("");
			}
			else if( lcd.getText().length() ==0)
			{
	               lcd2.setText(action);
			}
	        else if(action.equals(""))
	        {
	        	registerB = registerA;
	        	lcd.setText("");
	        	lcd2.setText(action);
	        	lcd3.setText(""+registerB);
	           }
			else{
				if(registerOP.equals("+")){
					registerB = registerB + registerA;
				}
				else if(registerOP.equalsIgnoreCase("-")){
					registerB = registerB - registerA;
				}
				else if(registerOP.equalsIgnoreCase("*")){
					registerB = registerB * registerA;
				}
				else if(registerOP.equalsIgnoreCase("/"))
				{
					if(registerA == 0)
					{
						registerB = 0;
						eMess = "Divide by Zero Error";
						eFlag = 1;
					}
					else
					{
					registerB = registerB / registerA;
					}
				}
				
				registerA = 0;
				registerOP = action;
				if(registerOP.equals("="))
			      {
			        registerOP = "";
			      }
					lcd.setText("");
					lcd2.setText(registerOP);
				if(eFlag == 0)
				{
					lcd3.setText(""+registerB);
				}
				else
				{
					lcd3.setText(eMess);
				}
			}
		}
	}
}
