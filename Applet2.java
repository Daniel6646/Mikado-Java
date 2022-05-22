package assignment.applets;
import java.awt.Button;
import java.applet.Applet;
public class Applet2 extends Applet
{
	Button b;
	public void init()
	{
		add(b=new Button("click"));
		//b=new Button("click");
			//add(b);
			//b.setLabel("click");
	}
}
/*
<applet code="assignment.applets.Applet2.class" width=300 height=300>
</applet>
*/