package PkFoto;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	private FotoVerwaltung fotoVerwaltung;
	private Scanner sc;
	
	Menu(FotoVerwaltung fotoVerwaltung){
		this.fotoVerwaltung = fotoVerwaltung;
		this.sc = new Scanner(System.in);
	}
public void menuAnzeigen() {
		int auswahl;
		do {
			System.out.println("\nFoto-App");
            System.out.println("\n1. Album hinzufügen");
            System.out.println("2. Drucke alle Alben");
            System.out.println("3. Drucke Album mit Name");
            System.out.println("4. Beenden");
            System.out.print("\nBitte Aktion wählen: ");
            
            auswahl = sc.nextInt();

    		switch (auswahl) {
            case 1:
                
            	String neuAlbumName = JOptionPane.showInputDialog(null,"Geben Sie den Namen des Albums ein:");
            	
            	String albumBesitzer = JOptionPane.showInputDialog(null,"Geben Sie den Namen des Besitzers ein:");
            	
            	Album neuesAlbum = new Album(neuAlbumName,albumBesitzer);
            	
            	int fotosFrage = JOptionPane.showConfirmDialog(null, "Wollen Sie Fotos hinzufügen?","Weitere Fotos", JOptionPane.YES_NO_OPTION);
            	
            	if(fotosFrage == JOptionPane.YES_OPTION) {
            		boolean weiteresFoto = true;
            	    while(weiteresFoto) {
            		String fotoName = JOptionPane.showInputDialog(null,"Geben Sie den Namen des Fotos ein:");
            		
            		String dateiName = JOptionPane.showInputDialog(null,"Geben Sie den Dateinamen des Fotos ein:");
            		
            		Foto neuesFoto = new Foto(fotoName, dateiName, new FotoMetadaten(1920, 1080,"Kamera","Modell", LocalDateTime.now()));
            		
            		neuesAlbum.addFoto(neuesFoto);
            		
            		int antwort2 = JOptionPane.showConfirmDialog(null, "Möchten Sie ein weiteres Foto hinzufügen?", "Weitere Foto?", JOptionPane.YES_NO_OPTION);
            		
            		weiteresFoto = (antwort2==JOptionPane.YES_OPTION);
            	    }
            	};
            	fotoVerwaltung.addAlbum(neuesAlbum);
            	break;
            case 2:
                fotoVerwaltung.druckeAlleAlben();
                break;
            case 3:
                String albumName = JOptionPane.showInputDialog(null,"Geben Sie den Namen des Albums ein");
                if (albumName != null && !albumName.isEmpty()) {
                	Album album = fotoVerwaltung.findeAlbumMitName(albumName);
                	if(album !=null) {
                	System.out.println("Album gefunden:");
                	album.drucke();}
                	else
                		System.out.println("Es gibt kein Album mit diesem Namen");}
                else 
                	System.out.println("Geben Sie bitte einen gültigen Namen");                 
                break;
            case 4:
                System.out.println("Programm beendet.");
                break;
            default:
                System.out.println("Ungültige Wahl. Bitte wählen Sie eine Zahl zwischen 1 und 4.");
       
            }
		}
		while(auswahl != 4);
		
		}
}