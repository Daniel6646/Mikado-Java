package assignment.applets;
import java.awt.*;
import java.applet.Applet;
public class Applet5 extends Applet
{
	Checkbox c1,c2,c3,c4;
	TextField t;
	public void init()
	{
		setLayout(new GridLayout(5,1));
		add(c1=new Checkbox("1"));
		add(c2=new Checkbox("2"));
		add(c3=new Checkbox("3"));
		add(c4=new Checkbox("4"));
		add(t=new TextField(15));
	}
	public boolean action(Event e,Object o)
	{
		int sum=0;
	if(c1.getState())
		sum=sum+1;
	if(c2.getState())
		sum=sum+2;
	if(c3.getState())
		sum=sum+3;
	if(c4.getState())
		sum=sum+4;
	String s = String.valueOf(sum);
	t.setText(s);
	return true;
	}
}
/*
<applet code="assignment.applets.Applet5.class" width=300 height=300>
</applet>
*/