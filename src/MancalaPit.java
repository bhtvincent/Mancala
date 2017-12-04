import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MancalaPit extends Pit
{
	public MancalaPit(int numOfMarbles, int x, int y)
	{
		super(numOfMarbles,x,y);
		this.setEnabled(false);
		this.setPreferredSize((new Dimension(100,250)));
	}
	

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		MancalaPit pit = new MancalaPit(0,10,10);
		panel.add(pit);	
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
