import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args){
		PlateauDeJeu plateau = new PlateauDeJeu(4, 4);
		Affichage aff = new Affichage(plateau);
		aff.AffichePlateau();
		plateau.insertTetrimino();
		aff.AffichePlateau();
		plateau.checkFullLine();
		aff.AffichePlateau();
	}
}
