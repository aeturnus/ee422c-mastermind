package mastermind.gui;

import mastermind.*;

import javax.swing.JFrame;

public class GUIDriver extends JFrame
{
	private BoardComponent boardGui;
	private Board board;
	public GUIDriver(Board board){
		this.board = board;
		boardGui = new BoardComponent(board);
		this.add(boardGui);
		boardGui.setVisible(true);
		
		this.pack();
	}
	
	public static void main(String[] args){
		Board board = new Board();
		JFrame driver = new GUIDriver(board);
		driver.setTitle("Woo!");
		driver.setVisible(true);
	}
}
