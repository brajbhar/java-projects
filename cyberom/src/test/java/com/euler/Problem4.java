package com.euler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * */
public class Problem4 {
	
	public static void main(String args[]) {
		
		for(long number=232792560; number<=10000000000L; number++) {
			if(isNumberDivisibleByAll(number, 1, 20)) {
				System.out.println(number);
				break;
			}
		}
	}
	
	private static boolean isNumberDivisibleByAll(long number, long start, long end) {
		boolean isDivisibleByAll = true;
		for(long i=start; i<=end;i++) {
			if(!isRemainderZero(number, i)) {
				isDivisibleByAll = false;
				break;
			}
		}
		return isDivisibleByAll;
	}

	public static boolean isRemainderZero(long number, long divider) {
		return number%divider == 0;
	}

}
