/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import acm.program.*;
import java.util.*;

public class HangmanLexicon {
	
	// This is the HangmanLexicon constructor
	public HangmanLexicon() {
	// your initialization code goes here		
		BufferedReader rd = null;
		while(rd == null) {
			try {
				rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
				while(true) {
					String word = rd.readLine();
					if(word == null) break;
					lex.add(word);
				}
				rd.close();
			} catch (IOException ex){
				throw new ErrorException(ex);
			}
		}
		
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return lex.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lex.get(index);
	}
	
	private ArrayList<String> lex = new ArrayList<String>();
}
