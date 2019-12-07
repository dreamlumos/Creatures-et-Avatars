import java.util.ArrayList;

public class Avatar extends Personnage{
	
	private ArrayList<Creature> listeAmis;
	private ArrayList<Acc> listeAcc;

	public Avatar(String nom, double poids){

		super(nom, poids);

		listeAmis = new ArrayList<Creature>();
		listeAcc = new ArrayList<Acc>();

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

		if (estAmi){
			System.out.println(getNom()+" est déjà ami avec "+c.getNom());
		} else {
			
			listeAmis.add(c);
			System.out.println(getNom()+" devient ami avec "+c.getNom());

		}

	}

	public void perdreAmi(Creature c){

		if (estAmi){

			listeAmis.remove(c);

			System.out.println(getNom()+" n'est plus ami avec "+c.getNom());

		} else {

			System.out.println(getNom()+" n'est pas ami avec "+c.getNom());

		}

	}

	public void rencontrer(Creature c){
	/* Lorsque l'avatar rencontre une créature, il lui offre le premier accessoire qu'il a dans listeAcc et la créature ajoute cet accessoire dans son sac. Si la créature n'est pas amie avec lui et si l'accessoire offert a un poids supérieur à 0.5 kg, alors la créature devient amie avec lui. S'il n'a pas d'accessoires à offrir et cette créature était une amie, alors il perd son amitié. */

		//FIX!!
		//c.addAcc();

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
		Creature creaturePlusRapide;

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

}