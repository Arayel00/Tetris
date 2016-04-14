import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main{
	
	public static void main(String[] args) throws IOException{
		PlateauDeJeu plateau = new PlateauDeJeu(10, 5);
		Affichage aff = new Affichage(plateau);
		plateau.insertTetrimino();
		aff.AffichePlateau();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		   while (line.equalsIgnoreCase("quit") == false) {
		       line = in.readLine();
		    
		       if(line.equals("z")){
		    	   plateau.turnTetrimino();
		       }
				if(line.equals("q")){
					plateau.deplaceTetrimino(0, -1);	    	   
						       }
				if(line.equals("d")){
					plateau.deplaceTetrimino(0, 1);
				}
				if(line.equals("s")){
					if(plateau.deplaceTetrimino(1, 0)){
						plateau.checkFullLine();
						if(plateau.initTetrimino()){
							System.out.println("GAME OVER");
						}
					}
				}
				aff.AffichePlateau();
		   }

		   in.close();
	}
	
}
