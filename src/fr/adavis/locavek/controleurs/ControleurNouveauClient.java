package fr.adavis.locavek.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.adavis.locavek.modeles.ModeleLocavek;
import fr.adavis.locavek.vues.VueLocavek;
import fr.adavis.locavek.vues.VueNouveauClient;

/** Contrôleur associé à la vue "Enregistrer un nouveau client"
 * @author xilim
 *
 */
public class ControleurNouveauClient implements ActionListener, DocumentListener {

	private VueNouveauClient vue ;
	
	private ModeleLocavek modele = ModeleLocavek.getModele() ;

	/** Constructeur
	 * @param vue La vue relative au cas d'utilisation "Enregistrer un nouveau client"
	 */
	public ControleurNouveauClient(VueNouveauClient vue) {
		super();
		System.out.println("ControleurNouveauClient::ControleurNouveauClient()") ;
		this.vue = vue ;
		this.enregistrerEcouteur();
		this.verifierChamps() ;
	}

	/** Enregistrer le contrôleur comme écouteur des boutons
	 * 
	 */
	private void enregistrerEcouteur(){
		System.out.println("ControleurNouveauClient::enregistrerEcouteur()") ;
		// Votre code ici
		this.vue.getbEnregistrer().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
		
		this.vue.getTfNom().getDocument().addDocumentListener(this) ;
		this.vue.getTfPrenom().getDocument().addDocumentListener(this) ;
		this.vue.getTfMobile().getDocument().addDocumentListener(this) ;
		
		
	}
	
	public VueNouveauClient getVue() {
		return vue;
	}

	public void setVue(VueNouveauClient vue) {
		this.vue = vue;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurNouveauClient::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		
		// Votre code ici
		if (sourceEvt == this.vue.getbAnnuler()) {
			this.vue.dispose() ;
			
		}
		else if(sourceEvt == this.vue.getbEnregistrer()) {
			modele.ajouterClient(this.vue.getTfNom().getText(),
					this.vue.getTfPrenom().getText(),
					this.vue.getTfMobile().getText()
					);
			((VueLocavek) this.vue.getParent()).getVueListeClients().getModeleTabClients().actualiser();
			JOptionPane.showMessageDialog(vue,
					"Enregistrement Réussi" + "\n"
					+ "Nom : " + this.vue.getTfNom().getText() + "\n"
					+ "Prénom : " + this.vue.getTfPrenom().getText() + "\n"
					+ "Numéro de tel : " + this.vue.getTfMobile().getText() + "\n"
					);
			this.vue.dispose() ;
		}
		
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ControleurNouveauClient::insertUpdate()") ;
		this.verifierChamps() ;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("ControleurNouveauClient::removeUpdate()") ;
		// TODO Auto-generated method stub
		this.verifierChamps() ;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void verifierChamps() {
		System.out.println("ControleurNouveauClient::verifierChamps()") ;
		boolean verif ;
		
		String nom = this.vue.getTfNom().getText() ;
		String prenom = this.vue.getTfPrenom().getText() ;
		String mobile = this.vue.getTfMobile().getText() ;
		
		verif = (nom.compareTo("") != 0) && (prenom.compareTo("") != 0) && (mobile.compareTo("") != 0) ;

		if(verif){
			this.vue.getbEnregistrer().setEnabled(true) ;
		}
		else {
			this.vue.getbEnregistrer().setEnabled(false) ;
		}
		
		
	}
	
}
