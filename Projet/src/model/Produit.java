package model;

public class Produit {
	//Attributes
	private int id_Produit;
	private String name;
	private float price;
	private int quantite;
	private String description;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public Produit (){
		//nothing to do
	}
	
	/**
	 * 
	 * @param name
	 * @param price
	 * @param quantite
	 */
	public Produit (int id_Produit, String name, float price, int quantite, String description){
		this.id_Produit = id_Produit;
		this.name = name;
		this.price =  price;
		this.quantite = quantite;
		this.description = description;
	}
	
	//Functions
	
	//Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId_Produit() {
		return id_Produit;
	}

	public void setId_Produit(int id_Produit) {
		this.id_Produit = id_Produit;
	}
	
}
