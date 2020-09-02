import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
/**
* Classe qui hérite de JPanel.
* <p>
* Cette classe permet d'afficher le mode "résolution automatique" du sudoku.
* </p>
* @see CreationGrille
* @see JPanel
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/
public class Automatique extends JPanel {
	/**
	* Objet le classe grille qui affichera le sudoku résolut.
	* @see Automatique#Automatique(g,f)
	* @see Automatique#modeAutomatique()
	* @see Grille
	*/
	private Grille grille;

	/**
	* Tableau des numéros des cases.
	* @see Automatique#Automatique(g,f)
	* @see Automatique#setCasesACompleter()
	* @see Automatique#modeAutomatique()
	* @see Automatique#resoudreSudoku(casesACompleter, tab, region)
	*/	
	private int[][] numeroDesCases;

	/**
	* Tableau de booléens qui déterminent les cases que l'algorithme doit compléter.
	* @see Automatique#modeAutomatique()
	* @see Automatique#Automatique(g,f)
	* @see Automatique#resoudreSudoku(casesACompleter, tab, region)
	*/
	private boolean[][] casesACompleter;

	/**
	* Tableau des régions des cases.
	* @see Automatique#Automatique(g,f)
	* @see Automatique#modeAutomatique()
	* @see Automatique#resoudreSudoku(casesACompleter, tab, region)
	*/
	private int[][] region;

	/**
	* JFrame qui affichera l'objet Automatique
	* @see Automatique#Automatique(g,f)
	* @see Automatique#modeAutomatique()
	*/
	private JFrame fenetre;

	/**
	* String qui affichera le temps de résolution de Sudoku.
	* @see Automatique#modeAutomatique()
	* @see Automatique#resoudreSudoku(casesACompleter, tab, region)
	*/
	private String chonoString;

	/**
	* Constructeur de la classe Automatique
	* @param g
	* @see Automatique#grille
	* @param f
	* @see Automatique#fenetre
	* @see Automatique#region
	* @see Automatique#setRegion()
	* @see Automatique#nymeroDesCases
	* @see Grille#getNumeroDesCases()
	* @see Automatique#casesACompleter
	* @see Automatique#setCasesACompleter
	*/
	public Automatique(Grille g, JFrame f) {
		this.grille = g;
		this.fenetre = f;
		this.region = this.setRegion();
		this.numeroDesCases = this.grille.getNumeroDesCases();
		this.casesACompleter = this.setCasesACompleter();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
	}

	/**
	* Méthode qui permet de rajouté à la fenetre la grille résolu.
	* @see Grille
	* @see Automatique#resoudreSudoku(casesACompleter,numeroDesCases,region)
	* @see Automatique#numeroDesCases
	* @see Automatique#grille
	* @see Automatique#chonoString
	* @see Automatique#fenetre
	*/
	public void modeAutomatique() {
		this.numeroDesCases = this.resoudreSudoku(casesACompleter,numeroDesCases,region);
		this.grille.setNumeroDesCases(this.numeroDesCases);
		this.grille.setTypeDeCase(2);
		this.add(this.grille, BorderLayout.CENTER);
		JLabel chronometre = new JLabel(chonoString);
		chronometre.setHorizontalAlignment(JLabel.CENTER);
		chronometre.setForeground(Color.WHITE);
		this.add(chronometre, BorderLayout.SOUTH);
		this.fenetre.setContentPane(this);
		this.fenetre.repaint();
		this.fenetre.revalidate();
	}
	/**
	* Méthode qui permet d'initialiser casesACompleter.
	* @return boolean[][]
	* @see Automatique#numerodesCases
	*/
	public boolean[][] setCasesACompleter() {
		boolean[][] casesACompleter = new boolean[9][9];
		for(int i=0;i<9;i++) {
			for(int j= 0;j<9;j++) {
				if(this.numeroDesCases[i][j] == 0) {
					casesACompleter[i][j] = true;
				}
			}
		}
		return casesACompleter;
	}
	/**
	* Méthode qui permet d'initialiser region.
	* @return int[][]
	*/
	public static int[][] setRegion() {
		int i,j;
		int[][] region = new int[9][9];
		for(i = 0;i<3;i++) {
			for(j = 0;j<3;j++) {
				region[i][j] = 1;
			}
		}
		for(i = 0;i<3;i++) {
			for(j = 3;j<6;j++) {
				region[i][j] = 2;

			}
		}
		for(i = 0;i<3;i++) {
			for(j = 6;j<9;j++) {
				region[i][j] = 3;

			}
		}
		for(i = 3;i<6;i++) {
			for(j = 0;j<3;j++) {
				region[i][j] = 4;

			}
		}
		for(i = 3;i<6;i++) {
			for(j = 3;j<6;j++) {
				region[i][j] = 5;
			}
		}
		for(i = 3;i<6;i++) {
			for(j = 6;j<9;j++) {
				region[i][j] = 6;

			}
		}
		for(i = 6;i<9;i++) {
			for(j = 0;j<3;j++) {
				region[i][j] = 7;

			}
		}
		for(i = 6;i<9;i++) {
			for(j = 3;j<6;j++) {
				region[i][j] = 8;
			}
		}
		for(i = 6;i<9;i++) {
			for(j = 6;j<9;j++) {
				region[i][j] = 9;
			}
		}
		return region;
	}
	/**
	* Méthode qui va résoudre le sudoku en utilisant une technique nommé le
	* Backtracking.
	* <p>
	* L'algorithme va essayé de remplir chaque case vide avec une valeur qui est possible.
	* Dès que l'algorithme rencontre une impasse, elle va revenir à une case précédente pour tenter 
	* sa valeur avec une autre valeur légale. 
	* Si l'algorithme détecte qu'aucune valeur que la première case à completer peut prendre est possible,
	* alors celui-ci indique que le sudoku est impossible à résoudre.
	* </p>
	* @param Automatique#caseACompleter
	* @param Automatique#region
	* @param Automatique#numeroDesCases
	* @return int[][]
	* 	tableau qui contient le sudoku résolu.
	* @see TestValeur
	* @see Automatique#chonoString
	*/
	public int[][] resoudreSudoku(boolean[][] casesACompleter, int[][] tab, int[][] region) {
		TestValeur v;
		long debut;
		double chrono;
		boolean test = false;
		boolean casePrecedente = false;
		boolean stop = false;
		boolean erreur =false;
		int number, i, j;
		i = 0;
		debut = System.nanoTime();
		while((i<9) && (stop == false)) {
			if(casePrecedente==true) {
				j=8;
			} else {
				j=0;
			}
			while((j<9) && (j>=0)) {
				
				if(casesACompleter[i][j] == true) {
					casePrecedente = false;
					if(tab[i][j] == 0) {
						number = 1;
					} else {
						number = tab[i][j] + 1;
					}
					for(test =true ;(number<10) && (test != false) ; number ++ ) {
						v = new TestValeur( i, j, region, tab);
						test = v.testAUnChiffre(number);
						if(test==false) {
							break;
						}
					}
					if(test == false ) {
						tab[i][j] = number;
					} else {
						casePrecedente = true;
						tab[i][j] = 0;
					}
				}
				if(casePrecedente == true) {
					j-=1;
					if(j<0) {
						break;
					}
				} else {
					j+=1;
				}
			}

			if(casePrecedente == true) {
				i -=1;
			} else  {
				i+=1;
			}
			if(i<0) {
				erreur = true;
				break ;
			}
		}
		if(erreur == true) {
			this.chonoString = "Ce sudoku n'a pas de solution !";
		} else {
			DecimalFormat numberFormat = new DecimalFormat("#.0000");
			chrono = (double)(System.nanoTime() - debut);
			chrono /= 1000000000;
			if(chrono < 1.0 ) {
				this.chonoString = "Résolu en 0" + numberFormat.format(chrono) + "s";
			} else {
				this.chonoString = "Résolu en " + numberFormat.format(chrono) + "s";
			}
		}
			

		return tab;
	}
}