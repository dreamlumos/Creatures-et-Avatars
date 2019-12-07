public abstract class Personnage extends Item{

	private double poids;

	public Personnage(String nom, double poids, int x, int y){

		super(nom, x, y);
		this.poids = poids;

	}

	public Personnage(String nom, int x, int y){ //poids aléatoire

		this(nom, Math.random()*100+30, x, y);

	}

	public Personnage(String nom, double poids){ //position aléatoire

		super(nom);
		this.poids = poids;

	}

	public Personnage(String nom){ //poids et position aléatoires
		
		this(nom, Math.random()*100+30);

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
		return String.format("%s %.1f kg", nom, poids);
	}

}