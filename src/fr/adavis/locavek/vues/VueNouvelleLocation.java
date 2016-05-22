package fr.adavis.locavek.vues;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.adavis.locavek.controleurs.ControleurNouvelleLocation;
import fr.adavis.locavek.entites.Client;
import fr.adavis.locavek.entites.Vehicule;
import fr.adavis.locavek.modeles.ModeleLocavek;
import fr.adavis.locavek.technique.DateFR;
import fr.adavis.locavek.technique.DateLabelFormatter;

/** Vue relative au cas d'utilisation "Enregistrer une nouvelle location"
 * 
 * @author xilim
 *
 */
public class VueNouvelleLocation extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ControleurNouvelleLocation controleur ;
	
	// Votre code ici
	private ModeleLocavek modele ;
	
	private JComboBox<Client> cbClients = new JComboBox<Client>() ;
	private JComboBox<Vehicule> cbVehicules = new JComboBox<Vehicule>() ;
	
	private JTextField tfDateRetourPrevue = new JTextField() ;
	
	// JDatePicker
	
	private UtilDateModel dateRetourModel = new UtilDateModel();
	private JDatePanelImpl dateRetourDatePanel = new JDatePanelImpl(dateRetourModel, new Properties()) ;
	private JDatePickerImpl dpDateRetourPrevue = new JDatePickerImpl(dateRetourDatePanel, new DateLabelFormatter());
	
	// Fin JDatePicker
	
	private JButton bEnregistrer = new JButton("Enregistrer") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	/** Constructeur
	 * @param vueParente La vue principale de l'application
	 */
	public VueNouvelleLocation(JFrame vueParente) {
		super(vueParente,"Nouvelle location",true);
		System.out.println("VueNouvelleLocation::VueNouvelleLocation()") ;
		this.modele = ModeleLocavek.getModele() ;
		
		this.creerInterfaceUtilisateur() ;
		this.controleur = new ControleurNouvelleLocation(this) ;
		this.initialiser();
		this.initialiserDatePicker();
		this.pack();
		this.setLocationRelativeTo(vueParente) ;
		this.setResizable(false) ;
		this.setVisible(true) ;
		
		
		
	}

	public JComboBox<Client> getCbClients() {
		return cbClients;
	}
	
	public JComboBox<Vehicule> getCbVehicules() {
		return cbVehicules;
	}

	public JTextField getTfDateRetourPrevue() {
		return tfDateRetourPrevue;
	}

	public JButton getbEnregistrer() {
		return bEnregistrer;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}

	/** Créer l'interface utilisateur
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueNouvelleLocation::creerInterfaceUtilisateur()") ;
		
		// Votre code ici
Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Client : ")) ;
		boxEtiquettes.add(new JLabel("Véhicule : ")) ;
		boxEtiquettes.add(new JLabel("Date de retour Prévue : "));
		
		boxSaisies.add(this.cbClients) ;
		boxSaisies.add(this.cbVehicules) ;
		//boxSaisies.add(this.tfDateRetourPrevue) ;
		
		boxSaisies.add(this.dpDateRetourPrevue) ;
		
		
		
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bEnregistrer) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bAnnuler) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxEtiquettes) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxSaisies) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxChamps) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxLigne) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxActions) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		
		conteneur.add(boxPrincipale) ;
		
		Dimension dimensionBouton = this.bEnregistrer.getPreferredSize() ;
		
		this.bAnnuler.setPreferredSize(dimensionBouton) ;
		this.bAnnuler.setMaximumSize(dimensionBouton) ;
		this.bAnnuler.setMinimumSize(dimensionBouton) ;
		
		
		
	}
	
	
	/** Initialiser les champs (liste des clients, liste des véhicules et date de retour prévue
	 * 
	 */
	private void initialiser(){
		System.out.println("VueNouvelleLocation::initialiser()") ;
		
		// Votre code ici
		
		//Clients
		List<Client> clients = modele.getClients() ; 
		
		for(Client client : clients) {
			cbClients.addItem(client) ;
		}
		
		
		
		//Voitures
		List<Vehicule> vehicules = modele.getVehiculesDisponibles() ; 
		
		for(Vehicule vehicule : vehicules) {
			
			cbVehicules.addItem(vehicule) ;
			
		}		
		
		//Date
		
		DateFR date = new DateFR() ;
		
		tfDateRetourPrevue.setText(date.toString()) ;
		
	}
	
	private void initialiserDatePicker() {
		System.out.println("VueNouvelleLocation::initialiserdatePicker()") ;
		DateFR DateFRAujourdhui= new DateFR() ;
		
		
		dateRetourModel.setDate(DateFRAujourdhui.getAnnee(), DateFRAujourdhui.getMois()-1, DateFRAujourdhui.getJour());
		
		dateRetourModel.setSelected(true);
	}

	public JDatePickerImpl getDpDateRetourPrevue() {
		return dpDateRetourPrevue;
	}

	public void setDpDateRetourPrevue(JDatePickerImpl dpDateRetourPrevue) {
		this.dpDateRetourPrevue = dpDateRetourPrevue;
	}
}
