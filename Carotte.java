import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

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
		int tc2 = tc/2;

		File carotte;
		Image image;

		try {
			carotte = new File("./images/carotte.png");
			image = ImageIO.read(carotte);
			g.drawImage(image, getX()*tc, getY()*tc+tc2, tc, tc-tc2, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

}