import java.awt.Color;
import javax.swing.*;
import java.util.ArrayList;
public class StrategyOne implements StyleStrategy
{	
	public void createBoard(Color mancalaColor, Color pitColor, ArrayList<Pit> pits, ArrayList<MancalaPit> mancalas)
	{
		for(Pit p : pits)
		{
			p.setBackground(pitColor);
		}
		for(MancalaPit mp : mancalas)
		{
			mp.setBackground(mancalaColor);
		}
	}
}
