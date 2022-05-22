package assignment.io;
import java.io.*;
public class Employee implements Serializable
{
	transient int id;
	String name;
	double salary;
	public Employee()
	{
	}
	public Employee(int id,String name, double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return name;
	}
	public void setsalary(double salary)
	{
		this.salary=salary;
	}
	public double getsalary()
	{
		return salary;
	}
	public String toString()
	{
		return "id= " +id + " name=" +name + " salary=" +salary;
	}
};