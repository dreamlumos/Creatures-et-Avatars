public abstract class Acc extends Item {
 	private static int numero = 0; //final, static or...?
	private int id;
	private String categorie;

	public Acc (String categorie, String nom) {
		super(nom);
		this.categorie = categorie;
		numero++;
		this.id = numero;
}

	public String getCategorie() {
		return categorie;
	}

	public int getNumero() {
		return id;
	}

	abstract public double getPoids();

	abstract public String toString();
}
