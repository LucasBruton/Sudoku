import javax.swing.*;
import java.awt.*;
/**
* Classe qui hérite de JPanel.
* <p>
* Grille affiche le sudoku en fonction du mode sélectionner 
* par le joueur. Cette classe sera ajoué à la fenêtre lorsqu'il sera solliciter.
* </p>
* @see CreationGrille
* @see Automatique
* @see ConstructionDeGrille
* @see JPanel
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/

public class Grille extends JPanel {
	/**
	* Tableau de JPanel qui contiendra des objets de la classe Case
	* @see Grille#Grille(f)
	* @see Grille#initialiserCases()
	*/
	private JPanel[][] panneau;

	/**
	* Tableau des régions des cases.
	* @see Grille#Grille(f)
	* @see Grille#initialiserCases()
	* @see Grille#typedeCase1()
	* @see Grille#typedeCase2()
	* @see Grille#typedeCase3()
	* @see Case
	* @see CaseActionListener
	* @see TestValeur
	*/
	private int[][] region;

	/**
	* Tableau des numéros des cases.
	* @see Grille#Grille(f)
	* @see Grille#setNumeroDesCases(tab)
	* @see Grille#getNumeroDesCases(tab)
	* @see Grille#typedeCase1()
	* @see Grille#typedeCase2()
	* @see Grille#typedeCase3()
	* @see Case
	* @see CaseActionListener
	* @see TestValeur
	*/	
	private int[][] numeroDesCases;

	/**
	* Tableau d'objets de la classe Case.
	* @see Grille#Grille(f)
	* @see Grille#typedeCase1()
	* @see Grille#typedeCase2()
	* @see Grille#typedeCase3()
	* @see Case
	* @see CaseActionListener
	* @see TestValeur
	*/		
	private Case[][] typeCase;

	/**
	* Attribut qui contient le mode de jeu choisit.
	* @see Grille#Grille(f)
	* @see Grille#typedeCase()
	*/
	private int modeCase;
	private JFrame fenetre;

	/**
	* Constructeur de la classe Grille qui initialise  
	* les attributs panneau, region et typecase.
	* @see Grille#panneau
	* @see Grille#region
	* @see Grille#typeCase
	* @see Case
	* @see CreationGrille
	*/
	public Grille(JFrame f) {
		GridLayout gestion = new GridLayout(9,9);
		this.setLayout(gestion);
		this.panneau = new JPanel[9][9];
		this.region = new int[9][9];
		this.typeCase = new Case[9][9];
		this.fenetre = f;
	}

	/**
	* Cette méthode permet aux autres classes qui utilisent grille
	* d'initialiser les cases dans le mode sélectionner par le joueur/
	* @param n
	* @see Grille#modeCase
	* @see Grille#initaliserCases()
	*/
	public void setTypeDeCase(int n) {
		this.modeCase = n;
		this.initialiserCases();
	}
	/**
	* Cette classe fait appel à la méthode approprié pour initialiser les cases
	* au format solliciter.
	* @see Grille#typeDeCase1()
	* @see Grille#typeDeCase2()
	* @see Grille#typeDeCase3()
	* @see Grille#ModeCase
	* @see Grille#initaliserCases()
	*/
	private void typeDeCase() {
		if(this.modeCase ==1) {
			this.typeDeCase1();
		} else if(this.modeCase == 2) {
			this.typeDeCase2();
		} else if(this.modeCase == 3) {
			this.typeDeCase3();
		}

	}

	/**
	* Cette méthode permet d'initialiser les cases au format 
	* manuel de résolution du sudoku.
	* @see Case
	* @see Grille#typeDeCase()
	* @see Grille#numerodesCases
	* @see Grille#typeCase
	*/
	private void typeDeCase1() {
		int i,j;
		for(i = 0;i<9;i++) {
			for(j = 0;j<9;j++) {
				if(this.numeroDesCases[i][j]==0) {
					this.typeCase[i][j] = new Case(4,i,j,true,this.region,this.numeroDesCases, this.fenetre);
				} else {
					this.typeCase[i][j] = new Case(4,i,j,false,this.region,this.numeroDesCases, this.fenetre);
				}
			}
		}
	}
	/**
	* Cette méthode permet d'initialiser les cases au format 
	* automatique de résolution du sudoku.
	* @see Case
	* @see Grille#typeCase
	* @see Grille#typeDeCase()
	*/
	private void typeDeCase2() {
		int i,j;
		for(i = 0;i<9;i++) {
			for(j = 0;j<9;j++) {
				this.typeCase[i][j] = new Case(1,i,j,false,this.region,this.numeroDesCases, this.fenetre);
			}
		}
		
	}

	/**
	* Cette méthode permet d'initialiser les cases au format 
	* construction de grille du sudoku.
	* @see Case
	* @see Grille#typeCase
	* @see Grille#typeDeCase()
	*/
	private void typeDeCase3() {
		int i,j;
		for(i = 0;i<9;i++) {
			for(j = 0;j<9;j++) {
					this.typeCase[i][j] = new Case(1,i,j,true,this.region,this.numeroDesCases, this.fenetre);
			}
		}
	}

	/**
	* Cette méthode initialise tous ce qui est en rapport avec les cases : 
	* la couleur de lase, la région de la case et le type de case.
	* @see Grille#typeDeCase
	* @see Grille#setTypeDeCase(n)
	* @see Grille#panneau
	* @see Grille#region
	* @see Case#setColor(c)
	*/

	private void initialiserCases() {
		this.typeDeCase();
		int i,j;
		for(i = 0;i<9;i++) {
			for(j = 0;j<9;j++) {
				this.panneau[i][j] = new JPanel(new GridBagLayout());
				this.panneau[i][j].add(typeCase[i][j]);
				this.add(this.panneau[i][j]);
			}

		}
		for(i = 0;i<3;i++) {
			for(j = 0;j<3;j++) {
				this.region[i][j] = 1;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(132,255,0));
					this.typeCase[i][j].setColor(new Color(132,255,0));
				} else {
					this.panneau[i][j].setBackground(new Color(255,165,0));
					this.typeCase[i][j].setColor(new Color(255,165,0));
				}
			}
		}
		for(i = 0;i<3;i++) {
			for(j = 3;j<6;j++) {
				this.region[i][j] = 2;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(0,255,255));
					this.typeCase[i][j].setColor(new Color(0,255,255));
				} else {
					this.panneau[i][j].setBackground(new Color(132,0,255));
					this.typeCase[i][j].setColor(new Color(132,0,255));
				}
			}
		}
		for(i = 0;i<3;i++) {
			for(j = 6;j<9;j++) {
				this.region[i][j] = 3;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(132,255,0));
					this.typeCase[i][j].setColor(new Color(132,255,0));
				} else {
					this.panneau[i][j].setBackground(new Color(255,165,0));
					this.typeCase[i][j].setColor(new Color(255,165,0));
				}
			}
		}
		for(i = 3;i<6;i++) {
			for(j = 0;j<3;j++) {
				this.region[i][j] = 4;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(0,255,255));
					this.typeCase[i][j].setColor(new Color(0,255,255));
				} else {
					this.panneau[i][j].setBackground(new Color(132,0,255));
					this.typeCase[i][j].setColor(new Color(132,0,255));
				}
			}
		}
		for(i = 3;i<6;i++) {
			for(j = 3;j<6;j++) {
				this.region[i][j] = 5;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(132,255,0));
					this.typeCase[i][j].setColor(new Color(132,255,0));
				} else {
					this.panneau[i][j].setBackground(new Color(255,165,0));
					this.typeCase[i][j].setColor(new Color(255,165,0));
				}
			}
		}
		for(i = 3;i<6;i++) {
			for(j = 6;j<9;j++) {
				this.region[i][j] = 6;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(0,255,255));
					this.typeCase[i][j].setColor(new Color(0,255,255));
				} else {
					this.panneau[i][j].setBackground(new Color(132,0,255));
					this.typeCase[i][j].setColor(new Color(132,0,255));
				}
			}
		}
		for(i = 6;i<9;i++) {
			for(j = 0;j<3;j++) {
				this.region[i][j] = 7;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(132,255,0));
					this.typeCase[i][j].setColor(new Color(132,255,0));
				} else {
					this.panneau[i][j].setBackground(new Color(255,165,0));
					this.typeCase[i][j].setColor(new Color(255,165,0));
				}
			}
		}
		for(i = 6;i<9;i++) {
			for(j = 3;j<6;j++) {
				this.region[i][j] = 8;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(0,255,255));
					this.typeCase[i][j].setColor(new Color(0,255,255));
				} else {
					this.panneau[i][j].setBackground(new Color(132,0,255));
					this.typeCase[i][j].setColor(new Color(132,0,255));
				}
			}
		}
		for(i = 6;i<9;i++) {
			for(j = 6;j<9;j++) {
				this.region[i][j] = 9;
				if((i+j)%2==0) {
					this.panneau[i][j].setBackground(new Color(132,255,0));
					this.typeCase[i][j].setColor(new Color(132,255,0));
				} else {
					this.panneau[i][j].setBackground(new Color(255,165,0));
					this.typeCase[i][j].setColor(new Color(255,165,0));
				}
			}
		}

	}

	/**
	* Cette méthode permet à d'autres classes de récupérer le tableau 
	* des numéro des cases.
	* @return numeroDesCases
	* 			Tabelau int[][]
	* @see Automatique#Automatique
	* @see Grille#numerodesCases
	*/
	public int[][] getNumeroDesCases() {
		return numeroDesCases;
	}
	/**
	* Cette méthode permet à d'autres classes de modifier le tableau 
	* des numéro des cases.
	* @param tab
	* 			tableau int[][]
	* @see CreationGrille
	* @see Grille#numerodesCases
	*/
	public void setNumeroDesCases(int[][] tab) {
		this.numeroDesCases = tab;
	}

}