import java.awt.Color;
import java.util.ArrayList;

public class StrategyTwo implements StyleStrategy 
{
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
