package view;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Membre;
import server.Serveur;

public class Interface_login extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// UI elements
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtMdp;

	// Server reference
	private Serveur serveur;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_login frame = new Interface_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame and init elements.
	 */
	public Interface_login(Serveur serveur) {
		// Reference the server
		this.serveur = serveur;
		
		// Init the Frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Login button
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setHorizontalTextPosition(SwingConstants.LEADING);
		btnLogIn.setAutoscrolls(true);
		btnLogIn.setBounds(170, 123, 89, 23);
		contentPane.add(btnLogIn);
		
		btnLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Membre membreConnecte = loginAccepter(txtEmail.getText(), txtMdp.getText());
				if (membreConnecte != null)
					System.out.println(membreConnecte.getMail() + " - " + membreConnecte.getNom() + " is Logged in");
				else
					System.out.println("Non login");
			}
		});
		
		
		// Signin button
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(170, 157, 89, 23);
		contentPane.add(btnSignIn);
		
		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : Lancer interface inscription ici
			}
		});
		
		
		// Login textfield
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(56, 72, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		// Password textfield
		txtMdp = new JPasswordField();
		txtMdp.setHorizontalAlignment(SwingConstants.CENTER);
		txtMdp.setBounds(282, 72, 86, 20);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		
		// Labels
		JLabel lblLogin = new JLabel("Email");
		lblLogin.setBounds(56, 53, 61, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(282, 53, 100, 14);
		contentPane.add(lblPassword);
	}
	
	/**
	 * Hash the password to send to server
	 * @param password to hash
	 * @return password hashed
	 */
	private String hash_Password (String password){
		
		String hashed_Password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
		
		return hashed_Password;
	}
	
	private Membre loginAccepter(String login, String password)
	{
		boolean estMembre = false;
		boolean passwordOK = false;
		
		Membre membre = null;
		
		String BDpassword = "";
		String BDnom = "";
		String BDmail = "";
		
		// Connection au serveur
		if (this.serveur.connect("dev", "&8IFG145!") == null) {
			System.out.println("Erreur Connection");
			return null;
		}
		else
		{
			System.out.println("Connecté");
		}
		
		// Preparation de la requete
	    String query = "SELECT nom_Membre, mail_Membre, password_Membre \n" +
	                   "FROM trolley.Membre \n" +
	                   "WHERE mail_Membre = '" + login + "'";
	    
	    // Envoi de la requete
	    ResultSet rs = serveur.ask(query);
	    
        try {
        	// false si pas de resultat, true sinon.
        	estMembre = rs.first();
			
			if (estMembre) // Si le resutat existe, memoriser le mot de passe.
			{
				// Recuperation des attribut dans la BD
				BDmail = rs.getString("mail_Membre");
				BDnom = rs.getString("nom_Membre");
				BDpassword = rs.getString("password_Membre");
				
				// Creation du membre
	        	membre = new Membre(BDmail, BDnom);
			}
			else // Si le resultat n'esite pas, le membre n'a pas ete trouve.
			{
				System.out.println("Non Membre");
	        	return null;
			}
			
			// Verification du mot de passe.
			passwordOK = BDpassword.equals(hash_Password(password));
			
			// Si le mot de passe est correct.
			if (passwordOK)
				return membre;
			else // Si le mot de passe ne correspond pas.
		    {
		    	System.out.println("Mauvais MDP");
	        	return null;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return null;
	}
}
