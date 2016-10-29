package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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

import model.Groupe;
import model.Liste_Courses;
import model.Membre;
import server.Serveur;

public class Interface_groupe extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JList<String> listeGroupe, listeMembre, listeListe;
	
	private Serveur serveur;
	private Membre membre;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_groupe frame = new Interface_groupe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Interface_groupe(final Serveur serveur, final Membre membre) {
		final ArrayList<Groupe> groupes = new ArrayList<Groupe>();
		final ArrayList<Liste_Courses> listes = new ArrayList<Liste_Courses>();
		final ArrayList<Membre> membres = new ArrayList<Membre>();
		
		this.serveur = serveur;
		this.membre = membre;
		
		// Connection a la BDD
		if (this.serveur.connect("dev", "&8IFG145!") == null) {
			System.out.println("Erreur Connection");
		}
		
		// Recuperer les groupes du membre
	    String query = "SELECT * \n" +
	                   "FROM trolley.Contribuer NATURAL JOIN trolley.Groupe \n" +
	                   "WHERE id_Membre = '" + this.membre.getMail() + "'";
	    
	    // Envoi de la requete
	    ResultSet rs = serveur.ask(query);
	    
	    try {
	    	int BDid;
	    	String BDnom = "";
	    	
	    	while (rs.next())
	    	{
	    		BDid = rs.getInt("id_Groupe");
	    		BDnom = rs.getString("nom_Groupe");
	    		groupes.add(new Groupe(BDid, BDnom));
	    		//System.out.println("Groupe " + groupes.get(groupes.size() - 1).getNom() + " chargé");
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    // Fin de la requete
	    this.serveur.endTransaction();
	    this.serveur.endConnection();
	    
	    
		// Init interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(20, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.WEST);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setMaximumSize(new Dimension(20, 20));
		splitPane_1.setPreferredSize(new Dimension(200, 10));
		splitPane_1.setMinimumSize(new Dimension(187, 25));
		splitPane.setRightComponent(splitPane_1);
		
		JButton button = new JButton("New Group");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		button.setPreferredSize(new Dimension(93, 15));
		button.setMinimumSize(new Dimension(75, 10));
		button.setMaximumSize(new Dimension(100, 10));
		splitPane_1.setLeftComponent(button);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAddGroup.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnAddGroup.setPreferredSize(new Dimension(45, 5));
		splitPane_1.setRightComponent(btnAddGroup);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_2);
		
		/*final JList<String>*/ listeGroupe = new JList<String> ();
		listeGroupe.setPreferredSize(new Dimension(0, 175));
		listeGroupe.setSize(new Dimension(0, 25));
		listeGroupe.setMaximumSize(new Dimension(0, 10));
		listeGroupe.setMinimumSize(new Dimension(0, 175));
		listeGroupe.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			
			public int getSize() {
				return groupes.size();
			}
			
			// Affiche les nom des groupe du membre
			public String getElementAt(int index) {
				return groupes.get(index).getNom();
			}
		});
		
		// Appeller lorsque la selection de la liste change.
		listeGroupe.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				// Connection a la BDD
				if (serveur.connect("dev", "&8IFG145!") == null) {
					System.out.println("Erreur Connection");
				}
				
				// Vider liste precedente
				listes.clear();
				membres.clear();
				
				// ID du groupe selectionne
				int groupeID = groupes.get(listeGroupe.getSelectedIndex()).getID();
				
				// Recuperer les listes du groupe selectionné
			    String query = "SELECT * \n" +
			                   "FROM trolley.Liste \n" +
			                   "WHERE id_Groupe = " + groupeID;
			    
			    // Envoi de la requete
			    ResultSet rs = serveur.ask(query);
			    
			    try {
			    	int BDid;
			    	int BDidGroupe;
			    	String BDnom = "";
			    	
			    	while (rs.next())
			    	{
			    		BDid = rs.getInt("id_Liste");
			    		BDidGroupe = rs.getInt("id_Groupe");
			    		BDnom = rs.getString("nom_Liste");
			    		listes.add(new Liste_Courses(BDid, BDidGroupe, BDnom));
			    		System.out.println("Liste " + listes.get(listes.size() - 1).getNom() + " chargé");
			    	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			    
			    // Fin de la requete
			    serveur.endTransaction();
			    
			    // Mise a jour de la list
			    listeListe.setModel(new AbstractListModel<String>() {
					private static final long serialVersionUID = 1L;
					
					public int getSize() {
						return listes.size();
					}
					public String getElementAt(int index) {
						return listes.get(index).getNom();
					}
				});
			    
			    // Recuperer les listes du groupe selectionné
			    query = 	"SELECT mail_Membre, nom_Membre \n" +
			                "FROM trolley.Groupe AS g, trolley.Contribuer AS c, trolley.Membre AS m \n" +
			                "WHERE g.id_Groupe = c.id_Groupe AND " +
			                "c.id_membre = m.mail_Membre AND " +
			                "g.id_Groupe = " + groupeID + " AND " +
			                "m.mail_Membre != '" + membre.getMail() + "'";
			    
			    // Envoi de la requete
			    rs = serveur.ask(query);
			    
			    try {
			    	String BDmail = "";
			    	String BDnom = "";
			    	
			    	while (rs.next())
			    	{
			    		BDmail = rs.getString("mail_Membre");
			    		BDnom = rs.getString("nom_Membre");
			    		membres.add(new Membre(BDmail, BDnom));
			    		System.out.println("Membre du groupe " + membres.get(membres.size() - 1).getNom() + " chargé");
			    	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			    
			    serveur.endTransaction();
			    
			    // Mise a jour de la liste
			    listeMembre.setModel(new AbstractListModel<String>() {
					private static final long serialVersionUID = 1L;
					
					public int getSize() {
						return membres.size();
					}
					public String getElementAt(int index) {
						return membres.get(index).getNom();
					}
				});
			    
			    serveur.endConnection();
			}
		});
		splitPane_2.setRightComponent(listeGroupe);
		
		JLabel lblGroupesAssocis = new JLabel("Associated Groups");
		lblGroupesAssocis.setPreferredSize(new Dimension(100, 14));
		lblGroupesAssocis.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_2.setLeftComponent(lblGroupesAssocis);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGestionDesGroupes = new JLabel("Gestion des groupes");
		panel.add(lblGestionDesGroupes);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_3, BorderLayout.EAST);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setLeftComponent(splitPane_5);
		
		JLabel lblNewLabel = new JLabel("Members list\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		splitPane_5.setLeftComponent(lblNewLabel);
		
		/*JList<String>*/ listeMembre = new JList<String>();
		listeMembre.setPreferredSize(new Dimension(100, 175));
		listeMembre.setMaximumSize(new Dimension(2000, 2000));
		listeMembre.setMinimumSize(new Dimension(100, 175));
		listeMembre.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			
			String[] values = new String[] {"", "", "", ""};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_5.setRightComponent(listeMembre);
		
		JButton btnNewList = new JButton("New List");
		splitPane_3.setRightComponent(btnNewList);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane_4, BorderLayout.CENTER);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setLeftComponent(splitPane_6);
		
		JLabel lblunknown = new JLabel("*unknown*");
		lblunknown.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_6.setLeftComponent(lblunknown);
		
		/*JList<String>*/ listeListe = new JList<String>();
		listeListe.setPreferredSize(new Dimension(0, 175));
		listeListe.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			
			String[] values = new String[] {"", "", ""};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		splitPane_6.setRightComponent(listeListe);
		
		JButton btnCheckList = new JButton("Check List");
		splitPane_4.setRightComponent(btnCheckList);
	}

}
