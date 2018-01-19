package cake;

public class Weight {
	private final String unit;
	private int amount;
	private final int factorToGramm;

	public Weight() {
		this.unit = "g";
		this.factorToGramm = 1;
	}

	public Weight(Weight weight) {
		amount = weight.getAmount();
		unit = weight.getUnit();
		factorToGramm = weight.getFactorToGramm();
	}

	/**
	 * Usable units: g, kg, t
	 */
	public Weight(int amount, String unit) {
		this.unit = unit;
		this.amount = amount;
		this.factorToGramm = calculateFactorToGramm();
	}

	@Override
	public String toString() {
		return amount + unit;
	}

	public Weight add(Weight weight) {
		int amountA, amountB;

		amountA = this.amount * factorToGramm;
		amountB = weight.getAmount() * weight.getFactorToGramm();

		Weight res = new Weight(amountA + amountB, "g");

		res.decideUnit();

		return res;
	}

	public Weight subtract(Weight weight) {
		int amountA, amountB;

		amountA = this.amount * factorToGramm;
		amountB = weight.getAmount() * weight.getFactorToGramm();

		Weight res = new Weight(amountA - amountB, "g");

		res.decideUnit();

		return res;
	}

	Weight toGramm() {
		return new Weight(amount * factorToGramm, "g");
	}

	Weight decideUnit() {
		Weight weightInGramm = toGramm();

		int amount = weightInGramm.getAmount();
		if (amount % 1_000_000 == 0) {
			return new Weight(amount / 1_000_000, "t");
		} else {
			if (amount % 1000 == 0) {
				return new Weight(amount / 1000, "kg");
			}
		}
		return weightInGramm;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Weight other = (Weight) obj;
		return this.equals(other);
	}

	boolean equals(Weight weight) {
		Weight a = new Weight(this);
		Weight b = new Weight(weight);
		a.toGramm();
		b.toGramm();
		if (a.getAmount() == b.getAmount()) {
			return true;
		} else {
			return false;
		}
	}

	int getAmount() {
		return amount;
	}

	String getUnit() {
		return unit;
	}

	int getFactorToGramm() {
		return factorToGramm;
	}

	void setAmount(int amount) {
		this.amount = amount;
	}

	int calculateFactorToGramm() {
		switch (unit) {
		case "g":
			return 1;
		case "kg":
			return 1000;
		case "t":
			return 1_000_000;
		default:
			break;
		}
		return 0;
	}
}