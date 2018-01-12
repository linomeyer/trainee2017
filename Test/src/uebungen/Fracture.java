package uebungen;

public class Fracture {
	private int counter;
	private int denominator;

	Fracture() {
		counter = 0;
		denominator = 1;
	}

	Fracture(int counter) {
		this.counter = counter;
		denominator = 1;
	}

	Fracture(int counter, int denominator) {
		this.counter = counter;
		this.denominator = denominator;
	}

	int getCounter() {
		return counter;
	}

	int getDenominator() {
		return denominator;
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

	String fractureToString() {
		return counter + "/" + denominator;
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

	boolean equals(Fracture fracture) {
		Fracture a = new Fracture(this.counter, this.denominator);
		Fracture b = new Fracture(fracture.counter, fracture.denominator);
		a.shorten();
		b.shorten();
		if (a.counter == b.counter && a.denominator == b.denominator) {
			return true;
		} else {
			return false;
		}
	}

	Fracture add(Fracture fracture) {
		Fracture a = new Fracture(this.counter, this.denominator);
		Fracture b = new Fracture(fracture.counter, fracture.denominator);
		a.expand(fracture.denominator);
		b.expand(this.denominator);
		a.counter += b.counter;
		a.shorten();
		return a;
	}

	Fracture subtract(Fracture fracture) {
		Fracture a = new Fracture(this.counter, this.denominator);
		Fracture b = new Fracture(fracture.counter, fracture.denominator);
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

	void multiply(Fracture fracture) {
		counter *= fracture.counter;
		denominator *= fracture.denominator;
	}
}
