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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateiName == null) ? 0 : dateiName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foto other = (Foto) obj;
		if (dateiName == null) {
			if (other.dateiName != null)
				return false;
		} else if (!dateiName.equals(other.dateiName))
			return false;
		return true;
	}
}
 