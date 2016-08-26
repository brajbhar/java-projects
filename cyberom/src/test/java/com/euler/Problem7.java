package com.euler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * */
public class Problem7 {
	
	public static void main(String args[]) {
		
		long number = getNthPrimeNumber(10001);
		System.out.println(number);
		
	}

	private static long getNthPrimeNumber(int n) {
		int numberOfPrimesFound = 0; 
		long number = 1;
		while(numberOfPrimesFound<=n) {
			if(isPrime(number)) {
				numberOfPrimesFound++;
			}
			number++;
		}
		return number-1;
	}
	
	private static boolean isPrime(long number) {
		for(long i=2;i<=number/2;i++) {
			if(isRemainderZero(number, i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRemainderZero(long number, long i) {
		return number%i == 0;
	}

}
