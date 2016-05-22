package fr.adavis.locavek.modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.* ;

import fr.adavis.locavek.entites.Client;
import fr.adavis.locavek.entites.Location;
import fr.adavis.locavek.entites.Utilisateur;
import fr.adavis.locavek.entites.Vehicule;
import fr.adavis.locavek.technique.ConnexionBD;
import fr.adavis.locavek.technique.DateFR;

/** Modèle de l'application
 * 
 * @author xilim
 *
 */
public class ModeleLocavek {
	
	private static ModeleLocavek modele = null;
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>() ;
	private List<Location> locations = new ArrayList<Location>() ;
	private List<Client> clients = new ArrayList<Client>() ;
	private List<Vehicule> vehicules = new ArrayList<Vehicule>() ;
	
	/** Constructeur
	 * 
	 */
	private ModeleLocavek(){
		super() ;
		System.out.println("ModeleLocavek::ModeleLocavek()") ;
		this.peupler() ;
	}
	
	/** Obtenir une unique instance du modèle
	 * @return Le modèle
	 */
	public static ModeleLocavek getModele(){
		System.out.println("ModeleLocavek::getModele()") ;
		if(modele == null){
			modele = new ModeleLocavek() ;
		}
		return modele ;
	}
	
	
	/** Peupler la base de données manipulée
	 * 
	 */
	private void peupler(){
		System.out.println("ModeleLocavek::peupler()") ;
		
		this.utilisateurs.add(new Utilisateur("ahecker","azerty")) ;
		this.utilisateurs.add(new Utilisateur("eprigent","azerty")) ;
		this.utilisateurs.add(new Utilisateur("jythomas","azerty")) ;
		this.utilisateurs.add(new Utilisateur("aalves","azerty")) ;
		this.utilisateurs.add(new Utilisateur("bba","azerty")) ;
		this.utilisateurs.add(new Utilisateur("rbouraoui","azerty")) ;
		this.utilisateurs.add(new Utilisateur("cchaudey","azerty")) ;
		this.utilisateurs.add(new Utilisateur("aclergeot","azerty")) ;
		this.utilisateurs.add(new Utilisateur("ygodefroy","azerty")) ;
		this.utilisateurs.add(new Utilisateur("vleguevel","azerty")) ;
		this.utilisateurs.add(new Utilisateur("mlebeau","azerty")) ;
		this.utilisateurs.add(new Utilisateur("blozach","azerty")) ;
		this.utilisateurs.add(new Utilisateur("gpequery","azerty")) ;
		this.utilisateurs.add(new Utilisateur("cperello","azerty")) ;
		this.utilisateurs.add(new Utilisateur("gwelle","azerty")) ;
		
		this.vehicules.add(new Vehicule("AA-111-AA","Citroën C1",2014,1000)) ;
		this.vehicules.add(new Vehicule("BB-222-BB","Citroën C2",2011,22000)) ;
		this.vehicules.add(new Vehicule("CC-333-CC","Citroën C3",2012,3000)) ;
		this.vehicules.add(new Vehicule("DD-444-DD","Citroën C4",2012,40000)) ;
		this.vehicules.add(new Vehicule("EE-555-EE","Citroën C5",2011,100000)) ;
		this.vehicules.add(new Vehicule("FF-666-FF","Citroën C2",2013,52000)) ;
		this.vehicules.add(new Vehicule("GG-777-GG","Citroën C3",2013,48020)) ;
		this.vehicules.add(new Vehicule("HH-888-HH","Citroën C4",2013,59230)) ;
		this.vehicules.add(new Vehicule("II-999-II","Citroën C2",2012,70323)) ;
		this.vehicules.add(new Vehicule("JJ-010-JJ","Citroën C4",2011,55827)) ;
		this.vehicules.add(new Vehicule("KK-020-KK","Citroën C5",2014,1200)) ;
		
		this.clients.add(new Client(1,"GENPRI","Erwan","0682492032")) ;
		this.clients.add(new Client(2,"KERREH","Armèle","0638678858")) ;
		this.clients.add(new Client(3,"TEFFON","Christophe","0627032673")) ;
		this.clients.add(new Client(5,"ARAUZO","Julien","0639607542")) ;
		this.clients.add(new Client(6,"MILLET","Antoine","0619264309")) ;
		this.clients.add(new Client(7,"KIENTZEL","Louis","0729443875")) ;
		this.clients.add(new Client(8,"BELHADJ","Taslim","0640908628")) ;
		this.clients.add(new Client(9,"BELLAICHE","Mikaël","0631784099")) ;
		this.clients.add(new Client(10,"BRIATTE","Guillaume","0628365347")) ;
		this.clients.add(new Client(11,"COESNOM","Florian","0696784358")) ;
		this.clients.add(new Client(12,"HURON","Kévin","0721011728")) ;
		this.clients.add(new Client(13,"JACQUIER","Nicolas","0606293623")) ;
		this.clients.add(new Client(14,"N'DIAYE","Mamadou","0630879007")) ;
		this.clients.add(new Client(15,"POIRIER","Nicolas","0657398079")) ;
		this.clients.add(new Client(16,"RAFINA","Dany","0638586890")) ;
		this.clients.add(new Client(17,"ROSCO","Steve","0620184981")) ;
		this.clients.add(new Client(18,"UZAN","Alexis","0667838291")) ;
		this.clients.add(new Client(19,"WELLE","Guillaume","0659023320")) ;
		
	}
	
	/** Rechercher un utilisateur par son nom de connexion et son mot de passe
	 * 
	 * @param login Le nom de connexion de l'utilisateur
	 * @param mdp Le mot de passe de l'utilisateur
	 * @return L'utilisateur ou null si le nom de connexion et/ou le mot de passe sont incorrects
	 */
	public Utilisateur getUtilisateur(String login, String mdp){
		System.out.println("ModeleLocavek::getUtilisateur()") ;
		Utilisateur utilisateur = null ;
		int i = 0 ;
		while(i < this.utilisateurs.size() && utilisateur == null){
			if( this.utilisateurs.get(i).getLogin().equals(login) &&
					this.utilisateurs.get(i).getMdp().equals(mdp)){
				utilisateur = this.utilisateurs.get(i) ;
			}
			else {
				i = i + 1 ;
			}
		}
		return utilisateur ;
	}
	
	
	/** Obtenir la liste des locations
	 * 
	 * @return La liste des locations
	 */
	
//	public List<Location> getLocations(){
//		System.out.println("ModeleLocavek::getLocations()") ;
//		return this.locations ;
//	}
	
	
	
	public List<Location> getLocations() {
		System.out.println("ModeleLocavek::getLocations()") ;
		
		List<Location> lesLocations = new ArrayList<Location>() ;
		Map<Integer, Client> lesClients = new HashMap<Integer, Client>() ;
		Map<String, Vehicule> lesVehicules = new HashMap<String, Vehicule>() ;
		
		try {
			
			Connection connexion = ConnexionBD.getConnexion() ;
			Statement stmt = connexion.createStatement() ;
			String requete = "SELECT l.numLocation, l.depart, l.retourPrevu, l.retourEffectif, "
					+ "v.immatriculation, v.modele, v.annee, v.compteur, v.situation, "
					+ "c.numClient, c.nom, c.prenom, c.mobile "+"\n"
					+ "FROM Location AS l, Vehicule AS v, Client as c "+"\n"
					+ "WHERE v.immatriculation = l.immatriculation" + "\n"
					+ "AND c.numClient = l.numClient ;" ;
					
			ResultSet resultat = stmt.executeQuery(requete) ;
			
			while( resultat.next() ){
				
				//Client
				int numeroClient = resultat.getInt("c.numClient") ;
				Client unClient = lesClients.get(new Integer(numeroClient));
				if (unClient == null) {
					unClient = new Client() ;
					unClient.setNumero( numeroClient);
					unClient.setNom(resultat.getString("c.nom"));
					unClient.setPrenom(resultat.getString("c.prenom"));
					unClient.setMobile(resultat.getString("c.mobile"));
					lesClients.put(numeroClient ,unClient) ;
				}
				
				//Vehicule
				String immatriculation = resultat.getString("v.immatriculation") ;
				Vehicule unVehicule = lesVehicules.get(immatriculation);
				if (unVehicule == null) {
					unVehicule = new Vehicule() ;
					unVehicule.setImmatriculation( immatriculation);
					unVehicule.setModele(resultat.getString("v.modele"));
					unVehicule.setAnnee(resultat.getInt("v.annee"));
					unVehicule.setCompteur(resultat.getInt("v.compteur"));
					unVehicule.setSituation(resultat.getInt("v.situation"));
					lesVehicules.put(immatriculation, unVehicule) ;
				}	
				
				//Location
				Location uneLocation = new Location() ;
				uneLocation.setNumero(resultat.getInt("l.numLocation"));
					//DateDepart
				Date dateDepart = resultat.getDate("l.depart") ;
				uneLocation.setDateDepart(new DateFR(dateDepart.getDate(), dateDepart.getMonth()+1,dateDepart.getYear()));
				
					//RetourPrevu
				Date retourPrevu = resultat.getDate("l.retourPrevu") ;
				uneLocation.setDateRetourPrevue(new DateFR(retourPrevu.getDate(), retourPrevu.getMonth()+1,retourPrevu.getYear()));
				
					//RetourEffectif
				Date retourEffectif = resultat.getDate("l.retourEffectif") ;
				if(retourEffectif != null){
					uneLocation.setDateRetourEffective(new DateFR(retourEffectif.getDate(), retourEffectif.getMonth()+1,retourEffectif.getYear()));
				}
				
				uneLocation.setClient(unClient);
				uneLocation.setVehicule(unVehicule);
				
				lesLocations.add(uneLocation) ;
			}
			
			resultat.close() ;
			stmt.close() ;
			
			return lesLocations ;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException") ;
		}
		catch(InstantiationException e){
			System.out.println("InstantiationException") ;
		}
		catch(IllegalAccessException e){
			System.out.println("IllegalAccessException") ;
		}
		catch(SQLException e){
			System.out.println("SQLException") ;
		}
		
		return lesLocations ;
	}
	
	
	/** Obtenir la liste des clients
	 * 
	 * @return La liste des clients
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	/*
	public List<Client> getClients(){
		System.out.println("ModeleLocavek::getClients()") ;
		return this.clients ;
	}
	*/
	
	public List<Client> getClients() {
		System.out.println("ModeleLocavek::getClients()") ;
		
		List<Client> lesClients = new ArrayList<Client>() ;
		try {
			
			Connection connexion = ConnexionBD.getConnexion() ;
			Statement stmt = connexion.createStatement() ;
			String requete = "SELECT numClient, nom, prenom, mobile from Client ;" ;
			ResultSet resultat = stmt.executeQuery(requete) ;
			
			while( resultat.next() ){
				Client unClient = new Client() ;
				unClient.setNumero( resultat.getInt("numclient"));
				unClient.setNom(resultat.getString("nom"));
				unClient.setPrenom(resultat.getString("prenom"));
				unClient.setMobile(resultat.getString("mobile"));
				lesClients.add(unClient) ;
				
			}
			
			resultat.close() ;
			stmt.close() ;
			
			return lesClients ;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException") ;
		}
		catch(InstantiationException e){
			System.out.println("InstantiationException") ;
		}
		catch(IllegalAccessException e){
			System.out.println("IllegalAccessException") ;
		}
		catch(SQLException e){
			System.out.println("SQLException") ;
		}
		
		return lesClients ;
	}
	
	
	/** Obtenir la liste des véhicules
	 * 
	 * @return La liste des véhicules
	 */
	/*
	public List<Vehicule> getVehicules(){
		System.out.println("ModeleLocavek::getVehicules()") ;
		return this.vehicules ;
	}
	*/
	public List<Vehicule> getVehicules() {
		System.out.println("ModeleLocavek::getVehicules()") ;
		
		List<Vehicule> lesVehicules = new ArrayList<Vehicule>() ;
		try {
			
			Connection connexion = ConnexionBD.getConnexion() ;
			Statement stmt = connexion.createStatement() ;
			String requete = "SELECT immatriculation, modele, annee, compteur, situation from Vehicule ;" ;
			ResultSet resultat = stmt.executeQuery(requete) ;
			
			while( resultat.next() ){
				Vehicule unVehicule = new Vehicule() ;
				unVehicule.setImmatriculation( resultat.getString("immatriculation"));
				unVehicule.setModele(resultat.getString("modele"));
				unVehicule.setAnnee(resultat.getInt("annee"));
				unVehicule.setCompteur(resultat.getInt("compteur"));
				unVehicule.setSituation(resultat.getInt("situation"));
				lesVehicules.add(unVehicule) ;
				
			}
			
			resultat.close() ;
			stmt.close() ;
			
			return lesVehicules ;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException") ;
		}
		catch(InstantiationException e){
			System.out.println("InstantiationException") ;
		}
		catch(IllegalAccessException e){
			System.out.println("IllegalAccessException") ;
		}
		catch(SQLException e){
			System.out.println("SQLException") ;
		}
		
		return lesVehicules ;
	}
	
	
	/** Enregistrer une nouvelle location
	 * @param vehicule Le véhicule
	 * @param client Le client
	 * @param dateRetourPrevue La date de retour prévue
	 */
	
//	public Location ajouterLocation(Vehicule vehicule, Client client, DateFR dateRetourPrevue){
//		System.out.println("ModeleLocavek::ajouterLocation()") ;
//		DateFR dateDepart = new DateFR() ;
//		int numero = this.genererNumeroLocation() ;
//		Location location = new Location(numero,vehicule,client,dateDepart,dateRetourPrevue) ;
//		this.locations.add(location) ;
//		vehicule.setSituation(Vehicule.LOUE);
//		return location ;
//	}
	
	public Location ajouterLocation(Vehicule vehicule, Client client, DateFR dateRetourPrevue){
		System.out.println("ModeleLocavek::ajouterLocation()") ;
		
		DateFR dateDepart = new DateFR() ;
		int numero = this.genererNumeroLocation() ;
		Location location = new Location(numero,vehicule,client,dateDepart,dateRetourPrevue) ;
		
		try {
			Connection connexion = ConnexionBD.getConnexion() ;
			
			Statement stmt = connexion.createStatement() ;
			String requete = "INSERT INTO Location(numLocation, depart, retourPrevu, immatriculation, numClient) "
					+ "VALUES("+ numero +",'" + dateDepart.toStringEN() + "','" + dateRetourPrevue.toStringEN() +"','"+vehicule.getImmatriculation() +"',"+client.getNumero() + ") ;" ;
			int nb = stmt.executeUpdate(requete) ;
			System.out.println(nb) ;
			
			
			Statement stmt2 = connexion.createStatement() ;
			String requete2 = "UPDATE Vehicule SET situation = 2 WHERE immatriculation = '"+vehicule.getImmatriculation()+"' ;" ;
			System.out.println(requete2);
			int nb2 = stmt.executeUpdate(requete2) ;
			System.out.println(nb2) ;
			
			
			
			return location ;
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException") ;
		}
		catch(InstantiationException e){
			System.out.println("InstantiationException") ;
		}
		catch(IllegalAccessException e){
			System.out.println("IllegalAccessException") ;
		}
		catch(SQLException e){
			System.out.println("SQLException") ;
		}
	
		return null ;
	
	}
	
	/** Enregistrer un nouveau client
	 * 
	 * @param nom Le nom
	 * @param prenom Le prénom
	 * @param mobile Le numéro de mobile
	 */
	/*
	public void ajouterClient(String nom, String prenom, String mobile){
		System.out.println("ModeleLocavek::ajouterClient()") ;
		int numero = genererNumeroClient() ;
		Client client = new Client(numero,nom,prenom,mobile) ;
		this.clients.add(client) ;
		System.out.println(client.toString()) ;
	}
	*/
	public void ajouterClient(String nom, String prenom, String mobile){
		System.out.println("ModeleLocavek::ajouterClient()") ;
		
		try {
			Connection connexion = ConnexionBD.getConnexion() ;
			
			

			Statement stmt = connexion.createStatement() ;
			String requete = "INSERT INTO Client(nom, prenom, mobile) "
					+ "VALUES('"+ nom +"','" + prenom + "','" + mobile + "') ;" ;
			int nb = stmt.executeUpdate(requete) ;
			System.out.println(nb) ;	
		}
		catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException") ;
		}
		catch(InstantiationException e){
			System.out.println("InstantiationException") ;
		}
		catch(IllegalAccessException e){
			System.out.println("IllegalAccessException") ;
		}
		catch(SQLException e){
			System.out.println("SQLException") ;
		}
	
	
	
	}	
	
	
	/** Générer un numéro unique de client
	 * 
	 * @return Le numéro de client
	 */
	private int genererNumeroClient(){
		System.out.println("ModeleLocavek::genererNumeroClient()") ;
		int numMax = 0 ;
		for(Client client : this.clients){
			if(client.getNumero() > numMax){
				numMax = client.getNumero() ;
			}
		}
		return numMax + 1 ;
	}
	
	/** Générer un numéro unique de location
	 * 
	 * @return Le numéro de location
	 */
	public int genererNumeroLocation(){
		System.out.println("ModeleLocavek::genererNumeroLocation()") ;
		int numMax = 0 ;
		
		for(Location location : this.getLocations()){
			if(location.getNumero() > numMax){
				numMax = location.getNumero() ;
			}
		}

		return numMax + 1 ;
	}
	
	
	/** Rechercher un client par son numéro
	 * 
	 * @param numero Le numéro du client
	 * @return Le client ou null si le client n'est pas recensé
	 */
	
	public Client getClient(int numero){
		System.out.println("ModeleLocavek::getClient()") ;
		Client client = null ;
		int i = 0 ;
		while(i < this.clients.size() && client == null){
			if(this.clients.get(i).getNumero() == numero){
				client = this.clients.get(i) ;
			}
			else {
				i += 1 ;
			}
		}
		return client ;
	}
	
	
	/** Rechercher une location par son numéro
	 * 
	 * @param numero Le numéro de la location
	 * @return La location ou null si la location n'existe pas
	 */
	private Location getLocation(int numero){
		System.out.println("ModeleLocavek::getLocation()") ;
		Location location = null ;
		int i = 0 ;
		while(i < this.locations.size() && location == null){
			if(this.locations.get(i).getNumero() == numero){
				location = this.locations.get(i) ;
			}
			else {
				i += 1 ;
			}
		}
		return location ;
	}
	
	/** Rechercher un véhicule par son immatriculation
	 * 
	 * @param immatriculation L'immatriculation du véhicule
	 * @return Le véhicule ou null si le véhicule n'est pas recensé
	 */
	private Vehicule getVehicule(String immatriculation){
		System.out.println("ModeleLocavek::getVehicule()") ;
		Vehicule vehicule = null ;
		for(Vehicule unVehicule : this.vehicules){
			if(unVehicule.getImmatriculation().equals(immatriculation)){
				vehicule = unVehicule ;
			}
		}
		return vehicule ;
	}
	
	/** Obtenir la liste des locations en cours
	 * 
	 * @return La liste des locations en cours
	 */
	public List<Location> getLocationsEnCours(){
		System.out.println("ModeleLocavek::getLocationsEnCours()") ;
		List<Location> locationsEnCours = new ArrayList<Location>() ;
		for(Location location : this.locations){
			if(location.estEnCours()){
				locationsEnCours.add(location) ;
			}
		}
		return locationsEnCours ;
	}
	
	/** Obtenir la liste des véhicules disponibles
	 * 
	 * @return La liste des véhicules disponibles
	 */
	public List<Vehicule> getVehiculesDisponibles(){
		System.out.println("ModeleLocavek::getVehiculesDisponibles()") ;
		List<Vehicule> vehiculesDisponibles = new ArrayList<Vehicule>() ;
		for(Vehicule vehicule : this.vehicules){
			if(vehicule.estDisponible()){
				vehiculesDisponibles.add(vehicule) ;
			}
		}
		return vehiculesDisponibles ;
	}
	
	/** Supprimer une location
	 * 
	 * @param numero Le numéro de la location
	 * @return true si la suppression de la location s'est déroulée avec succès et false dans le cas contraire
	 */
	public boolean supprimerLocation(int numero){
		System.out.println("ModeleLocavek::supprimerLocation()") ;
		Location location = getLocation(numero) ;
		if(location != null){
			location.getVehicule().setSituation(Vehicule.DISPONIBLE) ;
			this.locations.remove(location) ;
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Enregistrer le retour d'un véhicule
	 * 
	 * @param numeroLocation Le numéro de la location
	 * @param nombreKm Le nombre de kilomètres au compteur
	 * @return true si l'enregistrement s'est déroulé avec succès et false dans le cas contraire
	 */
	public boolean enregistrerRetourVehicule(int numeroLocation, int nombreKm){
		System.out.println("ModeleLocavek::enregistrerRetourVehicule()") ;
		Location location = getLocation(numeroLocation) ;
		if(location != null){
			location.setDateRetourEffective(new DateFR()) ;
			location.getVehicule().setSituation(Vehicule.DISPONIBLE) ;
			location.getVehicule().setCompteur(nombreKm) ;
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.println("ModeleLocations::toString()") ;
		return "MetierLocations [locations=" + locations + "]";
	}
	
}
