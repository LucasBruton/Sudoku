import javax.swing.text.*;
import java.awt.*;

/**
* Classe qui réalise un objet de la classe PlainDocument.
* <p>
* Le seul but de la classe est de limiter le nombre de colonne 
* des JTextField.
* </p>
* @see PlainDocument
* @see JTextField
* @see Case
* @author Lucas Bruton
* @version 1.0
* @since 2020-03-19
*/

public class JTextFieldLimite extends PlainDocument {

	/**
	* Int qui détermine le nombre maximale de colonne des JTextFields
	* qui utilise cette classe.
	* @see JTextFieldLimite#JTextFieldLimite(m)
	* @see JTextFieldLimite#insertString(offs, str, a)
	*/
	private int max;

	/**
	* Constructeur de la classe JTextFieldLimite.
	* @param m
	* @see  JTextFieldLimite#max
	*/
	public JTextFieldLimite(int m) {
		this.max = m;
	}

	/**
	* Méthode qui permet de limiter le nombre de colonnes des JTextFields.
	* @param offs
	* @param str
	* @param a
	*/
	@Override
	public void insertString(int offs, String str, AttributeSet a)
	throws BadLocationException {
		if(this.getLength()+str.length()>this.max) {
			str=str.substring(0,max - this.getLength());
		}
		super.insertString(offs,str,a);
	}
}