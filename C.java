package assignment.basic;
class A
{
	public A()
	{
	}
	public A(String S)
	{
	}
	public void m1()
	{
		System.out.println("Hi");
	}
};
class B extends A
{
	public B()
	{
	}
	public B(String S)
	{
	}
	public void m2()
	{
		System.out.println("Bye");
	}
	public void m1()
	{
		System.out.println("Hello");
	}
	public void m1(String s)
	{
		System.out.println(s);
	}
};
public class C
{
	public static void main (String args [])
	{
		A a,a1;
		B b;
		a=new A("harshad");
		b=new B();
		a1=a;
		a1.m1();
		a1=b;
		a1.m1();
	}
};