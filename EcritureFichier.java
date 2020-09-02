import java.io.*;

/**
* Classe qui permet de sauvegarder la grille créer par le joueur 
* dans le mode Creation/modification de grille.
* @see ConstructionDeGrille
* @see CreationGrille
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/

public class EcritureFichier {
	/**
	* Constructeur de la classe EcritureFichier qui va essayer de sauvegarder la
	* grille dans un fichier "grilles/Grille.gri".
	* @param tableau
	*  	Grille qui sera sauvegardé dans le fichier.
	* @see EcritureFichier#sauvegarderGrille(tableau)
	* @see IOException
	*/
	public EcritureFichier(int[][] tableau) {
		try {
			this.sauvegarderGrille(tableau);
		} catch(IOException e) {
			System.out.println("Problème de sauvegarde de fichier !");
		}
	}

	/**
	* Méthode qui va sauvegarder la grille dans un fichier.
	* @see EcritureFichier#setValeurs(tableau)
	* 	Méthode qui permet de transformer un tableau des 
	* 	numéro des cases d'une grille en un tableau de 9 int.
	* @param tableau
	*  	Grille qui sera sauvegardé dans le fichier.
	* @see File
	* @see FileOutputStream
	* @see DataOutputStream
	* @throws IOException
	*/
	public void sauvegarderGrille(int[][] tableau) throws IOException {
		int[] valeurs = this.setValeurs(tableau);
		File f = new File("grilles/Grille.gri");
		if(!f.exists()) {
			f.createNewFile();
		}
		FileOutputStream file = new FileOutputStream(f);
		DataOutputStream data = new DataOutputStream(file);
		for(int i = 0;i<9;i++) {
			data.writeInt(valeurs[i]);
		}
	}
	/** 	
	* Méthode qui permet de transformer un tableau des 
	* numéro des cases d'une grilleen un tableau de 9 int.
	* @param tableau
	*  	Grille qui sera sauvegardé dans le fichier.
	* @return int[]
	* 	Tableau de 9 int créer à partir des numéro des cases.
	*/
	private static int[] setValeurs(int[][] tableau) {
		int[] valeurs = new int[9];
		int i, j;

		for(i=0;i<9;i++) {
			valeurs[i] = tableau[i][0];
			for(j = 1;j<9;j++) {
				valeurs[i] *= 10;
				valeurs[i] += tableau[i][j];
			}
		}
		return valeurs;
	}
}