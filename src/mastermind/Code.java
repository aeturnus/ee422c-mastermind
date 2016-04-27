package mastermind;

/**
 * This class serves as the representation of a 
 * @author brandon
 *
 */
public class Code
{
	public static final int LENGTH = 4;
	protected Peg[] pegs;//holds the pegs representing this code
	
	/**
	 * Constructor to make an empty code
	 */
	public Code(){
		pegs = new Peg[LENGTH];
		for(int i = 0; i < LENGTH; i++){
			pegs[i] = Peg.EMPTY;	//empty
		}
	}
	
	/**
	 * Constructor to provide an array of pegs
	 * for this code
	 */
	public Code(Peg[] values){
		pegs = values;
	}
	
	/**
	 * Returns the pegs array of this code
	 * Protected so no external users can
	 * modify Code contents
	 */
	protected Peg[] getPegs(){
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

}
