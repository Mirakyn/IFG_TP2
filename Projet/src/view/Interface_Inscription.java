package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.Serveur;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Interface_Inscription extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	// Server reference
	private Serveur serveur;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Interface_Inscription dialog = new Interface_Inscription(new Serveur("trolley.yolo.cat", 3306));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Interface_Inscription(Serveur serveur) {
		// Reference the server
		this.serveur = serveur;
		
		//Init Frame
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(233, 57, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 88, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 119, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 150, 86, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(233, 181, 86, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setMinimumSize(new Dimension(55, 100));
		lblUsername.setMaximumSize(new Dimension(100, 14));
		lblUsername.setPreferredSize(new Dimension(100, 20));
		lblUsername.setBounds(123, 60, 68, 14);
		contentPanel.add(lblUsername);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(123, 91, 46, 14);
		contentPanel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(123, 122, 68, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblPasswordConfirm = new JLabel("Password confirm :");
		lblPasswordConfirm.setBounds(123, 153, 100, 14);
		contentPanel.add(lblPasswordConfirm);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(123, 184, 68, 14);
		contentPanel.add(lblEmail);
		
		JLabel lblInscription = new JLabel("Registration");
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setBounds(189, 11, 86, 20);
		contentPanel.add(lblInscription);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sign In");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener (){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						create_User ();
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener (){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// set empty fields
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
						// back to sign up
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Check the empty fields in the interface.
	 * @return True if empty field(s) exist. False if none
	 */
	private boolean check_Empty_Fields (){
		if (textField.getText().isEmpty()){
			return true;
		}
		else if (textField_1.getText().isEmpty()){
			return true;
		}
		else if (textField_2.getText().isEmpty()){
			return true;
		}
		else if (textField_3.getText().isEmpty()){
			return true;
		}
		else if (textField_4.getText().isEmpty()){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Check the password to send
	 * @return True if password is correct, false if it isn't
	 */
	private boolean check_Password (){
		if (textField_2.getText().contentEquals(textField_3.getText())){
			return true;
		}
		return false;
	}
	
	/**
	 * Check if the mail is existing in the data base
	 * @return false if don't exist in data base. True if it is
	 */
	private boolean check_Mail (){
		//Ask the data base
		String mail = textField_4.getText();
    	boolean result = false;
		
		String query = 	"SELECT mail_Membre \n" +
						"FROM trolley.Membre \n" +
						"WHERE mail_Membre = '" + mail + "'";

	    ResultSet rs = this.serveur.ask(query);
		
		//Check the data base return
	    try{	    	
			if (rs.first()){
				result = true;
			}
			
			this.serveur.endTransaction();
			return result;
	    }
	    catch (SQLException e){
	    	return true;
	    }
	}
	
	private String hash_Password (){
		String password = textField_2.getText();
		
		String hashed_Password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
		
		return hashed_Password;
	}
	
	private boolean insert_Membre (){
		//Ask the data base
		String name = textField_1.getText();
		String password = hash_Password();
		String mail = textField_4.getText();
    	boolean result = false;
		
		String query = 	"INSERT INTO trolley.Membre " +
						"VALUES ('" + mail + "', " +
						"'" + name + "', " +
						"'" + password + "', " +
						" NOW() )";

		this.serveur.insert(query);
		this.serveur.endTransaction();
		if (!check_Mail()){
			result = false;
		}
		return true;
	}
	
	/**
	 * Create the user in the data base
	 * @return false if the user coudn't be added. True if it's ok
	 */
	private boolean create_User (){
		// Check if there is some empty fields. return false and don't create user if empty fields exist
		if (check_Empty_Fields()){
			System.out.println("All fields needs to be completed to SIGN IN");
			return false;
		}
		System.out.println("No empty fields -> get continue");
		
		//Check password
		if (!check_Password()){
			System.out.println("Password is not correct");
			return false;
		}
		System.out.println("Password is correct");
		
		//Connection to the data abse server
		if (this.serveur.connect("dev", "&8IFG145!") == null) {
			System.out.println("Erreur Connection");
			return false;
		}
		else
			System.out.println("Connecté");
		
		// Check if mail is already used. don't create the user if already in data base
		if (check_Mail()){
			System.out.println("This mail is already used by another member");
			this.serveur.endConnection();
			return false;
		}
		System.out.println("Mail free -> can create new membre");
		
		//Send SQL insert to data base to create the new user
		if (!insert_Membre ()){
			System.out.println("Membre isn't added to data based - retry");
			this.serveur.endConnection();
			return false;
		}
		System.out.println("Membre added to data base");
		
		this.serveur.endConnection();
		return true;
	}
}
