package uebungen;

public class Proportion2 extends Fracture{
	static Fracture distributed = new Fracture();
	
	Proportion2() {
		super();
	}
	
	Proportion2(int denominator, int counter) {
		Fracture a = new Fracture(distributed.getDenominator(), distributed.getCounter());
		Fracture b = new Fracture(counter, denominator);
	}
}
