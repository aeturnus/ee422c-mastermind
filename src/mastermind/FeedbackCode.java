package mastermind;

/**
 * This represents the feedback that
 * a player can get. It's mainly here for type safety
 */
public class FeedbackCode extends Code
{
	public boolean checkWin(){
		int length = pegs.length;
		for(int i = 0; i < length; i++){
			if(pegs[i] == Peg.WHITE || pegs[i] == Peg.EMPTY){
				return false;
			}
		}
		return true;
	}
}