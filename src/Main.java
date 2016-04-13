import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args){
		PlateauDeJeu plateau = new PlateauDeJeu(10, 5);
		Affichage aff = new Affichage(plateau);
		plateau.insertTetrimino();
		aff.AffichePlateau();
		plateau.deplaceTetrimino(0, 1);
		aff.AffichePlateau();
		/*plateau.turnTetrimino();
		aff.AffichePlateau();*/
	}
}
