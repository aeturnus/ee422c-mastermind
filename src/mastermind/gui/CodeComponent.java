package mastermind.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import java.awt.Color;

import mastermind.Code;
import mastermind.Peg;

public class CodeComponent extends JComponent
{
	public static final int PEG_HEIGHT = 100;
	public static final int PEG_WIDTH = 100;
	
	protected BoardComponent board;
	protected Code code;
	protected boolean hidden;
	
	public CodeComponent(BoardComponent parent, Code code){
		this.board = parent;
		this.code = code;
		this.setPreferredSize(new Dimension(PEG_WIDTH * 4,PEG_HEIGHT));
	}
	
	/**
	 * Paints the peg at the specified spot on the graphics context
	 * @param g2		2D graphics context
	 * @param originX	x origin
	 * @param originY	y origin
	 * @param peg		reference to peg enum to paint
	 */
	public void paintPeg(Graphics2D g2,int originX, int originY,Peg peg){
		if(hidden){
			g2.setColor(board.getColor());
		} else {
			g2.setColor(peg.getColor());
		}
		g2.fillRect(originX, originY, PEG_WIDTH, PEG_HEIGHT);
	}
	
	public void hideCode(){
		hidden = true;
	}
	
	public void showCode(){
		hidden = false;
	}
}
