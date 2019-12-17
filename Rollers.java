import java.awt.*;
import javax.swing.*;

public class Rollers extends Acc implements Portable {

	public Rollers(){
		super("rollers");
	}

	public double getPoids(){
		/*2-5kg*/
		return 0.0;
	}

	public double changerVitesse(){
		return 0.0;
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		g.setColor(new Color(55, 59, 79)); 
		g.fillOval(getX()*tc, getY()*tc, tc, tc); 

	}

}