package assignment.threads;
class Q
{
	int count;
	boolean flag=true;
	public synchronized void put(int count)
	{
		if(!flag)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
			}
		}
		this.count=count;
		System.out.println("Put ="+count);
		flag=false;
		notify();
	}
	public synchronized int get()
	{
		if(flag)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
			}
		}
		System.out.println("Get ="+ count);
		flag=true;
		notify();
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
public class ProdCon1
{
	public static void main(String[] args) 
	{
		Q q=new Q();
		new Producer(q);
		new Consumer(q);
	}
}
