import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args){
		PlateauDeJeu plateau = new PlateauDeJeu(10, 5);
		Affichage aff = new Affichage(plateau);
		aff.AffichePlateau();
		plateau.insertTetrimino();
		aff.AffichePlateau();
		plateau.deplaceTetrimino(0, 0);
		aff.AffichePlateau();
		plateau.turnTetrimino();
		aff.AffichePlateau();
	}
}
