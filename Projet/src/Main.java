import java.awt.EventQueue;

import server.Serveur;
import view.Interface_login;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Serveur serveur = new Serveur("trolley.yolo.cat", 3306);
				
				try {
					Interface_login frame = new Interface_login(serveur);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
