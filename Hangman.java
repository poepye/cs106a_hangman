/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
    public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    }

    public void run() {
		/* You fill this in */
    	println("Welcome to Hangman!");
    	myWord = new HangmanLexicon();	// instantiation of myWord
    	incorrectWord = "";
    	dashWord = "";
    	canvas.reset();
    	
    	int index = rgen.nextInt(0, myWord.getWordCount()-1);	// pick a word from Lexicon randomly
    	toBeGuessed = myWord.getWord(index);
    	
    	life = 8;	// initialize life
    	gameStart();
	}    
    
    
    private void gameStart() {
    	int wordlen = toBeGuessed.length();
    	
    	for (int j = 0; j < wordlen; j++) {
    		dashWord += "-";
    	}
    	
    	while (life > 0) {
    		println("The word looks like this: " + dashWord);
    		println("You have " + life + " life left.");
    		myGuess = readLine("Your guess: ");
    		while(true) {
    			if(myGuess.length()==1 && ((myGuess.charAt(0)>='A' && myGuess.charAt(0)<='Z') || (myGuess.charAt(0)>='a' && myGuess.charAt(0)<='z'))) {
    				ifCharMatch();
    				break;
        		}else{
        			myGuess = readLine("Please enter one character: ");
        		}
    		}
    		if(!(dashWord.contains("-"))) {
    			println("The word looks like this: " + dashWord);
        		println("You succeed!");
    			break;
    		}
    	}
    }
    
    private void ifCharMatch() {
    	char ch = myGuess.charAt(0);
    	int j = 0;
    	String temp = "";
    	for(int i = 0; i < toBeGuessed.length(); i++) {
    		if(toBeGuessed.charAt(i) == Character.toUpperCase(ch)) {
    			temp += Character.toUpperCase(ch);
    			j++;
    		}else{
    			temp += dashWord.charAt(i);
    		}
    	}
    	dashWord = temp;
    	canvas.displayWord(dashWord);
    	if(j == 0) {
    		println("There are no '" + Character.toUpperCase(ch) + "'s in the word!");
    		life--;
    		canvas.noteIncorrectGuess(ch);
    	}
    }
    
    private HangmanLexicon myWord;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private String toBeGuessed;
    public static String dashWord;	// define dashWord as a public class variable so that it could be accessed by other class through CLASS.VAR
    private String myGuess;
    public static int life;
    public static String incorrectWord;
    private HangmanCanvas canvas;
}
