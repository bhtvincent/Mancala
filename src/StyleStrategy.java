import java.awt.*;
import java.util.ArrayList;

/**
 * Strategy to modify the Pits on the Mancala Board. Anything that can be done to a JButton may be done to a Pit
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 *
 */
public interface StyleStrategy 
{
	/**
	 * Method that will modifiy the look and feel of the given Pits and MancalaPits
	 * @param pits The Pits to modify
	 * @param mancalas The MancalaPits to modify
	 */
	public void createBoard(ArrayList<Pit> pits, ArrayList<MancalaPit> mancalas);
}
