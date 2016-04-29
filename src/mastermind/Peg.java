/*
 * Mastermind Project 7
 * yuriy minin, eid: ykm93
 * brandon nguyen, eid: btn366
 */
package mastermind;

import java.awt.Color;

/**
 * Class to represent the different colored pegs
 */
public enum Peg
{
	BLUE (Color.BLUE,"B"),
	GREEN (Color.GREEN,"G"),
	ORANGE (Color.ORANGE,"O"),
	PURPLE (new Color(128,0,128),"P"),
	RED (Color.RED,"R"),
	YELLOW (Color.YELLOW,"Y"),
	BLACK (Color.BLACK,"K"),
	WHITE (Color.WHITE,"W"),
	EMPTY(Color.GRAY,"_");		//Special peg to denote the absence of a peg
	
	private final Color color;	//Color to return
	private final String name;	//Character code to return
	
	//Arrays for the different kinds of pegs
	private final static Peg[] entry = {BLUE,GREEN,ORANGE,PURPLE,RED,YELLOW};
	private final static Peg[] feedback= {BLACK,WHITE};
	
	Peg(Color color, String name){
		this.color = color;
		this.name = name;
	}
	
	/**
	 * Returns an array of valid entry pegs
	 * @return
	 */
	public static Peg[] getValidEntries(){
		return entry;
	}
	
	/**
	 * Get a color object composing this peg color
	 * @return color
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Returns a peg's character code
	 */
	public String toString(){
		return name;
	}
	
	/*
	 * Returns a random peg available for entry. No feedback pegs
	 */
	public static Peg randomEntryPeg(){
		//Generate a random index into the entry peg
		int index = (int)(Math.random()*100)%entry.length;
		return entry[index];
	}
	
	public static Peg fromStringEntry(String text){
		if (text != null) {
	      for (Peg p : entry) {
	        if (text.equalsIgnoreCase(p.name)) {
	          return p;
	        }
	      }
	    }
	    return null;
	}
	
	/**
	 * Generic from string; can capture all
	 * @param text
	 * @return
	 */
	public static Peg fromString(String text) {
	    if (text != null) {
	      for (Peg p : Peg.values()) {
	        if (text.equalsIgnoreCase(p.name)) {
	          return p;
	        }
	      }
	    }
	    return null;
	  }
}