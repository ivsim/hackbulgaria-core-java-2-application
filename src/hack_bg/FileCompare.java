package hack_bg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCompare extends File {
	
	Integer forComparison;
	
	public FileCompare(String path) {
		super(path);
		this.forComparison = 0;
	}

	public boolean compareByteArray(FileCompare o, FileCompare f) {
		
		boolean output = false;
		
		try (FileInputStream in1 = new FileInputStream(o);
				FileInputStream in2 = new FileInputStream(f);) {
			
			int i;
			int j;
			byte[] b = new byte[80];//makes things faster
			
			while ((i = in1.read(b)) != -1 && (j = in2.read(b)) != -1) {
				
				if (i == j) {
					output = true;
				} else {
					output = false;
					break;
				}
			}		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return output;

	}
	
	@Override
	public int hashCode() {
		return forComparison.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {//comparisons of hasCodes, sizes, bytes...
		
		if (obj == null){return false;}
		if (! (obj instanceof FileCompare)){return false;}
		
		FileCompare other = (FileCompare)obj;
		
		boolean compareBytes = compareByteArray(this, other);
		boolean compareLengths = this.length() == other.length();
				
		if (compareLengths == true && compareBytes == true) {
			this.forComparison = 1;
			other.forComparison = 1;
		} else {
			this.forComparison = 1;
			other.forComparison = 0;
		}
		
		return this.hashCode() == obj.hashCode();

	}
	
	@Override
	public String toString() {		
		return this.getName();
	}
	
}
