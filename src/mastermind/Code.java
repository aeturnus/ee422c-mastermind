/*
 * Mastermind Project 7
 * yuriy minin, eid: ykm93
 * brandon nguyen, eid: btn366
 */
package mastermind;

/**
 * This class serves as the representation of a 
 * @author brandon
 *
 */
public class Code
{
	protected int length;
	protected Peg[] pegs;//holds the pegs representing this code
	
	/**
	 * Constructor to make an empty code
	 */
	public Code(int length){
		resize(length);
	}
	
	/**
	 * Constructor to provide an array of pegs
	 * for this code
	 */
	public Code(Peg[] values){
		pegs = values;
		length = values.length;
	}
	
	/**
	 * Set this code's pegs to the other's
	 */
	public void setPegs(Code other){
		if(length == other.length){
			for(int i = 0; i < length; i++){
				pegs[i] = other.pegs[i];
			}
		} else {
			length = other.length;
			pegs = new Peg[length];
			for(int i =0; i < length; i++){
				pegs[i] = other.pegs[i];
			}
		}
	}
	
	/**
	 * Resizes the code, clearing it and setting it to the size
	 * @param length
	 */
	public void resize(int length){
		this.length = length;
		pegs = new Peg[length];
		for(int i = 0; i < length; i++){
			pegs[i] = Peg.EMPTY;	//empty
		}
	}
	
	/**
	 * Returns length of code
	 * @return
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Returns the pegs array of this code
	 */
	public Peg[] getPegs(){
		return pegs;
	}
	
	/**
	 * Returns a copy of the pegs
	 * representing this code
	 * @return
	 */
	public Peg[] copyOfPegs(){
		return pegs.clone();
	}
	
	public String toString(){
		String output = "";
		for(int i = 0; i < pegs.length; i++){
			output += pegs[i].toString();
		}
		return output;
	}
	
	public boolean equals(Code other){
		if(length != other.length){
			return false;
		}
		for(int i = 0; i < length; i++){
			if(pegs[i] != other.pegs[i]){
				return false;
			}
		}
		return true;
	}

}
