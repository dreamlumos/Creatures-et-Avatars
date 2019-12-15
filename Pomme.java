import java.lang.Math.*;
public class Pomme extends Acc implements Mangeable {
	private double rayon;

	public Pomme() {
		super("pomme");
		int mmax = 7;
		int mmin = 3;
		rayon = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString() {
		String s = super.toString() + String.format("%.1fcm\n", rayon);
		return s;
	}

	public double getPoids() {
		return (4.0/3000) * Math.PI * Math.pow(rayon, 3);
	}

}
