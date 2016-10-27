import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;

public class Interface_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public Interface_login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setHorizontalTextPosition(SwingConstants.LEADING);
		btnLogIn.setAutoscrolls(true);
		btnLogIn.setBounds(170, 123, 89, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblLogin = new JLabel("Username");
		lblLogin.setBounds(56, 53, 61, 14);
		contentPane.add(lblLogin);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(170, 157, 89, 23);
		contentPane.add(btnSignIn);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(56, 72, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtMdp = new JTextField();
		txtMdp.setHorizontalAlignment(SwingConstants.CENTER);
		txtMdp.setBounds(282, 72, 86, 20);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(282, 53, 46, 14);
		contentPane.add(lblPassword);
	}
}
