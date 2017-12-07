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
	
	
	public Pit(int numOfMarbles) {
		
		super(Integer.toString(numOfMarbles));
		this.numOfMarbles = numOfMarbles;
		//this.x=x;
		//this.y=y;
		this.setPreferredSize(new Dimension(size,size));
		
		c = Color.RED;//Set the Color
		this.setBackground(c);
		this.setOpaque(true);
		this.setBorderPainted(false);


		setBackground(Color.lightGray);
	    setFocusable(false);
	    setContentAreaFilled(false);
	    
	    
	}
		
	
	//Adds a marble to the LinkedList
	public void addMarble() {
		this.setText(Integer.toString(++numOfMarbles));
	}
	
	
	protected void paintComponent(Graphics g)
	{
		//Paints the inside of the Pit, and grey if its clicked
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
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		Pit pit = new Pit(4);
		panel.add(pit);	
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

}
