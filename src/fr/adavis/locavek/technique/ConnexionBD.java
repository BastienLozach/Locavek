package fr.adavis.locavek.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	
	private static String dbURL = "jdbc:mysql://localhost/locavek" ;
	private static String user = "root" ;
	private static String password = "azerty" ;
	
	
	private static Connection connexion = null ;
	
	private ConnexionBD() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException  {
		super();
		Class.forName("com.mysql.jdbc.Driver").newInstance() ;
		
		connexion = DriverManager.getConnection(dbURL, user, password) ;
	}
	
	public static Connection getConnexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		if (connexion == null){
			new ConnexionBD() ;
		}
		return connexion ;
	
	}
	
}
