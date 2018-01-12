package cake;

public class Cake{
	private int startWeightInGramm;
	Fraction rest = new Fraction(1);
	
	/**
	 * Creates new Cake without weight
	 */
	public Cake() {
	}
	
	public Cake(int weightInGramm) {
		startWeightInGramm = weightInGramm;
	}
	
	public Fraction getRemovedPiece() {
		Fraction cake = new Fraction(1);
		return cake.subtract(rest);
	}
	
	public int getRemovedWeight() {
		Fraction removedPieces = new Fraction(getRemovedPiece());
		return startWeightInGramm * removedPieces.getCounter() / removedPieces.getDenominator();
	}
	
	public Fraction cut(int counter, int denominator) {
		Fraction piece = new Fraction(counter, denominator);
		return cut(piece);
	}
	
	public Fraction cut(Fraction piece) {
		if(canCutPiece(piece)) {
			rest = rest.subtract(piece);
			return piece;
		} else {
			Fraction rest = new Fraction(getRest());
			this.rest = this.rest.subtract(getRest());
			return rest;
		}
	}
	
	public int cut(int weightInGramm) {
		Fraction piece = new Fraction(weightInGramm, startWeightInGramm);
		piece.shorten();
		piece = cut(piece);
		return startWeightInGramm * piece.getCounter() / piece.getDenominator();
	}
	
	public Fraction getRest() {
		return rest;
	}
	
	int currentWeight(){
		return startWeightInGramm * rest.getCounter() / rest.getDenominator();
	}
	
	boolean canCutPiece(Fraction piece) {
		Fraction a = new Fraction(getRest());
		Fraction b = new Fraction(piece);
		a.expand(piece.getDenominator());
		b.expand(getRest().getDenominator());
		if(b.getCounter() <= a.getCounter()) {
			return true;
		}
		else {
			return false;
		}
	}
}
