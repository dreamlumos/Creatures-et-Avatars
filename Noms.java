public class Noms{
	
	private static String[] tabNoms = {"Bob", "Fil", "Jaz"};
	private static int ptTab = 0; //pointeur sur la prochaine case du tableau à utiliser
	private static int cptParcours = 0; //compteur pour le numéro du parcours

	private Noms(){}

	public static String getNom(){

		String nom = tabNoms[ptTab]+cptParcours;

		ptTab++;

		if (ptTab == tabNoms.length){
			
			ptTab = 0;
			cptParcours++;

		}

		return nom;

	}

}