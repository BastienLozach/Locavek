package fr.adavis.locavek.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.adavis.locavek.entites.Utilisateur;
import fr.adavis.locavek.modeles.ModeleLocavek;
import fr.adavis.locavek.technique.EtatTentativeConnexion;
import fr.adavis.locavek.technique.Session;
import fr.adavis.locavek.vues.VueAuthentification;

/** Contrôleur dédié à la vue "Authentification"
 * @author xilim
 *
 */
public class ControleurAuthentification implements ActionListener {
	
	private VueAuthentification vue ;
	
	// Votre code ici
	private ModeleLocavek modele = ModeleLocavek.getModele() ; // Initialisation
	
	private EtatTentativeConnexion etatTentativeConnexion = EtatTentativeConnexion.ABANDON ;
	
	/** Constructeur
	 * @param vue La vue associée
	 */
	public ControleurAuthentification(VueAuthentification vue){
		super() ;
		System.out.println("ControleurAuthentification::ControleurAuthentification()") ;
		this.vue = vue ;
		this.enregistrerEcouteur() ;

		
	}
	
	/** Enregistrer le contrôleur comme écouteur des deux boutons
	 * 
	 */
	private void enregistrerEcouteur(){
		System.out.println("ControleurAuthentification::enregistrerEcouteur()") ;
		// Votre code ici
		this.vue.getbConnecter().addActionListener(this) ;
		this.vue.getbAnnuler().addActionListener(this) ;
		
		
	}
	
	/** Obtenir le résultat de la tentative de connexion
	 * @return Résultat de la tentative de connexion
	 */
	public EtatTentativeConnexion getEtatTentativeConnexion(){
		System.out.println("ControleurAuthentification::getEtatTentativeConnexion()") ;
		return this.etatTentativeConnexion ;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurAuthentification::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		// Votre code ici
		if(sourceEvt == this.vue.getbAnnuler()){
			this.vue.dispose() ;
		}
		else if (sourceEvt == this.vue.getbConnecter()) {
			String login = this.vue.getTfLogin().getText() ;
			@SuppressWarnings("deprecation")
			String mdp = this.vue.getPfMDP().getText() ;
			
			Utilisateur user = modele.getUtilisateur(login,mdp) ;
			
			if (user == null) {
				this.etatTentativeConnexion = EtatTentativeConnexion.ECHEC ;
				JOptionPane.showMessageDialog(vue, "Echec de l'authentification");
				this.vue.initialiser();
			}
			else {
				this.etatTentativeConnexion = EtatTentativeConnexion.OK ;
				Session.ouvrirSession(login);
				JOptionPane.showMessageDialog(vue, "Réussite de l'authentification");
				this.vue.dispose() ;
			}
			
		}
		
		
		
	}
	
}
