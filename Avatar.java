import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class Avatar extends Personnage {

	private ArrayList<Creature> listeAmis;
	private ArrayList<Acc> listeAcc;
	private Monde monde;

	public Avatar(String nom, double poids, Monde monde) { //position aléatoire
		super(nom, poids);
		listeAmis = new ArrayList<Creature>();
		listeAcc = new ArrayList<Acc>();
		this.monde = monde;
		monde.ajouterItem((Item) this);
	}

	public Avatar(String nom, Monde monde) { //poids et position aléatoire
		super(nom);
		listeAmis = new ArrayList<Creature>();
		listeAcc = new ArrayList<Acc>();
		this.monde = monde;
		monde.ajouterItem((Item) this);
	}

	public String toString(){
		return super.toString()+listeAmis.size()+" ami(s) "+listeAcc.size()+" accessoire(s)";
	}

	public boolean estAmi(Creature c){
	/* Retourne vrai si la créature est un ami, faux sinon. */
		for (Creature creature : listeAmis){
			if (creature == c){
				return true;
			}
		}
		return false;
	}

	public void devenirAmi(Creature c){
	/* Fait devenir ami l'avatar avec la créature en paramètre, s'il n'est pas déjà ami avec. */
		if (estAmi(c)){
			System.out.println(getNom()+" est déjà ami avec "+c.getNom());
		} else {
			listeAmis.add(c);
			System.out.println(getNom()+" devient ami avec "+c.getNom());
		}
	}

	public void perdreAmi(Creature c){

		if (estAmi(c)) {
			listeAmis.remove(c);
			System.out.println(getNom()+" n'est plus ami avec "+c.getNom());
		} else {
			System.out.println(getNom()+" n'est pas ami avec "+c.getNom());
		}
	}

	public void rencontrer(Creature c){
	/* Lorsque l'avatar rencontre une créature, il lui offre le premier accessoire qu'il a dans listeAcc et la créature ajoute cet accessoire dans son sac. Si la créature n'est pas amie avec lui et si l'accessoire offert a un poids supérieur à 0.5 kg, alors la créature devient amie avec lui. S'il n'a pas d'accessoires à offrir et cette créature était une amie, alors il perd son amitié. */
		if (listeAcc.size() == 0){ //si l'avatar n'a pas d'accessoires
			perdreAmi(c);
		} else {
			Acc a = listeAcc.get(0);
			c.addAcc(a);
			listeAcc.remove(0);
			if (a.getPoids() > 0.5){
				devenirAmi(c);
			}
		}
	}

	public double course(){
	/* Fait manger puis courir pendant une heure chaque créature l'une après l'autre, et retourne la distance totale parcourue. */
		double distance = 0.0;
		for (Creature c : listeAmis){
			c.manger();
			c.courir();
			distance += c.getVitesse();
		}
		return distance;
	}
	public Creature getCreaturePlusRapide(){
	/* Retourne la créature qui court le plus vite. */
		double vitesseMax = -1.0; //au cas où toutes les créatures auraient une vitesse égale à zéro
		Creature creaturePlusRapide = null;
		for (Creature c : listeAmis){
			if (c.getVitesse() > vitesseMax){
				vitesseMax = c.getVitesse();
				creaturePlusRapide = c;
			}
		}
		return creaturePlusRapide;
	}

	public int compterAccMangeable(){
	/* Retourne le nombre d'accessoires mangeables. */
		int cpt = 0;
		for (Acc a : listeAcc){
			if(a instanceof Mangeable){
				cpt++;
			}
		}
		return cpt;
	}

	public void ramasser(Acc a){
	/* Supprime l'accessoire du monde et le met dans la liste d'accessoires de l'avatar. */

		monde.supprimerItem(a);

		listeAcc.add(a);

		System.out.println(getNom()+" ramasse "+a.getNom());

	}

	public void rencontrerVoisins(){
	/* Pour chaque voisin de l'avatar, si le voisin est un accessoire, alors l'avatar le ramasse; si le voisin est une créature, alors l'avatar la rencontre; si le voisin est un avatar, alors l'avatar le salue. */
		ArrayList<Item> listeVoisins = monde.getVoisins(this);
		for (Item i : listeVoisins){
			if (i instanceof Acc){
				ramasser((Acc) i);
			} else if (i instanceof Creature){
				rencontrer((Creature) i);
			} else if (i instanceof Avatar){
				System.out.println(getNom()+" salue "+i.getNom());
			}
		}
	}

	public void seDeplacer(){
	/* Déplace l'avatar dans le monde. L'utilisateur saisi une abcisse et une ordonnée. */

		int oldX = getX();
		int oldY = getY();
		int newX = -1;
		int newY = -1;

		Scanner scanner = new Scanner(System.in);
		System.out.println("### Deplacement de "+getNom()+" ###\n");

		do{
			System.out.println("Entrer une abcisse entre [0,"+(monde.getTaille()-1)+"] : \n");
			newX = scanner.nextInt();
			System.out.println("\n");
		} while (newX < 0 || newX >= monde.getTaille());

		do{
			System.out.println("Entrer une ordonnee entre [0,"+(monde.getTaille()-1)+"] : \n");
			newY = scanner.nextInt();
			System.out.println("\n");
		} while (newY < 0 || newY >= monde.getTaille());

		setX(newX);
		setY(newY);

		System.out.println("Deplacement de "+getNom()+" de ("+oldX+","+oldY+") vers ("+newX+","+newY+") \n");
	}

	public void deplacementAuto(){

		int mmax = 1;
		int mmin = -1;
		int newX = super.getX() + (int)(Math.random() * ((mmax - mmin) + 1)) + mmin;
		int newY = super.getY() + (int)(Math.random() * ((mmax - mmin) + 1)) + mmin;

		if(newX > monde.getTailleCase() - 1)
			newX = 0;
		if(newX < 0)
			newX = monde.getTailleCase() -1;
		if(newY > monde.getTailleCase() - 1)
			newY = 0;
		if(newY < 0)
			newY = monde.getTailleCase() -1;
		if (newY < 0 || newY >= monde.getTailleCase() || newX < 0 || newX >= monde.getTailleCase())
		System.out.println(newX+" "+newY);

		setX(newX);
		setY(newY);

	}

	public void dessiner(Graphics g, Monde m) {

		int tc = m.getTailleCase();

		g.setColor(new Color(0, 0, 255)); //Couleur courante devient bleu

		g.fillRect(getX()*tc, getY()*tc, tc, tc); //Carré plein

	}
}
