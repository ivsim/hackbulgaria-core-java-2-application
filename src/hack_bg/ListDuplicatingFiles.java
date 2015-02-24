package hack_bg;

import java.io.File;
import java.util.HashSet;

public class ListDuplicatingFiles {

	public static void main(String[] args) {
		
		/*
		 * Please, enter absolute path of the directory
		 * you would like to traverse.
		 * Thank you!
		 */
		traverseDir("/home/ivo/Desktop/dupl_files");	
		
	}
	
	public static void traverseDir(String directoryPath) {
		
		File temp = new File(directoryPath);		
		
		HashSet<FileCompare> nonDuplicatingList = new HashSet<FileCompare>();
		
		if (temp.exists()) {
			System.out.println(traverseDir(temp, nonDuplicatingList));
		} else {
			System.out.println("No such directory path!");
		}
		
	}
	
	private static HashSet<FileCompare> traverseDir(File dir, HashSet<FileCompare> files) {
		
		if (dir.isDirectory()) {
			
			String[] children = dir.list();
			
			for (String x : children) {
				traverseDir(new File(dir, x), files);
				}
			} else {
				files.add(new FileCompare(dir.getAbsolutePath()));
			}
		
		return files;
		
		}

}
