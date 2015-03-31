package helloGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormHello 
{
	//Introduce all the components
		//Introduce action listener
			ButtonListener btnPressed = new ButtonListener();
		//Introduce the frame
			JFrame frameHello = new JFrame("Hello GUI");	
		//Introduce the panel
			JPanel panelHello;
		//Introduce the components
			JLabel lblWorld;
			JButton btnGo;
			JButton btnReset;
			
	//Create the constructor
		public FormHello()
		{
			//create the panel and add controls
				//create the panel
					panelHello = new JPanel();
						panelHello.setLayout(new FlowLayout());
					//create the controls
						lblWorld = new JLabel("Hello World");
						btnGo = new JButton("Press Me");
						btnReset = new JButton("Reset");
					//attach action listener button
						btnGo.addActionListener(btnPressed);
						btnReset.addActionListener(btnPressed);
					//add controls to panel
						panelHello.add(lblWorld);
						panelHello.add(btnGo);
						panelHello.add(btnReset);
					//add panel to form
						frameHello.add(panelHello);
			//add lines to control the frame
				//set the frame size
					frameHello.setSize(400,400);
				//set the default close method
					frameHello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//make the frame visible
					frameHello.setVisible(true);
		}
		
		/*create a private inner class for the action listener
		*putting it here gives it scope access to all of the
		*controls on the form.
		*/
		private class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				//here is where we code the action
					String action = event.getActionCommand();
					if(action.equals("Reset"))
					{
						lblWorld.setText("Hello World");
						btnGo.setEnabled(true);
						btnReset.setEnabled(false);
					}
					else
					{	
						lblWorld.setText("Hello GUI World");
						btnGo.setEnabled(false);
						btnReset.setEnabled(true);
					}
			}
		}
}
