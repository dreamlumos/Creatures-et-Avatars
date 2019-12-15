public class Sac extends Acc {
	private Acc[] tab;
	private static int cpt = 0;

	public Sac(int n, String categorie, String nom) {
		super(categorie, nom);
		tab = new Acc[n];
	}

	public int size() {
		return tab.length;
	}

	public void ajouter(Acc a) {
		int i;
		for (i = 0; i < tab.length; i++) {
			if (tab[i] == null) {
				tab[i] = a;
				cpt++;
				return ;
			}
		}
		System.out.println("Pas de place");
	}

	public Acc obtenir(int i) {
		if (tab[i] != null)
					return tab[i];
		return null;
	}

	public double getPoids() {
		double poids = 0;
		for (int i = 0; i < cpt; i++)
			poids += tab[i].getPoids();
		return poids;
	}

	public String toString() {
		String s = String.format("%s No %d %.2fkg contient %d accessoires sur %d places\n", getCategorie(), getNumero(), this.getPoids(), cpt, tab.length);
		for (int i = 0; i < cpt; i++)
		 	s += tab[i].toString();
		return s;
	}
}
