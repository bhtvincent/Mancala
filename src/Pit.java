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
	private final int size = 60;
	private int numOfMarbles;
	private Shape shape;
	
	
	//Intializes the LinkedList, 
	public Pit(int numOfMarbles, Version v, int x, int y) {
		
		super(Integer.toString(numOfMarbles));
		numOfMarbles = 0;
		this.x=x;
		this.y=y;
		this.setPreferredSize(new Dimension(size,size));
		
		c = Color.RED;
		this.setBackground(Color.RED);
		this.setOpaque(true);
		this.setBorderPainted(false);


		setBackground(Color.lightGray);
	    setFocusable(false);
	    setContentAreaFilled(false);
	    
	    
	}
		
	
	//Adds a marble to the LinkedList
	public void addMarble(Marble m) {
		numOfMarbles++;;
	}
	
	
	protected void paintComponent(Graphics g)
	{
		//Paints the inside of the Pit, and grey if its clicked
		if (getModel().isArmed()) {
		      g.setColor(Color.gray);
		} else {
			   g.setColor(c);
		}
		 g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
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
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		Pit pit = new Pit(4,Version.ONE,10,10);
		panel.add(pit);	
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

}
