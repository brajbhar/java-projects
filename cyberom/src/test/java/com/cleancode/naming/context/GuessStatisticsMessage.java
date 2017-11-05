package com.cleancode.naming.context;

public class GuessStatisticsMessage {
	
	private String number;
	private String verb;
	private String pluralModifier;
	
	public void make(char candidate, int count) {
		createPluralDependentMessageParts(count);
		String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
		System.out.println(guessMessage);
	}
	

	private void createPluralDependentMessageParts(int count) {
		if(count == 0) {
			thereAreNoLetters();
		} else if(count == 1) {
			thereIsOneLetter();
		} else {
			thereAreManyLetters(count);
		}
	}
	
	private void thereAreManyLetters(int count) {
		number = Integer.toString(count);
		verb = "are";
		pluralModifier = "s";
	}
	
	private void thereIsOneLetter() {
		number = "1";
		verb = "is";
		pluralModifier = "";
	}
	
	private void thereAreNoLetters() {
		number = "no";
		verb = "are";
		pluralModifier = "s";
	}

}
