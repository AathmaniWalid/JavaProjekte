package pk.foto;

import java.io.File;
import pk.foto.util.FotoUtil;

public class Tester {

	public static void main(String[] args) throws Exception {
		
		
		FotoVerwaltung fotoVerwaltung = new FotoVerwaltung();
		
		Menu menu1 = new Menu(fotoVerwaltung);
		Album ersterAlbum = new Album("Städte","Alex Hornfischer");
		
		fotoVerwaltung.addAlbum(ersterAlbum);
		
		Album zweiterAlbum = new Album("Natur", "Simon Tuber");
		
		fotoVerwaltung.addAlbum(zweiterAlbum);
		
		File file1 = new File("images/16524319597_c735c777a8_o.jpg");
		FotoMetadaten fotoMetadaten1 = FotoUtil.readMetadata(file1);
	    Foto foto1= new Foto("Frankfurt", file1.getName(), fotoMetadaten1);
	    ersterAlbum.addFoto(foto1);
	    
	    
	    File file2 = new File("images/35835723323_b3ed4bf5d1_o.jpg");
	    FotoMetadaten fotoMetadaten2= FotoUtil.readMetadata(file2);
	    Foto foto2= new Foto("Dortmund", file2.getName(), fotoMetadaten2);
	    ersterAlbum.addFoto(foto2);
	    //nxnxn
	    
	    File file3 = new File("images/7861351302_74a45956dd_o.jpg");
	    FotoMetadaten fotoMetadaten3= FotoUtil.readMetadata(file3);
	    Foto foto3= new Foto("Strand", file3.getName(), fotoMetadaten3);
	    zweiterAlbum.addFoto(foto3);
	    
	    File file4 = new File("images/9207173484_852e8d983a_o.jpg");
	    FotoMetadaten fotoMetadaten4= FotoUtil.readMetadata(file4);
	    Foto foto4= new Foto("Baum", file4.getName(), fotoMetadaten4);
	    zweiterAlbum.addFoto(foto4);
	    
	    File file5 = new File("images/DSC02033.jpg");
	    FotoMetadaten fotoMetadaten5= FotoUtil.readMetadata(file5);
	    Foto foto5= new Foto("Berger", file5.getName(), fotoMetadaten5);
	    zweiterAlbum.addFoto(foto5);
	 
	   
	    menu1.menuAnzeigen();
	    
	}
}
