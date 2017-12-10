import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Marble extends JComponent
{	
	private Color c; //The color of the marble
	private int x; //The x of the marble's bounding rectangle's top left corner
	private int y; // the y of the marble's bounding rectangle's top left corner
	private static final int HEIGHT = 8; //height of the marble's bounding rectangle
	private static final int WIDTH = 8; //widht of the marble's bounding rectangle
	
	/**
	 * Creates a Marble with the given color at the x, y coordinate
	 * @param c the Color the marble will be
	 * @param x the X of the top left corner of the marble's bounding rectangle
	 * @param y the Y of the top left corner of the marble's bounding rectangle
	 */
	public Marble(Color c, int x, int y) 
	{
		this.c = c;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draws a marble as an {@link Ellipse2D} at (x,y) with a 
	 * bounding rectangle of height = width = 5
	 * @param g2 the Graphics2D that will draw this marble
	 */
	public void draw(Graphics2D g2)
	{
		Ellipse2D e = new Ellipse2D.Double(x, y, HEIGHT, WIDTH);
		g2.setColor(c);
		g2.fill(e);
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		this.draw(g2);
	}
	
}