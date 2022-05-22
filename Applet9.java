package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet9 extends Applet
{
	Button b,b1;
	TextField t;
	public void init()
	{
		add(b=new Button("click"));
		add(t=new TextField(15));
		add(b1=new Button("clear"));
		b.addActionListener(new A());
		b1.addActionListener(new B());
	}
	public class A implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
			t.setText("hello");
			}
	}
	public class B implements ActionListener
		{
		public void actionPerformed(ActionEvent e)
			{
				t.setText(" ");
			}
		}
}
	/*
<applet code="assignment.applets.Applet9.class" width=300 height=300>
</applet>
*/