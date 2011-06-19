package relation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemporaryRelation implements Relation {
	
	private String name;
	private List<Attribute> attributes;
	private ArrayList<Tuple> tuples;
	
	public TemporaryRelation(String name, List<Attribute> attributes) {
		this.name = name;
		this.attributes = attributes;
		tuples = new ArrayList<Tuple>();
	}

	public TemporaryRelation(String name, String ... attributeNames) {
		this.name = name;
		this.attributes = new ArrayList<Attribute>();
		for (String attribute : attributeNames) {
			this.attributes.add(new Attribute(attribute));
		}
		tuples = new ArrayList<Tuple>();
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}


	@Override
	public Attribute getAttribute(String attributeName) {
		for (Attribute att : attributes) {
			if (att.getName().equals(attributeName))
				return att;
		}
		return null;
	}
	
	@Override
	public boolean addTuple(Tuple t) throws IncompatibleNumberOfElementsException {
		if (t.size() != attributes.size())
			throw new IncompatibleNumberOfElementsException();
		
		return tuples.add(t);
	}
	

	@Override
	public boolean addTuple(Object ... elements) throws IncompatibleNumberOfElementsException {
		return addTuple(new Tuple(this, elements));
	}

	@Override
	public boolean removeTuple(Tuple t) throws IncompatibleNumberOfElementsException {
		if (t.size() != attributes.size())
			throw new IncompatibleNumberOfElementsException();
		
		return tuples.remove(t);
	}
	
	@Override
	public int numberOfTuples() {
		return tuples.size();
	}

	@Override
	public Iterator<Tuple> iterator() {
		return tuples.iterator();
	}
	
	@Override
	public String toString() {
		String result = name + ":\n";
		for (Attribute attribute : attributes) {
			result += attribute.getName() + "\t";
		}
		result += "\n";
		for (Tuple tuple : tuples) {
			for (Attribute attribute : attributes) {
				result += tuple.get(attribute) + "\t";
			}
			result += "\n";
		}
		return result;
	}

}
