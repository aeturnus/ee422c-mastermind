package mastermind.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import mastermind.Board;
import mastermind.SecretCode;

public class BoardComponent extends JComponent
{
	private static final Color DEFAULT_COLOR = Color.DARK_GRAY;
	private Color color = DEFAULT_COLOR;
	private Board board;
	
	SecretCodeComponent master;
	SecretCodeComponent[] guesses;
	public BoardComponent(Board board){
		this.board = board;
		init();
	}
	
	public BoardComponent(Board board,Color color){
		this.board = board;
		this.color = color;
		init();
	}
	
	private void init(){
		this.setLayout(null);	//we move everything in absolute
		//Set up component for master
		master = new SecretCodeComponent(this, board.getMaster());
		master.hideCode();
		this.add(master);
		master.setLocation(0,0);
		master.setVisible(true);
		
		//Set up components for the guesses
		SecretCode[] codeSlots = board.getGuesses();
		int length = codeSlots.length;
		guesses = new SecretCodeComponent[codeSlots.length];
		for(int i = 0; i<length; i++){
			guesses[i] = new SecretCodeComponent(this,codeSlots[i]);
			guesses[i].showCode();
			this.add(guesses[i]);
			guesses[i].setLocation(0, i * CodeComponent.PEG_HEIGHT);
			guesses[i].setVisible(true);
		}
		
		this.setSize(CodeComponent.PEG_WIDTH * 4, CodeComponent.PEG_HEIGHT*13);
	}
	
	public void paintComponent(Graphics g){
		master.paintComponent(g);
		int length = guesses.length;
		for(int i = 0; i < length; i++){
			guesses[i].paintComponent(g);
		}
	};
	
	public Color getColor(){
		return color;
	}
}
