package relation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemporaryRelation implements Relation {
	
	private String name;
	private ArrayList<String> columns;
	private ArrayList<Tuple> tuples;
	
	public TemporaryRelation(String name, ArrayList<String> columns) {
		this.name = name;
		this.columns = columns;
		tuples = new ArrayList<Tuple>();
	}

	public TemporaryRelation(String name, String ... columns) {
		this.name = name;
		this.columns = new ArrayList<String>();
		for (String column : columns) {
			this.columns.add(column);
		}
		tuples = new ArrayList<Tuple>();
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public List<String> getColumns() {
		return columns;
	}

	@Override
	public boolean addTuple(Tuple t) throws IncompatibleNumberOfElementsException {
		if (t.size() != columns.size())
			throw new IncompatibleNumberOfElementsException();
		
		return tuples.add(t);
	}
	

	@Override
	public boolean addTuple(Object ... elements) throws IncompatibleNumberOfElementsException {
		return addTuple(new Tuple(this, elements));
	}

	@Override
	public boolean removeTuple(Tuple t) throws IncompatibleNumberOfElementsException {
		if (t.size() != columns.size())
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
		for (String column : columns) {
			result += column + "\t";
		}
		result += "\n";
		for (Tuple tuple : tuples) {
			for (String column : columns) {
				result += tuple.get(column) + "\t";
			}
			result += "\n";
		}
		return result;
	}

}
