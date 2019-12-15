import java.lang.Math.*;
public class Bonbon extends Acc implements Mangeable {

	private double nb; //TO CHANGE

	public Bonbon() {
		super("bonbon");
		int mmax = 7;
		int mmin = 3;
	}

	public String toString() { //TO CHANGE
			return super.toString();
	}

	public double getPoids() {
		double poids = (4.0 / 3000.0) * Math.PI * Math.pow(nb, 3);
		return (poids);
	}
}
