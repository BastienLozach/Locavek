package fr.adavis.locavek;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import fr.adavis.locavek.controleurs.ControleurBoutonLocationEnregistrer;

public class EditeurBoutonLocationEnregistrer extends DefaultCellEditor{

		
	protected JButton bouton ;
	private boolean isPushed ;
	private ControleurBoutonLocationEnregistrer controleur ;
	
	
	
	public EditeurBoutonLocationEnregistrer(JCheckBox checkBox) {
		super(checkBox);
		System.out.println("EditeurBoutonLocationEnregistrer::EditeurBoutonLocationEnregistrer(JCheckBox)");
		controleur = new ControleurBoutonLocationEnregistrer() ;
		bouton = new JButton() ;
		bouton.addActionListener(controleur);
		
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int columnIndex) {
		System.out.println("EditeurBoutonLocationEnregistrer::getTableCellEditorComponent() - row="+rowIndex+" column="+columnIndex) ;
		
		controleur.setTable(table);
		controleur.setRow(rowIndex);
		controleur.setColumn(columnIndex);
		
		bouton.setText("Enregistrer Editeur");
		
		return bouton ;
	}
	

	/**
	 * 
	 */
	
	
}
