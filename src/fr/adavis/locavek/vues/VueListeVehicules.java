package fr.adavis.locavek.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.adavis.locavek.RenduCelluleVehicule;
import fr.adavis.locavek.modeles.ModeleListeVehicules;

public class VueListeVehicules extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ModeleListeVehicules modeleTabVehicules = new ModeleListeVehicules()  ;
	private JTable tabVehicules ;
	
	/** Constructeur
	 * 
	 */
	public VueListeVehicules(){
		super() ;
		System.out.println("VueListeVehicules::VueListeVehicules()") ;
		this.creerInterfaceUtilisateur() ;
	}
	
	/** Agencer les composants graphiques
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeVehicules::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		// Votre code ici
		this.tabVehicules = new JTable(this.modeleTabVehicules) ;
		this.tabVehicules.setRowHeight(30) ;
		this.tabVehicules.setDefaultRenderer(Object.class, new RenduCelluleVehicule());
		
		JScrollPane spVehicules = new JScrollPane(this.tabVehicules) ;
		
		spVehicules.setPreferredSize(new Dimension(1090, 420)) ;
		
		boxTableau.add(spVehicules) ;
		
		
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;
		
		this.add(boxPrincipale) ;
		
	}
	
	public JTable getTabVehicules() {
		return tabVehicules;
	}

	public ModeleListeVehicules getModeleTabVehicules() {
		return modeleTabVehicules;
	}
	
}
