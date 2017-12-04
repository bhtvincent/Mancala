import java.util.*;
import javax.swing.event.*;
public class ModelOfMancala 
{
	private ArrayList<Pit> pits;
	private ArrayList<MancalaPit> mancalas;
	private ArrayList<ChangeListener> listeners;
	
	/**
	 * Creates a ModelOfMancala with empty pit and listener arraylists
	 */
	public ModelOfMancala()
	{
		pits = new ArrayList<>();
		listeners = new ArrayList<>();
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
	 * Moves the Marbles from one pit into the next
	 * pits. Not yet Functional
	 */
	public void moveMade()
	{
		return;
	}
	
	public ArrayList<Pit> getPits()
	{
		return pits;
	}
	
	public ArrayList<MancalaPit> getMancalas()
	{
		return mancalas;
	}
}
