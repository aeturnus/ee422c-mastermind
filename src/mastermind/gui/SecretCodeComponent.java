package mastermind.gui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import mastermind.*;

public class SecretCodeComponent extends CodeComponent
{
	
	public SecretCodeComponent(BoardComponent parent,SecretCode code){
		super(parent, code);
	}
	
	
	public void paintComponent(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		Peg[] pegs = code.getPegs();
		int length = pegs.length;
		//Paint each peg
		for(int i = 0; i < length; i++){
			paintPeg(g2,i*PEG_WIDTH,0,pegs[i]);
		}
	}
}