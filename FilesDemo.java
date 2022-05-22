package assignment.nio;
import java.nio.file.*;
import java.io.IOException;
public class FilesDemo
{
	public static void main(String args[])
	{
		Path path = Paths.get("D:\\Students\\harshad\\Sample.txt");
		try
		{
			//Files.createFile(path);
			//Files.copy(path,Paths.get("D:\\Students\\harshad\\assignment\\Sample1.txt"));
			//Files.move(path,Paths.get("D:\\Students\\harshad\\assignment\\io\\Sample1.txt"));
			//Files.delete(path);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}