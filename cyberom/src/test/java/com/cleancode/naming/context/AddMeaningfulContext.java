package com.cleancode.naming.context;

public class AddMeaningfulContext {
	
	public static void main(String args[]){
		printGuessStatistics('c', 5);
	}
	
	public static void printGuessStatistics(char candidate, int count) {
		
		String verb;
		String pluralModifier;
		String number;
		
		if(count == 0) {
			number = "no";
			verb = "are";
			pluralModifier = "s";
		} else if (count == 1) {
			number = "1";
			verb = "is";
			pluralModifier = "";
		} else {
			number = Integer.toString(count);
			verb = "are";
			pluralModifier = "s";
		}
		
		String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
		System.out.print(guessMessage);
		
	}

}
