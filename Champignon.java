import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public abstract class Champignon extends Acc implements Mangeable {
	private static int cpt = 0;
	private int numero;
	private String categorie;

	public Champignon (String categorie) {
		super(categorie);
		this.categorie = categorie;
		cpt++;
		numero = cpt;
	}

	public String getCategorie() {
		return categorie;
	}

	public int getNumero() {
		return numero;
	}

	abstract public double getChange();

	public String toString(){
		return String.format("%s No %d %.2fkg", categorie, numero, getChange());
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();
		int a = tc/2; //ajustement

		File champignon;
		Image image;

		try {
			champignon = new File("./images/champignon.png");
			image = ImageIO.read(champignon);
			g.drawImage(image, getX()*tc, getY()*tc+a, tc, tc-a, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		} 

	}

}
