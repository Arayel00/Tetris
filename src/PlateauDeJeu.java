import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class PlateauDeJeu {

	int lignes;
	int colonnes;
	String TableauTetris[][];
	Point2D reference_position;
	ArrayList<Point2D> tetrimino_position;
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
		
		tetrimino_position = new ArrayList<Point2D>();
		tetrimino = Tetrimino.I;
		reference_position = new Point(colonnes/2 - tetrimino.getTaille()/2, 0);
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
		 int x = (int)reference_position.getX();
		 int y = (int)reference_position.getY();
		 clearTetrimino();
		 tetrimino_position.clear();
		 
		 for(int i=x; i<x+tetrimino.getTaille(); i++){
			 for(int j=y; j<y+tetrimino.getTaille(); j++){
				 if(tetrimino.isBrique(j-y, i-x)){
					 tetrimino_position.add(new Point(j, i));
				 }
			 }
		 }
		 displayTetrimino();
	 }
	 
	 public void deplaceTetrimino(int p_x, int p_y){
		 ArrayList<Point2D> next_position = new ArrayList<Point2D>();
		 
		 for(int i=0; i<tetrimino_position.size(); i++){
			 next_position.add(new Point((int)tetrimino_position.get(i).getX()+p_x, (int)tetrimino_position.get(i).getY()+p_y));
		 }
		 
		 System.out.println(tetrimino_position);
		 System.out.println(next_position);
		 
		 if(this.isFreePosition(next_position)){
			 clearTetrimino();
			 reference_position.setLocation((int)reference_position.getX() + p_x, (int)reference_position.getY() + p_y);
			 for(int i=0; i<tetrimino_position.size(); i++){
				 tetrimino_position.get(i).setLocation((int)next_position.get(i).getX() + p_x, (int)next_position.get(i).getY() + p_y);
			 }
			 displayTetrimino();
		 }
	 }
	 
	 public boolean isFreePosition(ArrayList<Point2D> position){
		 for(int i=0; i<position.size(); i++){
			 Point2D p = position.get(i);
			 if(!tetrimino_position.contains(p) && (TableauTetris[(int)p.getX()][(int)p.getY()]!="0")){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public void turnTetrimino(){
		 int x = (int)reference_position.getX();
		 int y = (int)reference_position.getY();
		 if(x>=0 && x<=colonnes && y>=0 && y<=lignes){
			 tetrimino.turn();
			 insertTetrimino();
		 }
	 }
	 
	 public void displayTetrimino(){
		 for(int i=0; i<tetrimino_position.size(); i++){
			 TableauTetris[(int)tetrimino_position.get(i).getX()][(int)tetrimino_position.get(i).getY()]="@";
		 }
	 }
	 
	 public void clearTetrimino(){
		 for(int i=0; i<tetrimino_position.size(); i++){
			 TableauTetris[(int)tetrimino_position.get(i).getX()][(int)tetrimino_position.get(i).getY()]="0";
		 }
	 }

}

