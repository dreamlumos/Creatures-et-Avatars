public class Pomme extends Acc implements Mangeable {
	private double rayon;
	public Pomme(String nom) {
		super("pomme", nom);
		int mmax = 7;
		int mmin = 3;
		rayon = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}
	public String toString() {
			String s = String.format("%s No %d %.2fkg %.1fcm\n", getCategorie(), getNumero(), getPoids(), rayon);
			return s;
	}
	public double getPoids() { //use a formula
		return (0.0);
	}
}
