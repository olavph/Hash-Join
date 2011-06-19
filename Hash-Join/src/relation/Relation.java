package relation;

import java.util.List;

public interface Relation extends Iterable<Tuple> {
	List<String> getColumns();
	
	// t must have the same size as table columns
	// returns true if t has been added, false otherwise
	boolean addTuple(Tuple t);
	
	// returns true if t was in table, false otherwise
	boolean removeTuple(Tuple t);

	int numberOfTuples();
}
