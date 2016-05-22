package fr.adavis.locavek.entites;

/** Représenter un utilisateur
 * @author xilim
 *
 */
public class Utilisateur {

	private String login ;
	private String mdp ;
	
	/** Constructeur
	 * @param login Le nom de connexion
	 * @param mdp Le mot de passe
	 */
	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", mdp=" + mdp + "]";
	}
	
}
