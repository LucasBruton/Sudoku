import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* <b>DebutDePartie est un composant graphique qui hérite de JPanel. 
* Celui-ci permet qui permet au joueur de sélectionner un mode de jeu du sudoku.</b> 
* <p>Ces mdes de jeu sont :
* <ul> 
* <li>le mode manuel de résolution du sudoku; </li>
* <li>le mode automatique de résolution du sudoku; </li>
* <li> le mode construction de grille.
* </ul>
* </p>
* <p>Cette classe est utilisé par la class Fenetre qui hérite de JPanel/
* @author Lucas Bruton
* @see CreationGrille
* @see Fenetre
* @version 1.0
* @since 2020-03-19
*/

public class DebutDePartie extends JPanel {
	/**
	* Constructeur de DebutDePartie.
	*<p>Il intialise un objet de la classe CreationGrille qui 
	* s'occupe de créer la grille du sudoku en fonction du mode choisit, et des fichiers  en .gri 
	* </p>
	* @param fenetre
	*	Le JFrame utilisé par la fenetre.
	* @see CreationGrille
	* @see BoutonActionListener
	*/

	public DebutDePartie(JFrame fenetre) {
        int[][] tableau = newTableau();
        CreationGrille c = new CreationGrille(tableau, fenetre);
		this.setLayout(new GridLayout(2,1));

		JPanel panneau1 = new JPanel(new BorderLayout());
		panneau1.setBackground(Color.BLACK);
		JPanel panneau2 = new JPanel(new BorderLayout());
		panneau2.setBackground(Color.BLACK);
		JPanel panneau3 = new JPanel(new GridLayout(1,2));
		panneau3.setBackground(Color.BLACK);
		JPanel panneau4 = new JPanel(new GridLayout(3,1));
		panneau4.setBackground(Color.BLACK);
		JPanel panneau5 = new JPanel();
		panneau5.setBackground(Color.BLACK);
		JPanel panneau6 = new JPanel(new GridLayout(3,1));
		panneau6.setBackground(Color.BLACK);
		JPanel panneau7 = new JPanel();
		panneau7.setBackground(Color.BLACK);
		JPanel panneau8 = new JPanel();
		panneau8.setBackground(Color.BLACK);

		JLabel titre = new JLabel("Sudoku");
		titre.setFont(new Font("Titre", Font.BOLD, 20));
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setForeground(Color.WHITE);

        JLabel jouer = new JLabel("Jouez :");
        jouer.setHorizontalAlignment(JLabel.CENTER);
        jouer.setFont(new Font("Jouer", Font.BOLD, 15));
        jouer.setForeground(Color.WHITE);

        JLabel construire = new JLabel("Construire une grille");
        construire.setHorizontalAlignment(JLabel.CENTER);
        construire.setFont(new Font("Construire", Font.BOLD, 15));
        construire.setForeground(Color.WHITE);

        JButton boutonManuel = new JButton("     En mode manuel     ");
        boutonManuel.setBackground(Color.WHITE);
        boutonManuel.setForeground(Color.BLACK);

        JButton boutonAlgorithme = new JButton("En mode Automatique");
        boutonAlgorithme.setBackground(Color.WHITE);
        boutonAlgorithme.setForeground(Color.BLACK);

        JButton boutonConstructionGrille = new JButton("Modifier/Construire grille");
        boutonConstructionGrille.setBackground(Color.WHITE);
        boutonConstructionGrille.setForeground(Color.BLACK);

        JButton boutonSelectionGrille = new JButton("Sélectionner une grille");
        boutonSelectionGrille.setBackground(Color.WHITE);
        boutonSelectionGrille.setForeground(Color.BLACK);

		this.add(panneau1);
		this.add(panneau2);
		panneau2.add(panneau3, BorderLayout.CENTER);
		panneau3.add(panneau4);
		panneau3.add(panneau6);
		panneau1.add(titre, BorderLayout.CENTER);
        panneau4.add(jouer, BorderLayout.SOUTH);
        panneau4.add(panneau5);
        panneau5.add(boutonManuel);
        panneau5.add(boutonAlgorithme);
        panneau6.add(construire);
        panneau6.add(panneau7);
        panneau7.add(boutonConstructionGrille);
        panneau2.add(panneau8, BorderLayout.SOUTH);
        panneau8.add(boutonSelectionGrille);

       	BoutonActionListener b1 = new BoutonActionListener(c,1);
       	BoutonActionListener b2 = new BoutonActionListener(c,2);
       	BoutonActionListener b3 = new BoutonActionListener(c,3);
       	BoutonActionListener b4 = new BoutonActionListener(c,4);

        boutonManuel.addActionListener(b1);
       	boutonAlgorithme.addActionListener(b2);
       	boutonConstructionGrille.addActionListener(b3);
       	boutonSelectionGrille.addActionListener(b4);
    }  
    /**
    * Cette méthode permet d'initialiser les numéro des cases du sudoku.
    * @see DebutDePartie#DebutDePartie(fenetre)
    * @return int[][]
    * 	tableau des numéro des cases.
    */

	private int[][] newTableau() {
		int[][] tab = new int[9][9];
		for(int i=0;i<9;i++) {
			for(int j= 0;j<9;j++) {
				tab[i][j] = 0;
			}
			
		}
		return tab;
	} 
}