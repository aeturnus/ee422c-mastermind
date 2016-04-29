package mastermind.gui;

import mastermind.*;

import javax.swing.JFrame;

public class BoardFrame extends JFrame
{
	private BoardComponent boardGui;
	private Board board;
	public BoardFrame(Board board){
		this.board = board;
		boardGui = new BoardComponent(board);
		this.add(boardGui);
		boardGui.setVisible(true);
		
		this.setBounds(0, 0, boardGui.getWidth(), boardGui.getHeight());
	}
	
	public static void main(String[] args){
		Board board = new Board(12,6,false);
		for(int i = 0; i < 6; i++)
			//board.makeGuess(new SecretCode(new Peg[]{Peg.BLUE,Peg.ORANGE,Peg.GREEN,Peg.YELLOW}));
			board.makeGuess(new SecretCode(new Peg[]{Peg.randomEntryPeg(),Peg.randomEntryPeg(),Peg.randomEntryPeg(),Peg.randomEntryPeg()}));
		JFrame driver = new BoardFrame(board);
		driver.setTitle("Woo!");
		driver.setVisible(true);
	}
}
