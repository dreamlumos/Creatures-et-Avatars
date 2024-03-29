import java.util.ArrayList;

public class Monde{
	
	private ArrayList<Item> listeItems;
	private int taille;

	public Monde(int taille){

		this.taille = taille;
		listeItems = new ArrayList<Item>();

	}

	public int getTaille(){
		return taille;
	}

	public int getPositionAlea(){
	/* Retourne une position (un entier) aléatoire dans le monde. */

		return (int) (Math.random()*taille);

	}

	public void ajouterItem(Item item){
	/* Initialise aléatoirement l'abcisse et l'ordonnée de l'item et ajoute l'item dans le monde. */

		if (item.getX() == -1 && item.getY() == -1){


			item.setX(getPositionAlea());
			item.setY(getPositionAlea());

		}

		listeItems.add(item);

	}

	public void supprimerItem(Item item){
	/* Supprime l'item du monde et met ses coordonnées à (-1,-1). */

		listeItems.remove(item);
		item.setX(-1);
		item.setY(-1);

	}

	public Item chercher(int x, int y){
	/* Retourne le premier item trouvé aux coordonnées (x,y) ou retourne null sinon. */

		for (Item i : listeItems){

			if (i.getX() == x && i.getY() == y){
				return i;
			}

		}

		return null;

	}

	public ArrayList<Item> getVoisins(Item item){
	/* Retourne la liste des items qui sont à une distance <= 2 de l'item en paramètre (et qui ne contient pas l'item en paramètre). */

		ArrayList<Item> listeVoisins = new ArrayList<Item>();

		for (Item i : listeItems){

			if (item.distance(i) <= 2 && item != i){

				listeVoisins.add(i);

			}

		}

		return listeVoisins;

	}

	private static String getNomCourt(String nom){
	/* Retourne un chaîne d'exactement 4 caractères. */

		int length = nom.length();

		switch(length){

			case 0:
				return nom;

			case 1:
				return " "+nom+"  ";

			case 2:
				return " "+nom+" ";

			case 3:
				return nom+" ";

			case 4:
				return nom;

		}

		return nom.substring(0,2)+nom.substring(length-1, length-1);

	}

	public void afficher(){
	/* Affiche le monde avec ses items. */

		String monde = "\t|";

		for (int i=0; i<taille; i++){

			monde += "  "+i+" |";

		}

		monde += "\n";

		for (int i=0; i<taille; i++){

			monde += i+" |";

			for (int j=0; j<taille; j++){

				Item item = chercher(i, j);

				if (item == null){

					monde += "    |";

				} else {

					monde += getNomCourt(item.getNom())+"|";

				}

			}

			monde +="\n";

		}

		System.out.println(monde);

	}

}