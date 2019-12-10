public class Jeu{
	
	public static void main(String[] args){

	/* Q9 : */

	Creature c1 = new Creature();

	c1.courir();
	c1.manger();
	c1.courir();

	/* Q13 : */

	Creature c2 = new Creature();
	Avatar a1 = new Avatar("Ava1", 45);

	Monde monde = new Monde(5);

	monde.ajouterItem(c1);
	monde.ajouterItem(c2);
	monde.ajouterItem(a1);

	monde.afficher();

	}

}