package fr.adavis.locavek.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import fr.adavis.locavek.EditeurBoutonLocationEnregistrer;
import fr.adavis.locavek.RenduBoutonLocation;
import fr.adavis.locavek.RenduCelluleLocation;
import fr.adavis.locavek.modeles.ModeleListeLocations;

public class VueListeLocations extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ModeleListeLocations modeleTabLocations = new ModeleListeLocations()  ;
	private JTable tabLocations ;
	
	/** Constructeur
	 * 
	 */
	public VueListeLocations(){
		super() ;
		System.out.println("VueListeLocations::VueListeLocations()") ;
		this.creerInterfaceUtilisateur() ;
	}
	
	/** Agencer les composants graphiques
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeLocations::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		// Votre code ici
		this.tabLocations = new JTable(this.modeleTabLocations) ;
		this.tabLocations.setRowHeight(30) ;
		
		this.appliquerRendu() ;
		this.appliquerEditeur() ;
		
		JScrollPane spLocations = new JScrollPane(this.tabLocations) ;
		
		spLocations.setPreferredSize(new Dimension(1090, 420)) ;
		
		boxTableau.add(spLocations) ;
		
		
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;
		
		this.add(boxPrincipale) ;
		
	}
	
	public JTable getTabLocations() {
		return tabLocations;
	}

	public ModeleListeLocations getModeleTabLocations() {
		return modeleTabLocations;
	}

	
	private void appliquerRendu() {
		RenduCelluleLocation renduCellule = new RenduCelluleLocation() ;
		
		for(int i = 0; i <= 4; i+=1){
			this.tabLocations.getColumnModel().getColumn(i).setCellRenderer(renduCellule);
		}
		
		RenduBoutonLocation renduBouton = new RenduBoutonLocation();
		this.tabLocations.getColumnModel().getColumn(5).setCellRenderer(renduBouton);
	}
	
	private void appliquerEditeur() {
		EditeurBoutonLocationEnregistrer editeur = new EditeurBoutonLocationEnregistrer(new JCheckBox()) ;
		this.tabLocations.getColumnModel().getColumn(5).setCellEditor(editeur);
	}
}
