package PkFoto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FotoVerwaltung {

	
	private List<Album> alben= new ArrayList<>(); 
	
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

    public List<Album> gibAlleAlben() {
    	List<Album> alleAlben = new ArrayList<>();
    	Iterator<Album> iterator= alben.iterator();
    	
    	while(iterator.hasNext()) {
    		alleAlben.add(iterator.next());
    	}
    	return alleAlben;
    }

    public int gibAnzahlAlben() {
    	return alben.size(); 
    }
    
    public List<Album> getAlben() {
		return alben;
	}

	public void addAlbum(Album album) {
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
