import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * A Player's Mancala in the game Mancala
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 *
 */
public class MancalaPit extends Pit
{
	/**
	 * Constructs an empty MancalaPit using the super ctor, and changes the size to be shaped like a Mancala
	 */
	public MancalaPit()
	{
		super(0);
		this.setEnabled(false);
		this.setPreferredSize((new Dimension(100,250)));
	}
	
	/**
	 * Constructs a MancalaPit with the specified value of marbles already inside
	 * @param i the numeber of marbles to initially be in the MancalaPit
	 */
	public MancalaPit(int i)
	{
		super(i);
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(100, 250));
	}
	
	protected void paintComponent(Graphics g)
	{
		System.out.println("Mancala Pit");
		if (getModel().isArmed()) {
		      g.setColor(Color.gray);
		} else {
			   g.setColor(c);
		}
		 g.fillOval(0, 0, getSize().width, getSize().height);
		 
		 if(getMarbles()>0) {
			 int startX = x+ 40;
			 int marbleY = y + 40;
			 boolean done  = false;
			 int counter = 0;
			 
			 while(!done) {
				 int marbleX = startX;
				 for(int i = 0;i<2;i++) {
					 if(counter == getMarbles()) {
						 done = true;
					 }
					 else {
						 Marble m = new Marble(Color.GREEN,marbleX,marbleY);
						 m.draw((Graphics2D)g);
						 marbleX = marbleX + 30;
						 counter++;
					 }
				 }
				 marbleY = marbleY + 30; 
			 }
		 }
		super.paintComponent(g);
	}
}
