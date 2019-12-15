import java.lang.Math.*;
public class Bonbon extends Acc implements Mangeable {
	private double nb;

	public Bonbon(String nom) {
		super("bonbon", nom);
		int mmax = 7;
		int mmin = 3;
		nb = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString() {
			String s = String.format("%s No %d %.2fkg nb:%.1f\n", getCategorie(), getNumero(), this.getPoids(), nb);
			return s;
	}

	public double getPoids() {
		double poids = (4.0 / 3000.0) * Math.PI * Math.pow(nb, 3);
		return (poids);
	}
}
