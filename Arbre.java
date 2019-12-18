import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Arbre extends Plante {
	
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
		int a = tc/2; //ajustement

		File arbre;
		Image image;

		try {
			arbre = new File("./images/arbre.png");
			image = ImageIO.read(arbre);
			g.drawImage(image, getX()*tc, getY()*tc-a, tc+a, tc+a, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}


}