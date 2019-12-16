import java.lang.Math.*;
public class ChampignonToxique extends Champignons {
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

}
