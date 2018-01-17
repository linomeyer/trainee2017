package cake;

import static org.hamcrest.CoreMatchers.is; 
import static org.junit.Assert.*;

import org.junit.Test;


public class CakeTest {
	
	Weight NOT_RELEVANT_VALUE = new Weight(0, "g");

	@Test
	public void cake_getRest_wholeCake() throws Exception {
		Cake schwarzwelder = new Cake();
		assertThat(schwarzwelder.getRest(), is(new Fraction(1)));
	}
	
	@Test
	public void cake_cutPiece_pieceRemoved() throws Exception {
		Cake schwarzwelder = new Cake();
		schwarzwelder.cut(new Fraction(1, 5));
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(1, 5)));
		assertThat(schwarzwelder.getRest(), is(new Fraction(4, 5)));
	}
	
	@Test
	public void cake_cutPiece_sizeOfPieceEqualsCutSize() throws Exception {
		Cake schwarzwelder = new Cake();
		Fraction cuttedPiece = schwarzwelder.cut(new Fraction(2, 5));
		
		assertThat(cuttedPiece, is(new Fraction(2, 5)));
	}
	
	@Test
	public void cake_cut2Pieces_bothPiecesRemoved() throws Exception {
		Cake schwarzwelder = new Cake();
		schwarzwelder.cut(new Fraction(1, 5));
		schwarzwelder.cut(new Fraction(1, 6));
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(11, 30)));
	}
	
	@Test
	public void cake_removeBiggerPieceThanAvailable_gotRestOfCake() throws Exception {
	 Cake zitronenCake = new Cake();
	 
	 zitronenCake.cut(new Fraction(4, 5));
	 Fraction piece = zitronenCake.cut(new Fraction(2, 5));
	 
	 assertThat(piece, is(new Fraction(1, 5)));
	}
	
	@Test
	public void cakeWithWeight_currentWeight_wholeCake() throws Exception {
		Cake schwarzwelder = new Cake(new Weight(500, "g"));
		assertThat(schwarzwelder.currentWeight(), is(new Weight(500, "g")));
	}
	
	@Test
	public void cakeWithWeight_cutWeight_weightRemoved() throws Exception {
		Cake schwarzwelder = new Cake(new Weight(500, "g"));
		
		Weight cuttedWeight = schwarzwelder.cut(new Weight(100, "g"));
		
		assertThat(schwarzwelder.getRest(), is(new Fraction(4, 5)));
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(1, 5)));
		assertThat(schwarzwelder.currentWeight(), is(new Weight(400, "g")));
		assertThat(cuttedWeight, is(new Weight(100, "g")));
	}
}
