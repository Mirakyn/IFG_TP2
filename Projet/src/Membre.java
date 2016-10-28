import java.util.ArrayList;

import model.Groupe;
import server.Serveur;

public class Membre {
	// Attributs
	private String nom_Membre;
	private ArrayList<Groupe> groupes;
	
	private Serveur serveur;
	
	// Constructeurs
	/**
	 * Default constructor
	 */
	public Membre (){
		// Nothing to do
	}
	
	/**
	 * 
	 * @param nom_Membre
	 * @param groupes
	 * @param serveur
	 */
	public Membre (String nom_Membre, ArrayList<Groupe> groupes, Serveur serveur){
		this.nom_Membre = nom_Membre;
		this.groupes = groupes;
		
		this.serveur = serveur;
		
	}
	
	// Méthodes
	
	
	// Setter & Getter
	public String get_Nom_Membre (){
		return this.nom_Membre;
	}
	
	public ArrayList<Groupe> get_Groupes (){
		return this.groupes;
	}
	
	public void add_Groupe (Groupe toAdd){
		this.groupes.add(toAdd);
	}
	
	public Groupe get_Groupe (){
		return new Groupe(); // TODO: A changer pour trouver le grp demandé
	}
}
