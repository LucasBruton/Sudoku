import javax.swing.*;
import java.awt.*;
/**
* Classe qui permet de créer un JPanel qui félécite le joueur.
* @see JPanel
* @see CaseActionListener
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class Victoire extends JPanel {
	/**
	* Constructeur de la classe Victoire.
	*/
	public Victoire() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.BLACK);
		JLabel text = new JLabel("Félicitations, vous avez réussi ce sudoku !");
		text.setForeground(Color.WHITE);
		this.add(text);
	}
}