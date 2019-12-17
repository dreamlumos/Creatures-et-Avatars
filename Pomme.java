import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

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

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();
		File pomme;
		Image image;

		try {
			pomme = new File("./images/pomme.png");
			image = ImageIO.read(pomme);
			g.drawImage(image, getX()*tc, getY()*tc, tc, tc, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

		//g.setColor(new Color(133, 17, 17)); 
		//g.fillRect(getX()*tc, getY()*tc, tc, tc); 


	}

}
