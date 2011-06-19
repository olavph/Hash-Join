package relation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TemporaryRelation implements Relation {
	
	private ArrayList<String> columns;
	private ArrayList<Tuple> tuples;
	
	public TemporaryRelation(ArrayList<String> columns) {
		this.columns = columns;
		tuples = new ArrayList<Tuple>();
	}

	public TemporaryRelation(String ... columns) {
		this.columns = new ArrayList<String>();
		for (String column : columns) {
			this.columns.add(column);
		}
		tuples = new ArrayList<Tuple>();
	}

	@Override
	public List<String> getColumns() {
		return columns;
	}

	@Override
	public boolean addTuple(Tuple t) {
		if (t.size() == columns.size()) {
			tuples.add(t);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeTuple(Tuple t) {
		if (t.size() == columns.size()) {
			return tuples.remove(t);
		} else {
			return false;
		}
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
		String result = new String();
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
