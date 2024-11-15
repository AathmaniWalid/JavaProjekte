package PkFoto;
import java.util.Arrays;

public class Album extends Fachobjekt{

private String besitzer;
private Foto[] fotos= new Foto[2];
private int anzFotos;
public Album(String name, String besitzer) {
	    super(name);
        this.besitzer = besitzer;
        this.anzFotos = 0;
} 

public Foto[] getFotos() {
	
        return fotos;
}
public void addFoto(Foto foto) {
        if(anzFotos == fotos.length)
        	fotos = Arrays.copyOf(fotos, fotos.length*2);
        
        fotos[anzFotos] = foto; 
        anzFotos++; 
  
}



public String getBesitzer() {
        return besitzer;
}



public String toString() {
    String result = super.toString() + "\nName: " + getName() + "\nBesitzer: " + besitzer + "\n";
    
    for(int i = 0; i< fotos.length; i++) {
    	 if (fotos[i] != null) {
    	result += "\n=== Foto " + (i + 1) + " ===\n";
    	result += fotos[i].toString();}
    	}
    return result;
    }

public void drucke() {
    
    System.out.println("Name: "+getName());
    System.out.println("Besitzer: "+besitzer);
    for (int i = 0; i < fotos.length; i++) {
    	   if (fotos[i] != null) {
    		   System.out.println("\n=== Foto " + (i + 1) + " ===");
               fotos[i].drucke();}
    }
  }
}