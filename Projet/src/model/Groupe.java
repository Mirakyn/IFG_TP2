package model;

public class Groupe {
	private int id;
	private String nom;
	
	public Groupe(int id, String nom)
	{
		this.id = id;
		this.nom = nom;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getNom()
	{
		return this.nom;
	}
}
