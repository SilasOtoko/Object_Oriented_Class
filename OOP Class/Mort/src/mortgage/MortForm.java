package mortgage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MortForm {
	//define the controls
	//#1 make a frame
		JFrame loanCalc = new JFrame("Mort");
	//#2 make a panel;
		JPanel loanPanel;
	//#3 introduce controls
		JLabel lblAmount;
		JTextField txtAmount;
		JLabel lblRate;
		JTextField txtRate;
		JLabel lblYears;
		JTextField txtYears;
		JLabel lblPmt;
		JLabel lblAnswer;
		JButton btnGo;
		JButton btnClear;
		
	
	//constructor is the form
	public MortForm()
	{
		//create the panel
			loanPanel = new JPanel();
			
		//add layout manager
			loanPanel.setLayout(new GridLayout(5, 2, 5, 5));
			
		//instantiate controls
			lblAmount = new JLabel("Enter Amount");
			txtAmount = new JTextField(20);
			lblRate = new JLabel("Enter Int Rate");
			txtRate = new JTextField(20);
			lblYears = new JLabel("Enter Years");
			txtYears = new JTextField(20);
			lblPmt = new JLabel("Your Payment is");
			lblAnswer = new JLabel("");
			btnGo = new JButton("Go");
			btnClear = new JButton("Clear");
			
		//attach action listener
		
		//add controls to the panel
			loanPanel.add(lblAmount);
			loanPanel.add(txtAmount);
			loanPanel.add(lblRate);
			loanPanel.add(txtRate);
			loanPanel.add(lblYears);
			loanPanel.add(txtYears);
			loanPanel.add(lblPmt);
			loanPanel.add(lblAnswer);
			loanPanel.add(btnGo);
			loanPanel.add(btnClear);
			
		
		//attach panel to frame
			loanCalc.add(loanPanel);
		
		//these lines finalize the form and display it
			loanCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loanCalc.setSize(400, 600);
			loanCalc.setVisible(true);
	}
	
	//define the action listener class
	private class BtnPress implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String button = e.getActionCommand();
			if(button.equals("Clear"))
			{
				txtAmount.setText("");
				txtYears.setText("");
				txtRate.setText("");
				lblAnswer.setText("");
			}
		}
	}
	
	
}
