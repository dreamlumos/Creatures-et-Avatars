public class Sac extends Acc {
	private Acc[] tab;
	public Sac(int n) {
		super("sac");
		tab = new Acc[n];
	}

	public Sac() {
		this((int)(Math.random() * 10) + 1);
	}

	public int size() {
		return tab.length;
	}

	public void ajouter(Acc a) {
	/* Ajoute a à la première place libre si possible. */
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == null) {
				tab[i] = a;
				return ;
			}
		}
		System.out.println("Pas de place");
	}

	public Acc obtenir(int i) {
	/* Retourne l'accessoire à la position i dans le sac,
	ou null s'il n'existe pas. L'accessoire n'est plus dans le sac. */
		if (tab[i] != null)
		{
			Acc temp = tab[i];
			tab[i] = null;
			return temp;
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

	public int nbObjet() {
		int cpt = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null)
				cpt++;
		}
	 	return cpt;
	}

	public String toString() {
		String s = super.toString()+" contient " + this.nbObjet() + " accessoires sur " + size() + " places\n";
		for (Acc a : tab) {
			if (a == null) {
				break;
			}
			s += a.toString();
		}
		return s;
	}
}
