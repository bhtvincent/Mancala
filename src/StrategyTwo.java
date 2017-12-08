import java.awt.Color;
import java.util.ArrayList;

/**
 * Second concrete strategy that implements the StyleStrategy interface and acts as a selectable style for the user.
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 * @version December 7, 2017
 */

public class StrategyTwo implements StyleStrategy 
{
	
	/**
	* Creates the board based on the selected style and changes the color of the pits and mancalas
	* @param pits the pits of the board
	* @param mancalas the two mancalas of the board
	*/
		 
	public void createBoard(ArrayList<Pit> pits, ArrayList<MancalaPit> mancalas)
	{
		for(Pit p : pits)
		{
			p.setColor(Color.CYAN);
		}
		for(MancalaPit mp : mancalas)
		{
			mp.setColor(Color.MAGENTA);
		}
	}
}
