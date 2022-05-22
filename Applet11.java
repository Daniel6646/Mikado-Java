package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet11 extends Applet
{
	Button b,b1;
	TextField t;
	public void init()
		{
		add(b=new Button("click"));
		add(t=new TextField(15));
		add(b1=new Button("clear"));
		//A a=new A(this);
		//a.takeRef(this);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				t.setText("hello");
			}
		});
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				t.setText(" ");
			}
		});
	}
}

	/*
<applet code="assignment.applets.Applet11.class" width=300 height=300>
</applet>
*/