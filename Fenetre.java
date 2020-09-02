import javax.swing.*;
import java.awt.*;

/**
* Fenetre est un objet de la classe JFrame.
*<p>
* Cette classe affiche le jeu "Sudoku"
* en faisant appel à des classes de type JPanel tel que DebutdePartie et Grille.
* </p>
* @see DebutDePartie 
* @see Grille
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/

public class Fenetre extends JFrame {
	/**Constructeur de la classe Fenetre.
	*<p>
	* Elle construit un objets de la classe DebutDePartie 
	* pour pouvoir l'afficher.
	* @see DebutDePartie
	*/

	public Fenetre() {
		DebutDePartie debut = new DebutDePartie(this);
		this.setContentPane(debut);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setMinimumSize(new Dimension(500,500));
		
	}


}