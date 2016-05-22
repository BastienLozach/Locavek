package fr.adavis.locavek;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fr.adavis.locavek.entites.Location;
import fr.adavis.locavek.modeles.ModeleListeLocations;

public class RenduBoutonLocation extends JButton implements TableCellRenderer {

	public RenduBoutonLocation(){
		super() ;
		this.setText("Enregistrer");
	}
	
	
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		System.out.println("RenduBoutonLocation::getTableCellRendererComponent") ;
		
		Location location = ((ModeleListeLocations) table.getModel()).getLocation(row) ;
		
		if(location.estTerminee()){
			this.setEnabled(false);
		}
		else {
			this.setEnabled(true);
		}
		
		return this ;
	}
	
	
	
	
}
