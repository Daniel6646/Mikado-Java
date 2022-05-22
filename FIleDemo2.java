package assignment.io;
import java.io.*;
import java.util.Date;
public class FileDemo2
{
	public static void main(String args[])
	{
	File f=new File("D:\\Students\\harshad\\xyz.txt");
	System.out.println("Name= " +f.getName());
	System.out.println("Parent=" +f.getParent());
	System.out.println("Path= "+f.getPath());
	System.out.println("is File=" +f.isFile());
	System.out.println("is Directory=" +f.isDirectory());
	System.out.println("can Read="+f.canRead());
	System.out.println("can Write=" +f.canWrite());
	System.out.println("exists="+f.exists());
	System.out.println("length="+f.length());
	System.out.println("lastModified="+new Date(f.lastModified()));
	String str[]=f.list();
	for(String s:str)
		System.out.println(s+" ");
	System.out.println();
	System.out.println("Rename To="+f.renameTo(new File("D:\\Students\\harshad\\abc.txt")));

	}
};