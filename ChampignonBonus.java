import java.lang.Math.*;
import java.awt.*;
import javax.swing.*;
public class ChampignonBonus extends Champignon {
	private double effect;

	public ChampignonBonus() {
		super("champignons bonus");
		int mmax = 2;
		int mmin = 0;
		effect = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString() {
		String s = super.toString() + String.format("%.1fchange\n", effect);
		return s;
	}

	public double getChange() {
		return effect;
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		g.setColor(new Color(245, 66, 66)); //Couleur courante devient bleu

		g.fillRect(getX()*tc, getY()*tc, tc, tc); //Carré plein

	}

}
