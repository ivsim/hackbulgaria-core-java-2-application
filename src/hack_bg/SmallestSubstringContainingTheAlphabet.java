package hack_bg;

import java.util.HashSet;
import java.util.Scanner;

/*
 * strings for the sake of testing:
 * 		String input1 = "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn";
		String input3 = "defghijklmnc6b78!a@#$%^&*opqrs&$#tuvwxyz!*defghijklmn";
		String input2 = "aaaaaabcdefghijklmnopqrstuvwxyz";
 */

public class SmallestSubstringContainingTheAlphabet {

	public static void main(String[] args) {

		Scanner enter = new Scanner(System.in);
		
		System.out.print("Please, enter string: ");
		String input = enter.nextLine();
		
		enter.close();
		
		String smallest = smallestSubstringContainingTheAlphabet(input);		
		
		System.out.printf("%n-> %s", smallest);					

	}
	
	public static String smallestSubstringContainingTheAlphabet(String input) {
		
		int minSize = input.length();
		String min = input;
		String current = null;
		boolean isAlphabet = false;
		
		for (String i = input; stringScan(i).length() <= i.length(); i = i.substring(1)) {
			
			current = stringScan(i);
			if (isScanAlphabet(current) == true) {
				isAlphabet = true;
				if (minSize >= current.length()) {
					minSize = current.length();
					min = current;
				}
				
			} else {
				isAlphabet = false;
			}
			
			if (stringScan(i).length() == i.length()) {
				break;
			}
			
		}
		
		if (isAlphabet == false) {
			System.out.println("There is no alphabet...");
			min = "";
		} 
		return min;
		
	}
	
	
	public static boolean isScanAlphabet(String input) {//checks if a string contains all alphabetic letters
		
		HashSet<Character> alphabetProof = new HashSet<Character>(); 
		boolean isAlphabet;
		
		for (char x : input.toCharArray()) {
			if ((int)x < 97 || (int)x > 122) {
				alphabetProof.add('0');
			} else {
				alphabetProof.add(x);				
			}
		}
		
		if (alphabetProof.size() == 27 || alphabetProof.size() == 26) {//in cases with or without any non-letter chars
			isAlphabet = true;
		} else {
			isAlphabet = false;
		}
		
		return isAlphabet;
		
		
	}
	
	public static String stringScan(String input) { //scans a string and returns the first n chars containing 26 letters and 
		//any non letters in between
		
		int counterNonLetters = 0;
		int counterChars = 0;
		
		StringBuilder mediumString = new StringBuilder();
		
		for (char x : input.toCharArray()) {
			
			//make sure string does not start with non-letters <- when counterCahrs is always 0
			if (((int)x < 97 || (int)x > 122) && counterChars == 0 ) {
				continue;
			}
			
			mediumString.append(x);
			
			if ((int)x < 97 || (int)x > 122) {
				counterNonLetters++;
			}
					
			counterChars++;
			
			if ((counterChars - counterNonLetters) == 26) {
				break;
			}
			
		}
		
		String output = mediumString.toString();
		mediumString.setLength(0);
		
		return output;
		
	}

}