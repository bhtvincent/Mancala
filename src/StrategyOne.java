import java.awt.Color;
import javax.swing.*;
import java.util.ArrayList;
public class StrategyOne implements StyleStrategy
{	
	private Color pitColor;
	private Color mancalaColor;
	
	public StrategyOne(Color pitColor, Color mancalaColor)
	{
		this.pitColor = pitColor;
		this.mancalaColor = mancalaColor;
	}
	
	public void createBoard(ArrayList<Pit> pits, ArrayList<MancalaPit> mancalas)
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
