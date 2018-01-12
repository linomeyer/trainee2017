package cake;

public class Fraction {
	private int counter;
	private int denominator;

	/**
	 * Creates new Fraction with initial size 0/1
	 */
	Fraction() {
		counter = 0;
		denominator = 1;
	}

	Fraction(int counter) {
		this.counter = counter;
		denominator = 1;
	}

	Fraction(int counter, int denominator) {
		this.counter = counter;
		this.denominator = denominator;
	}
	
	Fraction(Fraction fraction){
		counter = fraction.getCounter();
		denominator = fraction.getDenominator();
	}

	int getCounter() {
		return counter;
	}

	int getDenominator() {
		return denominator;
	}

	void set(Fraction fraction) {
		this.counter = fraction.getCounter();
		this.denominator = fraction.getDenominator();
	}
	
	void set(int counter, int denominator) {
		this.counter = counter;
		this.denominator = denominator;
	}
	
	void setCounter(int counter) {
		this.counter = counter;
	}

	void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	void out() {
		System.out.print(counter + "/" + denominator);
	}

	void shorten() {
		int m, n, r;
		m = Math.abs(counter);
		n = Math.abs(denominator);
		r = m % n;
		while (r > 0) {
			m = n;
			n = r;
			r = m % n;
		}
		counter /= n;
		denominator /= n;
	}

	void outShorten() {
		shorten();
		out();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (equals(other))
			return true;
		return false;
	}

	boolean equals(Fraction fracture) {
		Fraction a = new Fraction(this.counter, this.denominator);
		Fraction b = new Fraction(fracture.counter, fracture.denominator);
		a.shorten();
		b.shorten();
		if (a.counter == b.counter && a.denominator == b.denominator) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return counter + "/" + denominator;
	}
	
	Fraction add(Fraction fracture) {
		Fraction a = new Fraction(this.counter, this.denominator);
		Fraction b = new Fraction(fracture.counter, fracture.denominator);
		a.expand(fracture.denominator);
		b.expand(this.denominator);
		a.counter += b.counter;
		a.shorten();
		return a;
	}

	Fraction subtract(Fraction fracture) {
		Fraction a = new Fraction(this.counter, this.denominator);
		Fraction b = new Fraction(fracture.counter, fracture.denominator);
		a.expand(fracture.denominator);
		b.expand(this.denominator);
		a.counter -= b.counter;
		a.shorten();
		return a;
	}

	double decimal() {
		return (double) counter / denominator;
	}

	void expand(int value) {
		counter *= value;
		denominator *= value;
	}

	void multiply(Fraction fracture) {
		counter *= fracture.counter;
		denominator *= fracture.denominator;
	}
}
