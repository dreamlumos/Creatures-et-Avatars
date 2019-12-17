import java.awt.*;
import javax.swing.*;

public class Carotte extends Acc implements Mangeable {

	private double longeur;

	public Carotte(){
		super("carotte");
		int mmax = 8;
		int mmin = 4;
		longeur = (Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString(){
		return super.toString() + String.format("%.1fcm\n", longeur);
	}

	public double getPoids(){
		return longeur/100.0;
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		g.setColor(new Color(227, 135, 16)); 
		g.fillOval(getX()*tc, getY()*tc, tc/5, tc); 

	}

}