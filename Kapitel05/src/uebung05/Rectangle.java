package uebung05;

public class Rectangle {
	double laenge;
	double breite;

	public Rectangle() {
		laenge = 0.00;
		breite = 0.00;
	}

	public Rectangle(double l, double b) {
		laenge = l;
		breite = b;
	}
	
	void setLaenge(double l) {
		laenge = l;
	}
	
	void setBreite(double b) {
		breite = b;
	}
	
	void setSeiten(double l, double b) {
		laenge = l;
		breite = b;
	}
	
	double getLaenge() {
		return (double) laenge;
	}
	
	double getBreite() {
		return (double) breite;
	}
	
	double getLangeSeite() {
		if (laenge > breite) {
			return (double) laenge;
		} else {
			return (double) breite;
		}
	}
	
	double getKurzeSeite() {
		if (laenge < breite) {
			return (double) laenge;
		} else {
			return (double) breite;
		}
	}
	
	double getDiagonale() {
		return (double) Math.sqrt(laenge * laenge + breite * breite);
	}
	
	double getFlaeche() {
		return (double) laenge * breite;
	}
	
	double getUmfang() {
		return (double) 2 * laenge + 2 * breite;
	}
	
	void laengeAusgeben() {
		double laenge = 5.4;
		System.out.println("Laenge: " + laenge);
	}
	void laengeVergroessern(double l) {
		laenge += l;
	}
	
	void laengeVerkleinern(double l) {
		laenge -= l;
	}
	
	void breiteVergroessern(double b) {
		breite += b;
	}
	
	void breiteVerkleinern(double b) {
		breite -= b;
	}
	
	void outLaenge() {
		System.out.println("Laenge (klein/gross): " + laenge);
	}
	
	void outBreite() {
		System.out.println("Breite (klein/gross): " + breite);
	}
}









