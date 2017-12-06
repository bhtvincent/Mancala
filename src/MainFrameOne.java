import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrameOne extends JFrame implements StyleStrategy {
	private ModelOfMancala mom;

<<<<<<< HEAD
	public MainFrameOne() {
		mom = new ModelOfMancala();
		
=======
	public MainFrameOne(int numOfMarbles) {
>>>>>>> cc83e5413da1d2588e9b2718bf043a8f5303a144
		JPanel top = new JPanel();
		JLabel topArrow = new JLabel("<-------");
		JLabel topName = new JLabel("Player B");
		top.add(topArrow);
		top.add(topName);

		JPanel bottom = new JPanel();
		JLabel bottomArrow = new JLabel("------->");
		JLabel bottomName = new JLabel("Player A");
		bottom.add(bottomArrow);
		bottom.add(bottomName);

		JPanel left = new JPanel();
		JLabel leftPit = new JLabel();
		leftPit.setText("<html>M<br>A<br>N<br>C<br>A<br>L<br>A<br> <br>A</html>");
		leftPit.setPreferredSize(new Dimension(50, 50));
		leftPit.setHorizontalAlignment(JLabel.CENTER);
		left.setLayout(new BorderLayout());
		left.add(leftPit, BorderLayout.CENTER);

		JPanel right = new JPanel();
		JLabel rightPit = new JLabel();
		rightPit.setText("<html>M<br>A<br>N<br>C<br>A<br>L<br>A<br> <br>B</html>");
		rightPit.setPreferredSize(new Dimension(50, 50));
		rightPit.setHorizontalAlignment(JLabel.CENTER);
		right.setLayout(new BorderLayout());
		right.add(rightPit, BorderLayout.CENTER);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		setSize(1000, 700);
		setTitle("Mancala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.add(top, BorderLayout.NORTH);
		main.add(bottom, BorderLayout.SOUTH);
		main.add(left, BorderLayout.WEST);
		main.add(right, BorderLayout.EAST);

		add(main, BorderLayout.CENTER);
		createBoard(Color.RED, Color.CYAN, "circle");
		setVisible(true);
		
		//Gridlayout containing 12 buttons inside of Borderlayout
		int rows = 2;
		int columns = 6;
		
		JPanel pane = new JPanel();
	    pane.setLayout(new GridLayout(rows, columns));
	    for (int i = 7; i > 1; i--) {
	     JButton button = new JButton(Integer.toString(numOfMarbles));
	      pane.add(button);
	    }
	    for (int i = 0; i < 6; i++) {
		      JButton button = new JButton(Integer.toString(numOfMarbles));
		      pane.add(button);
		    }
	   
		JPanel pits = new JPanel();
		pits.setLayout(new BorderLayout());
		
		JButton pit1 = new JButton("0");
		pit1.setEnabled(false);
		JButton pit2 = new JButton("0");
		pit2.setEnabled(false);
		
		pits.add(pit1, BorderLayout.WEST);
		pit2.setEnabled(false);
		pits.add(pit2, BorderLayout.EAST);
		
		pits.add(pane, BorderLayout.CENTER);
	    main.add(pits, BorderLayout.CENTER);

	}
	
	public void createBoard(Color mancalaColor, Color pitColor, String pitShape)
	{
		
	}

}
