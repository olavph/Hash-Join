package join;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import relation.Relation;
import relation.TemporaryRelation;
import relation.Tuple;

public class HashJoin extends Join {

	public HashJoin(Relation r1, Relation r2, String attribute) {
		super(r1, r2, attribute);
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Relation execute() {
		ArrayList<String> outputColumns = new ArrayList<String>(build.getColumns());
		outputColumns.addAll(probe.getColumns());
		outputColumns.remove(joinAttribute);
		TemporaryRelation output = new TemporaryRelation(outputColumns);
		
		Hashtable<Object, Tuple> table = new Hashtable<Object, Tuple>();
		Iterator<Tuple> iterator = build.iterator();
		
		while (iterator.hasNext()) {
			Tuple current = iterator.next();
			table.put(current.get(joinAttribute), current);
			
			// TODO check max memory
		}
		scan(output, table);
		
		return output;
	}

	private void scan(TemporaryRelation output, Hashtable<Object, Tuple> table) {
		Iterator<Tuple> iterator = probe.iterator();
		
		while (iterator.hasNext()) {
			Tuple current = iterator.next();
			if (table.containsKey(current.get(joinAttribute))) {
				Tuple joinedTuple = new Tuple(table.get(current.get(joinAttribute)));
				joinedTuple.putAll(current);
				output.addTuple(joinedTuple);
			}
		}
	}

}
