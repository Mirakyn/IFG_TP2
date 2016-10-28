package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import server.Serveur;

public class Interface_login extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// UI elements
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtMdp;

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
				if (loginAccepter(txtLogin.getText(), txtMdp.getText()))
					System.out.println("Login");
				else
					System.out.println("Non login");
			}
		});
		
		
		// Signin button
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(170, 157, 89, 23);
		contentPane.add(btnSignIn);
		
		
		// Login textfield
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(56, 72, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		
		// Password textfield
		txtMdp = new JTextField();
		txtMdp.setHorizontalAlignment(SwingConstants.CENTER);
		txtMdp.setBounds(282, 72, 86, 20);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		
		// Labels
		JLabel lblLogin = new JLabel("Username");
		lblLogin.setBounds(56, 53, 61, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(282, 53, 46, 14);
		contentPane.add(lblPassword);
	}
	
	private boolean loginAccepter(String login, String password)
	{
		boolean estMembre = false;
		boolean passwordOK = false;
		String BDpassword = "";
		
		// Connection au serveur
		if (this.serveur.connect("dev", "&8IFG145!") == null) {
			System.out.println("Erreur Connection");
			return false;
		}
		else
			System.out.println("Connecté");
		
		// Preparation de la requete
	    String query = "SELECT mail_Membre, password_Membre \n" +
	                   "FROM trolley.Membre \n" +
	                   "WHERE mail_Membre = '" + login + "'";
	    
	    // Envoi de la requete
	    ResultSet rs = serveur.ask(query);
	    
        try {
        	// false si pas de resultat, true sinon.
        	estMembre = rs.first();
			
			if (estMembre) // Si le resutat existe, memoriser le mot de passe.
	        	 BDpassword = rs.getString("password_Membre");
			else // Si le resultat n'esite pas, le membre n'a pas ete trouve.
			{
				System.out.println("Non Membre");
	        	return false;
			}
			
			// Verification du mot de passe.
			passwordOK = BDpassword.equals(password);
			
			// Si le mot de passe est correct.
			if (passwordOK)
				return true;
			else // Si le mot de passe ne correspond pas.
		    {
		    	System.out.println("Mauvais MDP");
	        	return false;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return false;
	}
}
