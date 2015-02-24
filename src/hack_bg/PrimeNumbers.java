package hack_bg;

/*
 * In a programming language of your choice, implement the following function/method:
 * 
 * primesInAnInterval(from, to)
 * 
 * The goal is to return a collection of all the prime numbers in the given interval [from, to]
 * 
 * Make all sorts of checks for the interval - the from parameter has to be less than the to
 * parameter, they both have to be positive integers etc. etc.
 * Design is not important at the moment. You could call the method from the main function,
 * you could export it as a command line tool, you could execute it on a server - your choice
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("first number: ");
		int fromNumber = input.nextInt();
		System.out.print("second number: ");
		int toNumber = input.nextInt();
		
		input.close();
		
		System.out.printf("%nprimesInAnInterval(%d,%d) -> ", fromNumber, toNumber);
		
		try {
			
		primesInAnInterval(fromNumber, toNumber);
		
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong...");
		}
		
	}
	
	public static void primesInAnInterval(int fromNumber, int toNumber) throws InvalidInputException {
					
		if ((fromNumber >= toNumber) || (fromNumber < 2)) {
			throw new InvalidInputException("invalid input");
		}			
			
		//use Stratogen's grid to find the prime numbers...
			
		int[] initialInterval = new int[toNumber+1];
			
		//set up values in the array
		for (int i = 0; i < toNumber+1; i++) {
			initialInterval[i] = i; //i want index = value !!!...
		}
			
		initialInterval[1] = 0;
			
		//iterate over previous primes to find new primes and mark with zero the
		//non-primes...
			
		int endOfIteration = (int)Math.sqrt((double)toNumber);

		for (int i = 2; i <= endOfIteration; i++) {				
			boolean isAPrime = compareNumberWithPreviousPrimes(i, initialInterval);
			if (isAPrime = true) {
				turnNonPrimesIntoZeros(i, initialInterval);
			}
		}
			
		//remove those members whose indices point to zero values.
			
		ArrayList<Integer> primes = new ArrayList<Integer>();
			
		for (int i = fromNumber; i < initialInterval.length; i++) {
			if (initialInterval[i] != 0) {
				primes.add(i);
			}
		}
			
		System.out.println(primes);		
		
	}
	
	public static int[] turnNonPrimesIntoZeros(int startNumber, int[] initialInterval) {
		for (int i = startNumber + 1; i < initialInterval.length; i++) {
			if (initialInterval[startNumber] == 0) {
				continue;
			}
			
			if (i % startNumber == 0) {
				initialInterval[i] = 0;
			}
		}
		
		return initialInterval;
	}
	
	public static boolean compareNumberWithPreviousPrimes(int i, int[] initialInterval) {
		boolean itIsAPrime = false;
		for (int j : initialInterval) {
			if (j > i) {
				break;
			}
			if (j != 0 && i % j != 0) {
				itIsAPrime = true;
				
			} else {
				itIsAPrime = false;
				break;
			}
		}
		return itIsAPrime;
	}
		
}
