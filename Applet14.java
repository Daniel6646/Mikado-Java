package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet14 extends Applet
{
	public void init()
	{
		addMouseMotionListener(new MouseMotionAdapter()
		{
		@Override
			public void mouseMoved(MouseEvent e)
			{
			int x= e.getX();
			int y=e.getY();
			showStatus(String.valueOf(x)+","+String.valueOf(y));
			}
		}
	}
};
/*
<applet code="assignment.applets.Applet14.class" width=300 height=300>
</applet>
*/