package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver
{

	private static final boolean Boolean = false;

	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nWelcome to Mastermind.  Here are the rules. \n\nThis is a text version of the classic board game Mastermind. \nThe computer will think of a secret code. The code consists of 4 colored pegs. \nThe pegs may be one of six colors: blue, green, orange, purple, red, or yellow. \nA color may appear more than once in the code. \nYou try to guess what colored pegs are in the code and what order they are in. \nAfter you make a valid guess the result (feedback) will be displayed. \nThe result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  \nFor each peg in the guess that is the correct color, but is out of position, you get a white peg. \nFor each peg, which is fully incorrect, you get no feedback.");
		System.out.print("\nOnly the first letter of the color is displayed. B for Blue, R for Red, and so forth. \nWhen entering guesses you only need to enter the first character of each color as a capital letter.\nYou have 12 guesses to figure out the secret code or you lose the game.  \n\nAre you ready to play? (Y/N): ");
        while(true){
        	String input = reader.readLine().trim().toLowerCase();
	        if (input.matches("y")) {
	        	Board board = new Board(false);
	        	Boolean doneFlag = false;
	        	while(doneFlag == false)
	        	{
	        		try {
		        		System.out.println("\n" + board.printBoard(true) + "\nThe available colors are: " + Arrays.toString(Peg.values()) + "\n");
		        		System.out.print("Enter your guess: ");
		        		input = reader.readLine().trim().toLowerCase();
		        		if (input.length() != 4) {
		        			System.out.println("\nWrong number of characters, you can only guess four colors!");
		        		}
		        		else {
			        		Peg[] guess = new Peg[4];
			        		int i = 0;
			        		//build guess array, theres probably a better way to do this
			        		for (char ch : input.toUpperCase().toCharArray()) {
			        			guess[i] = Peg.fromString(Character.toString(ch));
			        			if (guess[i] == null)
			        			{
			        				throw new IOException();
			        			}
			        			i++;
			        		}
				        	board.makeGuess(new SecretCode(guess));
		        		}
		        		for (FeedbackCode feedback : board.getFeedback())
		        		{
		        			if(feedback.checkWin())
		        			{
		        				System.out.println("\nCongratualations you win!");
		        				doneFlag = true;
		        			}
		        		}
		        		if (board.getNumGuesses() == board.maxGuesses())
		        		{
		        			System.out.println("\n" + board.printBoard(true));
		        			System.out.println("You ran out of guesses!");
		        			doneFlag = true;
		        		}
	        		}
	        		catch (IOException e) {
	        			System.out.println("\nYou entered a peg that doesn't match the available colors, please try again!");
	        		}
	        	}
	        	System.out.print("\nThanks for playing, would you like to play again? (Y/N): ");
	        }
	        else {
	        	System.out.println("Thanks for playing! (or not)");
	        	System.exit(0);
				//board.makeGuess(new SecretCode(new Peg[]{Peg.BLUE,Peg.RED,Peg.PURPLE,Peg.GREEN}));
			}
        }
	}

}
