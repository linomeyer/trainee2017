package excercise06;

public class Proportion extends Fracture{		//erweitert Klasse "Fracture"
	static Fracture fracture = new Fracture();	//Initialisiere Klasse "Fracture" als "divide"
	
	Proportion() {
		super();	//ruft Konstruktor der Oberklasse "Fracture" auf
	}
	Proportion(int denominator, int counter) {	//Konstruktor mit 2 Parameter
		Fracture a = new Fracture(fracture.getCounter(), fracture.getDenominator());
		Fracture b = new Fracture(counter, denominator);
		if(a.add(b).getCounter() <= a.add(b).getDenominator()) { //Bruch darf nict grösser gleich 1.00 sein
			super.setCounter(counter);	//setze "setCounter" der Superklasse auf die lokale Variable "counter" 
			super.setDenominator(denominator);	//setze "setDenominator" der Superklasse auf die lokale Variable "denominator"
		} else {
			super.setCounter(0);	//setze "setCounter" auf 0
			super.setDenominator(1);	//setze "setDenominator" auf 1 
		}
		fracture = fracture.add(this);
	}
	void setCounter(int counter) {	//setter Methode
		Fracture a = new Fracture(fracture.getCounter(), fracture.getDenominator());
		Fracture b = new Fracture(counter, this.getDenominator());
		if(a.add(b).getCounter() <= a.add(b).getDenominator()) {
			super.setCounter(counter);
		} else {
			super.setCounter(0);	//setze "setCounter" auf 0
			super.setDenominator(1);	//setze "setDenominator" auf 1 
		}
		fracture = fracture.add(this);
	}
	void setDenominator(int denominator) {	//setter Methode
		Fracture a = new Fracture(fracture.getCounter(), fracture.getDenominator());
		Fracture b = new Fracture(this.getCounter(), denominator);
		if(a.add(b).getCounter() <= a.add(b).getDenominator()) {
			super.setDenominator(denominator);
		} else {
			super.setCounter(0);	//setze "setCounter" auf 0
			super.setDenominator(1);	//setze "setDenominator" auf 1 
		}
		fracture = fracture.add(this);
	}
	double getDivide() { //getter Methode
		return (double) fracture.getCounter() / fracture.getDenominator(); //Gibt einen double wert der Division von "getCounter" und "getDenominator" der Superklasse aus
	}		
	Fracture getDivideFacture() {
		return fracture;
	}
	String getRemaining() {
		return fracture.getCounter() + "/" + fracture.getDenominator();
	}
}
