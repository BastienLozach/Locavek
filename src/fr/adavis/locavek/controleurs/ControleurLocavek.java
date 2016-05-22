package fr.adavis.locavek.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.* ;

import javax.swing.JOptionPane;

import fr.adavis.locavek.technique.EtatTentativeConnexion;
import fr.adavis.locavek.technique.Session;
import fr.adavis.locavek.vues.VueAuthentification;
import fr.adavis.locavek.vues.VueLocavek;
import fr.adavis.locavek.vues.VueNouveauClient;
import fr.adavis.locavek.vues.VueNouvelleLocation;

/** Contrôleur associé à la vue principale de l'application
 * @author xilim
 *
 */
public class ControleurLocavek implements ActionListener {

	private VueLocavek vue ;
	
	/** Constructeur
	 * @param vue La vue principale de l'application
	 */
	public ControleurLocavek(VueLocavek vue) {
		super();
		System.out.println("ControleurLocavek::ControleurLocavek()") ;
		this.vue = vue ;
		this.enregistrerEcouteur();
	}
	
	public VueLocavek getVuePrincipale() {
		return this.vue ;
	}

	public void setVuePrincipales(VueLocavek vue) {
		this.vue = vue ;
	}
	
	/** Enregistrer le contrôleur comme écouteur des items de menu
	 * 
	 */
	private void enregistrerEcouteur(){
		System.out.println("ControleurLocavek::enregistrerEcouteur()") ;
		// Votre code ici
		
		this.vue.getItemQuitter().addActionListener(this) ;
		this.vue.getItemConnecter().addActionListener(this) ;
		this.vue.getItemDeconnecter().addActionListener(this) ;
		
		
		this.vue.getItemEnregistrerClient().addActionListener(this) ;
		this.vue.getItemEnregistrerLocation().addActionListener(this) ;
		
		this.vue.getItemVisualiserClients().addActionListener(this) ;
		this.vue.getItemVisualiserVehicules().addActionListener(this) ;
		this.vue.getItemVisualiserLocations().addActionListener(this) ;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurLocavek::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		
		// Votre code ici
		if(sourceEvt == this.vue.getItemQuitter()){
			
			int result = JOptionPane.showConfirmDialog(this.vue, "Voulez vous vraiment quitter ?", "Quitter ?", JOptionPane.OK_CANCEL_OPTION) ;
			
			if (result == 0) {
				this.vue.dispose();
			}
		}
		else if (sourceEvt == this.vue.getItemConnecter()){
			
			VueAuthentification vueAuthentification = new VueAuthentification(this.vue) ;
			EtatTentativeConnexion etat = vueAuthentification.getEtatTentativeConnexion() ;
			
			if (etat == EtatTentativeConnexion.OK){
				this.vue.setMenusConnecte();
				this.vue.changerVue(VueLocavek.ACCUEIL);
			}
						
		}
		else if (sourceEvt == this.vue.getItemDeconnecter()){
			
			Session.fermerSession();
			this.vue.setMenusDeconnecte() ;						
		}
		else if (sourceEvt == this.vue.getItemEnregistrerClient()){
			VueNouveauClient vueNouveauClient = new VueNouveauClient(this.vue);
			
		}
		else if (sourceEvt == this.vue.getItemEnregistrerLocation()){
			VueNouvelleLocation vueNouvelleLocation = new VueNouvelleLocation(this.vue);
			
		}
		else if (sourceEvt == this.vue.getItemVisualiserClients()){
			this.vue.getVueListeClients().getModeleTabClients().actualiser();
			this.vue.changerVue(VueLocavek.LISTECLIENTS);
		}
		else if (sourceEvt == this.vue.getItemVisualiserVehicules()){
			this.vue.getVueListeVehicules().getModeleTabVehicules().actualiser();
			this.vue.changerVue(VueLocavek.LISTEVEHICULES);
		}
		else if (sourceEvt == this.vue.getItemVisualiserLocations()){
			this.vue.changerVue(VueLocavek.LISTELOCATIONS);
		}
	}
		
	
}
