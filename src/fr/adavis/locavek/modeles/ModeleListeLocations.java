package fr.adavis.locavek.modeles;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import fr.adavis.locavek.entites.Client;
import fr.adavis.locavek.entites.Location;
import fr.adavis.locavek.technique.DateFR;

public class ModeleListeLocations extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Location> locations = ModeleLocavek.getModele().getLocations() ;
	private final String[] entetes = {"Numéro", "Date départ", "Date retour", "Client", "Véhicule", "Retour"} ;
	
	public ModeleListeLocations() {
		super() ;
		System.out.println("ModeleListeLocations::ModeleListeLocations()") ;
	}

	@Override
	public int getRowCount() {
		System.out.println("ModeleListeClients::getRowCount()") ;
		// Votre code ici
		return this.locations.size() ;
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListeClients::getColumnCount()") ;
		// Votre code ici
		return this.entetes.length ;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListeClients::getColumnName()") ;
		// Votre code ici
		return this.entetes[columnIndex] ;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListeLocations::getValueAt("+rowIndex+","+columnIndex+")") ;
		// Votre code ici
		switch(columnIndex){
			case 0 : {
				//return new Integer (this.locations.get(rowIndex).getNumero()) ;
				return ""+this.locations.get(rowIndex).getNumero() ;
			}
			case 1 : {
				return this.locations.get(rowIndex).getDateDepart() ;
			}
			case 2 : {
				return this.locations.get(rowIndex).getDateRetourEffective() ;
			}
			case 3 : {
				Client client = this.locations.get(rowIndex).getClient() ;
				return client.getNom()+" "+client.getPrenom() ;
			}
			case 4 : {
				return this.locations.get(rowIndex).getVehicule().getImmatriculation() ;
		
			}
			case 5 : {
				return new JButton("Enregistrer") ;
			}
			
			default :{
				return "null" ;
			}
		}
	}
	
	
    public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
			case 0 : {
				//return Integer.class ;
				return String.class ;
			}
			case 1 : {
				return DateFR.class ;
			}
			case 2 : {
				return DateFR.class ;
			}
			case 3 : {
				return String.class ;
			}
			case 4 : {
				return String.class ;
			}
			case 5 : {
				return JButton.class;
			}
			default :{
				return Object.class ;
			}
		}
	}
	
	
	public void actualiser(){
		System.out.println("ModeleListeLocations::actualiser()") ;
		this.fireTableDataChanged();
	}
	
	public void actualiser(int ligne, int colonne){
		this.fireTableCellUpdated(ligne, colonne);
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex){
		System.out.println("ModeleListeLocations::isCellEditable()") ;
		return columnIndex == 5 && !locations.get(rowIndex).estTerminee() ;
		
	}
	
	public Location getLocation(int row){
		return locations.get(row) ;
	}

}
