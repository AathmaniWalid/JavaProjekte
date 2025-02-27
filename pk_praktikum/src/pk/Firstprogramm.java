package pk;


public class Firstprogramm {
    
    // Methode zum Zeichnen der Treppe
	//ouissal zin
    public static void maleTreppe(int hoehe, int stufentiefe) {
        for (int i = 1; i <= hoehe; i++) {
            // Anzahl der Sterne für jede Stufe berechnen
            int anzahlSterne = i * stufentiefe;
            // Geben Sie die entsprechende Anzahl von Sternen aus
            for (int j = 0; j < anzahlSterne; j++) {
                System.out.print("*");
            }
            // Neue Zeile nach jeder Stufe
            System.out.println();
        }
    }

    // main-Methode
    public static void main(String[] args) {
        // Aufruf der maleTreppe-Methode mit hoehe = 6 und stufentiefe = 2
        maleTreppe(6, 3);
    }
}

