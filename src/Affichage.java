public class Affichage {
	PlateauDeJeu plateau;

	public Affichage(PlateauDeJeu p_plateau){
		plateau = p_plateau;
	}

	public void AffichePlateau(){
		System.out.println(plateau.toString());	
	}
}
