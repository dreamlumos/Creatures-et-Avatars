import java.lang.Math.*;
import java.awt.*;
import javax.swing.*;
public class ChampignonToxique extends Champignon implements Mangeable{
	private double effect;

	public ChampignonToxique() {
		super("champignons toxique");
		int mmax = 0;
		int mmin = -1;
		effect = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString() {
		String s = super.toString() + String.format("%.1fchange\n", effect);
		return s;
	}

	public double getChange() {
		return effect;
	}

	public double getPoids() {
		double poids = (4.0 / 3000.0) * Math.PI * Math.pow(effect, 3);
		return (poids);
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		g.setColor(new Color(37, 191, 34)); //Couleur courante devient bleu

		g.fillRect(getX()*tc, getY()*tc, tc, tc); //Carré plein

	}

}
