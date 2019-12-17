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

		int nbJoueurs;
		String[] tabNoms = new String[4];
		Avatar[] tabAvatars = new Avatar[4];

		Scanner scanner = new Scanner(System.in);
		System.out.println("### Bienvenue à Créatures et Avatars ! ###\n  ");


		do{
			System.out.println("Entrez le nombre de joueurs (1-4) : \n");
			nbJoueurs = scanner.nextInt();
		} while (newX < 1 || newX > 4);


		for (int i = 0; i < nbJoueurs; i++){

			System.out.println("Nom du joueur "+i+" : \n");
			nom[i] = scanner.nextLine();
			tabAvatars[i] = new Avatar(nom[i]); 

		}

		// Avatar jake = new Avatar("Jake", 79.5, m); //ajoute Jake dans le monde

		for (int i = 0; i < 10; i++) {

			for (Avatar avatar : tabAvatars) {

			Thread.sleep(1000); //Ralenti l'affichage
			jake.seDeplacer();
			m.repaint(); //Redessine le graphique


			}


		}

	}

}
