package com.euler;


/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 * */
//DONE
public class Problem9 {
	
	private static final int SUM_OF_TRIPLET = 1000;

	public static void main(String args[]) {
		
		for(int firstNumber=1; firstNumber<=SUM_OF_TRIPLET; firstNumber++) {
			for(int secondNumber=1; secondNumber<=SUM_OF_TRIPLET; secondNumber++) {
				for(int thirdNumber=1; thirdNumber<=SUM_OF_TRIPLET; thirdNumber++) {
					if(isSumOfTripletAsRequired(firstNumber, secondNumber, thirdNumber) && 
							isPythagoreanTriplet(firstNumber, secondNumber, thirdNumber)) {
						System.out.println(firstNumber + ", " + secondNumber + ", " + thirdNumber);
						System.out.println("Product of pythagorean triplet " + product(firstNumber, secondNumber, thirdNumber));
					}
				}
			}
			
		}
		
	}

	private static int product(int firstNumber, int secondNumber,
			int thirdNumber) {
		int result = firstNumber * secondNumber * thirdNumber;
		return result;
	}

	private static boolean isTripletIncrementing(int firstNumber,
			int secondNumber, int thirdNumber) {
		if((firstNumber < secondNumber) && (secondNumber < thirdNumber)) {
			return true;
		}
		return false;
	}

	private static boolean isSumOfTripletAsRequired(int firstNumber,
			int secondNumber, int thirdNumber) {
		return sum(firstNumber, secondNumber, thirdNumber) == SUM_OF_TRIPLET;
	}

	private static boolean isPythagoreanTriplet(int firstNumber,
			int secondNumber, int thirdNumber) {
		if(isTripletIncrementing(firstNumber, secondNumber, thirdNumber)) {
			if(sumOfSquares(firstNumber, secondNumber) == square(thirdNumber)) {
				return true;
			}
		}
		return false;
	}

	private static int sumOfSquares(int firstNumber, int secondNumber) {
		int result = square(firstNumber) + square(secondNumber);
		return result;
	}

	private static int square(int number) {
		return number*number;
	}

	private static int sum(int firstNumber, int secondNumber, 
			int thirdNumber) {
		return (firstNumber + secondNumber + thirdNumber);
	}
	
	
}
