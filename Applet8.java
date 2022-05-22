package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet8 extends Applet implements ActionListener
{
	Button b,b1;
	TextField t;
	public void init()
	{
		add(b=new Button("click"));
		add(t=new TextField(15));
		add(b1=new Button("clear"));
		b.addActionListener(this);
		b1.addActionListener(new A());
	}
	public void actionPerformed(ActionEvent e)
	{
			t.setText("hello");
	}
	public class A implements ActionListener
		{
		public void actionPerformed(ActionEvent e)
			{
				t.setText(" ");
			}
		}
}
	/*
<applet code="assignment.applets.Applet8.class" width=250 height=300>
</applet>
*/