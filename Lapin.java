import java.awt.*;
import javax.swing.*;

public class Lapin extends Creature {
	
	public Lapin(){
		super("Lapin"+Noms.getNom());
	}

	public void dessiner(Graphics g, Monde m){

		int tc = m.getTailleCase();

		g.setColor(new Color(173, 170, 153)); 
		g.fillRect(getX()*tc, getY()*tc, tc, tc); 

	}

}