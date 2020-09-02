import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
* BoutonActionListener réalise une interface ActionListener. Cette classe est utilisé pour
* transmettre à l'objet de la classe CreationGrille, initialiser par DebutDePartie, le numero 
* du bouton actionné.
*<p>Cette classe est utilisé par des boutons de la classe DebutDePartie
* et CreationDeGrille.</p>
* @see DebutDePartie
* @see CreationGrille
* @see BoutonActionListener#actionPerformed(ActionEvent e)
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/

public class BoutonActionListener implements ActionListener {
	/**
	* L'objet CreationGrille initialiser par DebutDePartie.
	* BoutonActionListener va transmettre à cet objet numBouton.
	* @see BoutonActionListener#numBouton
	* @see BoutonActionListener#BoutonActionListener()
	* @see BoutonActionListener#actionPerformed(ActionEvent)
	*/
	private CreationGrille creation;

	/**
	* Le numéro du bouton. Ce numéro dira à l'objet CreationGrille
	* quelle action faire lorsque le bouton est actionné.
	* @see BoutonActionListener#creation
	* @see BoutonActionListener#BoutonActionListener()
	* @see BoutonActionListener#actionPerformed(ActionEvent)
	*/
	private int numBouton;

	/**
	* Constructeur de BoutonActionListener.
	* <p>Initialise les attributs creation et numBouton.
	* </p>
	* @param c
	* 		Objet de la classe CreationGrille
	* @param n
	* 		int qui correspont au numéro du bouton qui va actionné l'action.
	* @see BoutonActionListener#creation
	* @see BoutonActionListener#numBouton
	* @see DebutDePartie
	* @see ConstructionDeGrille
	*/

	public BoutonActionListener(CreationGrille c, int n) {
		this.creation = c;
		this.numBouton = n;
	}

	/**Transmet à l'objet CreationGrille le numéro du bouton.
	* @param e
	* @see ActionEvent 
	* @see BoutonActionListener#creation
	* @see BoutonActionListener#numBouton
	* @see CreationGrille#effetBouton(numBouton)
	*/
	@Override 
	public void actionPerformed(ActionEvent e) {
		this.creation.effetBouton(this.numBouton);
	}
}