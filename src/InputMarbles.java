import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Viewer/Controller for how many marbles the user wishes to play with. 
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vicent Tran
 *
 */
public class InputMarbles extends JFrame{

	private int numOfMarbles;
	
	public InputMarbles(ModelOfMancala mom, StyleStrategy strat) {
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("Enter the number of marbles to play with:");
		JTextField marble_num = new JTextField(1);
		JButton button1 = new JButton("Begin!");
		JLabel warning = new JLabel("Wrong number of marbles entered! Enter 3 or 4");
		warning.setVisible(false);
		
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				int num_entered = Integer.parseInt(marble_num.getText());
				if (num_entered < 3 || num_entered > 4) 
					warning.setVisible(true);
				
				else {
					//load mancala game with num_entered
					InputMarbles.super.dispose();
					numOfMarbles = Integer.parseInt(marble_num.getText());
					System.out.println(numOfMarbles);
					MainFrameOne frame = new MainFrameOne(mom, numOfMarbles, strat);
				}
		}});
		
		panel1.add(label1);
		panel1.add(marble_num);
		panel1.add(button1);
		
		add(panel1, BorderLayout.NORTH);
		add(warning, BorderLayout.SOUTH);
		setSize(500,300);
		
		setDefaultCloseOperation(InputMarbles.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	/**
	 * Gets the number of marbles the user wishes to play with
	 * @return the number of marbles the user wishes to play with
	 */
	public int getNumOfMarbles() {
		return numOfMarbles;
	}
	
}
