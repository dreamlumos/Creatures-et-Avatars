import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Creature extends Personnage implements Sieste {
/* 	Une créature commence avec un sac vide et 10 unités d'énergie. 
	Elle dépense son énergie en se déplaçant et en regagne en prenant une sieste.
	Plus elle a d'énergie, plus vite elle pourra courir.
*/

	protected Sac leSac;
	private int energie; 
	private Monde monde;

	public Creature(double poids, Monde monde) { //nom et position aléatoire
		
		super(Noms.getNom(), poids);

		leSac = new Sac();
		energie = 10;

		this.monde = monde;
		monde.ajouterItem((Item) this);

	}

	public Creature(String nom, Monde monde) { //poids et position aléatoires
		super(nom);
		leSac = new Sac();
		energie = 10;
		this.monde = monde;
		monde.ajouterItem((Item) this);
	}

	public Creature(Monde monde) { //nom, poids et position aléatoires
		this(Noms.getNom(), monde);
	}

	public void addAcc(Acc acc){
	/* Ajoute un accessoire dans le sac de la créature si le poids du sac + le poids de l'accessoire est inférieur à la moitié du poids de la créature. */
		if(acc.getPoids() + leSac.getPoids() > getPoids()/2){
			System.out.println("Trop lourd.\n");
		} else {
			leSac.ajouter(acc);
		}
	}

	public double getVitesse(){
	/* Retourne la vitesse à laquelle peut courir la créature. */
		double vitesse = getPoids()/4 - leSac.getPoids() + energie/2;
		if (vitesse < 0) {
			return 0.0;
		}
		return vitesse;
	}

	public void manger(){
	/* La créature mange les accessoires mangeables du sac ce qui augmente son poids. */
		Acc a;
		for (int i=0; i<leSac.size(); i++) {
			a = leSac.obtenir(i);
			if (a instanceof Mangeable){
				manger((Mangeable) a);
			} else {
				leSac.ajouter(a);
			}
		}
	}

	public void manger(Mangeable m){
	/* Ajoute le poids du mangeable au poids de la créature. */
		super.addPoids(m.getPoids());
	}

	public void courir(){
		System.out.println(super.toString()+" court a vitesse "+String.format("%.2f", getVitesse())+" km/h avec "+leSac.toString());
	}

	public void deplacementAuto(){
	/* La créature bouge automatiquement d'une case dans une direction aléatoire. Le monde est torique. */

		if (energie > 0) {

			energie--;
			
			int oldX = getX();
			int oldY = getY();
			int mmax = 1;
			int mmin = -1;		
			int newX = super.getX() + (int)(Math.random() * ((mmax - mmin) + 1)) + mmin;
			int newY = super.getY() + (int)(Math.random() * ((mmax - mmin) + 1)) + mmin;

			if(newX > monde.getTaille() - 1)
				newX = 0;
			if(newX < 0)
				newX = monde.getTaille() -1;
			if(newY > monde.getTaille() - 1)
				newY = 0;
			if(newY < 0)
				newY = monde.getTaille() -1;
			
			setX(newX);
			setY(newY);
			System.out.println("Deplacement de "+getNom()+" de ("+oldX+","+oldY+") vers ("+newX+","+newY+") \n");

		}

	}

	public void faireLaSieste(){
	/* La créature prend une sieste si elle est sous un arbre. Elle regagne 2 unités d'énergie. */
		ArrayList<Item> listeVoisins = monde.getVoisins(this);
		for (Item i : listeVoisins){
			if (i instanceof Arbre && i.getX() == getX() && i.getY() == getY()){
				energie += 2;
			}
		}
	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();
		File creature;
		Image image;
		String fileName;
		String prenom = getNom();
		prenom = prenom.substring(0, prenom.length()-1);

		int i = 0;
		while (i < Noms.getTabLength() && !prenom.equals(Noms.getTabNoms(i))){
			i++;
		}

		switch (i){
			case 0: 
				fileName = "./images/bluemonster.png";
				break;
			case 1:
				fileName = "./images/greenmonster.png";
				break;
			case 2:
				fileName = "./images/pinkmonster.png";
				break;
			case 3:
				fileName = "./images/purplemonster.png";
				break;
			default:
				fileName = "./images/orangemonster.png";
		}


		try {
			creature = new File(fileName);
			image = ImageIO.read(creature);
			g.drawImage(image, getX()*tc, getY()*tc, tc, tc, m); 
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}
}
