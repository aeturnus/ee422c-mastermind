package mastermind;

import java.util.ArrayList;

/**
 * This class is to represent the secret code
 * the game generates and what people input
 * 
 * Precondition: there are no null pegs in this
 */
public class SecretCode extends Code
{
	public SecretCode(){
		super();
	}
	public SecretCode(Peg[] values){
		super(values);
	}
	/**
	 * Will generate a random secret code
	 * @param repeat allow repeats
	 * @return random secret code 
	 */
	public static SecretCode generateCode(boolean repeat){
		SecretCode code = null;
		ArrayList<Peg> pegs = new ArrayList<Peg>(LENGTH);
		Peg temp;
		for(int i = 0; i < LENGTH; i++){
			temp = Peg.randomEntryPeg();
			if(!repeat){
				//if we're not repeating pegs, check for them
				while(pegs.contains(temp)){
					temp = Peg.randomEntryPeg();
				}
				pegs.add(temp);	//If it's not there, we can add it
			}
		}
		//Set up our new secret code with the arraylist
		//and return it
		Peg[] array = new Peg[4];
		array = pegs.toArray(array);
		code = new SecretCode(array);
		
		return code;
	}
	
	/**
	 * Will check secret codes and return an array of feedback
	 * @param other
	 * @return
	 */
	public FeedbackCode checkCode(SecretCode other){
		FeedbackCode output = new FeedbackCode();
		Peg[] array = output.getPegs();	//Get the array for output: we can modify it
		int exactCount = 0;		//Keep track of exact matches
		int presentCount = 0;	//Keep track of how many non-place matches
		
		Peg[] myPegs = this.copyOfPegs();		//get a copy so we can eliminate pegs
		Peg[] otherPegs  = other.copyOfPegs();
		
		//Check for place match
		for(int i = 0; i < LENGTH; i++){
			if(myPegs[i] == otherPegs[i]){
				exactCount++;
				myPegs[i] = Peg.EMPTY;
				otherPegs[i] = Peg.EMPTY;
			}
		}
		//Check for non-exact matches
		for(int i = 0; i < LENGTH; i++){
			if(myPegs[i] != Peg.EMPTY){
				for(int j = 0; j < LENGTH; j++){
					if(myPegs[i] == otherPegs[j]){
						presentCount++;
						myPegs[i] = Peg.EMPTY;
						otherPegs[i] = Peg.EMPTY;
						break;	//this peg check has claimed this peg
					}
				}
			}
		}
		int pegDex = 0;	//to index the output peg array
		//Add the exact matches
		for(int i = exactCount; i > 0; i--){
			array[pegDex] = Peg.BLACK;
			pegDex++;
		}
		//Add the nonexact matches
		for(int i = presentCount; i > 0; i--){
			array[pegDex] = Peg.WHITE;
			pegDex++;
		}
		return output;
	}
}
