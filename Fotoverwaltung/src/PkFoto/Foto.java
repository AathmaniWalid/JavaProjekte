package PkFoto;

import java.time.format.DateTimeFormatter;

public class Foto extends Fachobjekt{
	private String dateiName;
	private FotoMetadaten metadaten;
	
	
	public Foto(String name, String dateiName, FotoMetadaten metadaten) {
		super(name);
		this.dateiName = dateiName;
		this.metadaten = metadaten;
	}
	public void drucke() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm:ss");
		String formatiertesDatum = metadaten.erstellungszeitpunkt.format(dtf);
		
		System.out.println("Fotoname: " + this.getName());
		System.out.println("Dateiname: " + this.dateiName);
		System.out.println("Größe: " + this.metadaten.getBreite());
		System.out.println("Kamera: " + this.metadaten.getKameraMarke() + " " + this.metadaten.getKameraModell());
		System.out.println("Erstellungsdatum: " + formatiertesDatum);
	}
	public String toString() {
		return super.toString() + "\nname: " + getName() + "\nDateiName: " + dateiName + "\nMetaDaten: (" + metadaten.toString();	
	}
}
 