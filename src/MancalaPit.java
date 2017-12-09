import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * A Player's Mancala in the game Mancala
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 *
 */
public class MancalaPit extends Pit
{
	/**
	 * Constructs an empty MancalaPit using the super ctor, and changes the size to be shaped like a Mancala
	 */
	public MancalaPit()
	{
		super(0);
		this.setEnabled(false);
		this.setPreferredSize((new Dimension(100,250)));
	}
	
	/**
	 * Constructs a MancalaPit with the specified value of marbles already inside
	 * @param i the numeber of marbles to initially be in the MancalaPit
	 */
	public MancalaPit(int i)
	{
		super(i);
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(100, 250));
	}
	
	/*public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(200, 200);
		MancalaPit pit = new MancalaPit();
		panel.add(pit);	
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}*/
}
