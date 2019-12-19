import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class JeuAuto {

	private static final int TAILLE_CASE = 80;
	private static final int NB_CASES = 10;
	private static final int NB_CREATURES = 8;

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

		Creature[] tabCreatures = new Creature[NB_CREATURES];
		for (int i = 0; i < NB_CREATURES-1; i++){
			tabCreatures[i] = new Creature(m);
		}

		tabCreatures[NB_CREATURES-1] = new Lapin(m);

		Arbre a1 = new Arbre();
		Pomme p1 = new Pomme();
		Pomme p2 = new Pomme();
		Pomme p3 = new Pomme();
		Carotte c1 = new Carotte();
		Carotte c2 = new Carotte();
		Bonbon b1 = new Bonbon();
		Bonbon b2 = new Bonbon();
		Rollers r1 = new Rollers();
		Sac s1 = new Sac(5);
		ChampignonToxique ct1 = new ChampignonToxique();
		ChampignonBonus cb1 = new ChampignonBonus();

		m.ajouterItem(a1);
		m.ajouterItem(p1);
		m.ajouterItem(c1);
		m.ajouterItem(b1);
		m.ajouterItem(p2);
		m.ajouterItem(p1);
		m.ajouterItem(c2);
		m.ajouterItem(b2);
		m.ajouterItem(r1);
		m.ajouterItem(s1);
		m.ajouterItem(ct1);
		m.ajouterItem(cb1);

		int nbJoueurs;
		String[] tabNoms = new String[4];
		Avatar[] tabAvatars = new Avatar[4];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("### Bienvenue à Créatures et Avatars ! ###\n  ");

		/* Choix du nombre de joueurs. */
		do{
			System.out.println("Entrez le nombre de joueurs (1-4) : \n");
			nbJoueurs = scanner.nextInt();
		} while (nbJoueurs < 1 || nbJoueurs > 4);

		/* Noms des joueurs et création des avatars. */
		for (int i = 0; i < nbJoueurs; i++){

			System.out.println("Nom du joueur "+i+" : \n");
			tabNoms[i] = scanner.next();
			tabAvatars[i] = new Avatar(tabNoms[i], m); 

		}

		/* Tours de jeu. */
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < nbJoueurs; j++) {

				Thread.sleep(500);
				tabAvatars[j].deplacementAuto();
				tabAvatars[j].rencontrerVoisins();
				m.repaint();

			}
			for (Creature creature : tabCreatures){
				creature.deplacementAuto();
			}
		}

		double distanceMax = 0.0;
		Avatar gagnant = null;

		/* Course et calcule du gagnant. */
		for (int i = 0; i < nbJoueurs; i++){
			double distance = tabAvatars[i].course();
			if (distance > distanceMax){
				distanceMax = distance;
				gagnant = tabAvatars[i]; 
			}
			System.out.println("Distance parcourue par les amis de "+tabAvatars[i].getNom()+" : "+distance);
		}

		if (gagnant != null){
			System.out.println("Le gagnant est "+gagnant.getNom()+" !");
		} else {
			System.out.println("Il n'y a pas de gagnant.");
		}

		System.exit(0);

	}

}
