import java.awt.Color;
import java.util.ArrayList;

/**
 * First concrete strategy that implements the StyleStrategy interface and acts as a selectable style for the user.
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 * @version December 7, 2017
 */

public class StrategyOne implements StyleStrategy
{	
	public void createBoard(ArrayList<Pit> pits, ArrayList<MancalaPit> mancalas)
	{
		for(Pit p : pits)
		{
			p.setColor(Color.YELLOW);
		}
		for(MancalaPit mp : mancalas)
		{
			mp.setColor(Color.RED);
		}
	}
}
