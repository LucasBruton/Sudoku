import javax.swing.*;
import java.awt.*;
import java.lang.Math;
/**
* Classe qui test un int pour voir si les chiffres qui composent
* ce int sont légaux légal dans la position de la case.
* @see Case
* @see CaseActionListener
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class TestValeur {

	/**
	* CaseACompleter est le JTextField qui fourni le int à cette classe
	* CaseACompleter pourra voir son texte modifier par cette clase.
	* @see Case
	* @see CaseActionListener
	* @see JTextField
	* @see TestValeur#testNumeroDeLaCase(x)
	* @see TestValeur#TestValeur(c, i, j,  g, r, num, f)
	* @see TestValeur#testNombre(int x)
	*/
	private JTextField caseACompleter;

	/**
	* Int contentant le numéro de la ligne de la case
	* @see TestValeur#testNumeroDeLaCase(x)
	* @see TestValeur#TestValeur(c, i, j,  g, r, num, f)
	* @see TestValeur#TestValeur(i, j,  g, r, num, f)
	* @see TestValeur#testLigneNumeroDeLaCase(x)
	* @see TestValeur#testColonneNumeroDeLaCase(x)
	* @see TestValeur#testRegionNumeroDeLaCase(x)
	*/	
	private int numLigne;


	/**
	* Int contentant le numéro de la colonne de la case
	* @see TestValeur#testNumeroDeLaCase(x)
	* @see TestValeur#TestValeur(c, i, j,  g, r, num, f)
	* @see TestValeur#TestValeur(i, j,  g, r, num, f)
	* @see TestValeur#testLigneNumeroDeLaCase(x)
	* @see TestValeur#testColonneNumeroDeLaCase(x)
	* @see TestValeur#testRegionNumeroDeLaCase(x)
	*/
	private int numColonne;

	/**
	* Tableau des régions des cases.
	* @see TestValeur#testNumeroDeLaCase(x)
	* @see TestValeur#TestValeur(c, i, j,  g, r, num, f)
	* @see TestValeur#TestValeur(i, j,  g, r, num, f)
	* @see TestValeur#testRegionNumeroDeLaCase(x)
	*/
	private int[][] region;

	/**
	* Tableau des numéros des cases.
	* @see TestValeur#testNumeroDeLaCase(x)
	* @see TestValeur#TestValeur(c, i, j,  g, r, num, f)
	* @see TestValeur#TestValeur(i, j,  g, r, num, f)
	* @see TestValeur#testLigneNumeroDeLaCase(x)
	* @see TestValeur#testColonneNumeroDeLaCase(x)
	* @see TestValeur#testRegionNumeroDeLaCase(x)
	*/
	private int[][] numeroDesCases;

	/**
	* Constructeur de la classe TestValeur.
	* @param c
	* @see TestValeur#caseACompleter
	* @param i
	* @see TestValeur#numLigne
	* @param j
	* @see TestValeur#numColonne
	* @param r
	* @see TestValeur#region
	* @param num
	* @see TestValeur#numeroDesCases
	*/
	public 	TestValeur(JTextField c, int i, int j, int[][] r, int[][] num) {
		this.caseACompleter = c;
		this.numLigne = i;
		this.numColonne = j;
		this.region = r;
		this.numeroDesCases = num;
	}

	/**
	* Constructeur de la classe TestValeur qui n'utilise pas caseACompleter.
	* @param i
	* @see TestValeur#numLigne
	* @param j
	* @see TestValeur#numColonne
	* @param r
	* @see TestValeur#region
	* @param num
	* @see TestValeur#numeroDesCases
	*/
	public 	TestValeur(int i, int j, int[][] r, int[][] num) {
		this.numLigne = i;
		this.numColonne = j;
		this.region = r;
		this.numeroDesCases = num;
	}
	/**
	* Cette méthode test son paramètre x pour savoir si tous les chiffres qui le composent 
	* sont légaux dans la position de la case. Si x est inférieur à 1, le string JTextField
	* est remplacé par une chaîne vide. 
	* @param x
	* 	int à tester
	* @see TestValeur#testAUnChiffre(x)
	* 	Utiliser pour tester x s'il est compris entre 1 et 9
	* @see TestValeur#testAUnChiffre(x)
	* 	Utiliser pour tester x s'il est strictement supérieur à 9.
	* @see TestValeur#caseACompleter
	* @see TestValeur#numLigne
	* @see TestValeur#numColonne
	* @see TestValeur#numDesCases
	*/
	public void testNumeroDeLaCase(int x) {
		boolean test;
		if((x >= 1) && (x <= 9 )) {
			test = this.testAUnChiffre(x);
			if(test == true) {
				this.caseACompleter.setText("");
			} else {
			this.numeroDesCases[this.numLigne][this.numColonne] = x;
			}
		}else if(x>9) {
			this.testNombre(x);
		}else if(x<1) {
			this.caseACompleter.setText("");
		}
	}
	/**
	* Méthode qui permet de tester un x > 9.
	* testNombre va tester chaque chiffre qui appartient au nombre en utilisant 
	* la méthode testAUnChiifre(x). Après avoir tester chaque chiffre, testNombre va 
	* modifier le string de caseACompleter par tous les chiffres qui sont légaux dans la
	* position de la case.
	* @param x
	* 	int à tester.
	* @see TestValeur#testAUnChiffre(x)
	* @see TestValeur#CaseAcompleter
	*/
	private void testNombre(int x) {
		boolean test;
		double y;
		String nombre = "";
		if(x > 999) {
			y = Math.floor((double)x/1000);
			x -= (int)y * 1000;
			test = testAUnChiffre((int)y);
			if(test == false) {
				nombre = nombre + (int)y;
			}
		}
		if((x <= 999) && (x > 99)) {
			y = Math.floor((double)x/100);
			x -= (int)y * 100;
			test = testAUnChiffre((int)y);
			if(test == false) {
				nombre = nombre + (int)y;
			}
		}
		if((x <= 99) && (x > 9)) {
			y = Math.floor((double)x/10);
			x -= (int)y * 10;
			test = testAUnChiffre((int)y);
			if(test == false) {
				nombre = nombre + (int)y;
			}
		}
		if((x<=9) && (x > 0)) {
			y = Math.floor((double)x);
			x -= (int)y;
			test = testAUnChiffre((int)y);
			if(test == false) {
				nombre = nombre + (int)y;
			}
		}
		this.caseACompleter.setText(nombre);

	}
	/**
	* Cette méthode va regarder si le chiffre fourni est
	* légal en fonction de la position de la case.
	* @return boolean
	* @param x
	* 	chiffre à tester.
	* @see TestValeur#testLigneNumeroDeLaCase(x)
	* 	Test si le chiffre est possible sur la ligne de la case.
	* @see TestValeur#testColonneNumeroDeLaCase(x)
	* 	Test si le chiffre est possible sur la colonne de la case.
	* @see TestValeur#testLigneNumeroDeLaCase(x)
	* 	Test si le chiffre est possible dans la région de la case.
	*/
	public boolean testAUnChiffre(int x) {
		boolean test;
		test = this.testLigneNumeroDeLaCase(x);
		if(test == false ) {
			test = this.testColonneNumeroDeLaCase(x);
		} 
		if(test == false) {
			test = this.testRegionNumeroDeLaCase(x);
		}

		return test;	
	}
	/**
	* Test si le chiffre est possible sur la ligne de la case.
	* @return boolean
	* @param x
	* 	chiffre à tester.
	* @see TestValeur#numLigne
	* @see TestValeur#numColonne
	* @see TestValeur#numDesCases
	*/
	private boolean testLigneNumeroDeLaCase(int x) {
		boolean test = false;
		for(int j = 0;j<9;j++) {
			if((j!=this.numColonne) && (this.numeroDesCases[this.numLigne][j] == x)) {
				test = true;
			}
		}

		return test;
	}

	/**
	* Test si le chiffre est possible sur la colonne de la case.
	* @return boolean
	* @param x
	* 	chiffre à tester.
	* @see TestValeur#numLigne
	* @see TestValeur#numColonne
	* @see TestValeur#numDesCases
	*/
	private boolean testColonneNumeroDeLaCase(int x) {
		boolean test = false;
		for(int i = 0;i<9;i++) {
			if((i!=this.numLigne) && (this.numeroDesCases[i][this.numColonne] == x)) {
				test = true;
			}
		}

		return test;
	}

	/**
	* Test si le chiffre est possible sur la ligne de la case.
	* @return boolean
	* @param x
	* 	chiffre à tester.
	* @see TestValeur#numLigne
	* @see TestValeur#numColonne
	* @see TestValeur#numDesCases
	* @see TestValeur#region
	*/
	private boolean testRegionNumeroDeLaCase(int x) {
		boolean test = false;
		for(int i = 0;i<9;i++) {
			for(int j = 0;j<9;j++) {	
				if((i!=this.numLigne) && (j!=this.numColonne) && (this.region[this.numLigne][this.numColonne] == this.region[i][j]) && (this.numeroDesCases[i][j]==x)) {
					test = true;
				}	
			}
		}
		return test;
	}
}