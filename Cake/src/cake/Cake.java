package cake;

public class Cake {
	Weight startWeight;
	Fraction rest = new Fraction(1);

	/**
	 * Creates new Cake without weight
	 */
	public Cake() {
	}

	/**
	 * Creates new Cake with a weight
	 */
	public Cake(Weight weight) {
		this.startWeight.set(weight);
	}

	public Fraction getRemovedPiece() {
		Fraction cake = new Fraction(1);
		return cake.subtract(rest);
	}

	public Weight getRemovedWeight() {
		Fraction removedPieces = new Fraction(getRemovedPiece());
		Weight removedWeight = new Weight(startWeight);

		removedWeight.toGramm();
		removedWeight.setAmount(removedWeight.getAmount() * removedPieces.getCounter() / removedPieces.getDenominator());
		removedWeight.calculateFactorToGramm();

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
		Weight weightInGramm = new Weight(weight);
		weightInGramm.toGramm();
		Weight startWeightInGramm = new Weight(startWeight);
		startWeightInGramm.toGramm();

		Fraction piece = new Fraction(weightInGramm.getAmount(), startWeightInGramm.getAmount());
		piece.shorten();
		piece = cut(piece);

		Weight cuttedWeight = new Weight(startWeightInGramm);
		cuttedWeight.setAmount(startWeightInGramm.getAmount() * piece.getCounter() / piece.getDenominator());
		return cuttedWeight;
	}

	public Fraction getRest() {
		return rest;
	}

	Weight currentWeight() {
		Weight currentWeight = new Weight(startWeight);

		currentWeight.toGramm();
		currentWeight.setAmount(currentWeight.getAmount() * rest.getCounter() / rest.getDenominator());
		currentWeight.calculateFactorToGramm();

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
