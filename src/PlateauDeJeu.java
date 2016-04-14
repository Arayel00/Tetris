import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PlateauDeJeu extends JPanel{
	
	//on évite les magic string
	static final String PLEIN = "@";
	static final String VIDE = "O";
	
	static final int rectSize = 50;

	int lignes;
	int colonnes;
	// la grille
	String TableauTetris[][];
	//point de reference pour insérer un tetrimino (inserer un nouveau en haut de la graille ou changer l'orientation)
	//ce point représente de point haut gache de chaque grille de tetrimino (orientation)
	Point2D reference_position;
	//tableau de point: chaque point est une brique du tetrimino. le tableau decrit donc sa position dans la grille
	ArrayList<Point2D> tetrimino_position;
	//objet tetrimino utilisé dans la grille
	Tetrimino tetrimino;
	
	//constructeur
	public PlateauDeJeu(int p_colonne, int p_ligne){
		lignes = p_ligne;
		colonnes = p_colonne;
		TableauTetris = new String[lignes][colonnes];
		
		for(int i=0; i<lignes; i++){
			for(int j=0; j<colonnes; j++){
				TableauTetris[i][j] = VIDE;
			}
		}
		initTetrimino();
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
	 
	//insert une orientation de tetrimino, donc appellee quand on on met 
	//un nouveau au haut de la grille ou quand la piece tourne
	//return true si la creation de la piece est bloquee (creation ou rotation)
	 public boolean insertTetrimino(){
		 int x = (int)reference_position.getX();
		 int y = (int)reference_position.getY();
		 ArrayList<Point2D> next_position = new ArrayList<Point2D>();
		 
		 for(int i=x; i<x+tetrimino.getTaille(); i++){
			 for(int j=y; j<y+tetrimino.getTaille(); j++){
				 if(tetrimino.isBrique(j-y, i-x)){
					 next_position.add(new Point(j, i));
				 }
			 }
		 }
		 if(isFreePosition(next_position)){
			 updateTetrimino(next_position);
			 return false;
		 }else{
			 return true;
		 }
	 }
	 
	 //deplace le tetrimino
	 public boolean deplaceTetrimino(int p_x, int p_y){
		 //creation du tableau contenant les points occupés par la prochaine position du tetrimino
		 ArrayList<Point2D> next_position = new ArrayList<Point2D>();
		 
		 for(int i=0; i<tetrimino_position.size(); i++){
			 next_position.add(new Point((int)tetrimino_position.get(i).getX()+p_x, (int)tetrimino_position.get(i).getY()+p_y));
		 }
		 
		 //la prochaine position est-elle valide
		 if(this.isFreePosition(next_position)){
			 //ajustement du point de reference
			 reference_position.setLocation((int)reference_position.getX() + p_y, (int)reference_position.getY() + p_x);
			 updateTetrimino(next_position);
		//la position n'est pas valide, on vérifie si le déplacement est vertical
		 }else if((int)tetrimino_position.get(1).getX()<(int)next_position.get(1).getX()){
			 //le déplacement est vertical ça la donc c'est la fin de la descente du tetrimino
			 return true;
		 }
		 //ce n'est pas la fin de la descente du tetrimino
		 return false;
	 }
	 
	 //verifie la position passée en paramtre (tableau de points) est libre
	 //renvoi true si la position est libre, false sinon
	 public boolean isFreePosition(ArrayList<Point2D> position){
		 for(int i=0; i<position.size(); i++){
			 Point2D p = position.get(i);
			 int x = (int)p.getX();
			 int y = (int)p.getY();
			 
			 //vérifie que chaque point sera dans la grille
			 if((x<0 || x>lignes-1 || y<0 || y>colonnes-1)){
				 return false;
			//vérifie que chaque point est soit un espace libre, soit une partie du tetrimino en déplacement
			 }else if(!tetrimino_position.contains(p) && (TableauTetris[x][y]!=VIDE)){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 //change l'orientation du tetrimino
	 public void turnTetrimino(){
		 int x = (int)reference_position.getX();
		 int y = (int)reference_position.getY();
		 
		 if(x>=0 && x<=colonnes-tetrimino.getTaille() && y>=0 && y<=lignes-tetrimino.getTaille()){
			 tetrimino.turn();
			 if(insertTetrimino()){
				 tetrimino.reverseTurn();
			 }
		 }
	 }
	 
	 //affiche le tetrimino dans la grille
	 public void displayTetrimino(){
		 for(int i=0; i<tetrimino_position.size(); i++){
			 TableauTetris[(int)tetrimino_position.get(i).getX()][(int)tetrimino_position.get(i).getY()]=PLEIN;
		 }
	 }
	 
	 //efface le tetrimino de la grille
	 public void clearTetrimino(){
		 for(int i=0; i<tetrimino_position.size(); i++){
			 TableauTetris[(int)tetrimino_position.get(i).getX()][(int)tetrimino_position.get(i).getY()]=VIDE;
		 }
	 }
	 
	 //initialise un nouveau tetrimino sur la grille
	 //renvoie ce que renvoie la fonction insertTerimino (pour rappel elle renvoie true si la creation du tetrimino est bloqué
	 //donc si initTetrimino renvoie true, le jeu est fini
	 public boolean initTetrimino(){
		tetrimino_position = new ArrayList<Point2D>();
		tetrimino = Tetrimino.randomTetrimino();
		reference_position = new Point(colonnes/2 - tetrimino.getTaille()/2, 0);
		return insertTetrimino();
	 }

	 //verifie si une ligne est complétée, la vide le cas échant
	 public void checkFullLine() {
		 int compteur = 0;
		 for(int i=0; i<lignes; i++){
			 for(int j=0; j<colonnes; j++){
				 if(TableauTetris[i][j] == PLEIN) {
					 compteur += 1;
				 }
			 }
			 if(compteur == colonnes){
				 for(int j=0; j<colonnes; j++){
					 TableauTetris[i][j] = VIDE;
				 }
				 decaleBrique(i);
			 }
			 compteur = 0;
		 }
	 }
	 
	 // decale vers le bas les briques au dessus de la ligne x
	 public void decaleBrique(int x){
		 for(int i=x-1; i>=0; i--){
			 for(int j=0; j<colonnes; j++){
				 if(TableauTetris[i][j]==PLEIN){
					 TableauTetris[i][j]=VIDE;
					 TableauTetris[i+1][j]=PLEIN;
				 }
			 }
		 }
	 }
	 
	 private void updateTetrimino(ArrayList<Point2D> t){
		 //efface le tetrimino de la grille
		 clearTetrimino();
		 //reset la position du tetrimino
		 tetrimino_position.clear();
		 //set la position du tetrimino
		 tetrimino_position.addAll(t);
		 //affiche le tetrimino dans la grille
		 displayTetrimino();
		 repaint();
	 }
	 
	 public void paint(Graphics g)
	 { 
		super.paint(g);
				
		int posX=0;
		int posY=0;
		
		for (int i=0; i<lignes; i++)
		{
			for (int j=0; j<colonnes; j++)
			{
				switch(TableauTetris[i][j])
				{
					case PLEIN:
						g.setColor(new Color(156, 93, 82));
						g.fillRect(posX,posY, rectSize, rectSize);
						break;
						
					case VIDE: 
						g.setColor(Color.GRAY);
						g.fillRect(posX,posY, rectSize, rectSize);
						break;
				}
				
				g.setColor(Color.BLACK);
				g.drawRect(posX,posY, rectSize,rectSize);
				
				posX+= rectSize;
			}
			posY+=rectSize;
			posX=0;
		}
	}
}

