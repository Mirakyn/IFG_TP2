package model;
import java.util.ArrayList;

import server.Serveur;

public class Membre {
	// Attributs
	private String mail;
	private String nom;
	
	// Constructeurs
	/**
	 * Default constructor
	 */
	public Membre (){
		// Nothing to do
	}
	
	/**
	 * Creer un membre avec son email et son nom
	 * @param mail : email du membre.
	 * @param nom : nom du membre
	 */
	public Membre (String mail, String nom){
		this.mail = mail;
		this.nom = nom;
	}
	
	// Méthodes
	
	// Setter & Getter
	public String getMail() {
		return this.mail;
	}
	
	public String getNom (){
		return this.nom;
	}
}
