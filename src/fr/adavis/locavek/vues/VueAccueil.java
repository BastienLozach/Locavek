package fr.adavis.locavek.vues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAccueil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6305616517224071558L;

	public VueAccueil() {
		
		super() ;
		
		System.out.println("vueAccueil::vueAccueil()");
		/*
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("/media/My Passport/fond ecran.png")));
		setLayout(new FlowLayout());
		*/
		
		this.add(new JLabel("Accueil")) ;
		
		this.setVisible(true);
	}
}
