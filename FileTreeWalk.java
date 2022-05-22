package assignment.nio;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
class MyFileVisitor extends SimpleFileVisitor<Path>
{
	@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes)
	{
		System.out.println("About to visit File : "+path.getFileName());
		System.out.println("File Size = "+ fileAttributes.size());
		Path newPath = Paths.get("D:\\Students\\harshad\\ConsoleDemo.java");
			if(path.equals(newPath))
				return FileVisitResult.SKIP_SIBLINGS;
			else
				return FileVisitResult.CONTINUE;
	}
	@Override
		public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes dirAttributes)
	{
		System.out.println("About to visit directory : "+path.getFileName());
		System.out.println("Directory Creation Time = " + dirAttributes.creationTime());
		Path newPath = Paths.get("D:\\Students\\harshad\\assignment");
			if(path.equals(newPath))
				return FileVisitResult.SKIP_SUBTREE;
			else
				return FileVisitResult.CONTINUE;
	}
	@Override
		public FileVisitResult postVisitDirectory(Path path, IOException e)
	{
		System.out.println(" Finished Visiting Directory : "+path.getFileName());
		return FileVisitResult.CONTINUE;
	}
	@Override
		public FileVisitResult visitFileFailed(Path path, IOException e)
	{
		System.out.println(" File Visit Failed due to Following Exception : "+e);
		return FileVisitResult.CONTINUE;
	}
};
	public class FileTreeWalk
	{
		public static void main(String args[])
		{
				try
			{
				Path path = Paths.get("D:\\Students\\harshad");
					Files.walkFileTree(path,new MyFileVisitor());
			}
				catch(Exception e)
			{
			System.out.println(e);
			}
		}
};