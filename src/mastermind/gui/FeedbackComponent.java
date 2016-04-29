package mastermind.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mastermind.FeedbackCode;
import mastermind.Peg;

public class FeedbackComponent extends CodeComponent
{
	public FeedbackComponent(BoardComponent parent,FeedbackCode code){
		super(parent, code);
		this.setSize(new Dimension(PEG_WIDTH,PEG_HEIGHT));
	}
	
	
	public void paintComponent(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		Peg[] pegs = code.getPegs();
		//Hardcoded for four:
		/*
		paintPeg(g2,0,0,pegs[0],0.5);
		paintPeg(g2,PEG_WIDTH/2,0,pegs[1],0.5);
		paintPeg(g2,0,PEG_HEIGHT/2,pegs[2],0.5);
		paintPeg(g2,PEG_WIDTH/2,PEG_HEIGHT/2,pegs[3],0.5);
		*/
		//Two rows
		int length = pegs.length;
		//Paint each peg
		int i,j;
		for(i = 0, j = 0; i < length/2; i++,j++){
			paintPeg(g2,j*PEG_WIDTH/2,0,pegs[i],0.5);
		}
		for(j = 0; i < length; i++,j++){
			paintPeg(g2,j*PEG_WIDTH/2,PEG_HEIGHT/2,pegs[i],0.5);
		}
		g2.setColor(Color.BLACK);
		g2.drawRect(0, 0, this.getWidth(), this.getHeight());
		
	}
}
