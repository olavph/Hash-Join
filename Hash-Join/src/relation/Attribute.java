package relation;

public class Attribute {

	private String name;
	
	public Attribute(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
