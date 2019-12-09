public class Creature extends Personnage {
	private Sac leSac;

	public Creature() {
		super(Noms.getNom());

	}

	public Creature(double poids) {
		super(Noms.getNom(), poids);
	}

	public void addAcc(Acc acc){
	/* Ajoute un accessoire dans le sac de la créature si le poids du sac + le poids de l'accessoire est inférieur à la moitié du poids de la créature. */
		if(acc.getPoids() + leSac.getPoids() > getPoids()/2){
			System.out.println("Trop lourd.\n");
		} else {
			leSac.ajouter(acc);
		}
	}

	public double getVitesse(){
	/* Retourne la vitesse à laquelle peut courir la créature. */
		double vitesse = getPoids()/4 - leSac.getPoids();
		if (vitesse < 0) {
			return 0;
		}
		return vitesse;
	}

	public void manger(){
	/* La créature mange les accessoires mangeables du sac ce qui augmente son poids. */
		Acc a;
		for (int i=0; i<leSac.size(); i++) {
			a = leSac.obtenir(i);
			if (a instanceof Mangeable){
				manger((Mangeable) a);
			} else {
				leSac.ajouter(a);
			}
		}
	}

	public void manger(Mangeable m){
	/* Ajoute le poids du mangeable au poids de la créature. */
		super.addPoids(m.getPoids());
	}

	public void courir(){
		System.out.println(super.toString()+" court à vitesse "+getVitesse()+" km/h avec "+leSac.toString());
	}
}
