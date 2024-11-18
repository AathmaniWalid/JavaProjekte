package PkFoto;
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

	public String toString() {
        return "ID: " + id;
    }
	
	public abstract void drucke();



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fachobjekt other = (Fachobjekt) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}

