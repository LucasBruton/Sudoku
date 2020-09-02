import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
* Classe qui réalise un objet de class ActionListenr
* <p>
* Cette class va tester le string fourni à la case qui est associé à cette classe.
* Pour tester le string, cette classe utilise un bojet de la classe TestValeur.
* </p>
* @see Case
* @see ActionListener
* @see TestValeur
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class CaseActionListener implements ActionListener {
	/**
	* CaseACompleter est le JTextField qui utilise cette classe.
	* CaseACompleter pourra voir son texte modifier par cette clase.
	* @see Case
	* @see CaseActionListener#CaseActionListener(c, i, j,  g, r, num, f)
	* @see TestValeur
	* @see JTextField
	*/
	private JTextField caseACompleter;

	/**
	* Int contentant le numéro de la ligne de la case
	* @see Case
	* @see CaseActionListener#CaseActionListener(c, i, j,  g, r, num, f)
	* @see TestValeur
	* @see CaseActionListener#actionPerformed(e)
	*/
	private int numLigne;

	/**
	* Int contentant le numéro de la colonne de la case
	* @see Case
	* @see CaseActionListener#CaseActionListener(c, i, j,  g, r, num, f)
	* @see CaseActionListener#actionPerformed(e)
	* @see TestValeur
	*/
	private int numColonne;

	/**
	* Tableau des régions des cases.
	* @see Case
	* @see CaseActionListener#CaseActionListener(c, i, j,  g, r, num, f)
	* @see CaseActionListener#actionPerformed(e)
	* @see TestValeur
	*/
	private int[][] region;

	/**
	* Tableau des numéros des cases.	
	* @see Case
	* @see CaseActionListener#CaseActionListener(c, i, j,  g, r, num, f)
	* @see CaseActionListener#actionPerformed(e)
	* @see TestValeur
	*/
	private int[][] numeroDesCases;

	/**
	*Fenetre du jeu. Elle sera utiliser pour affichier un objet de la classe victoire
	* @see Case
	* @see CaseActionListener#CaseActionListener(c, i, j,  g, r, num, f)
	* @see CaseActionListener#actionPerformed(e)
	* @see Victoire
	*/	
	private JFrame fenetre;

	/**
	* Constructeur de la classe CaseActionListener.
	* @param c
	* @see CaseActionListener#caseACompleter
	* @param i
	* @see CaseActionListener#numLigne
	* @param j
	* @see CaseActionListener#genreDeCase
	* @param r
	* @see CaseActionListener#region
	* @param num
	* @see CaseActionListener#numeroDesCases
	* @param f
	* @see CaseActionListener#fenetre
	*/
	public CaseActionListener(JTextField c, int i, int j, int[][] r, int[][] num, JFrame f) {
		this.caseACompleter = c;
		this.numLigne = i;
		this.numColonne = j;
		this.region = r;
		this.numeroDesCases = num;
		this.fenetre = f;
	}


	/**
	* Cette méthode est appelé lorsque la case récupère du text.
	* actionPerformed va essayé de convertir le string fourni en int pour pouvoir
	* tester la valeur.
	* <p>
	* Si on ne peut pas convertir le string fourni, on le remplace par une chaîne vide.
	* Sinon la valeur est fourni à un objet de la classe TestValeur pour tester si les chiffres fournis sont possible à cet emplacement.
	* </p>
	* @see CaseActionListener#caseACompleter
	* @see Case#numLigne
	* @see CaseActionListener#numColonne
	* @see CaseActionListener#genreDeCase
	* @see CaseActionListener#region
	* @see CaseActionListener#numeroDesCases
	* @see CaseActionListener#fenetre
	* @see TestValeur
	* @see Victoire
	* @param e
	*		Objet de la classe ActionEvent
	* @see ActionEvent
	*/
	@Override 
	public void actionPerformed(ActionEvent e) {
		TestValeur v;
		try {
			int x = Integer.parseInt(this.caseACompleter.getText());
			v = new TestValeur(this.caseACompleter, this.numLigne, this.numColonne, this.region, this.numeroDesCases);
			v.testNumeroDeLaCase(x);
		}catch(NumberFormatException exception) {
			this.caseACompleter.setText("");
			this.numeroDesCases[this.numLigne][this.numColonne] = 0;
		}
		int i,j;
		boolean test =true;
		for(i = 0;i<9;i++) {
			for(j = 0;j<9;j++) {
				if(this.numeroDesCases[i][j] == 0) {
					test = false;
				}
			}
		}
		if(test==true) {
			this.fenetre.setContentPane(new Victoire());
			this.fenetre.repaint();
			this.fenetre.revalidate();
		}
		
	}

}
