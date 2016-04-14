import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import junit.framework.TestCase;


public class PlateauDeJeuTest extends TestCase {
	static final int COLONNES = 5;
	static final int LIGNES = 5;
	
	@Before
	public void initialize() {
	}
	
	@Test
	public void testcheckFullLine() {
		PlateauDeJeu pj = new PlateauDeJeu(LIGNES, COLONNES);
		PlateauDeJeu pjAttendu = new PlateauDeJeu(LIGNES, COLONNES);
		for(int i=0; i<LIGNES; i++){
			for(int j = 0; j<COLONNES; j++) {	
				pj.TableauTetris[i][j] = "O";
			}
		}
		for(int j = 0; j<COLONNES; j++) {	
			pj.TableauTetris[0][j] = "@";
		}
		pj.checkFullLine();
	
		for(int i=0; i<LIGNES; i++){
			for(int j = 0; j<COLONNES; j++) {	
				pjAttendu.TableauTetris[i][j] = "O";
			}
		}
		Assert.assertArrayEquals(pjAttendu.TableauTetris, pj.TableauTetris);
	}
	
	@Test
	public void testclearTetrimino(){
		PlateauDeJeu pj = new PlateauDeJeu(LIGNES, COLONNES);
		pj.resetPlateau();
		pj.clearTetrimino();
		
		PlateauDeJeu pjAttendu = new PlateauDeJeu(LIGNES, COLONNES);
		for(int i=0; i<LIGNES; i++){
				for(int j = 0; j<COLONNES; j++) {	
					pjAttendu.TableauTetris[i][j] = "O";
				}
		}
		Assert.assertArrayEquals(pjAttendu.TableauTetris, pj.TableauTetris);
	}
	
	@Test
	public void testdisplayTetrimino(){
		PlateauDeJeu pj = new PlateauDeJeu(LIGNES, COLONNES);
		pj.resetPlateau();
		pj.displayTetrimino();
		boolean vide = true;
		for(int i=0; i<LIGNES; i++){
			for(int j = 0; j<COLONNES; j++) {	
				if(pj.TableauTetris[i][j] == "@"){
					vide = false;
					break;
				}
			}
		}
		assertEquals(false, vide);
	}
	
	
	
	
}
