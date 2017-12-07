import java.awt.Color;
import java.util.ArrayList;
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
