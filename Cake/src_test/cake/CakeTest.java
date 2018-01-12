package cake;

import static org.hamcrest.CoreMatchers.is; 
import static org.junit.Assert.*;

import org.junit.Test;


public class CakeTest {
	
	private static final int NOT_RELEVANT_VALUE = 0;

	@Test
	public void cake_getRest_wholeCake() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		assertThat(schwarzwelder.getRest(), is(new Fraction(1)));
	}
	
	@Test
	public void cake_cutPiece_pieceRemoved() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		schwarzwelder.cut(1, 5);
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(1, 5)));
		assertThat(schwarzwelder.getRest(), is(new Fraction(4, 5)));
	}
	
	@Test
	public void cake_cutPiece_sizeOfPieceEqualsCutSize() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		Fraction cuttedPiece = schwarzwelder.cut(2, 5);
		
		assertThat(cuttedPiece, is(new Fraction(2, 5)));
	}
	
	@Test
	public void cake_cut2Pieces_bothPiecesRemoved() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		schwarzwelder.cut(1, 5);
		schwarzwelder.cut(1, 6);
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(11, 30)));
	}
	
	@Test
	public void cake_removeBiggerPieceThanAvailable_gotRestOfCake() throws Exception {
	 Cake zitronenCake = new Cake(NOT_RELEVANT_VALUE);
	 
	 zitronenCake.cut(4, 5);
	 Fraction piece = zitronenCake.cut(2, 5);
	 
	 assertThat(piece, is(new Fraction(1, 5)));
	}
	
	@Test
	public void cakeWithWeight_() throws Exception {
		Cake schwarzwelder = new Cake(500);
		assertThat(schwarzwelder.currentWeight(), is(500));
	}
	
	@Test
	public void cutWeight() throws Exception {
		Cake schwarzwelder = new Cake(500);
		
		int cuttedWeight = schwarzwelder.cut(100);
		
		assertThat(schwarzwelder.getRest(), is(new Fraction(4, 5)));
		assertThat(schwarzwelder.currentWeight(), is(400));
		assertThat(cuttedWeight, is(100));
	}
	
	@Test
	public void getRemovedWeight() throws Exception {
		Cake schwarzwelder = new Cake(500);
		
		schwarzwelder.cut(100);
		assertThat(schwarzwelder.getRemovedWeight(), is(100));
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(1, 5)));
	}
}
