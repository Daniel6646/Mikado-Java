package assignment.applets;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Applet12 extends Applet
{
	Button b,b1;
	TextField t;
	public void init()
		{
		add(b=new Button("click"));
		add(t=new TextField(15));
		add(b1=new Button("clear"));
		b.addActionListener((ActionEvent e)->{t.setText("hello");});
		b1.addActionListener((ActionEvent e)->{t.setText("");});
		//b.addActionListener((e)->{t.setText("hello");});
		//b1.addActionListener((e)->{t.setText(" ");});
		//b.addActionListener((e)->t.setText("hello"));
		//b1.addActionListener((e)->t.setText(" "));
	}
}

	/*
<applet code="assignment.applets.Applet12.class" width=300 height=300>
</applet>
*/