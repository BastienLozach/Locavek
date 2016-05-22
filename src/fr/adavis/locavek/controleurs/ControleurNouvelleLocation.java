package fr.adavis.locavek.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.adavis.locavek.entites.Client;
import fr.adavis.locavek.entites.Location;
import fr.adavis.locavek.entites.Vehicule;
import fr.adavis.locavek.modeles.ModeleLocavek;
import fr.adavis.locavek.technique.DateFR;
import fr.adavis.locavek.vues.VueLocavek;
import fr.adavis.locavek.vues.VueNouvelleLocation;

/** Contrôleur dédié à la vue "Enregistrer une nouvelle location"
 * @author xilim
 *
 */
public class ControleurNouvelleLocation implements ActionListener, DocumentListener {

	private VueNouvelleLocation vue ;
	private ModeleLocavek modele = ModeleLocavek.getModele() ;
	
	/** Constructeur
	 * @param vue La vue relative au cas d'utilisation "Enregistrer une nouvelle location"
	 */
	public ControleurNouvelleLocation(VueNouvelleLocation vue) {
		super();
		System.out.println("ControleurNouvelleLocation::ControleurNouvelleLocation()") ;
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}

	public VueNouvelleLocation getVue() {
		return vue;
	}

	public void setVue(VueNouvelleLocation vue) {
		this.vue = vue;
	}

	/** Enregistrer le contrôleur comme écouteur des boutons et de la zone de saisie de la date de retour prévue
	 * 
	 */
	private void enregistrerEcouteur(){
		System.out.println("ControleurNouvelleLocation::enregistrerEcouteur()") ;
		this.vue.getTfDateRetourPrevue().getDocument().addDocumentListener(this) ;
		// Votre code ici
		this.vue.getbEnregistrer().addActionListener(this) ;
		this.vue.getbAnnuler().addActionListener(this) ;
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println("ControleurNouvelleLocation::insertUpdate()") ;
		// Votre code ici si nécessaire
		repercuterSaisieDate();
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("ControleurNouvelleLocation::removeUpdate()") ;
		// Votre code ici si nécessaire
		repercuterSaisieDate();
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("ControleurNouvelleLocation::changedUpdate()") ;
		// Votre code ici si nécessaire
		//repercuterSaisieDate();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurNouvelleLocation::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		// Votre code ici
		if (e.getSource() == this.vue.getbAnnuler()){
			this.vue.dispose() ;
		}
		else if (e.getSource() == this.vue.getbEnregistrer()){
			//String dateFin = this.vue.getTfDateRetourPrevue().getText() ;
			Date dateFinTemp = (Date)this.vue.getDpDateRetourPrevue().getModel().getValue() ;
			String dateFin = dateFinTemp.getDate()+"/" ;
			int month = dateFinTemp.getMonth()+1 ;
			dateFin += month + "/" ;
			int year = dateFinTemp.getYear() + 1900 ;
			dateFin += year ;
			
			Location location = modele.ajouterLocation((Vehicule)this.vue.getCbVehicules().getSelectedItem(),
					(Client)this.vue.getCbClients().getSelectedItem(),
					DateFR.parseString(dateFin)
					);
			int nbrVehiculerestants = this.vue.getCbVehicules().getItemCount() ;
			 
			JOptionPane.showMessageDialog(vue,
					"Enregistrement Réussi" + "\n"
					+ "num Location : " + location.getNumero() + "\n"
					+ "Vehicule : " + ((Vehicule)this.vue.getCbVehicules().getSelectedItem()) + "\n"
					+ "Client : " + ((Client)this.vue.getCbClients().getSelectedItem()) + "\n"
					+ "Date de départ : " + new DateFR() + "\n"
					+ "Date de retour : " + DateFR.parseString(dateFin) + "\n"
					);
			
			((VueLocavek) this.vue.getParent()).getVueListeLocations().getModeleTabLocations().actualiser();
			
			if (nbrVehiculerestants == 1){
				JOptionPane.showMessageDialog(vue,"Attention, il n'y a plus de véhicules disponibles !") ;
			}
			this.vue.dispose() ;
		}
		
		
		
		
	}
	
	/** Positionne l'état du bouton "Enregistrer" en fonction de la valeur saisie
	 * dans le champ relatif à la date de retour prévue
	 * 
	 */
	private void repercuterSaisieDate(){
		System.out.println("ControleurNouvelleLocation::repercuterSaisieDate()") ;
		String dateSaisie = this.vue.getTfDateRetourPrevue().getText() ;
		System.out.println(dateSaisie) ;
		DateFR aujourdhui = new DateFR() ;
		System.out.println(aujourdhui) ;
		
		
		boolean dateRetourOk = false ;
		
		if( DateFR.estDate(dateSaisie) ){
			DateFR dateRetour = DateFR.parseString(dateSaisie) ;
			System.out.println("\t" + dateRetour) ;
			if(dateRetour.estIdentique(aujourdhui) || dateRetour.estPosterieure(aujourdhui)){
				dateRetourOk = true ;
			}
		}
		
		if(dateRetourOk){
			this.vue.getbEnregistrer().setEnabled(true) ;
		}
		else {
			this.vue.getbEnregistrer().setEnabled(false) ;
		}
	}
	
	
}
