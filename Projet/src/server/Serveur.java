package server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Serveur {
	// Attributs
	private String adresse_Serveur;
	private int port_Serveur;
	//private Socket application_Socket;
	private Connection con;
	
	private Statement stmt = null;
	//Constructeurs
	/**
	 * Default constructor
	 */
	public Serveur (){
		
	}
	
	/**
	 * initialize the parametres of the distant server and try to connect
	 * @param adresse_Serveur
	 * @param port_Serveur
	 */
	public Serveur (String adresse_Serveur, int port_Serveur){
		this.adresse_Serveur = adresse_Serveur;
		this.port_Serveur = port_Serveur;
		
		/*this.con = connect("dev", "&8IFG145!");
		if (this.con == null)
			System.out.println("Erreur de connection");
		else
			System.out.println("Connect�");*/
	}
	
	// M�thodes
	/**
	 * Used to connect to the distant server
	 * @return True if the connect succed or False if it's failed
	 */
	public Connection connect (String DBuser, String DBpassword)
	{
		//Connection result = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", DBuser);
		connectionProps.put("password", DBpassword);
		
		try {
			this.con = DriverManager.getConnection(
			   "jdbc:mysql://" +
			   this.adresse_Serveur + ":" + 
			   this.port_Serveur + "/",
			   connectionProps);
			this.con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.con;
	}

	
	public ResultSet ask(String query)
	{
		this.stmt = null;
		ResultSet result = null;
		
		try {
			// Creation du 'statement'
			this.stmt = this.con.createStatement();
			
			// Execution de la requete
			result = this.stmt.executeQuery(query);
		} catch (SQLException e ) { // Echec de la requete
			e.printStackTrace();
			result = null;
		}
		
		return result;
	}
	
	public int insert(String query)
	{
		this.stmt = null;
		int result = 0;
		
		try {
			// Creation du 'statement'
	        this.stmt = this.con.createStatement();
	        
	        // Execution de la requete
	        result = this.stmt.executeUpdate(query);
		} catch (SQLException e ) { // Echec de la requete
	    	e.printStackTrace();
	    	result = 0;
		}
		
		return result;
	}
	
	public void endTransaction()
	{
		if (this.stmt != null) { 
        	// Fermeture du 'statement'
        	try {
        		this.stmt.close();
			} catch (SQLException e) { // Echec de fermeture
				e.printStackTrace();
			} 
        	
        	stmt = null;
        }
	}
	
	public void endConnection()
	{
		 if (this.con != null) {
			 // Fermeture de la connection
             try {
                 con.close();
             } catch (SQLException e) { // Echec de fermeture
            	 e.printStackTrace();
             }

             con = null;
             //System.out.println("Fin Connexion");
         }
	}
	
	public Connection getConnection()
	{
		return this.con;
	}
}
