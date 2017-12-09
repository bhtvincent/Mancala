import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.*;

import java.util.*;

/**
 * Viewer/Controller of the game. Creates the main game board and notifies the model of user actions
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 *
 */
public class MainFrameOne extends JFrame implements ChangeListener{
	private ModelOfMancala mom;
	private JPanel pits;
	private JPanel main;
	private JPanel pane;
	private JButton undo;
	private StyleStrategy strat;


	public MainFrameOne(ModelOfMancala mom, int numOfMarbles, StyleStrategy strat) {
		this.strat = strat;
		this.mom = mom;
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
		leftPit.setText("<html>M<br>A<br>N<br>C<br>A<br>L<br>A<br> <br>B</html>");
		leftPit.setPreferredSize(new Dimension(50, 50));
		leftPit.setHorizontalAlignment(JLabel.CENTER);
		left.setLayout(new BorderLayout());
		left.add(leftPit, BorderLayout.CENTER);

		JPanel right = new JPanel();
		JLabel rightPit = new JLabel();
		rightPit.setText("<html>M<br>A<br>N<br>C<br>A<br>L<br>A<br> <br>A</html>");
		rightPit.setPreferredSize(new Dimension(50, 50));
		rightPit.setHorizontalAlignment(JLabel.CENTER);
		right.setLayout(new BorderLayout());
		right.add(rightPit, BorderLayout.CENTER);

		main = new JPanel();
		main.setLayout(new BorderLayout());

		setSize(1000, 700);
		setTitle("Mancala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.add(top, BorderLayout.NORTH);
		main.add(bottom, BorderLayout.SOUTH);
		main.add(left, BorderLayout.WEST);
		main.add(right, BorderLayout.EAST);

		add(main, BorderLayout.CENTER);
		//createBoard(Color.RED, Color.CYAN, "circle");
		setVisible(true);
		
		//Gridlayout containing 12 buttons inside of Borderlayout
		int rows = 4;
		int columns = 6;
		
		pane = new JPanel();
		GridLayout layout = new GridLayout(rows, columns);
		layout.setVgap(15);
		layout.setHgap(25);
	    pane.setLayout(layout);
	    ArrayList<Pit> pt = new ArrayList<>();
	    ArrayList<MancalaPit> mpt = new ArrayList<>();
	    for(int i = 0; i < 12; i++)
	    {
	    	pt.add(new Pit(numOfMarbles));
	    }
	    
	    MancalaPit mpb = new MancalaPit();
		mpb.setEnabled(false);
		mpt.add(mpb);
		MancalaPit mpa = new MancalaPit();
		mpa.setEnabled(false);
		mpt.add(mpa);
		
		this.strat.createBoard(pt, mpt);
		for(Pit p : pt)
		{
			this.mom.addPit(p);
		}
		for(MancalaPit mp : mpt)
		{
			this.mom.addMancala(mp);
		}
		
	   for(int i = 5; i > -1; i--)
	   {
		   pane.add(this.mom.getPits().get(i));;
	   }
	   for(int i = 1; i < 13; i++)
	   {
		   String s ="";
		   if(i < 7)
		   {
			   s = "             B" + (7-i);
		   }
		   else
		   {
			   s = "             A" + (i-6);
		   }
		   JLabel b = new JLabel(s);
		   //b.setEnabled(false);
		   //b.setPreferredSize(new Dimension(10, 10));
		   pane.add(b);
	   }
	   for(int i = 6; i < 12; i++)
	   {
		   pane.add(this.mom.getPits().get(i));
	   }
	  undo = new JButton("Undo");
	  undo.setEnabled(false);
	  addActionListeners();
	  createUndoListener();
	  
		pits = new JPanel();
		pits.setLayout(new BorderLayout());
		
		pits.add(mpb, BorderLayout.WEST);
		//pit2.setEnabled(false);
		pits.add(mpa, BorderLayout.EAST);
		pits.add(undo, BorderLayout.NORTH);
		
		pits.add(pane, BorderLayout.CENTER);
	    main.add(pits, BorderLayout.CENTER);

	}
	
	/**
	 * Updates the view if the model has been updated
	 */
	public void stateChanged(ChangeEvent e)
	{
		pane.repaint();
		pits.repaint();
		main.repaint();
		this.repaint();
	}
	
	/**
	 * Creates the ActionListeners for the Pits, so the Pits may notify the model when a play has been made.
	 */
	private void addActionListeners()
	{
		 for(Pit p : mom.getPits())
		   {
			   p.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent e)
				   {
					   mom.moveMade(mom.getPits().indexOf(p));
					   undo.setEnabled(true);
				   }
			   });
		   }
	}
	
	/**
	 * Creates the ActionListener for the undo button, so the model may be notified when the user wishes to undo a turn.
	 */
	private void createUndoListener()
	{
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				mom.undo();
				undo.setEnabled(false);
			}
		});
	}

}
