package pk.foto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FotoMetadaten implements CsvExportable{

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


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + breite;
	result = prime * result + hoehe;
	result = prime * result + ((kameraMarke == null) ? 0 : kameraMarke.hashCode());
	result = prime * result + ((kameraModell == null) ? 0 : kameraModell.hashCode());
	result = prime * result + ((erstellungszeitpunkt == null) ? 0 : erstellungszeitpunkt.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	FotoMetadaten other = (FotoMetadaten) obj;
	if (breite != other.breite)
		return false;
	if (hoehe != other.hoehe)
		return false;
	if (kameraMarke == null) {
		if (other.kameraMarke != null)
			return false;
	} else if (!kameraMarke.equals(other.kameraMarke))
		return false;
	if (kameraModell == null) {
		if (other.kameraModell != null)
			return false;
	} else if (!kameraModell.equals(other.kameraModell))
		return false;
	if (erstellungszeitpunkt == null) {
		if (other.erstellungszeitpunkt != null)
			return false;
	} else if (!erstellungszeitpunkt.equals(other.erstellungszeitpunkt))
		return false;
	return true;
}



public String exportiereAlsCsv() {
    StringBuilder sb = new StringBuilder();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm:ss");
    String formatiertesDatum = erstellungszeitpunkt.format(dtf);
    sb.append(breite).append(",").append(hoehe).append(",").append(kameraMarke).append(",").append(kameraModell).append(",").append(formatiertesDatum).append("\n");
    return sb.toString();
}

}
