package PkFoto;

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

	public void addAlbum(Album album) {
		if (album != null)
         alben.add(album);
}

    public Album findeAlbumMitName(String name) {
	     for(Album album : alben) {
	    	 if(album.getName().equals(name))
	    		 return album;
	     }
	     return null;
	     }
    
	
}
