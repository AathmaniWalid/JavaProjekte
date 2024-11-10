package pk.foto;

import java.util.Arrays;

public class FotoVerwaltung {
        private Album[] alben = new Album[2];
        private int anzAlben = 0;
        
public Album[] getAlben() {
        return alben;
}

public void druckeAlleAlben() {
       for(int i = 0; i<anzAlben; i++) {
    	   System.out.println("\n=== Album " + (i+1) + " ===" );
    	   alben[i].drucke();    
    			   }  
}

public int gibAnzahlAlben() {
	return anzAlben;  
}

public Album[] gibAlleAlben() {
	Album[] alleAlben = new Album[anzAlben];
       for(int i=0; i<anzAlben; i++) {
    	   if(alben[i]!= null) {
    	   alleAlben[i]=alben[i];
    	   }
       }
	return alleAlben;
}

public void addAlbum(Album album) {
        if(anzAlben == alben.length)
        	alben = Arrays.copyOf(alben, anzAlben*2);
        
        alben[anzAlben]= album;
        anzAlben++;
}

public Album findeAlbumMitName(String name) {
        if(name == null) {
        	return null;
        }
        for(int i=0; i < anzAlben; i++) {
        	if(alben[i].getName().equals(name))
        		return alben[i]; 	
        }
        return null;
}
}
