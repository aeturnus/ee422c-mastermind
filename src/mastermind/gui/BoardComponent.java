package mastermind.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import mastermind.*;

public class BoardComponent extends JComponent
{
	private static final Color DEFAULT_COLOR = Color.DARK_GRAY;
	private Color color = DEFAULT_COLOR;
	private Board board;
	
	SecretCodeComponent master;
	SecretCodeComponent[] guesses;
	FeedbackComponent[] feedback;
	
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
		
		//Set up components for the guesses and their feedbacks
		SecretCode[] codeSlots = board.getGuesses();
		FeedbackCode[] feedSlots = board.getFeedback();
		int length = codeSlots.length;
		guesses = new SecretCodeComponent[codeSlots.length];
		feedback = new FeedbackComponent[feedSlots.length];
		for(int i = 0; i<length; i++){
			guesses[i] = new SecretCodeComponent(this,codeSlots[i]);
			guesses[i].showCode();
			this.add(guesses[i]);
			guesses[i].setLocation(0, (i+1) * CodeComponent.PEG_HEIGHT);
			guesses[i].setVisible(true);
			
			feedback[i] = new FeedbackComponent(this,feedSlots[i]);
			feedback[i].showCode();
			this.add(feedback[i]);
			feedback[i].setLocation(guesses[i].getWidth(), (i+1) * CodeComponent.PEG_HEIGHT);
			feedback[i].setVisible(true);
		}
		
		this.setSize(guesses[0].getWidth() + feedback[0].getWidth(), guesses[0].getHeight()*13);
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
