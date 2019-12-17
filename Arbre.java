import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Arbre extends Item {
	
	private int nbFeuilles;

	public Arbre(){
		super("arbre");
		nbFeuilles = (int) (Math.random()*150);
	}

	public int getNbFeuilles(){
		return nbFeuilles;
	}

	public void dessiner(Graphics g, Monde m){

		int tc = m.getTailleCase();
		/*File arbre;
		Image image;

		try {
			arbre = new File("./images/arbre.png");
			image = ImageIO.read(arbre);
			g.drawImage(image, getX()*tc, getY()*tc, tc, tc, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}*/

		g.setColor(new Color(87, 161, 18)); 
		g.fillRect(getX()*tc, getY()*tc, tc, tc);

	}


}