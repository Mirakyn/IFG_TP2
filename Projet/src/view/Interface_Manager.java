package view;

import server.Serveur;

public class Interface_Manager {
	//Attributes
	private Serveur serveur;
	private Interface_login logging;
	private Interface_Applicative appli;
	
	public Interface_Manager (Serveur serveur){
		this.serveur = serveur;
		
		try {
			logging = new Interface_login(this, serveur);
			logging.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void log_In_User (){
		try {
			Interface_Applicative appli = new Interface_Applicative(this, serveur);
			appli.setVisible(true);
			logging.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void log_Out_User (){
		logging.setVisible(true);
		appli.setVisible(false);
		appli = null;
	}
}
