package mastermind.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import mastermind.*;

public class SecretCodeComponent extends CodeComponent
{
	
	public SecretCodeComponent(BoardComponent parent,SecretCode code){
		super(parent, code);
		this.setSize(new Dimension(PEG_WIDTH*4,PEG_HEIGHT));
	}
	
	
	public void paintComponent(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		Peg[] pegs = code.getPegs();
		int length = pegs.length;
		//Paint each peg
		for(int i = 0; i < length; i++){
			paintPeg(g2,i*PEG_WIDTH,0,pegs[i]);
		}
		g2.setColor(Color.BLACK);
		g2.drawRect(0, 0, this.getWidth(), this.getHeight());
	}
}