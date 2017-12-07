import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	
	private Color c;
	private int x;
	private int y;
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
		super.paintComponent(g);
	}
	
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
	
	public void setColor(Color c)
	{
		this.c = c;
		this.repaint();
	}
	
	//if the user picks up the pit
	public int pickedPit() {
		
		int hand = numOfMarbles;
		numOfMarbles = 0;
		this.setText(Integer.toString(numOfMarbles));
		return hand;
	}
	
	public int getMarbles()
	{
		return numOfMarbles;
	}
	
	public void setNumOfMarbles(int i)
	{
		this.setText(Integer.toString(i));
		numOfMarbles = i;
	}
	
}
