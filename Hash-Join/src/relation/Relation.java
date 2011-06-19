package relation;

import java.util.List;

public interface Relation extends Iterable<Tuple> {
	String getName();
	List<Attribute> getAttributes();
	Attribute getAttribute(String attributeName);
	
	// t must have the same size as relation attributes
	// returns true if t has been added, false otherwise
	boolean addTuple(Tuple t) throws IncompatibleNumberOfElementsException;
	
	boolean addTuple(Object ... elements) throws IncompatibleNumberOfElementsException;
	
	// returns true if t was in table, false otherwise
	boolean removeTuple(Tuple t) throws IncompatibleNumberOfElementsException;

	int numberOfTuples();
}
