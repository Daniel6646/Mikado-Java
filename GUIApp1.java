package assignment.guiapps;
import java.awt.*;
import java.awt.event.*;
public class GUIApp1 extends Frame
{
	Button b,b1;
	TextField t;
	public GUIApp1()
	{
		setLayout(new FlowLayout());
		add(b=new Button("Click"));
		add(t=new TextField(15));
		add(b1=new Button("Clear"));
		b.addActionListener((e)->t.setText("Hello"));
		b1.addActionListener((e)->t.setText(""));
		addWindowListener(new WindowAdapter()
		{
			@Override
				public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new GUIApp1();
	}
}