import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class PlateauDeJeu {

	int lignes;
	int colonnes;
	String TableauTetris[][];
	Point2D reference_position;
	//ArrayList<Point2D> tetrimino_position;
	int x_ref;
	int y_ref;
	Tetrimino tetrimino;
	
	public PlateauDeJeu(int p_colonne, int p_ligne){
		lignes = p_ligne;
		colonnes = p_colonne;
		TableauTetris = new String[lignes][colonnes];
		
		for(int i=0; i<lignes; i++){
			for(int j=0; j<colonnes; j++){
				TableauTetris[i][j] = "0";
			}
		}
		
		tetrimino = Tetrimino.I;
		x_ref = colonnes/2 - tetrimino.getTaille()/2;
		y_ref = 0;
		tetrimino.turn();
	}
	
	public String toString(){
		 String retour="";
		 for(int i=0; i<lignes;i++){
			 for(int j=0; j<colonnes;j++){
				 retour += TableauTetris[i][j];
			 }
			 retour += "\n";
		 }
		 return retour;
	 }
	 
	 public void insertTetrimino(){
		 //reference_position = new Point(colonnes/2 - tetrimino.getTaille()/2, 0);
		 //int x = (int)reference_position.getX();
		 
		 for(int i=x_ref; i<x_ref+tetrimino.getTaille(); i++){
			 for(int j=y_ref; j<y_ref+tetrimino.getTaille(); j++){
				 if(tetrimino.isBrique(j-y_ref, i-x_ref)){
					 TableauTetris[j][i]="@";
					 //tetrimino_position.add(new Point(j, i));
				 }
			 }
		 }
	 }
	 
	 public void descendTetrimino(){
		 /*ArrayList<Point2D> next_position = new ArrayList<Point2D>();
		 next_position.addAll(tetrimino_position);
		 for(int i=0; i<next_position.size(); i++){
			 Point2D temp = next_position.get(i);
			 temp.setLocation(temp.getX(), temp.getY()+1);
		 }*/
		 if(this.isFree(x_ref, y_ref+1/*next_position*/)){
			 
			 y_ref++;
			 insertTetrimino();
		 }
	 }
	 
	 public boolean isFree(int x, int y/*ArrayList<Point2D> position*/){
		 for(int i=x; i<x+tetrimino.getTaille(); i++){
			 for(int j=y; j<y+tetrimino.getTaille(); j++){
				 if(tetrimino.isBrique(j-y, i-x) && TableauTetris[j][i]!="0"){
					 return false;
					 //tetrimino_position.add(new Point(j, i));
				 }
			 }
		 }
		 /*for(int i=0; i<position.size(); i++){
			 if(TableauTetris[(int)position.get(i).getX()][(int)position.get(i).getY()]!="0"){
				 return false;
			 }
		 }*/
		 return true;
	 }

}


