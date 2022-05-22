package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet15 extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawLine(0,0,200,190);
		g.drawRect(50,0,70,80);
		g.fillRect(100,0,70,80);
		g.drawOval(0,90,80,90);
		g.fillOval(50,90,80,90);
		g.drawArc(140,70,60,40,0,-90);
		g.fillArc(140,140,60,40,0,90);
		setFont( new Font("Viner Hand ITC",3,29));
		g.drawString("harshad",100,100);
	}
};
/*
<applet code="assignment.applets.Applet15.class" width=300 height=300>
</applet>
*/