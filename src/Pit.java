import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

/**
 * This class extends JButton showing them as Ellipses instead of squares
 * Pits can be clicked, can set their color, and save the amount of marbles they hold
 * @author Team Java
 *
 */
public class Pit extends JButton{
	
	protected Color c;
	protected int x;
	protected int y;
	private final int size = 60;
	private int numOfMarbles;
	private Shape shape;
	
	/**
	 * Creates a Pit Button and sets numOfMarbles to amount of marbles it holds
	 * @param numOfMarbles - can only be initialized to 3 or 4, but taken care of in InputMarbles class
	 */
	public Pit(int numOfMarbles) {
		
		super(Integer.toString(numOfMarbles));
		this.numOfMarbles = numOfMarbles;
		this.setPreferredSize(new Dimension(size,size));
		
		this.setBackground(c);
		this.setOpaque(true);
		this.setBorderPainted(false);

		setBackground(Color.lightGray);
	    setFocusable(false);
	    setContentAreaFilled(false);
	    
	}
		
	
	/**
	 * Adds one marble to numOfMarbles
	 */
	public void addMarble() {
		this.setText(Integer.toString(++numOfMarbles));
	}
	
	/**
	 * Paints the inside of the Pit its Color c, and grey when clicked
	 */
	protected void paintComponent(Graphics g)
	{
		if (getModel().isArmed()) {
		      g.setColor(Color.gray);
		} else {
			   g.setColor(c);
		}
		 g.fillOval(0, 0, getSize().width, getSize().height);
		 
		 if(numOfMarbles>0) {
			 int startX = x+ 25;
			 int marbleY = y + 40;
			 boolean done  = false;
			 int counter = 0;
			 
			 while(!done) {
				 int marbleX = startX;
				 for(int i = 0;i<3;i++) {
					 if(counter == numOfMarbles) {
						 done = true;
					 }
					 else {
						 Marble m = new Marble(Color.BLACK,marbleX,marbleY); //THIS IS WHERE THE MARBLE COLOR IS CHOSEN
						 m.draw((Graphics2D)g);
						 marbleX = marbleX + 10;
						 counter++;
					 }
				 }
				 marbleY = marbleY + 10; 
			 }
		 }
		super.paintComponent(g);
	}
	
	/**
	 * Creates the dark border for the pits.
	 */
	protected void paintBorder(Graphics g) {
		//paints the border
		 g.setColor(Color.darkGray);
		 g.drawOval(0, 0, getSize().width , getSize().height );
		 super.paintBorder(g);
	}
	
	public boolean contains(int x, int y) {
	    // If the button has changed size,  make a new shape object.
	    if (shape == null || !shape.getBounds().equals(getBounds())) {
	      shape = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
	    }
	    return shape.contains(x, y);
	  }
	
	/**
	 * Changes the color of the pit
	 * @param c the new color of the pit
	 */
	public void setColor(Color c)
	{
		this.c = c;
		this.repaint();
	}
	
	/**
	 * Changes pit's value if it is selected. Resets the pit's value to zero
	 * @return the number of marbles held in this pit
	 */
	public int pickedPit() {
		
		int hand = numOfMarbles;
		numOfMarbles = 0;
		this.setText(Integer.toString(numOfMarbles));
		return hand;
	}
	
	/**
	 * Gets the number of marbles in the pit without mutating the pit's value
	 * @return the number of marbles in the pit
	 */
	public int getMarbles()
	{
		return numOfMarbles;
	}
	
	/**
	 * Sets the number of marbles in the pit to the specified value
	 * @param i the number of marbles to be in the pit
	 */
	public void setNumOfMarbles(int i)
	{
		this.setText(Integer.toString(i));
		numOfMarbles = i;
	}

}
