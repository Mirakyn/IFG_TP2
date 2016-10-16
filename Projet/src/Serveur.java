import java.net.Socket;

public class Serveur {
	// Attributs
	private String adresse_Serveur;
	private int port_Serveur;
	private Socket application_Socket;
	
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
		
		if (!connect())
			System.out.println("Error to connect");
	}
	
	// Méthodes
	/**
	 * Used to connect to the distant server
	 * @return True if the connect succed or False if it's failed
	 */
	public boolean connect (){
		return false;
	}
	
	/**
	 * Used to send information to the user application
	 * @param bytes to send
	 */
	public void send (byte[] toSend){
		
	}
	
	
	/**
	 * Used to send serealized information to the user application
	 */
	public void send (){
		
	}
	
	/**
	 * Used to received information from the user application
	 */
	public void received (){
		
	}
}
