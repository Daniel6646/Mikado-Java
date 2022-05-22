package assignment.threads;
class Q
{
	int count;
	public void put(int count)
	{
		this.count=count;
		System.out.println("put="+count);
	}
	public int get()
	{
		System.out.println("get="+count);
		return count;
	}
}
class Producer extends Thread
{
	int count;
	Q q;
	public Producer(Q q)
	{
		this.q=q;
		start();
	}
	public void run()
	{
		while(true)
		{
			q.put(count);
			count++;
			try
			{
				Thread.sleep(200);
			}
			catch(Exception e)
			{
			}
		}
	}
}
class Consumer extends Thread
{
	int count;
	Q q;
	public Consumer(Q q)
	{
		this.q=q;
		start();
	}
	public void run()
	{
		while(true)
		{
			count=q.get();
			try
			{
				Thread.sleep(400);
			}
			catch(Exception e)
			{
			}
		}
	}
};
public class ProdCon
{
	public static void main(String[] args) 
	{
		Q q=new Q();
		new Producer(q);
		new Consumer(q);
	}
}
