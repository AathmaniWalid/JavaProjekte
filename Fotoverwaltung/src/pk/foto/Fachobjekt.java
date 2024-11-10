package pk.foto;

import java.util.UUID;

public abstract class Fachobjekt {
    private String name;
	protected final String id;
	
	
	
	public Fachobjekt(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
	}
	
	

	public String getName() {
		return name;
	}



	public String getId() {
		return id;
	}


	public abstract void drucke();
	
}
