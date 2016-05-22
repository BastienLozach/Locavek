package fr.adavis.locavek;

import fr.adavis.locavek.vues.VueLocavek;

/** Classe principale de l'application
 * 
 * @author xilim
 *
 */
public class AppLocavek {

	/** Lanceur
	 * @param args Arguments de la ligne de commande
	 */
	public static void main(String[] args) {

		System.out.println("AppLocavek::main()") ;
		new VueLocavek() ;
	}

}
