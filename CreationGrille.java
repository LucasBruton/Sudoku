import javax.swing.*;
import java.awt.*;

/**
* <b>CreationGrille gère les actions des boutons une fois actionné.</b>
* <p>Ces actions sont :
* <ul>
* <li>remplacer l'objet de type DebutdePartie par le mode de jeu sélectionné;</li>
* <li>sauvegarder la grille du joueur dans un nouveau fichier .gri;</li>
* <li>ouvrir un fichier pour que le joueur puisse sélectionner une grille.
* </ul>
* @see DebutDePartie
* @see ConstructionDeGrille
* @see LectureFichier
* @see EcritureFichier
* @see Grille
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class CreationGrille {
	/**
	* Fenetre du jeu. Celle-ci pourra subir des modifications par CreationGrille.
	* @see CreationGrille#CreationGrille(tab, f)
	* @see CreationGrille#effetBouton1(numBouton)
	* @see CreationGrille#effetBouton2()
	* @see CreationGrille#effetBouton3(numBouton)
	* @see JFrame
	* @see Fenetre
	*/
	private JFrame fenetre;

	/**
	* Tableau des numéro des cases du sudoku.
	* @see CreationGrille#effetBouton1(numBouton)
	* @see CreationGrille#effetBouton2()
	* @see CreationGrille#effetBouton3(numBouton)
	* @see CreationGrille#effetBouton4(numBouton)
	* @see CreationGrille#effetBouton5(numBouton)
	* @see CreationGrille#effetBouton1(numBouton)
	*/
	private int[][] tableau;

	/**
	* Objet le classe grille qui remplacera l'objet DebutDePartie.
	* @see CreationGrille#effetBouton1(numBouton)
	* @see CreationGrille#effetBouton2()
	* @see CreationGrille#effetBouton3(numBouton)
	* @see Grille
	*/
	private Grille grille;

	/**
	* Constructeur de la classe CreationGrille.
	* <p> Il initialise les attributs de la classe.</p>
	* @param tab
	* 	Initialise CreationGrille#tableau
	* @param f
	* 	Initialise CreationGrille#fenetre
	* @see CreationGrille#tableau
	* @see CreationGrille#grille
	* @see CreationGrille#fenetre
	*/

	public CreationGrille(int[][] tab, JFrame f) {
		this.fenetre = f;
		this.tableau = tab;
		this.grille = new Grille(this.fenetre);	
	}

	/**
	* Méthode appelé par BoutonActionListener.
	* EffetBouton sélectionne la méthode approprié pour 
	* réalisé l'action demandé par le joueur.
	* @param numBouton 
	* 	Numéro du bouton qui fait une demande d'action
	* @see BoutonActionListener#actionPerformed(e)
	* @see CreationGrille#effetBouton1(numBouton)
	* @see CreationGrille#effetBouton2()
	* @see CreationGrille#effetBouton3(numBouton)
	* @see CreationGrille#effetBouton4(numBouton)
	* @see CreationGrille#effetBouton5(numBouton)
	*/
	public void effetBouton(int numBouton) {
		if(numBouton == 1) {
			this.effetBouton1(numBouton);
		} else if(numBouton == 2) {
			this.effetBouton2();
		} else if(numBouton == 3) {
			this.effetBouton3(numBouton);
		} else if(numBouton == 4) {
			this.effetBouton4(numBouton);
		} else if(numBouton == 5) {
			this.effetBouton5(numBouton);
		}

	}
	/**
	* Cette méthode s'occupe de remplacer l'objet DebutdePartie
	* par le mode de résolution manuel du sudoku.
	* @param numBouton
	* @see CreationGrille#effetBouton(numBouton)
	* @see CreationGrille#tableau
	* @see CreationGrille#grille
	* @see CreationGrille#fenetre
	*/
	private void effetBouton1(int numBouton) {
		this.grille.setNumeroDesCases(this.tableau);
		this.fenetre.setContentPane(this.grille);
		this.grille.setTypeDeCase(numBouton);
		this.fenetre.repaint();
		this.fenetre.revalidate();		
	}
	/**
	* Cette méthode s'occupe de remplacer l'objet DebutdePartie
	* par le mode de résolution automatique du sudoku.
	* @param numBouton
	* @see Automatique
	* @see CreationGrille#effetBouton(numBouton)
	* @see CreationGrille#tableau
	* @see CreationGrille#grille
	* @see CreationGrille#fenetre
	*/
	private void effetBouton2() {
		this.grille.setNumeroDesCases(this.tableau);
		Automatique a = new Automatique(this.grille, this.fenetre);
		a.modeAutomatique();
	}

	/**
	* Cette méthode s'occupe de remplacer l'objet DebutdePartie
	* par le mode de construction de grille du sudoku.
	* @param numBouton
	* @see ConstructionDeGrille
	* @see CreationGrille#effetBouton(numBouton)
	* @see CreationGrille#tableau
	* @see CreationGrille#grille
	* @see CreationGrille#fenetre
	*/
	private void effetBouton3(int numBouton) {
		this.grille.setNumeroDesCases(this.tableau);
		ConstructionDeGrille construction = new ConstructionDeGrille(grille, this);
		this.fenetre.setContentPane(construction);
		this.grille.setTypeDeCase(numBouton);
		this.fenetre.repaint();
		this.fenetre.revalidate();
	}
	/**
	* Cette méthode s'occupe de modifier le tableau des numéro des cases 
	* du sudoku utilisé par l'objet Grille en fonction du fichier
	* .gri sélectionner par le joueur.
	* @param numBouton
	* @see LectureFichier
	* @see CreationGrille#effetBouton(numBouton)
	* @see CreationGrille#tableau
	*/	
	private void effetBouton4(int numBouton) {
		LectureFichier file = new LectureFichier(this.tableau);
		this.tableau = file.getTableau();
	}
	/**
	* Cette méthode s'occupe de sauvegarder le tableau des numéro des cases 
	* du sudoku dans un fichier nommé "Grille.gri" dans le dossier grilles.
	* @param numBouton
	* @see EcritureFichier
	* @see CreationGrille#effetBouton(numBouton)
	* @see CreationGrille#tableau
	*/	
	private void effetBouton5(int numBouton) {
		EcritureFichier fichier = new EcritureFichier(this.tableau);
	}
}