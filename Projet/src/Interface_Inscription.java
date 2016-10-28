package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Interface_Inscription dialog = new Interface_Inscription();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Interface_Inscription() {
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
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
