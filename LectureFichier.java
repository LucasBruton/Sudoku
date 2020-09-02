import java.io.*;
import javax.swing.*;
import java.awt.*;
/**
* Classe qui permet de créer une grille de Sudoku 
* à partir d'un fichier .gri
* @see CreationGrille
* @author Lucas Bruton
* @author Gabriel Chavanon
* @version 1.0
* @since 2020-03-19
*/
public class LectureFichier {
    /**
    * Tableau de numéro des cases qui sera créer à partir d'un fichier .gri
    * @see LectureFichier#readFile(tab)
    * @see LectureFichier#getTableau()
    * @see LectureFichier#afficherTableau()
    */
	private int[][] tableau;

    /**
    * Constructeur de la classe LectureFichier qui va essayé de lire un fichier.
    * @param tab
    *   Valeurs de la grille qui précède la lecture d'un fichier.
    * @see LectureFichier#readFile(tab)
    * @see IOException
    */
	public LectureFichier(int[][] tab) {
		try {
			this.readFile(tab);
		} catch(IOException e) {
			System.out.println("Problème de sauvegarde de fichier !");
		}

    }

    /**
    * Méthode qui va tenter de lire un fichier pour le transformer en grille.
    * @see LectureFichier#remplirTableau
    *   Méthode qui permet remplir la grille en fonction des int lu par readFile.
    * @param tab
    *   Valeurs de la grille qui précède la lecture d'un fichier.
    * @see FileInputStream
    * @see File
    * @see JFileChooser
    * @see DataInputStream
    * @throws IOException
    */
    private void readFile(int[][] tab) throws IOException{
		JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("grilles"));
        fc.setDialogTitle("Choix de Grille");
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            //
        }
        File f = fc.getSelectedFile();
        if(f != null) {
	        FileInputStream file = new FileInputStream(f);
			DataInputStream data = new DataInputStream(file);
	        int[] valeurs = new int[9];
	        int j=2;
	        for(int i=0;i<9;i++) {
	        	valeurs[i] = data.readInt();
	        }
	        this.tableau = remplirTableau(valeurs);
            this.afficherTableau();
    	} else {
    		this.tableau = tab;
    	}
        
    }

    /**
    * Méthode qui permet de visualiser la grille sélectionner par le joueur.
    */
    private void afficherTableau() {
        int i, j;
        for(i=0;i<9;i++) {
            for(j= 0;j<9;j++) {
                System.out.print(this.tableau[i][j] + " ");
            }
            System.out.println("");
        }  
        System.out.println("");     
    }

    /**
    * Méthode qui permet remplir une grille en fonction des int lu par readFile.
    * @param valeurs
    *   Tableau des int lus par readFile
    * @return int[][]
    *   Grille créer par remplirTableau
    */
    private static int[][] remplirTableau(int[] valeurs) {
    	int[][] tab = new int[9][9];
    	int i,j, k, z, longueur;
    	double y;
    	String nombre;
    	char[] charValeurs;
    	for(i = 0;i<9;i++) {
    		nombre = String.valueOf(valeurs[i]);
    		longueur = nombre.length();
    		charValeurs = new char[longueur];
    		for(j = 0;j<longueur;j++) {
    			charValeurs[j] = nombre.charAt(j);
    		}
    		k =  9 - nombre.length();
    		for(j = 0; j<k;j++) {
    			tab[i][j] = 0;
    		}
    		for(j = k;j<9;j++) {
				tab[i][j] = Integer.parseInt(""+charValeurs[j - k]);		
    		}
		}
    	return tab;
    }
    /**
    * Méthode qui permet de récupérer this.tableau
    * @return int[][]
    *   Tableau modifié par LectureFichier
    */
    public int[][] getTableau() {
    	return this.tableau;
    }
}