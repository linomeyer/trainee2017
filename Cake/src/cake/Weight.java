package cake;

public class Weight {
	String unit;
	int amount;
	int factorToGramm;

	public Weight() {

	}

	/**
	 * Usable units: g, kg, t
	 */
	public Weight(int amount, String unit) {
		this.unit = unit;
		this.amount = amount;

		switch (unit) {
		case "g":
			factorToGramm = 1;

			break;
		case "kg":
			factorToGramm = 1000;
			break;
		case "t":
			factorToGramm = 1000000;
		default:
			break;
		}
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
	
	private void decideUnit() {
		amount *= factorToGramm;
		unit = "g";
		
		if (amount % 1000000 == 0) {
			unit = "t";
			amount /= 1000000;
		} else {
			if (amount % 1000 == 0) {
				unit = "kg";
				amount /= 1000;
			}
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

	void setUnit(String unit) {
		this.unit = unit;
	}

	void setAmount(int amount) {
		this.amount = amount;
	}
}
