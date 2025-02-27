package pk.foto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;

import pk.foto.util.FotoUtil;

public class Album extends Fachobjekt implements Comparable<Album>, CsvExportable{

private String besitzer;
private List<Foto> fotos = new ArrayList<>();

public Album(String name, String besitzer) {
	super(name);
        this.besitzer = besitzer;
} 
public List<Foto> getFotos() {
        return fotos;
}
public void addFoto(Foto foto) throws FotoMetadatenException {

	 try {
	        FotoMetadaten metadaten = FotoUtil.readMetadata(foto.getFile());
	        foto.setMetadaten(metadaten);
	        fotos.add(foto);
	 } catch(ImageProcessingException | MetadataException | NullPointerException | IOException e) {
		 throw new FotoMetadatenException("Fehler beim Hinzufügen des Fotos. Metadaten konnten nicht gelesen werden.", e);
	 }
}
public String getBesitzer() {
        return besitzer;
}

public String toString() {
    String result = super.toString() + "\nName: " + getName() + "\nBesitzer: " + besitzer + "\n";
    int fotoNr=1;
    for(Foto foto : fotos) {
    	result += "\n=== Foto " + fotoNr + " ===\n";
    	result += foto.toString();
        fotoNr++;
    }
    	
    return result;
}

public void drucke() {
    int fotoNr=1;
    System.out.println("Name: "+getName());
    System.out.println("Besitzer: "+besitzer);
    for (Foto foto: fotos) {
    	System.out.println("\n=== Foto " + fotoNr + " ===");
        fotoNr++;
        foto.drucke();
        }
   }
@Override
public int compareTo(Album o) {
                if (this.getName() == null && o.getName() == null) 
                    return 0;
                if (this.getName() == null) 
                    return -1;   
                if (o.getName() == null) 
                    return 1;     
                return this.getName().compareTo(o.getName());
            }

public String exportiereAlsCsv() {
	StringBuilder stringbuilder = new StringBuilder();
	for(Foto foto: fotos){
	stringbuilder.append(super.exportiereAlsCsv()).append(", ").append(besitzer).append(", ").append(foto.exportiereAlsCsv());	
	}
	return stringbuilder.toString();
}

}