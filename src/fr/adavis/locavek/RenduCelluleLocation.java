package fr.adavis.locavek;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import fr.adavis.locavek.entites.Location;
import fr.adavis.locavek.modeles.ModeleListeLocations;

public class RenduCelluleLocation extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public RenduCelluleLocation(){
		super() ;
	}

	
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		System.out.println("rendulocation ligne="+row+" ,colonne="+column) ;
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);
		Location location = ((ModeleListeLocations) table.getModel()).getLocation(row) ;
	
		if(location.estEnCours()){
			composant.setBackground(new Color(249,219,115,50)) ;
		}
		else if(location.estTerminee()){
			composant.setBackground(new Color(237,200,200,50)) ;
		}
		
		if(column == 1 || column == 2 || column == 4){
			composant.setHorizontalAlignment(SwingConstants.CENTER);
			
			
		}
		else if(column == 0 || column == 3) {
			composant.setHorizontalAlignment(SwingConstants.LEFT);
		}
		
		return composant ;
	}
	

	
}
