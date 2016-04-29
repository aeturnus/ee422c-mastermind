package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver{

	public static void main(String[] args) throws IOException{
		int codeLength = 4;			//How long each code is
		int guesses = 12;			//how many guesses
		boolean debug = false;		//if we're in debug mode
		boolean printon = false;	//if we print the board every time
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nWelcome to Mastermind.  Here are the rules. \n\nThis is a text version of the classic board game Mastermind. \nThe computer will think of a secret code. The code consists of 4 colored pegs. \nThe pegs may be one of six colors: blue, green, orange, purple, red, or yellow. \nA color may appear more than once in the code. \nYou try to guess what colored pegs are in the code and what order they are in. \nAfter you make a valid guess the result (feedback) will be displayed. \nThe result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  \nFor each peg in the guess that is the correct color, but is out of position, you get a white peg. \nFor each peg, which is fully incorrect, you get no feedback.");
		System.out.print("\nOnly the first letter of the color is displayed. B for Blue, R for Red, and so forth. \nWhen entering guesses you only need to enter the first character of each color as a capital letter.\nYou have 12 guesses to figure out the secret code or you lose the game.  \n\nAre you ready to play? (Y/N): ");
        while(true){
        	String input = reader.readLine().trim().toLowerCase();
	        if (input.matches("y")) {
	        	
	        	//Custom guess number
	        	System.out.print("\nEnter number of guesses (default=12):");
	        	boolean numberEntered = false;
	        	while(!numberEntered){
	        		input = reader.readLine();
	        		//If empty, default
	        		if(input.length() == 0){
	        			numberEntered = true;
	        			continue;
	        		}
	        		try{
	        			guesses = Integer.parseInt(input);
	        			numberEntered = true;
	        		}catch(NumberFormatException ne){
	        			System.out.print("Bad number entered. Try again: ");
	        		}
	        	}
	        	
	        	//Custom size
	        	System.out.print(String.format("\nEnter code size(default=4; max=%d, min=%d):",Peg.getValidEntries().length,1));
	        	numberEntered = false;
	        	while(!numberEntered){
	        		input = reader.readLine();
	        		//If empty, default
	        		if(input.length() == 0){
	        			numberEntered = true;
	        			continue;
	        		}
	        		try{
	        			int len = Integer.parseInt(input);
	        			//Check bounds
	        			if(len >= 1 && len <= Peg.getValidEntries().length){
	        				codeLength = len;
	        				numberEntered = true;
	        			} else {
	        				System.out.print("Out of bounds. Try again:");
	        			}
	        		}catch(NumberFormatException ne){
	        			System.out.print("Bad number entered. Try again: ");
	        		}
	        	}
	        	
	        	
	        	Board board = new Board(guesses,codeLength,false);
	        	Boolean doneFlag = false;
	        	
	        	System.out.println(String.format("\nNote that %s is white and %s is black",Peg.WHITE.toString(),Peg.BLACK.toString()));
	        	System.out.println("Type \"help\" for more commands!");
	        	while(doneFlag == false)
	        	{
	        		try {
	        			//Check for commands
	        			if(printon){
	        				System.out.println("\n" + board.printBoard(!debug));
	        			}
	        			System.out.println("\nThe available colors are: " + Arrays.toString(Peg.getValidEntries()));
		        		System.out.print("Enter your guess: ");
		        		input = reader.readLine().trim().toLowerCase();
		        		if(input.equals("debug")){
		        			debug = true;
		        			System.out.println("<DEBUG MODE ENABLED>");
		        		} else if (input.equals("help") || input.equals("?")){
		        			System.out.println("\ndebug: turns on debug mode (you cheater)");
		        			System.out.println("help / ?: prints this help prompt");
		        			System.out.println("quit: ends the current game");
		        			System.out.println("history: prints the board");
		        			System.out.println("printon: enable printing the board on every move");
		        			System.out.println("printof: disable printing the board on every move\n");
		        		} else if (input.equals("quit")){
		        			System.out.print("Are you sure you want to quit? (Y/N): ");
		        			String input2 = reader.readLine().trim().toLowerCase();
		        			if(input2.equals("y")){
		        				System.out.println("You quitter...");
		        				doneFlag = true;
		        			}
		        		} else if (input.equals("history")){
		        			System.out.println(board.printBoard(!debug));
		        		} else if (input.equals("printon")){
		        			printon = true;	//enable printing board every turn
		        		} else if (input.equals("printoff")){
		        			printon = false;	//disable printing board every turn
		        		} else if (input.length() != codeLength) {
		        			System.out.println("\nWrong number of characters, you can only guess " + codeLength + " colors!");
		        		} else {
			        		Peg[] guess = new Peg[codeLength];
			        		int i = 0;
			        		//build guess array, there's probably a better way to do this
			        		for (char ch : input.toUpperCase().toCharArray()) {
			        			guess[i] = Peg.fromStringEntry(Character.toString(ch));
			        			if (guess[i] == null) {
			        				throw new IOException();
			        			}
			        			i++;
			        		}
				        	FeedbackCode feedback = board.makeGuess(new SecretCode(guess));
				        	System.out.println("Feedback: " + feedback.toString());
				        	System.out.println("Remaining Guesses: " + (board.maxGuesses()-board.getNumGuesses()));
							if(feedback.checkWin()) {
								//Check if you win
								System.out.println("\n" + board.printBoard(true));
								System.out.println("The master code was: " + board.getMaster());
								System.out.println("\nCongratualations you win!");
								doneFlag = true;
							} else if (board.getNumGuesses() == board.maxGuesses()) {
								//If we run out of guesses
								System.out.println("\n" + board.printBoard(true));
								System.out.println("You ran out of guesses!");
								System.out.println("The master code was: " + board.getMaster());
								doneFlag = true;
							}
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
