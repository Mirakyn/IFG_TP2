import java.awt.EventQueue;

import server.Serveur;
import view.Interface_Manager;
<<<<<<< HEAD
=======
import view.Interface_login;
>>>>>>> master

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Serveur serveur = new Serveur("trolley.yolo.cat", 3306);
<<<<<<< HEAD
=======
				
>>>>>>> master
				Interface_Manager manager = new Interface_Manager(serveur);
			}
		});
	}

}
