package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet10 extends Applet
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
		b.addActionListener(new B(this));
		b1.addActionListener(new A(this));
	}
}
class B implements ActionListener
{
 Applet10 a10;
		public B(Applet10 a10)
		{
			this.a10=a10;
		}
		public void actionPerformed(ActionEvent e)
			{
			a10.t.setText("hello");
			}
	}
class A implements ActionListener
{
Applet10 a10;
		public A	 (Applet10 a10)
		{
			this.a10=a10;
		}
		public void actionPerformed(ActionEvent e)
			{
				a10.t.setText(" ");
			}
}
	/*
<applet code="assignment.applets.Applet10.class" width=300 height=300>
</applet>
*/