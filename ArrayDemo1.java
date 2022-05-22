package assignment.arrays;
import java.awt.*;
import java.awt.event.*;
public class ArrayDemo1 extends Frame
{
	int x[],y[];
	public ArrayDemo1()
	{
		x=new int[10];
		y=new int[10];
		for(int i=0;i<x.length;i++)
			{
			x[i]=(int)(200*Math.random());
			y[i]=(int)(200*Math.random());
			}
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
	public void paint(Graphics g)
	{
		g.drawPolygon(x,y,10);
	}
	public static void main(String args[])
	{
		new ArrayDemo1();
	}
}