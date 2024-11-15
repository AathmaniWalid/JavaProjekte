package PkFoto;

import java.time.LocalDateTime;


public class FotoMetadaten {

private int breite;
private int hoehe;
private String kameraMarke;
private String kameraModell;
LocalDateTime erstellungszeitpunkt;




public FotoMetadaten(int breite, int hoehe, String kameraMarke, String kamreModell, LocalDateTime erstellungszeitpunkt) {
	
	this.breite = breite;
	this.hoehe = hoehe;
	this.kameraMarke = kameraMarke;
	this.kameraModell = kamreModell;
	this.erstellungszeitpunkt = erstellungszeitpunkt;
	
}


public String getKameraMarke() {
	return kameraMarke;
}


public String getKameraModell() {
	return kameraModell;
}



public int getBreite() {
	return breite;
}

public int getHoehe() {
	return hoehe;
}



public String toString() {
	return "Breite: " + breite + "\nHoehe: " + hoehe + "\nKameraMarke: " + kameraMarke + "\nKameraModell: " + kameraModell + "\nErstellungszeitpunkt: " + erstellungszeitpunkt + ")\n";
}
}
