package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import server.Serveur;

public class Interface_Applicative extends JFrame {
	//Attributes
	private JTabbedPane tabbedPane;
	private Interface_Manager parent;
	private Serveur serveur;
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Applicative frame = new Interface_Applicative(null, new Serveur("trolley.yolo.cat", 3306));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interface_Applicative (Interface_Manager parent, Serveur serveur){
		this.parent = parent;
		this.serveur = serveur;
		// disable the close of the inscription frame by the user
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		tabbedPane = new JTabbedPane (JTabbedPane.TOP);
		setSize(800, 600);
		

		//Add the panes
		tabbedPane.addTab ("Interface_Groupe", new Interface_groupe());
		tabbedPane.add ("Interface_Listes", new Interface_Liste());
		
		add(tabbedPane, BorderLayout.CENTER);
		getContentPane().add(tabbedPane);
		
		
		System.out.println(getSize() + "    " + tabbedPane.getSize());
	}
	
}
