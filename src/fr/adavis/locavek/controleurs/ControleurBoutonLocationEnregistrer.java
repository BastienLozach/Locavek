package fr.adavis.locavek.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import fr.adavis.locavek.entites.Location;
import fr.adavis.locavek.modeles.ModeleListeLocations;
import fr.adavis.locavek.modeles.ModeleLocavek;

public class ControleurBoutonLocationEnregistrer implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------");
		System.out.println("ControleurBoutonLocationEnregistrer::actionPerformed() - row="+row+" column="+column) ;
		Location location = ((ModeleListeLocations)this.table.getModel()).getLocation(row) ;
		//Vehicule vehicule = location.getVehicule() ;
		
		String compteur = JOptionPane.showInputDialog(table, "saisir la valeur du compteur kilométrique", "Retour Véhicule", JOptionPane.QUESTION_MESSAGE) ;
		
		int intCompteur = Integer.parseInt(compteur) ;
		ModeleLocavek.getModele().enregistrerRetourVehicule(location.getNumero(), intCompteur) ;
		((ModeleListeLocations)this.table.getModel()).actualiser();
				
		
	}



	public int getRow() {
		return row;
	}



	public void setRow(int row) {
		this.row = row;
	}



	public int getColumn() {
		return column;
	}



	public void setColumn(int column) {
		this.column = column;
	}



	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}

	
	
}
