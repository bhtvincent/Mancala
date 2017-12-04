import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

import javax.swing.*;

public class Pit extends JButton{
	
	private Color c;
	private int x;
	private int y;
	private final int size = 50;
	private int numOfMarbles;
	private Shape shape;
	
	
	//Intializes the LinkedList, 
	public Pit(int numOfMarbles, Version v, int x, int y) {
		
		super(Integer.toString(numOfMarbles));
		numOfMarbles = 0;
		this.x=x;
		this.y=y;
		c = Color.RED;

		//setBackground(Color.lightGray);
	    //setFocusable(false);
	   // Dimension size = new Dimension(size,size);
	    //size.width = size.height = Math.max(size.width, size.height);*/
	    setContentAreaFilled(false);
	    
	    shape = new Ellipse2D.Double();
	    
	}
		
	
	//Adds a marble to the LinkedList
	public void addMarble(Marble m) {
		numOfMarbles++;;
	}
	
	
	protected void paintComponent(Graphics g)
	{
		/*Graphics2D g2 = (Graphics2D) g;
		this.draw(g2);*/
		g.setColor(c);
		g.fillOval(x, y, size-1,size-1);
		super.paintComponent(g);
	}
	
	protected void paintBorder(Graphics g) {
		 g.setColor(Color.darkGray);
		 g.drawOval(x, y, size, size);
		 super.paintBorder(g);
	}
	
	public boolean contains(int x, int y) {
	    // If the button has changed size,  make a new shape object.
	    if (shape == null || !shape.getBounds().equals(getBounds())) {
	      shape = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
	    }
	    return shape.contains(x, y);
	  }
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		Pit pit = new Pit(4,Version.ONE,10,10);
		Pit pit2 = new Pit(4,Version.ONE,20,20);
		
		frame.add(pit);
		frame.add(pit2)
;		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

}
