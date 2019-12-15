public class Jeu {

	public static void main(String[] args){

	Pomme p1 = new Pomme();
	Pomme p2 = new Pomme();
	Sac s1 = new Sac(5);
	s1.toString();

	/* Q9 : */

	Creature c1 = new Creature();

	c1.courir();
	c1.manger();
	c1.courir();

	/* Q13 : */

	Creature c2 = new Creature();

	Monde monde = new Monde(5);

	Avatar a1 = new Avatar("Ava1", 45, monde);

	monde.ajouterItem(c1);
	monde.ajouterItem(c2);
	monde.ajouterItem(a1);

	monde.afficher();

	}

}
