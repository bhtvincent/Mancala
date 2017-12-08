import java.awt.Color;

/**
 * Opens the Select Style View and creates a new Mancala Board based on the selected style. Begins the Mancala game. 
 * @author Grant Clegg
 * @author Daniel Fonyo
 * @author Vincent Tran
 * @version May 6, 2014
 */

public class MancalaTester {

	public static void main(String[] args) {
		new SelectStyle(new ModelOfMancala());
	}
}
