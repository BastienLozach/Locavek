package fr.adavis.locavek.vues;

import java.awt.* ;
import java.awt.event.* ;

import javax.swing.* ;

import fr.adavis.locavek.controleurs.ControleurNouveauClient;

/** Vue relative au cas d'utilisation "Enregistrer un nouveau client"
 * 
 * @author xilim
 *
 */
public class VueNouveauClient extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ControleurNouveauClient controleur ;
	
	private JTextField tfNom = new JTextField() ;
	private JTextField tfPrenom = new JTextField() ;
	private JTextField tfMobile = new JTextField() ;
	
	private JButton bEnregistrer = new JButton("Enregistrer") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	/** Constructeur
	 * @param vueParente Vue principale de l'application
	 */
	public VueNouveauClient(JFrame vueParente) {
		super(vueParente,"Nouveau client",true);
		System.out.println("VueNouveauClient::VueNouveauClient()") ;
		
		this.creerInterfaceUtilisateur();
		
		this.controleur = new ControleurNouveauClient(this) ;
		this.pack();
		this.setLocationRelativeTo(vueParente) ;
		this.setResizable(false) ;
		this.setVisible(true) ;
	}
	
	public JTextField getTfNom() {
		return tfNom;
	}

	public JTextField getTfPrenom() {
		return tfPrenom;
	}

	public JTextField getTfMobile() {
		return tfMobile;
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
		System.out.println("VueNouveauClient::creerInterfaceUtilisateur()") ;
		
		// Votre code ici
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Nom : ")) ;
		boxEtiquettes.add(new JLabel("Prénom : ")) ;
		boxEtiquettes.add(new JLabel("Téléphone Mobile : "));
		
		boxSaisies.add(this.tfNom) ;
		boxSaisies.add(this.tfPrenom) ;
		boxSaisies.add(this.tfMobile) ;
		
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
	
}
