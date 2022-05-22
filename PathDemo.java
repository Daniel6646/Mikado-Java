package assignment.nio;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;
public class PathDemo
{
	public static void main(String args[])
	{
		Path samplePath = Paths.get("D:\\Students\\harshad\\PathDemo.java");
		System.out.println("File name = "+samplePath.getFileName());
		System.out.println("Root = "+samplePath.getRoot());
		System.out.println("Parent ="+samplePath.getParent());
		for(Path element : samplePath)
			System.out.println("Path Element = "+element);
		File f =samplePath.toFile();
		System.out.println("Converted File = "+f);
		System.out.println("Absolute Path = "+samplePath.toAbsolutePath());
		try
		{
			System.out.println("Real Path = "+ samplePath.toRealPath());
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		Path anotherPath = Paths.get("PathDemo.java");
		System.out.println("samplePath and anotherPath are equal = "+samplePath.equals(anotherPath));
		anotherPath = anotherPath.toAbsolutePath();
		System.out.println("samplePath and anotherPath are equal = "+samplePath.equals(anotherPath));
	}
};