package fr.adavis.locavek.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.adavis.locavek.entites.Vehicule;

public class ModeleListeVehicules extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Vehicule> vehicules = ModeleLocavek.getModele().getVehicules() ;
	private final String[] entetes = {"Immatriculation","Modèle","Année","Compteur","Situation"} ;
	
	public ModeleListeVehicules() {
		super() ;
		System.out.println("ModeleListeVehicules::ModeleListeVehicules()") ;
	}

	@Override
	public int getRowCount() {
		System.out.println("ModeleListeClients::getRowCount()") ;
		// Votre code ici
		return this.vehicules.size() ;
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
		System.out.println("ModeleListeVehicules::getValueAt("+rowIndex+","+columnIndex+")") ;
		// Votre code ici
		switch(columnIndex){
		case 0 : {
			return this.vehicules.get(rowIndex).getImmatriculation() ;
		}
		case 1 : {
			return this.vehicules.get(rowIndex).getModele() ;
		}
		case 2 : {
			return new Integer(this.vehicules.get(rowIndex).getAnnee()) ;
		}
		case 3 : {
			return this.vehicules.get(rowIndex).getCompteur() ;
		}
		case 4 : {
			return new Integer(this.vehicules.get(rowIndex).getSituation()) ;
			/*
			int situation =  this.vehicules.get(rowIndex).getSituation() ;
			switch(situation){
				case Vehicule.DISPONIBLE : {
					return "Disponible" ;
				}
				case Vehicule.IMMOBILISE : {
					return "Immobilisé" ;
				}
				case Vehicule.LOUE : {
					return "Loué" ;
				}
				default : {
					return null ;
				}
			
			}
			*/
		}
		default :{
			return null ;
		}
	}
	}
	
	public void actualiser(){
		System.out.println("ModeleListeVehicules::actualiser()") ;
		this.fireTableDataChanged();
	}
	
	public int getSituation(int indiceLigne){
		return vehicules.get(indiceLigne).getSituation() ;
	}

}
