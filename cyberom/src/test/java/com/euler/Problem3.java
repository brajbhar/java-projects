package com.euler;

/**
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * */
public class Problem3 {
	
	public static void main(String args[]) {
		getLargetPrimeFactor(600851475143L);
	}
	
	public static void getLargetPrimeFactor(long number) {
		for(long i=2;i <= number/2 ;i++){
			if(isPrime(i) && isRemainderZero(number, i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(long number) {
		for(long i=2;i<=number/2;i++) {
			if(isRemainderZero(number, i)){
				return false;
			}
		}
		return true;
	}

	private static boolean isRemainderZero(long number, long divider) {
		return number%divider == 0;
	}
	
	
}
