package hack_bg;

/*
 * SOLUTION IN A NUTSHELL
 * A class FileCompare is created that extends the File class
 * Specific thing is that it overrides the hashCode(), equals() methods
 * in such a way that the hashCode() distinguishes is sensitive to
 * file contents. For the comparison of files FileInputStream class is
 * used which reads bytes after that bytes are cast into int and compared.
 */

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
