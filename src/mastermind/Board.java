package mastermind;

/**
 * Models the mastermind board
 */
public class Board
{
	private final static int DEFAULT_GUESSES = 12;
	private final static boolean DEFAULT_REPEATS= false;
	private int guesses = DEFAULT_GUESSES;
	private boolean repeats = DEFAULT_REPEATS;
	private SecretCode master;			//The master code
	private SecretCode[] secrets; 		//The secret codes
	private FeedbackCode[] feedback;	//Feedback codes
	
	private int guessCounter = 0;
	
	/**
	 * Constructor with default number of guesses
	 */
	public Board(){
		buildBoard();
	}
	
	/**
	 * Constructor to build board with number of guesses
	 * @param guesses
	 */
	public Board(int guesses){
		this.guesses = guesses;
		buildBoard();
	}
	
	/**
	 * Constructor to build board with repeats or not
	 * @param repeats
	 */
	public Board(boolean repeats){
		this.repeats = repeats;
		buildBoard();
	}
	
	/**
	 * Fully featured constructor to provide guess count and repeat status
	 * @param guesses
	 * @param repeats
	 */
	public Board(int guesses, boolean repeats){
		this.guesses = guesses;
		this.repeats = repeats;
		buildBoard();
	}
	
	/**
	 * Sets up the internal data structures
	 */
	private void buildBoard(){
		secrets = new SecretCode[guesses];
		feedback = new FeedbackCode[guesses];
		for(int i = 0; i < guesses; i++){
			secrets[i] = new SecretCode();
			feedback[i] = new FeedbackCode();
		}
		master = SecretCode.generateCode(repeats);
	}
	
	public void makeGuess(SecretCode code){
		if(guessCounter < guesses){
			secrets[guessCounter] = code;
			feedback[guessCounter] = master.checkCode(code);
			guessCounter++;
		}
	}
	
	public String toString(){
		String output = "";
		output += printBoard(false);
		return output;
	}
	
	public String printBoard(boolean hideMaster){
		String output = "";
		if(!hideMaster){
			output += "Master: " + master.toString() + "\n";
		}
		output += "Guesses ||| Feedback\n";
		for(int i = 0; i < guesses; i++){
			output += "  " + secrets[i].toString() + "  |||  " + feedback[i].toString() +"  \n";
		}
		return output;
	}
	
	/**
	 * returns the master code 
	 */
	public SecretCode getMaster(){
		return master;
	}
	
	/*
	 * returns the array of guesses for a given board instance encoded as characters
	 */
	public SecretCode[] getGuesses(){
		return secrets;
	}
	
	/*
	 * returns the number of guess that a given board has had
	 */
	public int getNumGuesses(){
		return guessCounter;
	}
	
	/*
	 * returns the max number of guesses for a board
	 */
	public int maxGuesses(){
		return guesses;
	}
	
	/*
	 * checks if a board allows repeats
	 */
	public Boolean checkRepeats(){
		return repeats;
	}
	
	/*
	 * returns the array of feedback codes for a given board instance encoded as characters
	 */
	public FeedbackCode[] getFeedback(){
		return feedback;
	}
	
	
}
