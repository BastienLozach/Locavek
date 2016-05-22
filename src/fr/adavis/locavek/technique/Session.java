package fr.adavis.locavek.technique;

public class Session {

	private static Session session = null ;
	private String login;
	
	private Session(String login){
		super();
		this.login = login ;
	}
	
	public static void ouvrirSession(String login){
		if(session == null){
			session = new Session(login) ;
		}
	}
	
	public static void fermerSession(){
		session = null ;
	}

	public static Session getSession() {
		return session;
	}

	public String getLogin() {
		return login;
	}
	
}
