public class Sac extends Acc {

	private Acc[] tab;

	public Sac(int n) {
		super("sac");
		tab = new Acc[n];
	}

	public Sac(){
		this((int) (Math.random()*10)+1);
	}

	public int size() {
		return tab.length;
	}

	public void ajouter(Acc a) {
	/* Ajoute a à la première place libre si possible. */
		for (Acc acc : tab) {
			if (acc == null) {
				acc = a;
				return ;
			}
		}
		System.out.println("Pas de place");
	}

	public Acc obtenir(int i) { //TO DO: Enlever l'objet du sac ?
	/* Retourne l'accessoire à la position i dans le sac, ou null s'il n'existe pas. L'accessoire n'est plus dans le sac. */
		if (tab[i] != null) {
					return tab[i];
		}
		return null;
	}

	public double getPoids() {

		double poids = 0.0;

		for (Acc a : tab){
			if (a == null) {
				break;
			}
			poids += a.getPoids();
		}

		return poids;
	}

	public String toString() { //TO FIX: Ajouter une méthode pour calculer le nombre d'objets dans le sac ?
		String s = super.toString()+" contient "+" accessoires sur "+size()+" places\n";
		for (Acc a : tab) {
			if (a == null) {
				break;
			}
			s += a.toString();
		}
		return s;
	}
}
