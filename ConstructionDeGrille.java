import javax.swing.*;
import java.awt.*;
/**
* Classe qui hérite de JPanel.
* <p>
* Cette classe affiche le mode Construction / Modification de la grille
* avec un bouton qui sauvegarde la grille.
* </p>
* @see CreationGrille
* @see JPanel
* @see Grille
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class ConstructionDeGrille extends JPanel {
	/**
	* Constructeur de la classe ConstructionGrille.
	* @param grille
	* 	Grille du jeu
	* @param c
	* 	Objet qui permettra de sauvegarder la grille.
	*/
	public ConstructionDeGrille(Grille grille, CreationGrille c) {
		this.setLayout(new BorderLayout());
		this.add(grille, BorderLayout.CENTER);
		JPanel panneau = new JPanel();
		panneau.setBackground(Color.BLACK);
		this.add(panneau, BorderLayout.SOUTH);

		JButton boutonSauvegarde = new JButton("Sauvegarder la grille");
		boutonSauvegarde.setBackground(Color.WHITE);
		boutonSauvegarde.setForeground(Color.BLACK);
		panneau.add(boutonSauvegarde);

		BoutonActionListener b5 = new BoutonActionListener(c,5);
		boutonSauvegarde.addActionListener(b5);

	}
}