import java.awt.EventQueue;

import model.Membre;
import server.Serveur;
import view.Interface_groupe;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Serveur serveur = new Serveur("trolley.yolo.cat", 3306);
				Membre membre = new Membre("test@test.ca", "test");
				try {
					Interface_groupe frame = new Interface_groupe(serveur, membre);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
