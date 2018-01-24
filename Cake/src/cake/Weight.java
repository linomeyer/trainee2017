package cake;

public abstract class Weight {
	private final String unit;
	private final int amount;
	private final int factorToMiliGramm;

	/*
	 * public Weight() { this.amount = 0; this.unit = "g"; this.factorToGramm = 1; }
	 * 
	 * public Weight(Weight weight) { amount = weight.getAmount(); unit =
	 * weight.getUnit(); factorToGramm = weight.getFactorToGramm(); }
	 * 
	 * /** Usable units: g, kg, t
	 */
	public Weight(int amount, String unit, int factorToMiliGramm) {
		this.unit = unit;
		this.amount = amount;
		this.factorToMiliGramm = factorToMiliGramm;
	}

	@Override
	public String toString() {
		return amount + unit;
	}

	public Weight add(Weight weight) {
		int amountA, amountB;

		amountA = this.amount * factorToMiliGramm;
		amountB = weight.getAmount() * weight.getFactorToMiliGramm();

		Weight res = new WeightMiliGramm(amountA + amountB);

		res = res.decideUnit();

		return res;
	}

	public Weight subtract(Weight weight) {
		int amountA, amountB;

		amountA = this.amount * factorToMiliGramm;
		amountB = weight.getAmount() * weight.getFactorToMiliGramm();

		Weight res = new WeightMiliGramm(amountA - amountB);

		res = res.decideUnit();

		return res;
	}

	Weight toMiliGramm() {
		return new WeightMiliGramm(amount * factorToMiliGramm);
	}

	Weight decideUnit() {
		Weight weightInMiliGramm = toMiliGramm();

		int amount = weightInMiliGramm.getAmount();
		if (amount % 1_000_000_000 == 0) {
			return new WeightTonns(amount / 1_000_000_000);
		} else {
			if (amount % 1_000_000 == 0) {
				return new WeightKG(amount / 1_000_000);
			} else {
				if (amount % 1_000 == 0) {
					return new WeightGramm(amount / 1_000);
				}
			}
		}
		return weightInMiliGramm;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Weight other = (Weight) obj;
		return this.equals(other);
	}

	boolean equals(Weight weight) {
		Weight a = this.toMiliGramm();
		Weight b = weight.toMiliGramm();
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

	int getFactorToMiliGramm() {
		return factorToMiliGramm;
	}
	/*
	 * int calculateFactorToMiliGramm() { switch (unit) { case "mg": return 1; case
	 * "g": return 1_000; case "kg": return 1_000_000; case "t": return
	 * 1_000_000_000; default: break; } return 0; }
	 */
}