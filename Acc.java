public abstract class Acc extends Item {
	private static int cpt = 0;
	private int numero;
	private String categorie;

	public Acc (String categorie, String nom) {
		super(nom);
		this.categorie = categorie;
	}

	public String getCategorie() {
		return categorie;
	}

	public int getNumero() {
		return numero;
	}

	abstract public double getPoids();

	abstract public String toString();
}
