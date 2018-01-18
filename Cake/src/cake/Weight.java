package cake;

public class Weight {
	String unit;
	int amount;
	int factorToGramm;

	public Weight() {

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
		calculateFactorToGramm();
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
	
	void toGramm() {
		unit = "g";
		amount *= factorToGramm;
		factorToGramm = 1;
	}
	
	void decideUnit() {
		toGramm();
		
		if (amount % 1000000 == 0) {
			unit = "t";
			amount /= 1000000;
			factorToGramm = 1000000;
		} else {
			if (amount % 1000 == 0) {
				unit = "kg";
				amount /= 1000;
				factorToGramm = 1000;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Weight other = (Weight)obj;
		return this.equals(other);
	}
	
	boolean equals(Weight weight) {
		Weight a = new Weight(this);
		Weight b = new Weight(weight);
		a.toGramm();
		b.toGramm();
		if(a.getAmount() == b.getAmount()) {
			return true;
		}else {
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

	void setUnit(String unit) {
		this.unit = unit;
		calculateFactorToGramm();
	}

	void setAmount(int amount) {
		this.amount = amount;
	}
	
	void set(Weight weight) {
		amount = weight.getAmount();
		unit = weight.getUnit();
		factorToGramm = weight.getFactorToGramm();
	}
	
	void calculateFactorToGramm() {
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
}
