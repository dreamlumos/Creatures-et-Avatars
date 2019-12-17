import java.awt.*;
import javax.swing.*;

public class Bonbon extends Acc implements Mangeable {

	private int couleur;

	public Bonbon() {
		super("bonbon");
		int mmax = 7;
		int mmin = 1;
		couleur = (int)(Math.random() * ((mmax - mmin) + 1)) + mmin;
	}

	public String toString() {
		String c;
		switch(couleur) {
  	case 1:
    	c = "rouge";
    	break;
  	case 2:
    	c = "orange";
    	break;
	case 3:
	    c = "jaune";
	    break;
	case 4:
		  c = "vert";
		  break;
	case 5:
	    c = "bleu claire";
	   	break;
	case 6:
	   	c = "bleu foncé";
	    break;
	case 7:
		c = "violet";
		break;
  	default:
    	c = "blanc";
		}
		String s = super.toString() + String.format(" couleur: %s", c);
		return s;
	}

	public double getPoids() {
		double poids = (4.0 / 3000.0) * Math.PI * Math.pow(couleur, 3);
		return (poids);
	}
	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		g.setColor(new Color(227, 66, 245)); 
		g.fillOval(getX()*tc, getY()*tc, tc, tc); 

	}
}
