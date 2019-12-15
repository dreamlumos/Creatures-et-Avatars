public abstract class Acc extends Item {
	private static int cpt = 0;
	private int numero;
	private String categorie;

<<<<<<< HEAD
	public Acc (String categorie, String nom) {
		super(nom);
=======
	public Acc (String categorie) { 
>>>>>>> d6b6c85c693f099a823f8141ba1335cb5edb8e9d
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
