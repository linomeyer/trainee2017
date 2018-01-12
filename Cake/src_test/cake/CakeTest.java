package cake;

import static org.hamcrest.CoreMatchers.is; 
import static org.junit.Assert.*;

import org.junit.Test;


public class CakeTest {
	
	private static final int NOT_RELEVANT_VALUE = 0;

	@Test
	public void getPieces() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		assertThat(schwarzwelder.getRest(), is(new Fraction(1)));
	}
	
	@Test
	public void cutPiece() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		schwarzwelder.cut(1, 5);
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(1, 5)));
		schwarzwelder.cut(1, 6);
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(11, 30)));
	}
	
	@Test
	public void moreCakeTest() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		Cake zitronenkuchen = new Cake(NOT_RELEVANT_VALUE);
		schwarzwelder.cut(1, 2);
		zitronenkuchen.cut(2, 5);
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(1, 2)));
		assertThat(zitronenkuchen.getRemovedPiece(), is(new Fraction(2, 5)));
	}
	
	@Test
	public void restOfCakeTest() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		assertThat(schwarzwelder.getRest(), is(new Fraction(1)));
	}
	
	@Test
	public void restAfterCutTest() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		assertThat(schwarzwelder.getRest(), is(new Fraction(1)));
		schwarzwelder.cut(2, 3);
		assertThat(schwarzwelder.getRest(), is(new Fraction(1, 3)));
	}
	
	@Test
	public void GetRemovedPieceTest() throws Exception {
		Cake schwarzwelder = new Cake(NOT_RELEVANT_VALUE);
		schwarzwelder.cut(3, 5);
		assertThat(schwarzwelder.getRemovedPiece(), is(new Fraction(3, 5)));
	}
	
	@Test
	public void removeBiggerPieceThanAvailable_gotSmallerPieceAndCakeEaten() throws Exception {
	 Cake zitronenCake = new Cake(NOT_RELEVANT_VALUE);
	 
	 Fraction piece = zitronenCake.cut(2, 1);
	 
	 assertThat(piece, is(new Fraction(1)));
	}
	
	@Test
	public void cakeWithWeight() throws Exception {
		Cake schwarzwelder = new Cake(500);
		assertThat(schwarzwelder.getWeight(), is(500));
	}
	
	@Test
	public void cutWeight() throws Exception {
		Cake schwarzwelder = new Cake(500);
		
		int cuttedWeight = schwarzwelder.cut(100);
		
		assertThat(schwarzwelder.getRest(), is(new Fraction(4, 5)));
		assertThat(schwarzwelder.getWeight(), is(400));
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
