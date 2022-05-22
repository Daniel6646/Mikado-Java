class A
{
	B b;
		public void takeRef(B b)
	{ 
		this.b=b;
	}
	public synchronized void m1()
	{
		System.out.println("Inside m1()");
		try
		{
			Thread.sleep(200);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		b.m4();
			System.out.println("Finished  m1()");
	}
	public synchronized void m2()
	{System.out.println("Inside m2()");
	System.out.println("Finished m2()");
	}
};
class B
{
	A a;
	public B(A a)
	{
		this.a=a;
	}
	public synchronized void m3()
	{
		System.out.println("Inside m3()");
		try
		{
			Thread.sleep(300);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		a.m2();
		System.out.println("Finished m3()");
	}
	public synchronized void m4()
	{
		System.out.println("Inside m4()");
		System.out.println("Finished m4()");
	}
};
class ThreadA extends Thread
{
	A a;
	public ThreadA(A a)
	{
		this.a=a;
		start();
	}
	public void run()
	{
		a.m1();
	}
};
class ThreadB extends Thread
{
	B b;
	public ThreadB(B b)
	{
		this.b=b;
		start();
	}
	public void run()
	{
		b.m3();
	}
};
public class Deadlock
{
	public static void main(String args[])
	{
		A a=new A();
	B b=new B (a);
	a.takeRef(b);
	new ThreadA(a);
	new ThreadB(b);
	}
};