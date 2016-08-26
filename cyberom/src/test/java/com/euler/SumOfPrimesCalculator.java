 package com.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

 * Find the sum of all the primes below two million.
 * */
public class SumOfPrimesCalculator implements Runnable{
	
	private long start;
	private long end;
	
	private static long sum = 0;
	private static List numbers = new ArrayList();
	
	public SumOfPrimesCalculator(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		System.out.println(sum(getPrimesWithin(start, end)));
		//numbers.addAll(sum(getPrimesWithin(start, end)));
	}
	
	private static final long PRIMES_BELOW = 2000000;
	
	
	public static void main(String args[]) {
		for(long i=1; i<=PRIMES_BELOW;i=i+(PRIMES_BELOW/2000)){
			long start = i;
			long end = i + (PRIMES_BELOW/2000) - 1;
			SumOfPrimesCalculator obj = new SumOfPrimesCalculator(start, end);
			Thread thread = new Thread(obj);
			thread.start();
		}
		//System.out.println(sum(numbers)+ " "+numbers);
	}
	
	private static synchronized List getPrimesWithin(long start, long end) {
		List primes = new ArrayList();
		for(long i=start; i<=end; i++) {
			if(isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
		
	}
	private static boolean isPrime(long number) {
		if(number == 1){
			return false;
		}
		for(long i=2;i<=(number/2);i++) {
			if(isRemainderZero(number, i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRemainderZero(long number, long i) {
		return number%i == 0;
	}
	
	private static synchronized long sum(List numbers) {
		Long sum = 0L;
		for(long number : (List<Long>)numbers) {
			sum = sum + number;
		}
		return sum;
	}

	

}
