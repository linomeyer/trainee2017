import javax.swing.*;

public class ZahlensystemeUmrechnen {

	public static void main(String[] args) {
		double anfangsZahlDouble;
		int anfangsZahlInt;
		String anfangsZahl = "";
		String anfangsZahlKomma = "";
		int anfangsFormat = 0;
		int zielFormat = 0;
		String way = "";
		String input = "";

		input = JOptionPane.showInputDialog("Geben Sie die Anfangszahl ein:");
		input = input.toLowerCase();
		anfangsZahl = input;

		input = JOptionPane.showInputDialog("Geben Sie das Anfangszahlenformat ein:");
		anfangsFormat = Integer.parseInt(input);

		int length = anfangsZahl.length();
		int dot = anfangsZahl.indexOf(".");
		if(dot < 0)
			dot = length;
		input = anfangsZahl;
		anfangsZahl = "";
		for (int x = 0; x < dot; x++) {
			anfangsZahl += input.charAt(x);
		}
		for (int x = dot + 1; x < length; x++) {
			anfangsZahlKomma += input.charAt(x);
		}

		input = JOptionPane.showInputDialog("Geben Sie das Zielzahlenformat ein:");
		zielFormat = Integer.parseInt(input);

		if (zielFormat == 10) {
			way = toDecimal(anfangsZahl, anfangsZahlKomma, anfangsFormat, way)[1];
		} else {
			if (anfangsFormat == 10) {
				way = fromDecimalToOther(anfangsZahl, anfangsZahlKomma, zielFormat, way)[1];
			} else {
				String[] returned = toDecimal(anfangsZahl, anfangsZahlKomma, anfangsFormat, way);

				way = returned[1];
				input = returned[0];

				length = input.length();
				dot = input.indexOf(".");
				if(dot < 0)
					dot = length;
				anfangsZahl = "";
				anfangsZahlKomma = "";
				for (int x = 0; x < dot; x++) {
					anfangsZahl += input.charAt(x);
				}
				for (int x = dot + 1; x < length; x++) {
					anfangsZahlKomma += input.charAt(x);
				}

				way = fromDecimalToOther(anfangsZahl, anfangsZahlKomma, zielFormat, way)[1];
			}
		}
		System.out.println(way);
	}

	private static String[] fromDecimalToOther(String anfangsZahl, String anfangsZahlKomma, int zielFormat,
			String way) {
		int rest = 0;
		double restKomma = 0.00;
		int zwischenZahl = 0;
		double zwischenZahlKomma = 0.00;
		String zielZahl;

		way += "----------ins " + zielFormat + "er-System----------\n\n";
		zwischenZahl = Integer.parseInt(anfangsZahl);
		int zwischenZahl1 = zwischenZahl;
		zielZahl = "";
		while (zwischenZahl != 0) {
			way += zwischenZahl + " / " + zielFormat;
			zwischenZahl1 = zwischenZahl;
			zwischenZahl /= zielFormat;
			rest = zwischenZahl1 % zielFormat;
			if (zielFormat == 16)
				zielZahl += Integer.toHexString(rest);
			else
				zielZahl += rest;
			way += " = " + zwischenZahl + " Rest: " + rest + "\n";
		}
		StringBuilder zielZahl1 = new StringBuilder(zielZahl);
		zielZahl1.reverse();
		zielZahl = zielZahl1.toString();
		way += "\nErgebnis: " + zielZahl + "\n\n";
		zielZahl += ".";
		anfangsZahlKomma = "0." + anfangsZahlKomma;
		zwischenZahlKomma = Double.parseDouble(anfangsZahlKomma);
		for (int x = 1; zwischenZahlKomma >= 0.1 && x <= 5; x++) {
			rest = 0;
			way += zwischenZahlKomma + " * " + zielFormat;
			zwischenZahlKomma *= (double) zielFormat;
			zwischenZahlKomma = (double) ((int) (zwischenZahlKomma * 1000)) / 1000.0;
			if (zwischenZahlKomma - 1.00 >= 0) {
				rest = (int) zwischenZahlKomma;
				zwischenZahlKomma -= rest;
				zwischenZahlKomma = (double) ((int) (zwischenZahlKomma * 1000)) / 1000.0;
			}
			if (zielFormat == 16)
				zielZahl += Integer.toHexString(rest);
			else
				zielZahl += rest;
			way += " = " + zwischenZahlKomma + " + " + rest + "\n";
		}
		way += "\nErgebnis: " + zielZahl + "\n\n\n";
		return new String[] { zielZahl, way };
	}

	private static String[] toDecimal(String anfangsZahl, String anfangsZahlKomma, int anfangsFormat, String way) {
		String charAt = "";
		int zwischenZahl = 0;
		double zwischenZahlKomma = 0.00;
		double zielZahlKomma1 = 0;
		String zielZahlKomma = "";
		String zielZahl;
		int rest = 0;

		way += "----------ins 10er-System----------\n\n";
		int zielZahl1 = 0;
		int length = anfangsZahl.length();
		int y = 0;
		for (int x = length - 1; x >= 0; x--) {
			charAt = Character.toString(anfangsZahl.charAt(x));
			if (anfangsFormat > 10)
				zwischenZahl = Integer.parseInt(charAt, anfangsFormat);
			else
				zwischenZahl = Integer.parseInt(charAt);
			way += zwischenZahl + " * " + anfangsFormat + "^" + y;
			zwischenZahl *= Math.pow(anfangsFormat, y);
			zielZahl1 += zwischenZahl;
			way += " = " + zwischenZahl + "\n";
			y++;
		}
		zielZahl = Integer.toString(zielZahl1);
		way += "\nErgebnis: " + zielZahl + "\n\n";
		length = anfangsZahlKomma.length();
		zielZahl += ".";
		y = 0;
		for (int x = 1; y < length; x++) {
			charAt = Character.toString(anfangsZahlKomma.charAt(y));
			if (anfangsFormat > 10)
				zwischenZahlKomma = Integer.parseInt(charAt, anfangsFormat);
			else
				zwischenZahlKomma = Integer.parseInt(charAt);
			way += zwischenZahlKomma + " / " + anfangsFormat + "^" + x;
			zwischenZahlKomma /= Math.pow(anfangsFormat, x);
			zwischenZahlKomma = (double) ((int) (zwischenZahlKomma * 1000)) / 1000.0;
			zielZahlKomma1 += zwischenZahlKomma;
			way += " = " + zwischenZahlKomma + "\n";
			y++;
		}
		zielZahlKomma1 = (double) ((int) (zielZahlKomma1 * 1000)) / 1000.0;
		zielZahlKomma = Double.toString(zielZahlKomma1);
		length = zielZahlKomma.length();
		for (int x = 2; x < length; x++) {
			zielZahl += Character.toString(zielZahlKomma.charAt(x));
		}
		way += "\nErgebnis: " + zielZahl + "\n\n\n";
		return new String[] { zielZahl, way };
	}
}
