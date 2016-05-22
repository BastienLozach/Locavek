package fr.adavis.locavek.entites;

import fr.adavis.locavek.technique.DateFR;


/** Représenter une location
 * 
 * @author xilim
 *
 */
public class Location {
	
	private int numero ;
	private DateFR dateDepart ;
	private DateFR dateRetourPrevue ;
	private DateFR dateRetourEffective ;
	
	private Vehicule vehicule ;
	private Client client ;
	
	/** Constructeur
	 * @param numero Le numéro
	 * @param vehicule Le véhicule loué
	 * @param client Le client
	 * @param dateDepart La date de départ du véhicule
	 * @param dateRetourPrevue La date de retour prévue du véhicule
	 */
	public Location(int numero, Vehicule vehicule, Client client, DateFR dateDepart, DateFR dateRetourPrevue) {
		super();
		this.numero = numero;
		this.dateDepart = dateDepart;
		this.dateRetourPrevue = dateRetourPrevue ;
		this.vehicule = vehicule ;
		this.client = client ;
		
	}
	
	public Location() {
		super();
	
	}
	
	/** Constructeur
	 * @param numero Le numéro
	 * @param vehicule Le véhicule loué
	 * @param client Le client
	 * @param dateDepart La date de départ du véhicule
	 * @param dateRetourPrevue La date de retour prévue du véhicule
	 * @param dateRetourEffective La date de retour effective du véhicule
	 */
	public Location(int numero, Vehicule vehicule, Client client, DateFR dateDepart, DateFR dateRetourPrevue, DateFR dateRetourEffective) {
		super();
		this.numero = numero;
		this.dateDepart = dateDepart;
		this.dateRetourPrevue = dateRetourPrevue ;
		this.vehicule = vehicule ;
		this.client = client ;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public DateFR getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(DateFR dateDepart) {
		this.dateDepart = dateDepart;
	}

	public DateFR getDateRetourPrevue() {
		return dateRetourPrevue;
	}

	public void setDateRetourPrevue(DateFR dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}
	
	public DateFR getDateRetourEffective() {
		return dateRetourEffective;
	}

	public void setDateRetourEffective(DateFR dateRetourEffective) {
		this.dateRetourEffective = dateRetourEffective;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/** La location est elle en cours ?
	 * @return true si la location est en cours et false dans le cas contraire
	 */
	public boolean estEnCours(){
		if(this.dateRetourEffective == null){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** La location est elle terminée ?
	 * @return true si la location terminée et false dans le cas contraire
	 */
	public boolean estTerminee(){
		if(this.dateRetourEffective != null){
			return true ;
		}
		else {
			return false ;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [numero=" + numero + ", dateDepart=" + dateDepart
				+ ", dateRetourPrevue=" + dateRetourPrevue
				+ ", dateRetourEffective=" + dateRetourEffective 
				+ ", vehicule=" + vehicule + ", client=" + client + "]";
	}
	
}
