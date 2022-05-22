package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet16 extends Applet
{
	Button b;
	Boolean flag;
	public void init()
	{
		flag=true;
		add(b=new Button("Click"));
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				flag=!flag;
				repaint();
			}
		});
	}
	public void paint(Graphics g)
		{
		if (flag)
			g.fillRect(100,100,100,100);
		else
			g.fillOval(100,100,100,100);
		}
}
	
/*
<applet code="assignment.applets.Applet16.class" width=300 height=300>
</applet>
*/