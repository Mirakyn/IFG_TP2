package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import model.Membre;
import server.Serveur;

public class Interface_Applicative extends JFrame {
	//Attributes
	private JTabbedPane tabbedPane;
	private Interface_Manager parent;
	private Serveur serveur;
	private Membre membre;
	
	public Interface_Applicative (Interface_Manager parent, Serveur serveur, Membre membre){
		this.parent = parent;
		this.serveur = serveur;
		this.membre = membre;
		// disable the close of the inscription frame by the user
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane (JTabbedPane.TOP);
		setSize(800, 600);
		

		//Add the panes
		tabbedPane.addTab ("Interface_Groupe", new Interface_groupe(serveur, membre));
		tabbedPane.add ("Interface_Listes", new Interface_Liste());
		
		add(tabbedPane, BorderLayout.CENTER);
		getContentPane().add(tabbedPane);
		
		
		System.out.println(getSize() + "    " + tabbedPane.getSize());
	}
	
}
