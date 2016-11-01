package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Liste_Courses;
import model.Produit;
import server.Serveur;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;


public class Interface_Liste extends JPanel {
	
	// Server reference
	private Serveur serveur;
	
	private JList<String> list;
	private ArrayList<Produit> listes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	//Liste dans laquelle on est
	private int id_Liste;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Interface_Liste(Serveur serveur) {
		setSize(new Dimension(777, 488));
		
		this.serveur = serveur;
		setLayout(null);
		listes = new ArrayList<Produit> ();
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setSize(new Dimension(203, 30));
		splitPane_6.setPreferredSize(new Dimension(203, 30));
		splitPane_6.setBounds(61, 5, 704, 47);
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_6);
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_6.setRightComponent(splitPane_7);
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_7.setRightComponent(splitPane_8);
		
		JLabel lblGroupListProduct = new JLabel("Group List Product");
		lblGroupListProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupListProduct.setPreferredSize(new Dimension(142, 18));
		splitPane_8.setLeftComponent(lblGroupListProduct);
		
		JLabel lblProductDetail = new JLabel("Product Details");
		lblProductDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductDetail.setPreferredSize(new Dimension(72, 18));
		splitPane_8.setRightComponent(lblProductDetail);
		
		JLabel lblProductList = new JLabel("Product List");
		lblProductList.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductList.setPreferredSize(new Dimension(160, 18));
		splitPane_7.setLeftComponent(lblProductList);
		
		JLabel lblListManagement = new JLabel("List Management");
		lblListManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblListManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		splitPane_6.setLeftComponent(lblListManagement);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(62, 57, 162, 417);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane);
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setMinimumSize(new Dimension(0, 200));
		list.setMaximumSize(new Dimension(0, 200));
		list.setPreferredSize(new Dimension(0, 375));
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textField.setText(listes.get(list.getSelectedIndex()).getName());
				textField_1.setText(String.valueOf(listes.get(list.getSelectedIndex()).getPrice()));
				textField_3.setText(String.valueOf(listes.get(list.getSelectedIndex()).getQuantite()));
				textField_2.setText(listes.get(list.getSelectedIndex()).getDescription());
			}
		});
		
		splitPane.setLeftComponent(list);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setMinimumSize(new Dimension(200, 25));
		splitPane_1.setMaximumSize(new Dimension(200, 30));
		splitPane.setRightComponent(splitPane_1);
		
		JButton btnAdd = new JButton("Add");
		splitPane_1.setLeftComponent(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		splitPane_1.setRightComponent(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(376, 57, 389, 417);
		add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(157, 57, 200, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 88, 200, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 170, 200, 150);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 119, 200, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description :");
		lblNewLabel.setBounds(37, 238, 75, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity:");
		lblNewLabel_1.setBounds(37, 122, 75, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		lblNewLabel_2.setBounds(37, 91, 75, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setBounds(37, 60, 75, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(37, 375, 100, 31);
		panel_1.add(btnAdd_1);
		btnAdd_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AjoutProduit(textField.getText(),
							Float.valueOf(textField_1.getText()),
							Integer.valueOf(textField_3.getText()),
							textField_2.getText());
				
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(147, 375, 100, 30);
		panel_1.add(btnEdit);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(257, 375, 100, 30);
		panel_1.add(btnDelete_1);
		
		JList<String> list_2 = new JList<String>();
		list_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_2.setBounds(227, 57, 145, 417);
		add(list_2);
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setPreferredSize(new Dimension(0, 180));
		list_2.setMinimumSize(new Dimension(0, 175));
		list_2.setMaximumSize(new Dimension(0, 200));
		list_2.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {/*produit.getName(), produit.getPrice(), produit.getQuantite(), produit.getDescription()*/};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});

	}
	
	private void AjoutProduit (String name, float price, int qtt, String description){
		// Connection au serveur
		if (this.serveur.connect("dev", "&8IFG145!") == null) 
		{
			System.out.println("Erreur Connection");
		}
		else
		{
			System.out.println("Connecté");
		}
		
		// Preparation de la requete
	    String query = "INSERT INTO trolley.Produit (nom_Produit, prix_Produit, quantie_Produit, description_Produit)" +
	    				"VALUES ('" + name + "'," + price + "," + qtt + ",'" + description + "');";
	    serveur.insert(query);
	    this.serveur.endTransaction();
	    
	    int id_Produit = -1;
	    String query_2 = "SELECT id_Produit " +
	    				"FROM trolley.Produit " +
	    				"WHERE nom_Produit = '" + name + "' AND prix_Produit = " + price + " AND quantie_Produit = '" + qtt + "';";
	    ResultSet rs = serveur.ask(query_2);
	    try{
	    	rs.first();
	    	id_Produit = rs.getInt("id_Produit");
	    	System.out.println(id_Produit);
	    }catch (SQLException e){
	    	
	    }
	    this.serveur.endTransaction();
	    
	    String query_3 = "INSERT INTO trolley.Contenir (id_Produit, id_Liste)" +
				"VALUES (" + id_Produit + "," + id_Liste + ");";
	    serveur.insert(query_3);
	    
	    this.serveur.endTransaction();
	    this.serveur.endConnection();
	    
	    chargerListe (id_Liste);
	    
	}
	
	public void chargerListe (int id_Liste){
		// Connection au serveur
		this.id_Liste = id_Liste;
		if (this.serveur.connect("dev", "&8IFG145!") == null) 
		{
			System.out.println("Erreur Connection");
		}
		else
		{
			System.out.println("Connecté");
		}
		
		// Preparation de la requete
	    String query = "SELECT id_Produit, nom_Produit, prix_Produit, quantie_Produit, description_Produit \n" +
	    				"FROM trolley.Contenir NATURAL JOIN trolley.Produit \n" +
	    				"WHERE Contenir.id_Liste = " + id_Liste + ";";
	    
	    // Envoi de la requete
	    ResultSet rs = serveur.ask(query);
	    try{
	    	listes.clear();
		    while(rs.next())
		    {
		    	//rs.first();
			    final int id_Produit = rs.getInt("id_Produit");
			    final String nameProduct = rs.getString("nom_Produit");
			    final int priceProduct = rs.getInt("prix_Produit");
			    final int quantiteProduct = rs.getInt("quantie_Produit");
			    final String descriptionProduct = rs.getString("description_Produit");
		   
				listes.add(new Produit (id_Produit, nameProduct, priceProduct, quantiteProduct, descriptionProduct));
		    }
		    
		    list.setModel(new AbstractListModel<String>() {
				String[] values = new String[] {};
				public int getSize() {
					
					return listes.size();
				}
				public String getElementAt(int index) {
					return listes.get(index).getName();
				}
			});
		    
	    }catch (SQLException e){
	    	
	    }
	    
		serveur.endTransaction();
		serveur.endConnection();
				
	}
}




