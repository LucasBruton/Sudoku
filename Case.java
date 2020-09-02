import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
* Classe qui hérite de JPanel.
* <p>
* Cette classe va créer des objets graphiques contentant les chiffres du sudoku.
* En fonction du mode de jeu, les cases contiendront un JLabel ou un JTextField.
* </p>
* @see Grille
* @see JPanel
* @see JLabel
* @see JTextField
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class Case extends JPanel {

	/**
	* JTextField qui sera ajouté à l'objet case si on a besoin que le numéro de la case
	* soit modifiable par le joueur.
	* @see Case#setJTextField(tailleMaxColumns)
	*/
	private JTextField caseACompleter;

	/**
	* JTextField qui sera ajouté à l'objet case si on a besoin que le numéro de la case
	* ne soit pas modifiable par le joueur.
	* @see Case#JLabel()
	* @see Case#setColor(c)
	*/
	private JLabel caseANePasCompleter;

	/**
	* Int contentant le numéro de la ligne de la case
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see Case#setJTextField(tailleMaxColumns)
	* @see CaseActionListener
	* @see TestValeur
	*/
	private int numLigne;

	/**
	* Int contentant le numéro de la colonne de la case
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see Case#setJTextField(tailleMaxColumns)
	* @see CaseActionListener
	* @see TestValeur
	*/
	private int numColonne;

	/**
	* Tableau des régions des cases.
	* @see Case#setJTextField(tailleMaxColumns)
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see CaseActionListener
	* @see TestValeur
	*/	
	private int[][] region;

	/**
	* Tableau des numéros des cases.
	* @see Case#setJTextField(tailleMaxColumns)
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see Case#JLabel()
	* @see CaseActionListener
	* @see TestValeur
	*/		
	private int[][] numeroDesCases;	

	/**
	* Booléen qui détermine le type de case demandé.
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see Case#setColor(c)
	*/
	private boolean genreDeCase;

	/**
	* Fenetre du jeu. Elle sera transmise à CaseActionListener pour affichier un objet de la classe victoire
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see CaseActionListener
	* @see Case#setJTextField(tailleMaxColumns)
	* @see JFrame
	* @see Fenetre
	*/
	private JFrame fenetre;

	/**
	* Constructeur de la classe case. Elle initialise tous les attributs nécessaires pour
	* la création d'un bojet de la classe case.
	* @see Case#setJTextField(tailleMaxColumns)
	* @see Case#setJLabel()
	* @param i
	* @see Case#numLigne
	* @param j
	* @see Case#numColonne
	* @param g
	* @see Case#genreDeCase
	* @param r
	* @see Case#region
	* @param num
	* @see Case#numeroDesCases
	* @param f
	* @see Case#fenetre
	* @param tailleMaxColumns
	* 	int qui détermine le nombre maximale de colonnes d'un JTextField si celui-ci est créé
	*/
	public Case(int tailleMaxColumns,int i, int j, boolean g, int[][] r, int[][] num, JFrame f) {
		this.setLayout(new GridBagLayout());
		this.numLigne = i;
		this.numColonne = j;
		this.genreDeCase = g;
		this.region = r;
		this.numeroDesCases = num;
		this.fenetre =f;
		if(this.genreDeCase == true) {
			this.setJTextField(tailleMaxColumns);
		} else {
			this.setJLabel();
		}
		
	}
	/**
	* Méthode qui va créé un JTextField qui sera ajouté à la case.
	* Ce JTextField permet au joueur de modifier le numéro de la case.
	* @param tailleMaxColumns
	* 	int qui détermine le nombre maximale de colonnes du JTextField.
	* @see JTextFieldLimite
	* 	Classe qui réalise un PlainDocument. Elle permet de limiter le nombre de colonne du JTextField.
	* @see Case#caseACompleter
	* @see JTextField
	* @see Case#numLigne
	* @see Case#numColonne
	* @see Case#region
	* @see Case#numeroDesCases
	* @see Case#fenetre
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	*/
	private void setJTextField(int tailleMaxColumns) {
		this.caseACompleter = new JTextField(); 
		this.caseACompleter.setDocument(new JTextFieldLimite(tailleMaxColumns));
		if(this.numeroDesCases[this.numLigne][this.numColonne]!=0) {
			this.caseACompleter.setText(String.valueOf(this.numeroDesCases[this.numLigne][this.numColonne]));
		}
		
		this.caseACompleter.setColumns(tailleMaxColumns);
		this.caseACompleter.setHorizontalAlignment(JTextField.CENTER);
		this.caseACompleter.addActionListener(new CaseActionListener(this.caseACompleter, this.numLigne, this.numColonne, this.region, this.numeroDesCases, this.fenetre));
		this.add(this.caseACompleter);
	}
	/**
	* Méthode qui va initialiser un JLabel qui sera ajouté à l'objet case.
	* @see JLabel
	* @see Case#Case(tailleMaxColumns, i, j,  g, r, num, f)
	* @see Case#caseANePasCompleter
	* @see Case#numLigne
	* @see Case#numColonne
	* @see Case#numeroDesCases
	*/
	private void setJLabel() {
		this.caseANePasCompleter = new JLabel(String.valueOf(this.numeroDesCases[this.numLigne][this.numColonne]));
		this.add(this.caseANePasCompleter);
	}
	/**
	* Méthode qui modifie la couleur de l'arrière plan du JLabel.
	* @param c
	*	Couleur utiliser pour l'arrière plan du JLabel
	* @see Color
	* @see Case#genreDeCase
	* @see Case#caseANePasCompleter 
	* @see Grille#initialiserCases()
	*/
	public void setColor(Color c) {
		if(this.genreDeCase == false) {
			this.caseANePasCompleter.setOpaque(true);
			this.caseANePasCompleter.setBackground(c);
		}
	}

}