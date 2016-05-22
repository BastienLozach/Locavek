package fr.adavis.locavek.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.adavis.locavek.entites.Client;

public class ModeleListeClients extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Client> clients = ModeleLocavek.getModele().getClients() ;
	private final String[] entetes = {"Numéro","Nom","Prénom","Mobile"} ;
	
	public ModeleListeClients() {
		super() ;
		System.out.println("ModeleListeClients::ModeleListeClients()") ;
	}

	@Override
	public int getRowCount() {
		System.out.println("ModeleListeClients::getRowCount()") ;
		// Votre code ici
		if (this.clients != null) {
			return this.clients.size() ;
		}
		else {
			return 0 ;
		}
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
	
    public Class<?> getColumnClass(int columnIndex) {
        if (clients.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListeClients::getValueAt("+rowIndex+","+columnIndex+")") ;
		// Votre code ici
		switch(columnIndex){
			case 0 : {
				return new Integer(this.clients.get(rowIndex).getNumero()) ;
			}
			case 1 : {
				return this.clients.get(rowIndex).getNom() ;
			}
			case 2 : {
				return this.clients.get(rowIndex).getPrenom() ;
			}
			case 3 : {
				return this.clients.get(rowIndex).getMobile() ;
			}
			default :{
				return null ;
			}
		}
		
			
	}
	
	public void actualiser(){
		System.out.println("ModeleListeClients::actualiser()") ;
		clients = ModeleLocavek.getModele().getClients() ;
		this.fireTableDataChanged();
		
	}

}
