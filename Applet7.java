package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet7 extends Applet implements ActionListener
{
	Button b,b1;
	TextField t;
	public void init()
	{
		add(b=new Button("click"));
		add(t=new TextField(1));
		add(b1=new Button("clear"));
		b.addActionListener(this)
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		Object o=e.getSource();
		if(o.equals(b))
			t.setText("hello");
		if(o.equals(b1))
			t.setText(" ");
	}
}
	/*
<applet code="assignment.applets.Applet7.class" width=250 height=300>
</applet>
*/