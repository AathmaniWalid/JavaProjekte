package pk.foto;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu{

	private FotoVerwaltung fotoVerwaltung;
	private Scanner sc;
	
	Menu(FotoVerwaltung fotoVerwaltung){
		this.fotoVerwaltung = fotoVerwaltung;
		this.sc = new Scanner(System.in);
	}
    public void menuAnzeigen(){
		int auswahl=0;
		do {
			try {
			System.out.println("\nFoto-App");
            System.out.println("\n1. Album hinzufügen");
            System.out.println("2. Drucke alle Alben");
            System.out.println("3. Drucke Album mit Name");
            System.out.println("4. CSV-Export");
            System.out.println("5. Beenden");
            System.out.print("\nBitte Aktion wählen: ");
            
            auswahl = sc.nextInt();
   
               if(auswahl < 1 || auswahl > 5) {
                  throw new UngueltigeWahlException("Ungültige Wahl. Bitte wählen Sie eine Zahl zwischen 1 und 5.");
               }
            
            } catch(InputMismatchException exp){
            	System.out.println("Ungültige Eingabe.");
            	sc.nextLine();
            } catch(UngueltigeWahlException exp){
            	System.out.println(exp.getMessage());
            }
			
    		switch (auswahl) {
            case 1:
            	String neuAlbumName = "";
                
            	while(true) {
                	try {
            	neuAlbumName = eingabemitExceptionHandling("Geben Sie den Namen des Albums ein:");
            	break;
            	
                } catch(UngueltigeEingabeException exp) {
                	JOptionPane.showMessageDialog(null, exp.getMessage(), "fehler", JOptionPane.ERROR_MESSAGE);
                }
                }
                String albumBesitzer = JOptionPane.showInputDialog(null,"Geben Sie den Namen des Besitzers ein:");
                Album neuesAlbum = null;
                neuesAlbum = new Album(neuAlbumName,albumBesitzer);
            	try{
            		fotoVerwaltung.addAlbum(neuesAlbum);
            		JOptionPane.showMessageDialog(null, "Album wurde erfolgreich hinzugefügt!", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
            	} catch(AlbumVorhandenException exp){
            		JOptionPane.showMessageDialog(null, exp.getMessage(), "fehler", JOptionPane.ERROR_MESSAGE);
            		break;
            	}
            	int fotosFrage = JOptionPane.showConfirmDialog(null, "Wollen Sie Fotos hinzufügen?","Weitere Fotos", JOptionPane.YES_NO_OPTION);
            	
            	if(fotosFrage == JOptionPane.YES_OPTION) {
            		boolean weiteresFoto = true;
            		while(weiteresFoto) {
            		String fotoName = "";
            		while(true) {
            		try {
            		fotoName = eingabemitExceptionHandling("Geben Sie den Namen des Fotos ein:");
            		break;
            		} catch(UngueltigeEingabeException exp) {
            			JOptionPane.showMessageDialog(null, exp.getMessage(), "fehler", JOptionPane.ERROR_MESSAGE);

            		}
            		}
            		String dateiName = JOptionPane.showInputDialog(null,"Geben Sie den Dateinamen des Fotos ein:");
            		
            		File fotoFile = new File("images/" + dateiName);
            		while (!fotoFile.exists()) {
            		    JOptionPane.showMessageDialog(null, "Die Datei existiert nicht. Geben Sie bitte einen gültigen Dateinamen ein.", "Fehler!", JOptionPane.ERROR_MESSAGE);
            		    dateiName = JOptionPane.showInputDialog(null, "Geben Sie den Dateinamen des Fotos ein:");
            		    fotoFile = new File("images/" + dateiName);
            		    }
            		
            		Foto neuesFoto = new Foto(fotoName, dateiName, new FotoMetadaten(1920, 1080,"Kamera","Modell", LocalDateTime.now()));
            		
            		try {
						neuesAlbum.addFoto(neuesFoto);
					} catch (FotoMetadatenException e) {
						JOptionPane.showMessageDialog(null, "Fehler beim Hinzufügen des Fotos: ", "Fehler", JOptionPane.ERROR_MESSAGE);
		                break;

					}
            		
            		int antwort2 = JOptionPane.showConfirmDialog(null, "Möchten Sie ein weiteres Foto hinzufügen?", "Weitere Foto?", JOptionPane.YES_NO_OPTION);
            		
            		weiteresFoto = (antwort2==JOptionPane.YES_OPTION);
            	    }
            	}
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
            	
            	String dateiname = "";
				
            	while(true) {try {
					dateiname = eingabemitExceptionHandling("Geben Sie den Dateinamen für den CSV-Export ein:") + ".csv";
					File datei = new File(dateiname);
					int antwort=0;
					if(datei.exists()) {
					antwort = JOptionPane.showConfirmDialog(null, "die Datei existiert bereits, möchten Sie fortfahren?", "Datei überschreiben?", JOptionPane.YES_NO_OPTION);
					} if (antwort != JOptionPane.YES_OPTION) {
					    continue;
					}
					
					fotoVerwaltung.exportiereEintraegeAlsCsv(datei);
					JOptionPane.showMessageDialog(null, "Daten wurden erfolgreich in die Datei exportiert.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
					break;
				} catch (UngueltigeEingabeException exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage(), "fehler", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Ein Fehler ist während des Exports aufgetreten: " + e.getMessage(), "Export-Fehler", JOptionPane.ERROR_MESSAGE);
			        break; 
				}
            	}
            	break;
			case 5:
            	System.out.println("Programm beendet.");
            	break;
            }
		}
		while(auswahl != 5);
}
		String eingabemitExceptionHandling(String message) throws UngueltigeEingabeException{
			String eingabe = JOptionPane.showInputDialog(null, message);
			if(eingabe == null || eingabe.trim().isEmpty()) {
				throw new UngueltigeEingabeException("Üngültige Eingabe. die Eingabe darf nicht leere sein!");
			}
			return eingabe;
		}
}



