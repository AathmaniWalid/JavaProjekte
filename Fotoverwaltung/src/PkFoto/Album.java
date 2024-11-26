package PkFoto;
import java.util.ArrayList;
import java.util.List;

public class Album extends Fachobjekt implements Comparable<Album>{

private String besitzer;
private List<Foto> fotos = new ArrayList<>();

public Album(String name, String besitzer) {
	super(name);
        this.besitzer = besitzer;
} 
public List<Foto> getFotos() {
        return fotos;
}
public void addFoto(Foto foto) {
        if (foto != null) {
        fotos.add(foto);
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
}