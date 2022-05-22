package assignments.applets;
import java.awt.*;
import java.applet.Applet;
public class Applet6 extends Applet
{
	Panel1 p1;
	Panel2 p2;
	public void init()
	{
		setLayout(new GridLayout(1,2));
		add(p1=new Panel1());
		add(p2=new Panel2());
		p2.c1.setState(true);
		p2.c2.setState(true);
		p2.c3.setState(false);
		p2.t.setText("12000");
		p2.t.setEditable(false);
	}
	public boolean action(Event e,Object o)
	{
	if(p1.c1.getState())
		{
		p2.c1.setState(true);
		p2.c2.setState(true);
		p2.c3.setState(false);
		p2.t.setText("12000");
		}
	if(p1.c2.getState())
		{
		p2.c1.setState(true);
		p2.c2.setState(false);
		p2.c3.setState(true);
		p2.t.setText("14000");
		}
	if(p1.c3.getState())
		{
		p2.c1.setState(false);
		p2.c2.setState(true);
		p2.c3.setState(true);
		p2.t.setText("15000");
		}
		return true;
	}
}
class Panel1 extends Panel
{
	Checkbox c1,c2,c3;
	CheckboxGroup group;
	public Panel1()
	{
		group=new CheckboxGroup();
		setLayout(new GridLayout(3,1));
		add(c1=new Checkbox("Tour1",group,true));
		add(c2=new Checkbox("Tour2",group,false));
		add(c3=new Checkbox("Tour3",group,false));
	}
};
class Panel2 extends Panel
{
	Checkbox c1,c2,c3;
	TextField t;
	public Panel2()
	{
		setLayout(new GridLayout(4,1));
		add(c1=new Checkbox("Shimla"));
		add(c2=new Checkbox("Manali"));
		add(c3=new Checkbox("Dalhousie"));
		add(t=new TextField(15));
	}
};
/*
<applet code="assignment.applets.Applet6.class" width=250 height=300>
</applet>
*/