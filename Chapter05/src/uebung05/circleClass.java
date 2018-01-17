package uebung05;

public class circleClass {
	
	double radius;
	
	double getRadius() {
		return (double)radius;
	}
	
	public circleClass(double r) {
		radius = r;
	}
	public circleClass() {
		radius = 0;
	}
	double umfang() {
		return (double) 2 * radius * 3.14;
	}
	
	double flaeche() {
		return (double) radius * radius * 3.14;
	}

	void setFlaeche(double f) {
		radius = Math.sqrt(f / 3.14);
	}
	
	void setUmfang(double u) {
		radius = u / 3.14 / 2;
	}
}
