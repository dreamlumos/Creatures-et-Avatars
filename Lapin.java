import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Lapin extends Creature {
	
	public Lapin(Monde monde){
		super("Lapin"+Noms.getNom(), monde);
	}

	public void dessiner(Graphics g, Monde m){

		int tc = m.getTailleCase();

		File lapin;
		Image image;

		try {
			lapin = new File("./images/lapin.png");
			image = ImageIO.read(lapin);
			g.drawImage(image, getX()*tc, getY()*tc, tc, tc, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

}