import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Pit {
	
	private Color c;
	private int x;
	private int y;
	private Shape shape;
	private final int size = 200;
	
	
	public Pit(Version v) {
		if(v == Version.ONE) {
			c = Color.GREEN;
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
	}
	
	

}
