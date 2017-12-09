import java.util.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Models a Mancala Game
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 *
 */
public class ModelOfMancala 
{
	private ArrayList<Pit> pits;
	private ArrayList<MancalaPit> mancalas;
	private ArrayList<Integer> previousPits;
	private ArrayList<Integer> previousMancalas;
	private ArrayList<ChangeListener> listeners;
	
	/**
	 * Creates a ModelOfMancala with empty pit and listener arraylists
	 */
	public ModelOfMancala()
	{
		pits = new ArrayList<>();
		mancalas = new ArrayList<>();
		listeners = new ArrayList<>();
		previousPits = new ArrayList<>();
		previousMancalas = new ArrayList<>();
	}
	
	/**
	 * Attaches a ChangeListener to this model
	 * @param cl the ChangeListener to attach to this model
	 */
	public void attach(ChangeListener cl)
	{
		listeners.add(cl);
	}
	
	/**
	 * Updates the ChangeListeners of this Model
	 * if there is a change
	 */
	public void update()
	{
		for(ChangeListener cl : listeners)
		{
			cl.stateChanged(new ChangeEvent(this));
		}
	}
	
	/**
	 * Models on turn in the Mancala game
	 * @param index the index of the pit on the board where the turn was initiated
	 */
	public void moveMade(int index)
	{
		previousPits.clear();
		for(int i = 0; i < 12; i++)
		{
			previousPits.add(pits.get(i).getMarbles());
		}
		previousMancalas.clear();
		for(int i = 0; i < 2; i++)
		{
			previousMancalas.add(mancalas.get(i).getMarbles());
		}
		Pit p = pits.get(index);
		int stones = p.pickedPit();
		int i = index;
		while(stones > 0)
		{
			if(i == 5 && index > -1 && index <= 5 )
			{
				mancalas.get(0).addMarble();
				i=6;
				stones--;
				if(stones == 0)
				{
					JFrame extraTurnFrame = new JFrame();
					extraTurnFrame.setLocationRelativeTo(null);
					extraTurnFrame.setLayout(new BorderLayout());
					extraTurnFrame.setSize(new Dimension(450,100));
					extraTurnFrame.add(new JLabel("Congratulations! You get an extra turn for landing in your own mancala!"), BorderLayout.NORTH);
					JButton ok = new JButton("OK");
					ok.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							extraTurnFrame.dispose();
						}
					});
					extraTurnFrame.add(ok, BorderLayout.CENTER);
					extraTurnFrame.setVisible(true);
				}
			}
			else if(i == 11 && index > 5 && index <= 11)
			{
				mancalas.get(1).addMarble();
				i=-1;
				stones--;
				if(stones == 0)
				{
					JFrame extraTurnFrame = new JFrame();
					extraTurnFrame.setLocationRelativeTo(null);
					extraTurnFrame.setLayout(new BorderLayout());
					extraTurnFrame.setSize(new Dimension(450,100));
					extraTurnFrame.add(new JLabel("Congratulations! You get an extra turn for landing in your own mancala!"), BorderLayout.NORTH);
					JButton ok = new JButton("OK");
					ok.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							extraTurnFrame.dispose();
						}
					});
					extraTurnFrame.add(ok, BorderLayout.CENTER);
					extraTurnFrame.setVisible(true);
				}
			}
			else
			{
				//int z = i;
				//if(++z > 11)
				//{
				//	i = -1;
				//}
				//if(i >= 6 && index < 6)
				//{
				//	pits.get(i++).addMarble();
				//	stones--;
				//}
				//else
				//{
				//	pits.get(++i).addMarble();
				//	stones--;
				//}
				//if(++i > 11)
				//{
				//	i = -1;
				//}
				//else
				//{
				//	i--;
				//}
				if(i >= 6 && index < 6 || i == 11)
				{
					pits.get(i).addMarble();
					stones--;
					i++;
				}
				else
				{
					pits.get(++i).addMarble();
					stones--;
				}
				int z = 0;
				if(i == 12)
				{
					i--;
					z = 12;
				}
				if(stones == 0 && pits.get(i).getMarbles() == 1)
				{
					if(index <= 5)
					{
						if( i == 0)
						{
							int j = 11;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(0).addMarble();
							}
						}
						if(i == 1)
						{
							int j = 10;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(0).addMarble();
							}
						}
						if(i == 2)
						{
							int j = 9;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(0).addMarble();
							}
						}
						if(i == 3)
						{
							int j = 8;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(0).addMarble();
							}
						}
						if(i == 4)
						{
							int j = 7;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(0).addMarble();
							}
						}
						if(i == 5)
						{
							int j = 6;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(0).addMarble();
							}
						}
					}
					else
					{
						if(index > 5)
						{
						if(i == 11)
						{
							int j = 0;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(1).addMarble();
							}
							//i++;
						}
						if(i == 10)
						{
							int j = 1;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(1).addMarble();
							}
						}
						if(i == 9)
						{
							int j = 2;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(1).addMarble();
							}
						}
						if(i == 8)
						{
							int j = 3;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(1).addMarble();
							}
						}
						if(i == 7)
						{
							int j = 4;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(1).addMarble();
							}
						}
						if(i == 6)
						{
							int j = 5;
							int caputred = pits.get(i).pickedPit() + pits.get(j).pickedPit();
							for(int x = caputred; x > 0; x--)
							{
								mancalas.get(1).addMarble();
							}
						}
						}
					}
				}
				if(z != 0)
				{
					i = z;
				}
				if(i > 11 && index < 6)
				{
					i = -1;
				}
			}
		}
		update();
		
		if(pits.get(0).getMarbles() == 0 && pits.get(1).getMarbles() == 0 && pits.get(2).getMarbles() == 0 && pits.get(3).getMarbles() == 0 && pits.get(4).getMarbles() == 0 && pits.get(5).getMarbles() == 0)
		{
			int remaining = 0;
			for(int a = 6; a < 12; a++)
			{
				remaining += pits.get(a).pickedPit();
			}
			while(remaining > 0)
			{
				mancalas.get(1).addMarble();
				remaining--;
			}
			if(mancalas.get(0).getMarbles() > mancalas.get(1).getMarbles())
			{
				JFrame victoryFrame = new JFrame();
				victoryFrame.setLocationRelativeTo(null);
				victoryFrame.setLayout(new BorderLayout());
				victoryFrame.setSize(new Dimension(250,100));
				victoryFrame.add(new JLabel("Congratulations Player B! You Win"), BorderLayout.NORTH);
				JButton ok = new JButton("OK");
				ok.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						victoryFrame.dispose();
					}
				});
				victoryFrame.add(ok, BorderLayout.CENTER);
				victoryFrame.setVisible(true);
			}
			else
			{
				JFrame victoryFrame = new JFrame();
				victoryFrame.setLocationRelativeTo(null);
				victoryFrame.setLayout(new BorderLayout());
				victoryFrame.setSize(new Dimension(250,100));
				victoryFrame.add(new JLabel("Congratulations Player A! You Win"), BorderLayout.NORTH);
				JButton ok = new JButton("OK");
				ok.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						victoryFrame.dispose();
					}
				});
				victoryFrame.add(ok, BorderLayout.CENTER);
				victoryFrame.setVisible(true);
			}
		}
		if(pits.get(6).getMarbles() == 0 && pits.get(7).getMarbles() == 0 && pits.get(8).getMarbles() == 0 && pits.get(9).getMarbles() == 0 && pits.get(10).getMarbles() == 0 && pits.get(11).getMarbles() == 0)
		{
			int remaining = 0;
			for(int b = 0; b < 6; b++)
			{
				remaining += pits.get(b).pickedPit();
			}
			while(remaining > 0)
			{
				mancalas.get(0).addMarble();
				remaining--;
			}
			if(mancalas.get(0).getMarbles() > mancalas.get(1).getMarbles())
			{
				JFrame victoryFrame = new JFrame();
				victoryFrame.setLocationRelativeTo(null);
				victoryFrame.setLayout(new BorderLayout());
				victoryFrame.setSize(new Dimension(250,100));
				victoryFrame.add(new JLabel("Congratulations Player B! You Win"), BorderLayout.NORTH);
				JButton ok = new JButton("OK");
				ok.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						victoryFrame.dispose();
					}
				});
				victoryFrame.add(ok, BorderLayout.CENTER);
				victoryFrame.setVisible(true);
			}
			else
			{
				JFrame victoryFrame = new JFrame();
				victoryFrame.setLocationRelativeTo(null);
				victoryFrame.setLayout(new BorderLayout());
				victoryFrame.setSize(new Dimension(250,100));
				victoryFrame.add(new JLabel("Congratulations Player A! You Win"), BorderLayout.NORTH);
				JButton ok = new JButton("OK");
				ok.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						victoryFrame.dispose();
					}
				});
				victoryFrame.add(ok, BorderLayout.CENTER);
				victoryFrame.setVisible(true);
			}
		}
	}
	
	/**
	 * Reverts the most recent turn in the Mancala game
	 */
	public void undo()
	{
		for(int i = 0; i < 12; i++)
		{
			pits.get(i).setNumOfMarbles(previousPits.get(i));
		}
		for(int i = 0; i < 2; i++)
		{
			mancalas.get(i).setNumOfMarbles(previousMancalas.get(i));
		}
		update();
	}
	
	/**
	 * Retrieves the list of Pits in this game
	 * @return the list of Pits in this game
	 */
	public ArrayList<Pit> getPits()
	{
		return pits;
	}
	
	/**
	 * Returns the MancalaPits of this game
	 * @return the MancalaPits of this game
	 */
	public ArrayList<MancalaPit> getMancalas()
	{
		return mancalas;
	}
	
	/**
	 * Adds a pit to this game
	 * @param p The pit to add to this game
	 */
	public void addPit(Pit p)
	{
		pits.add(p);
	}
	
	/**
	 * Adds a MancalaPit to this game. 
	 * @param mp The MancalaPit to be added to this game
	 */
	public void addMancala(MancalaPit mp)
	{
		mancalas.add(mp);
	}
}
