public abstract class Acc extends Item {

	private static int cpt = 0;
	private int numero;
	private String categorie;

	public Acc (String categorie) { 
		super(categorie);
		this.categorie = categorie;
		cpt++;
		numero = cpt;
	}

	public String getCategorie() {
		return categorie;
	}

	public int getNumero() {
		return numero;
	}

	abstract public double getPoids();

	public String toString(){
		return String.format("%s No %d %.2fkg", categorie, numero, getPoids());
	}
}
