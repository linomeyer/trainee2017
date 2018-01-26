package cake;

public class Cake {
  private final Weight startWeight;
  private Fraction rest = new Fraction(1);

  /**
   * Creates new Cake without weight
   */
  public Cake() {
    this.startWeight = Weight.NO_WEIGHT;
  }

  /**
   * Creates new Cake with a weight
   */
  public Cake(Weight weight) {
    this.startWeight = weight;
  }

  public Fraction getRemovedPiece() {
    Fraction cake = new Fraction(1);
    return cake.subtract(rest);
  }

  public Weight getRemovedWeight() {
    Fraction removedPieces = new Fraction(getRemovedPiece());
    Weight removedWeight = startWeight.toMiliGramm();
    long removedAmount;

    removedAmount = removedWeight.getAmount() * removedPieces.getCounter() / removedPieces.getDenominator();

    removedWeight = new WeightMiliGramm(removedAmount);
    removedWeight = removedWeight.convertIntoHighestPossibleUnit();

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
    Weight weightInMiliGramm = weight.toMiliGramm();
    Weight startWeightInMiliGramm = startWeight.toMiliGramm();

    Fraction piece = new Fraction(weightInMiliGramm.getAmount(), startWeightInMiliGramm.getAmount());
    piece.shorten();
    piece = cut(piece);

    Weight cuttedWeight = new WeightMiliGramm(startWeightInMiliGramm.getAmount());
    cuttedWeight = new WeightMiliGramm(
        startWeightInMiliGramm.getAmount() * piece.getCounter() / piece.getDenominator());
    cuttedWeight = cuttedWeight.convertIntoHighestPossibleUnit();

    return cuttedWeight;
  }

  public Fraction getRest() {
    return rest;
  }

  Weight currentWeight() {
    Weight currentWeight = new WeightMiliGramm(startWeight.getAmount() * startWeight.getFactorToMiliGramm());

    currentWeight = currentWeight.toMiliGramm();
    currentWeight = new WeightMiliGramm(currentWeight.getAmount() * rest.getCounter() / rest.getDenominator());
    currentWeight = currentWeight.convertIntoHighestPossibleUnit();

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
