package fr.adavis.locavek.vues;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.adavis.locavek.controleurs.ControleurLocavek;

/** Vue principale de l'application
 * 
 * @author xilim
 *
 */
public class VueLocavek extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ControleurLocavek controleur ;
		
	private JMenuItem itemConnecter  = new JMenuItem("Se connecter") ;
	private JMenuItem itemDeconnecter  = new JMenuItem("Se déconnecter") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;
	private JMenuItem itemVisualiserLocations = new JMenuItem("Liste des locations") ;
	private JMenuItem itemEnregistrerLocation = new JMenuItem("Nouvelle location") ;
	private JMenuItem itemVisualiserClients = new JMenuItem("Liste des clients") ;
	private JMenuItem itemEnregistrerClient = new JMenuItem("Nouveau client") ;
	private JMenuItem itemVisualiserVehicules = new JMenuItem("Liste des véhicules") ;
	
	private JMenu menuFichier = new JMenu("Fichier") ;
	private JMenu menuLocations = new JMenu("Locations") ;
	private JMenu menuVehicules = new JMenu("Véhicules") ;
	private JMenu menuClients = new JMenu("Clients") ;
	
	private CardLayout clPanneaux = new CardLayout(5, 5);
	
	public static String ACCUEIL = "Accueil" ;
	public static String LISTECLIENTS = "ListeClients" ;
	public static String LISTEVEHICULES = "ListeVehicules" ;
	public static String LISTELOCATIONS = "ListeLocations" ;
	
	
	private VueListeClients vueListeClients = new VueListeClients() ;
	private VueListeVehicules vueListeVehicules = new VueListeVehicules() ;
	private VueListeLocations vueListeLocations = new VueListeLocations() ;
	

	/** Constructeur
	 * 
	 */
	public VueLocavek() {
		super();
		System.out.println("VuePrincipale::VuePrincipale()") ;
		
		this.setTitle("Locavek") ;
		this.setSize(1300,500) ; 
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		this.creerBarreMenus() ;
		this.setMenusDeconnecte();
		this.setCardlayout() ;
		
		this.setVisible(true) ;
		
		this.controleur = new ControleurLocavek(this) ;
		
	}
	
	private void setCardlayout() {
		// TODO Auto-generated method stub
		System.out.println("VuePrincipale::setCardlayout()") ;
		Container conteneur = this.getContentPane() ;
		conteneur.setLayout(clPanneaux) ;
		
		conteneur.add(new JPanel(), "") ;
		conteneur.add(new VueAccueil(), ACCUEIL) ;
		conteneur.add(vueListeClients, LISTECLIENTS) ;
		conteneur.add(vueListeVehicules, LISTEVEHICULES) ;
		conteneur.add(vueListeLocations, LISTELOCATIONS) ;
		
		
	}

	public ControleurLocavek getControleur() {
		return this.controleur;
	}

	public JMenuItem getItemConnecter() {
		return itemConnecter;
	}
	
	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public JMenuItem getItemVisualiserLocations() {
		return itemVisualiserLocations;
	}

	public JMenuItem getItemEnregistrerLocation() {
		return itemEnregistrerLocation;
	}

	public JMenuItem getItemVisualiserClients() {
		return itemVisualiserClients;
	}

	public JMenuItem getItemEnregistrerClient() {
		return itemEnregistrerClient;
	}

	public JMenuItem getItemVisualiserVehicules() {
		return itemVisualiserVehicules;
	}

	public JMenuItem getItemDeconnecter() {
		return itemDeconnecter;
	}
	
	/** Positionner les menus et les items de menu pour l'état "Connecté"
	 * 
	 */
	public void setMenusConnecte(){
		System.out.println("VuePrincipale::setMenusConnecte()") ;
		// Votre code ici
		this.itemConnecter.setEnabled(false) ;
		this.itemQuitter.setEnabled(true) ;
		this.itemDeconnecter.setEnabled(true) ;
		this.menuClients.setEnabled(true) ;
		this.menuLocations.setEnabled(true) ;
		this.menuVehicules.setEnabled(true) ;
		
		//this.itemQuitter.setEnabled(true) ;
	
	}
	
	/** Positionner les menus et les items de menu pour l'état "Déconnecté"
	 * 
	 */
	public void setMenusDeconnecte(){
		System.out.println("VuePrincipale::setMenusDeconnecte()") ;
		// Votre code ici
		

	
		this.itemConnecter.setEnabled(true) ;
		this.itemQuitter.setEnabled(true) ;
		this.itemDeconnecter.setEnabled(false) ;
		this.menuClients.setEnabled(false) ;
		this.menuLocations.setEnabled(false) ;
		this.menuVehicules.setEnabled(false) ;
		
		//this.itemQuitter.setEnabled(true) ;
		
	}

	/** Créer la barre de menus
	 * 
	 */
	private void creerBarreMenus(){
		System.out.println("VuePrincipale::creerBarreMenus()") ;
		JMenuBar barreMenus = new JMenuBar() ;
		
		menuFichier.add(this.itemConnecter) ;
		menuFichier.add(this.itemDeconnecter) ;
		menuFichier.addSeparator() ;
		menuFichier.add(this.itemQuitter) ;

		menuLocations.add(this.itemVisualiserLocations) ;
		menuLocations.add(this.itemEnregistrerLocation) ;
		
		menuClients.add(this.itemVisualiserClients) ;
		menuClients.add(this.itemEnregistrerClient) ;
		
		menuVehicules.add(this.itemVisualiserVehicules) ;
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuLocations) ;
		barreMenus.add(menuClients) ;
		barreMenus.add(menuVehicules) ;
		
		this.setJMenuBar(barreMenus) ;
		
		
		
		
	}
	
	
	public void changerVue(String clef){
		System.out.println("VuePrincipale::changerVue()") ;
		this.clPanneaux.show(this.getContentPane(),clef);
	}

	public VueListeClients getVueListeClients() {
		return vueListeClients;
	}
	
	public VueListeVehicules getVueListeVehicules() {
		return vueListeVehicules;
	}
	
	public VueListeLocations getVueListeLocations() {
		return vueListeLocations;
	}

}
