JFLAGS = -g
JC = javac 

.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
			Automatique.java  \
			Fenetre.java  \
			Start.java \
			CaseActionListener.java \
			Grille.java   \
			TestValeur.java \
			Case.java \
			JTextFieldLimite.java \
			Victoire.java \
			DebutDePartie.java \
			BoutonActionListener.java \
			CreationGrille.java \
			ConstructionDeGrille.java \
			LectureFichier.java \
			EcritureFichier.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
run:
	java Start
