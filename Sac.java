public class Sac extends Acc {
	Acc[] tab;
	public Sac(int n) {
		tab = new Acc[n];
	}

	public int size() {
		return tab.length;
	}

	public void ajouter(Acc a) {
		for (Acc i : tab) {
			if (i == null) {
				i = a;
				return ;
			}
		}
		System.out.println("Pas de place");
	}

	public Acc obtenir(int i) {
		if (tab[i] != null) {
					return tab[i];
		}
		return null;
	}

	public double getPoids() {
		return (0.0);
	}

	public String toString() {
		for (Acc i : tab)
			i.toString();
	}
}
