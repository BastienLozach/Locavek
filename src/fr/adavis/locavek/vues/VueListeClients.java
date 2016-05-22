package fr.adavis.locavek.vues;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.adavis.locavek.modeles.ModeleListeClients;

/** Vue associée au cas d'utilisation "Visualiser la liste des clients"
 * @author xilim
 *
 */
public class VueListeClients extends JPanel {


	private static final long serialVersionUID = 1L;
	
	private ModeleListeClients modeleTabClients = new ModeleListeClients() ;
	private JTable tabClients ;
	
	/** Constructeur
	 * 
	 */
	public VueListeClients(){
		super() ;
		System.out.println("VueListeClients::VueListeClients()") ;
		this.creerInterfaceUtilisateur() ;
	}
	
	/** Agencer les composants graphiques
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeClients::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		// Votre code ici
		
		this.tabClients = new JTable(this.modeleTabClients) ;
		this.tabClients.setRowHeight(30) ;
		
		// tri
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabClients.getModel());
		tabClients.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		 
		int columnIndexToSort = 0;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		// fin tri
		
		
		JScrollPane spClients = new JScrollPane(this.tabClients) ;
		
		spClients.setPreferredSize(new Dimension(1090, 420)) ;
		
		boxTableau.add(spClients) ;
		
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;
		
		this.add(boxPrincipale) ;
		
	}
	
	public JTable getTabClients() {
		return tabClients;
	}

	public ModeleListeClients getModeleTabClients() {
		return modeleTabClients;
	}

	
}
