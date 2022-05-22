package assignment.io;

public class IODemo2
{
	public static void main(String args[])
	{
		System.out.println("Keep Typing");
		System.out.println("q to quit");

		while(true)
		{
			try{
				char c = (char)System.in.read();
				System.out.println(c);
				if(c == 'q')
					break;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}