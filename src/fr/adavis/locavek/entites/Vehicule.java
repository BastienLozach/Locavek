package fr.adavis.locavek.entites;

/** Représenter un véhicule
 * 
 * @author xilim
 *
 */
public class Vehicule {
	
	public static final int DISPONIBLE = 1 ;
	public static final int LOUE = 2 ;
	public static final int IMMOBILISE = 3 ;
	
	private String immatriculation ;
	private String modele ;
	private int annee ;
	private int compteur = 0 ;
	private int situation = DISPONIBLE ;
	
	/** Constructeur
	 * @param immatriculation Le numéro d'immatriculation
	 * @param modele Le modèle avec constructeur
	 * @param annee L'année de première mise en circulation
	 */
	public Vehicule() {
		super();
		
	}
	
	public Vehicule(String immatriculation, String modele, int annee) {
		super();
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.annee = annee ;
	}
	
	/** Constructeur
	 * @param immatriculation Le numéro d'immatriculation
	 * @param modele Le modèle avec constructeur
	 * @param annee L'année de première mise en circulation
	 * @param compteur Le nombre de kilomètres parcourus
	 */
	public Vehicule(String immatriculation, String modele, int annee, int compteur) {
		super();
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.annee = annee ;
		this.compteur = compteur ;
	}
	
	/** Constructeur
	 * @param immatriculation Le numéro d'immatriculation
	 * @param modele Le modèle avec constructeur
	 * @param annee L'année de première mise en circulation
	 * @param compteur Le nombre de kilomètres parcourus
	 * @param situation L'état du véhicule (disponible, loué ou immobilisé)
	 */
	public Vehicule(String immatriculation, String modele, int annee, int compteur, int situation) {
		super();
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.annee = annee ;
		this.compteur = compteur ;
		this.situation = situation ;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public int getAnnee(){
		return this.annee ;
	}
	
	public void setAnnee(int annee){
		this.annee = annee ;
	}

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	
	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}
	
	/** Le véhicule est il disponible ?
	 * @return true si le véhicule est disponible et false dans le cas contraire
	 */
	public boolean estDisponible(){
		if(this.situation == DISPONIBLE){
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
		return this.modele + " (" + this.immatriculation + ")" ;
	}
	
}
