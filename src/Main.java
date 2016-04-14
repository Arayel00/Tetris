import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main implements KeyListener{
	
	PlateauDeJeu plateau;
	
	public Main(){
		plateau = new PlateauDeJeu(10, 5);
		
		JFrame frame = new JFrame("Tetris");
		frame.setMinimumSize(new Dimension(640,480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(plateau, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		plateau.addKeyListener(this);
		plateau.requestFocusInWindow();
		
		Horloge a = new Horloge();
		a.init();
		
		while(true){
			if(a.cycleDone(System.nanoTime())){
				plateau.descendreTetrimino();
			}
		}
	}

	
		
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT:
				plateau.deplaceTetrimino(0, 1);
				break;
			case KeyEvent.VK_LEFT:
				plateau.deplaceTetrimino(0, -1);
				break;
			case KeyEvent.VK_UP:
				plateau.turnTetrimino();
				break;
			case KeyEvent.VK_DOWN:
				plateau.descendreTetrimino();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new Main();
	}
	
	
	
}
