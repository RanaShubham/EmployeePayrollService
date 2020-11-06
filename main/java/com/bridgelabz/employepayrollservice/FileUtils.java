package com.bridgelabz.employepayrollservice;

import java.io.File;

public class FileUtils 
{
	/**Delete the given folder along with all it's files.
	 * @param contentToDelete
	 * @return
	 */
	public static boolean deleteFiles(File contentToDelete)
	{
		File[] allContent = contentToDelete.listFiles();
		
		//If the directory is not empty then delete files within.
		if(allContent != null)
		{
			//Loop to delete all the files inside the directory.
			for (File file : allContent)
			{
				deleteFiles(file);
			}
		}
		//Finally deleting the directory.
		return contentToDelete.delete();
	}
}
