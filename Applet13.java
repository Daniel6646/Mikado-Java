package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet13 extends Applet
{
	Button b,b1;
	TextField t;
	public void init()
		{
		add(b=new Button("click"));
		add(t=new TextField(15));
		add(b1=new Button("clear"));
		b.addFocusListener(new FocusListener()
			{
			public void focusGained(FocusEvent e)
				{
				t.setText("HELLO");
				}
				public void focusLost(FocusEvent e)
					{
					}
			});
		b1.addFocusListener(new FocusAdapter(){});
			/*{
			public void focusGained(FocusEvent e)
				{
				t.setText("");
				}
				public void focusLost(FocusEvent e)
				{
				}
			});*/
	}
}
/*
<applet code="assignment.applets.Applet13.class" width=300 height=300>
</applet>
*/