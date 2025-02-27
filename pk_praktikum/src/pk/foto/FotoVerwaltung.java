package pk.foto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class FotoVerwaltung {

	private Set<Album> alben = new TreeSet<>();

    public void druckeAlleAlben(){
    	Iterator<Album> iterator = alben.iterator();
    	int albumNr = 1;
    	while(iterator.hasNext()) {
    		Album album = iterator.next();
    		System.out.println("\n=== Album " + albumNr + " ===");
    		album.drucke();
    		albumNr++;
    	}
    }
    public Set<Album> gibAlleAlben() {
    	Set<Album> alleAlben = new TreeSet<>();
    	Iterator<Album> iterator= alben.iterator();
    	
    	while(iterator.hasNext()) {
    		alleAlben.add(iterator.next());
    	}
    	return alleAlben;
    }

    public int gibAnzahlAlben() {
    	return alben.size(); 
    }
    
    public Set<Album> getAlben() {
		return alben;
	}

	public void addAlbum(Album album) throws AlbumVorhandenException {
         for(Album alleAlben : alben) {
        	 if(alleAlben.getName().equals(album.getName()))
        	 throw new AlbumVorhandenException("Dieser Name existiert schon!");
         }
        	 alben.add(album);
}

    public Album findeAlbumMitName(String name) {
	    if (name == null) {
            return null;
        } 
		for(Album album : alben) {
	    	 if(album.getName().equals(name))
	    		 return album;
	     }
	     return null;
	     }
    
    public void exportiereEintraegeAlsCsv(File datei) throws IOException {
    	
    	 StringBuilder csv = new StringBuilder();
    	 csv.append("Album-ID, Name, Besitzer, Foto-ID, Name, Dateiname, Breite, Höhe, Kameramarke, Kameramodell, Erstellungszeitpunkt\n");
    	 
    	 for(Album album: alben) {
    		 
    		 csv.append(album.exportiereAlsCsv()).append("\n");
    		
    	 }
    	 
    	 Files.write(datei.toPath(), csv.toString().getBytes());
    }  
}
