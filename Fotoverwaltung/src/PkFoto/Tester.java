package PkFoto;

import java.time.LocalDateTime;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {
		
		FotoVerwaltungArray fotoVerwaltung1 = new FotoVerwaltungArray();
		FotoVerwaltung fotoVerwaltung2 = new FotoVerwaltung();
		
		Menu menu1 = new Menu(fotoVerwaltung2);
		Album ersterAlbum = new Album("Städte","Alex Hornfischer");
		fotoVerwaltung1.addAlbum(ersterAlbum);
		fotoVerwaltung2.addAlbum(ersterAlbum);
		
		Album zweiterAlbum = new Album("Natur", "Simon Tuber");
		fotoVerwaltung1.addAlbum(zweiterAlbum);
		fotoVerwaltung2.addAlbum(zweiterAlbum);
		
	    FotoMetadaten fotoMetadaten1= new FotoMetadaten(1920, 1080, "Sony", "Alpha 6000", LocalDateTime.now());
	    Foto foto1= new Foto("Frankfurt", "images/7861351303.jpg", fotoMetadaten1);
	    ersterAlbum.addFoto(foto1);
	    
	    FotoMetadaten fotoMetadaten2= new FotoMetadaten(2400, 1344, "Canon", "EOS R1", LocalDateTime.now());
	    Foto foto2= new Foto("Dortmund", "images/7861368573.jpg", fotoMetadaten2);
	    ersterAlbum.addFoto(foto2);
	    
	    
	    FotoMetadaten fotoMetadaten3= new FotoMetadaten(4000, 4000, "Canon", "EOS R5", LocalDateTime.now());
	    Foto foto3= new Foto("Strand", "images/7861368980.jpg", fotoMetadaten3);
	    zweiterAlbum.addFoto(foto3);
	    
	    FotoMetadaten fotoMetadaten4= new FotoMetadaten(2656, 2656, "Nikon", "Z 8", LocalDateTime.now());
	    Foto foto4= new Foto("Baum", "images/7861360098.jpg", fotoMetadaten4);
	    zweiterAlbum.addFoto(foto4);
	    
	    FotoMetadaten fotoMetadaten5= new FotoMetadaten(1920, 1080, "Sony", "Alpha 6000", LocalDateTime.now());
	    Foto foto5= new Foto("Berger", "images/786136123.jpg", fotoMetadaten5);
	    zweiterAlbum.addFoto(foto5);
	    // für die Klasse FotoVerwaltungArray
		
	/*    System.out.println("Alle Alben:\n");
	    fotoVerwaltung1.druckeAlleAlben();
	    
	    System.out.println("Anzahl der Alben: "+ fotoVerwaltung1.gibAnzahlAlben());
	    
	    System.out.println("\nListe aller Alben:");
	    Album[] alleAlben = fotoVerwaltung1.gibAlleAlben();
	    for(int i=0; i< alleAlben.length; i++){
		    if(alleAlben[i] != null)
			   System.out.println("Album " + (i+1) + ": " + alleAlben[i].getName() );
	    }
	    
	    System.out.println("\nSuche nach Album: Natur ");
	    Album findeAlbum = fotoVerwaltung1.findeAlbumMitName("Natur");
	    if(findeAlbum != null)
	    {
		    System.out.println("Album gefunden: " );
		    System.out.println(findeAlbum.toString()); }
	    else
		    System.out.println("Es wird kein Album gefunden");
	   */
	    
	    System.out.println("Alle Alben:\n");
	    fotoVerwaltung2.druckeAlleAlben();
	    
	    System.out.println("\nAnzahl der Alben: "+ fotoVerwaltung2.gibAnzahlAlben());
	    
	    System.out.println("\nListe aller Alben:");
        Set<Album> alleAlben = fotoVerwaltung2.gibAlleAlben();
        int albumNummer = 1;
        for (Album album : alleAlben) {
            System.out.println("Album " + albumNummer + ": " + album.getName());
            albumNummer++;}
	    
	    System.out.println("\nSuche nach Album: Natur ");
	    Album findeAlbum = fotoVerwaltung2.findeAlbumMitName("Natur");
	    if(findeAlbum != null)
	    {
		    System.out.println("Album gefunden: " );
		    System.out.println(findeAlbum.toString()); }
	    else
		    System.out.println("Es wird kein Album gefunden");
	    
	    menu1.menuAnzeigen();
	}

}
