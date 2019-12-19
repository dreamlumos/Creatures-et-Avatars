import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Lapin extends Creature {
	
	public Lapin(Monde monde){
		super("Lapin"+Noms.getNom(), monde);
	}

	@Override
	public void manger(){
	/* La créature mange les accessoires mangeables du sac ce qui augmente son poids. */
		Acc a;
		for (int i=0; i<leSac.size(); i++) {
			a = leSac.obtenir(i);
			
			if (a instanceof Carotte){
				manger((Carotte) a);
			} else if (a instanceof Mangeable){
				manger((Mangeable) a);
			} else {
				leSac.ajouter(a);
			}
		}
	}

	public void manger(Carotte c){
	/* Ajoute deux fois le poids de la carotte au poids de la créature. */
		super.addPoids(c.getPoids()*2);
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