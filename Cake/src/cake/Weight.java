package cake;

public class Weight {
	String unit;
	int amount;
	int factorToGramm;
	
	public Weight() {
		
	}
	/**
	 *  Usable units: g, kg, t
	 *  */
	public Weight(int amount, String unit) {
		this.unit = unit;
		this.amount = amount;
		
		switch (unit) {
		case "g": factorToGramm = 1;
			
			break;
		case "kg": factorToGramm = 1000;
			break;
		case "t": factorToGramm = 1000000;
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		return amount + unit;
	}
	
	public Weight add(Weight weight) {
		String unitA, unitB;
		int amountA, amountB;
		
		amountA = this.amount;
		unitA = this.unit;
		amountB = weight.getAmount();
		unitB = weight.getUnit();
		
		
		
		return null;
	}
	
	int getAmount() {
		return amount;
	}
	
	String getUnit() {
		return unit;
	}
	
}
