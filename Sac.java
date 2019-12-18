import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Sac extends Acc {

	private Acc[] tab;

	public Sac(int n) {
		super("sac");
		tab = new Acc[n];
	}

	public Sac() {
		this((int)(Math.random() * 10) + 1);
	}

	public int size() {
	/* Retourne le nombre maximal de places dans le sac. */
		return tab.length;
	}

	public void ajouter(Acc a) {
	/* Ajoute a à la première place libre si possible. */
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == null) {
				tab[i] = a;
				return ;
			}
		}
		System.out.println("Pas de place");
	}

	public Acc obtenir(int i) {
	/* Retourne l'accessoire à la position i dans le sac,
	ou null s'il n'existe pas. L'accessoire n'est plus dans le sac. */
		if (tab[i] != null) {
			Acc temp = tab[i];
			tab[i] = null;
			return temp;
		}
		return null;
	}

	public double getPoids() {
	/* Retourne le poids du sac (poids de tous les accessoires). */
		double poids = 0.0;
		for (Acc a : tab){
			if (a == null) {
				break;
			}
			poids += a.getPoids();
		}

		return poids;
	}

	public int nbObjets() {
	/* Retourne le nombre d'accessoires qu'il y a dans le sac. */
		int cpt = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null)
				cpt++;
			else
				break;
		}
	 	return cpt;
	}

	public String toString() {
		String s = super.toString()+" contient " + nbObjets() + " accessoires sur " + size() + " places\n";
		for (Acc a : tab) {
			if (a == null) {
				break;
			}
			s += a.toString();
		}
		return s;
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		File sac;
		Image image;

		try {
			sac = new File("./images/sac.png");
			image = ImageIO.read(sac);
			g.drawImage(image, getX()*tc, getY()*tc, tc, tc, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

		/*g.setColor(new Color(250, 179, 0));
		g.fillRect(getX()*tc, getY()*tc, tc, tc);*/

	}
}
