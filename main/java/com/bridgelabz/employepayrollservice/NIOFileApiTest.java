package com.bridgelabz.employepayrollservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileApiTest 
{
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";
	
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException
	{
		//To confirm is the home path exists.
		System.out.println(HOME);
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
		

		Path playPath = Paths.get(HOME+"/"+PLAY_WITH_NIO);
		//Checking if the directory exists.
		if(Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));
		
		//Creating directory and then asserting that it was created.
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));
		
		//Creating 10 temp folders in playPath.
		//Before creating each temp folder we assert if it doesn't exist. After creating we assert if it exists.
		IntStream.range(1, 10).forEach(counter -> {
			Path tempFile = Paths.get(playPath+"/temp"+counter); //Creating a new file name along with it's path name.
			Assert.assertTrue(Files.notExists(tempFile));
			try {Files.createFile(tempFile);}
			catch (IOException e) {}
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		//create stream of files in directory playPath. Then among these filter the files that are regular (Not hidden etc)
		//For each of those files, print their names.
		Files.list(playPath).filter(Files::isRegularFile);//.forEach(System.out::println);
		//Files.newDirectoryStream(playPath).forEach(System.out::println); ANOTHER WAY TO PRINT FILES IN A DIRECTORY.
		Files.newDirectoryStream(playPath, path -> path.toFile().
				isFile() && path.toString().startsWith("temp")).
				forEach(System.out::println);//NOT WORKING
	}
}