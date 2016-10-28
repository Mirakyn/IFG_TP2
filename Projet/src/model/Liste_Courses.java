package model;

public class Liste_Courses {
	private int id;
	private int idGroupe;
	private String nom;
	
	public Liste_Courses(int id, int idGroupe, String nom)
	{
		this.id = id;
		this.idGroupe = idGroupe;
		this.nom = nom;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getIDgroupe() {
		return this.idGroupe;
	}
	
	public String getNom() {
		return this.nom;
	}
}
