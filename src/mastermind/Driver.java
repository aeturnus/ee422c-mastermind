package mastermind;

public class Driver
{

	public static void main(String[] args)
	{
		Board board = new Board(false);
		//board.makeGuess(new SecretCode(new Peg[]{Peg.BLUE,Peg.RED,Peg.PURPLE,Peg.GREEN}));
		board.makeGuess(new SecretCode(new Peg[]{Peg.randomEntryPeg(),Peg.randomEntryPeg(),Peg.randomEntryPeg(),Peg.randomEntryPeg()}));
		System.out.println(board.toString());
	}

}
