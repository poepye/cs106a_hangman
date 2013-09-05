/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		x = getWidth();
		y = getHeight();
		add(new GLine(x/2-BEAM_LENGTH, (y-SCAFFOLD_HEIGHT)/2, x/2-BEAM_LENGTH, (y+SCAFFOLD_HEIGHT)/2)); //SCAFFOLD
		add(new GLine(x/2-BEAM_LENGTH, (y-SCAFFOLD_HEIGHT)/2, x/2, (y-SCAFFOLD_HEIGHT)/2)); //BEAM
		add(new GLine(x/2, (y-SCAFFOLD_HEIGHT)/2, x/2, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH)); //ROPE
		
		label = new GLabel(Hangman.incorrectWord);
		add(label, x/2, y-20);
		
		disp = new GLabel(Hangman.dashWord);
		add(disp, x/2, y-40);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game. The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		disp.setLabel(Hangman.dashWord);
		disp.setLocation((x-disp.getWidth())/2, y-40);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user. Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		Hangman.incorrectWord += Character.toUpperCase(letter);
		label.setLabel(Hangman.incorrectWord);
		label.setLocation((x-label.getWidth())/2, y-20);
		
		switch(Hangman.life) {
		case(7):
			add(new GOval(x/2-HEAD_RADIUS, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH, 2*HEAD_RADIUS, 2*HEAD_RADIUS)); break;
		case(6):
			add(new GLine(x/2, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS, x/2, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH));break;
		case(5):
			add(new GLine(x/2, y/2-40, x/2-UPPER_ARM_LENGTH, y/2-40));break;
		case(4):
			add(new GLine(x/2, y/2-40, x/2+UPPER_ARM_LENGTH, y/2-40));break;
		case(3):
			add(new GLine(x/2, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, x/2-HIP_WIDTH, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH));
			add(new GLine(x/2-HIP_WIDTH, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, x/2-HIP_WIDTH, y/2+LEG_LENGTH));
			break;
		case(2):
			add(new GLine(x/2, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, x/2+HIP_WIDTH, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH));
			add(new GLine(x/2+HIP_WIDTH, (y-SCAFFOLD_HEIGHT)/2+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH, x/2+HIP_WIDTH, y/2+LEG_LENGTH));
			break;
		case(1):
			add(new GLine(x/2-HIP_WIDTH, y/2+LEG_LENGTH, x/2-HIP_WIDTH-FOOT_LENGTH, y/2+LEG_LENGTH));break;
		case(0):
			add(new GLine(x/2+HIP_WIDTH, y/2+LEG_LENGTH, x/2+HIP_WIDTH+FOOT_LENGTH, y/2+LEG_LENGTH));break;
		default:
			break;
		}
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private double x, y;
	private GLabel label, disp;
}
