package cake;

public class Cake {
	private final Weight startWeight;
	private Fraction rest = new Fraction(1);

	/**
	 * Creates new Cake without weight
	 */
	public Cake() {
		this.startWeight = new Weight();
	}

	/**
	 * Creates new Cake with a weight
	 */
	public Cake(Weight weight) {
		this.startWeight = new Weight(weight);
	}

	public Fraction getRemovedPiece() {
		Fraction cake = new Fraction(1);
		return cake.subtract(rest);
	}

	public Weight getRemovedWeight() {
		Fraction removedPieces = new Fraction(getRemovedPiece());
		Weight removedWeight = startWeight.toGramm();
		int removedAmount;
		
		removedAmount = removedWeight.getAmount() * removedPieces.getCounter() / removedPieces.getDenominator();
		
		removedWeight = new Weight(removedAmount, "g");
		removedWeight = removedWeight.decideUnit();

		return removedWeight;
	}

	public Fraction cut(Fraction piece) {
		if (canCutPiece(piece)) {
			rest = rest.subtract(piece);
			return piece;
		} else {
			Fraction rest = new Fraction(getRest());
			this.rest = this.rest.subtract(getRest());
			return rest;
		}
	}

	public Weight cut(Weight weight) {
		Weight weightInGramm = weight.toGramm();
		Weight startWeightInGramm = startWeight.toGramm();

		Fraction piece = new Fraction(weightInGramm.getAmount(), startWeightInGramm.getAmount());
		piece.shorten();
		piece = cut(piece);

		Weight cuttedWeight = new Weight(startWeightInGramm);
		cuttedWeight = new Weight(startWeightInGramm.getAmount() * piece.getCounter() / piece.getDenominator(), "g");
		cuttedWeight = cuttedWeight.decideUnit();
		
		return cuttedWeight;
	}

	public Fraction getRest() {
		return rest;
	}

	Weight currentWeight() {
		Weight currentWeight = new Weight(startWeight);

		currentWeight = currentWeight.toGramm();
		currentWeight = new Weight(currentWeight.getAmount() * rest.getCounter() / rest.getDenominator(), "g");
		currentWeight = currentWeight.decideUnit();

		return currentWeight;
	}

	boolean canCutPiece(Fraction piece) {
		Fraction a = new Fraction(getRest());
		Fraction b = new Fraction(piece);
		a.expand(piece.getDenominator());
		b.expand(getRest().getDenominator());
		if (b.getCounter() <= a.getCounter()) {
			return true;
		} else {
			return false;
		}
	}
}
