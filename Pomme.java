import java.lang.Math.*;
public class Pomme extends Acc implements Mangeable {
	private double rayon;

	public Pomme(String nom) {
		super("pomme", nom);
		int mmax = 7;
		int mmin = 3;
		rayon = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString() {
			String s = String.format("%s No %d %.2fkg %.1fcm\n", getCategorie(), getNumero(), this.getPoids(), rayon);
			return s;
	}

	public double getPoids() {
		double poids = (4.0 / 3000.0) * Math.PI * Math.pow(rayon, 3);
		return (poids);
	}
}
