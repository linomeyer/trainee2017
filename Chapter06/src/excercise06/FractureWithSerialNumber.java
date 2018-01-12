package excercise06;

public class FractureWithSerialNumber extends Fracture{
	static int FactureCounter;
	final int serialNumber = FactureCounter + 1;

	FractureWithSerialNumber() {
	super();
	FactureCounter += 1;
	}

	FractureWithSerialNumber(int counter) {
	super(counter);
	FactureCounter += 1;
	}

	FractureWithSerialNumber(int counter, int denominator) {
	super(counter, denominator);
	FactureCounter += 1;
	}

	int getSerialNumber() {
	return serialNumber;
	}
}
