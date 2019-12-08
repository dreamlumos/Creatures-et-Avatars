public class Noms{
	
	private String[] tabNoms;
	private int ptTab; //pointeur sur la prochaine case du tableau à utiliser
	private int cptParcours; //compteur pour le numéro du parcours

	public Noms(String[] tabNoms){

		this.tabNoms = tabNoms;
		ptTab = 0;
		cptParcours = 1;

	}

	public String getNom(){

		String nom = tabNoms[ptTab]+cptParcours;

		ptTab++;

		if (ptTab == tabNoms.length){
			
			ptTab = 0;
			cptParcours++;

		}

		return nom;

	}

}