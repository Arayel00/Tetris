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
		plateau.descendTetrimino();
		aff.AffichePlateau();
		
		
		ArrayList<Point2D> tetrimino_position = new ArrayList<Point2D>();
		tetrimino_position.add(new Point(1,2));
		tetrimino_position.add(new Point(3,2));
		
		System.out.println(tetrimino_position.contains(new Point(1,2)));
	}
}
