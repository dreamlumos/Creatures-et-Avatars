public class Bonbons extends Acc implements Mangeable {
	private double nb;
	public Bonbons() {
		super("bonbons");
		int mmax = 7;
		int mmin = 3;
		rayon = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}
	public String toString() {
			String s = String.format("%s No %d %.2fkg %.1fcm", getCategorie(), getNumero(), getPoids(), nb);
			return s;
	}
}
