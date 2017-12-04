import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Pit extends JButton{
	
	private Color c;
	private int x;
	private int y;
	private Shape shape;
	private final int size = 150;
	
	
	public Pit(Version v, int x, int y) {
		this.x=x;
		this.y=y;
		if(v == Version.ONE) {
			c = Color.CYAN;
			shape = new Ellipse2D.Double(x, y, size, size);
			
		}
		else if(v == Version.TWO) {
			c = Color.RED;
			shape = new Rectangle2D.Double(x, y, size, size);
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(c);
		g2.draw(shape);
		g2.fill(shape);
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		this.draw(g2);
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		frame.add(new Pit(Version.ONE,10,10), BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

}
