import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Rollers extends Acc implements Portable {
/* Pour l'instant les rollers sont juste encombrants. */

	public Rollers(){
		super("rollers");
	}

	public double getPoids(){
		/*2-5kg*/
		return 2.0;
	}

	public double changerVitesse(){
		return 0.0;
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();
		int a = tc/2; //ajustement

		File rollers;
		Image image;

		try {
			rollers = new File("./images/rollers.png");
			image = ImageIO.read(rollers);
			g.drawImage(image, getX()*tc+a, getY()*tc+a, tc-a, tc-a, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

}