import java.awt.EventQueue;

import model.Membre;
import server.Serveur;
<<<<<<< HEAD
import view.Interface_Manager;
import view.Interface_login;
=======
import view.Interface_groupe;
>>>>>>> master

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Serveur serveur = new Serveur("trolley.yolo.cat", 3306);
<<<<<<< HEAD
				
				Interface_Manager manager = new Interface_Manager(serveur);
=======
				Membre membre = new Membre("test@test.ca", "test");
				try {
					Interface_groupe frame = new Interface_groupe(serveur, membre);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
>>>>>>> master
			}
		});
	}

}
