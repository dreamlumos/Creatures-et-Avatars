public abstract class Personnage extends Item{

	private double poids;

	public Personnage(String nom, double poids, int x, int y){

		super(nom, x, y);
		this.poids = poids;

	}

	public Personnage(String nom, int x, int y){

		this(nom, Math.random()*100+30, x, y);

	}

	public Personnage(String nom){ //necessary?
		
		super(nom);
		this.poids = Math.random()*100+30;

	}

	protected double getPoids(){
		return poids;
	}

	protected void addPoids(double p){

		if (p > 0){
			poids += p;
		}

	}

	public String toString(){
		return String.format("%s %.1fkg", nom, poids);
	}

}