package assignment.swings;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// <applet code="assignments.swings.SwingAppletDemo.class" width=300 height=300> </applet>

public class SwingAppletDemo extends JApplet
{
	JButton jbtn1,jbtn2;
	JTextField jtf;

	public void init()
	{
		setLayout(new FlowLayout());

		add(jbtn1 = new JButton("Click"));
		add(jtf = new JTextField(15));
		add(jbtn2 = new JButton("Clear"));	

		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jtf.setText("Hello");
			}
		});
	
		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jtf.setText("");
			}
		});

	}
}
