import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
public class Marble extends JComponent
{	
	private Color c; //The color of the marble
	private int x; //The x of the marble's bounding rectangle's top left corner
	private int y; // the y of the marble's bounding rectangle's top left corner
	private static final int HEIGHT = 20; //height of the marble's bounding rectangle
	private static final int WIDTH = 20; //widht of the marble's bounding rectangle
	
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
	
	/*Main method for testing purposes
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		frame.add(new Marble(Color.BLACK, 5, 5), BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	*/
}
