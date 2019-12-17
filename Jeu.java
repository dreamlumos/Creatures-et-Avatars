import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Jeu {

	private static final int TAILLE_CASE = 30;
	private static final int NB_CASES = 20;

	public static void main(String[] args) throws InterruptedException {

		//Création fenêtre graphique et ses caractéristiques
		JFrame f = new JFrame();

		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Création du monde (qui est un panneau)
		Monde m = new Monde(NB_CASES, TAILLE_CASE);

		f.setContentPane(m); //Ajout du monde à la fenêtre
		f.pack(); //Adaptation de la fenêtre au panneau
		f.setVisible(true);


		Pomme p1 = new Pomme();
		Bonbon b1 = new Bonbon();
		Sac s1 = new Sac(5);
		ChampignonToxique ct1 = new ChampignonToxique();
		ChampignonBonus cb1 = new ChampignonBonus();
		Creature c1 = new Creature();		

		m.ajouterItem(p1);
		m.ajouterItem(b1);
		m.ajouterItem(s1);
		m.ajouterItem(ct1);
		m.ajouterItem(cb1);
		m.ajouterItem(c1);

		int nbJoueurs;
		String[] tabNoms = new String[4];
		Avatar[] tabAvatars = new Avatar[4];

		Scanner scanner = new Scanner(System.in);
		System.out.println("### Bienvenue à Créatures et Avatars ! ###\n  ");


		do{
			System.out.println("Entrez le nombre de joueurs (1-4) : \n");
			nbJoueurs = scanner.nextInt();
		} while (nbJoueurs < 1 || nbJoueurs > 4);


		for (int i = 0; i < nbJoueurs; i++){

			System.out.println("Nom du joueur "+i+" : \n");
			tabNoms[i] = scanner.next();
			tabAvatars[i] = new Avatar(tabNoms[i], m); 

		}

		// Avatar jake = new Avatar("Jake", 79.5, m); //ajoute Jake dans le monde

		for (int i = 0; i < 10000; i++) {

			for (int j = 0; j < nbJoueurs; j++) {

				Thread.sleep(10); //Ralenti l'affichage
				tabAvatars[j].deplacementAuto();
				tabAvatars[j].rencontrerVoisins();
				m.repaint(); //Redessine le graphique


			}


		}

	}

}
