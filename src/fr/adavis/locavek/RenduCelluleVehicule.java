package fr.adavis.locavek;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fr.adavis.locavek.entites.Vehicule;
import fr.adavis.locavek.modeles.ModeleListeVehicules;

public class RenduCelluleVehicule extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public RenduCelluleVehicule(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);
		int situation = ((ModeleListeVehicules) table.getModel()).getSituation(row) ;
		
		// Votre code ici
		
		switch(situation){
			case Vehicule.DISPONIBLE : {
				composant.setBackground(new Color(211,237,200,50)) ;
				break ;
			}
			case Vehicule.IMMOBILISE : {
				composant.setBackground(new Color(237,200,200,50)) ;
				break ;
			}
			case Vehicule.LOUE : {
				composant.setBackground(new Color(249,219,115,50)) ;
				break ;
			}
		}
		
		
		if(column == 4) {
		
			switch(situation){
				case Vehicule.DISPONIBLE : {
					composant.setText("Disponible")  ;
					break ;
				}
				case Vehicule.IMMOBILISE : {
					composant.setText("Immobilisé") ;
					break ;
				}
				case Vehicule.LOUE : {
					composant.setText("Loué") ;
					break ;
				}
				
			}
		}

		return composant ;
	}
	
	
}
