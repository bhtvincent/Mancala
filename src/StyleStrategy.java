import java.awt.*;
import java.util.ArrayList;
public interface StyleStrategy 
{
	public void createBoard(Color mancalaColor, Color pitColor, ArrayList<Pit> pits, ArrayList<MancalaPit> mancalas);
}
