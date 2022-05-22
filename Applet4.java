package assignment.applets;
import java.awt.*;
import java.applet.Applet;
public class Applet4 extends Applet
{
	Button b;
	TextField t1,t2,t3;
	Label l;
	public void init()
	{
		add(t1=new TextField(15));
		add(l=new Label("+"));
		add(t2=new TextField(15));
		add(b=new Button("="));
		add(t3=new TextField(15));
	}
	public boolean action(Event e,Object o)
	{
		if(e.target.equals(b))
		{
			String s=t1.getText();
			String s1=t2.getText();
			int i=Integer.parseInt(s);
			int j=Integer.parseInt(s1);
			int k=i+j;
			String str=String.valueof(k);
			t3.setText(str);
		}
	}
	return true;
}
/*
<applet code="assignment.applets.Applet4.class" width=300 height=300>
</applet>
*/