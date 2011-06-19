package join;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import relation.Attribute;
import relation.IncompatibleNumberOfElementsException;
import relation.Relation;
import relation.TemporaryRelation;
import relation.Tuple;

public class HashJoin extends Join {

	public HashJoin(String outputName, Relation r1, Relation r2, Attribute r1JoinAttribute, Attribute r2JoinAttribute) {
		super(outputName, r1, r2, r1JoinAttribute, r2JoinAttribute);
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Relation execute() {
		ArrayList<Attribute> outputAttributes = new ArrayList<Attribute>(build.getAttributes());
		outputAttributes.addAll(probe.getAttributes());
		
		TemporaryRelation output = new TemporaryRelation(outputName, outputAttributes);
		
		Hashtable<Object, Tuple> table = new Hashtable<Object, Tuple>();
		Iterator<Tuple> iterator = build.iterator();
		
		while (iterator.hasNext()) {
			Tuple current = iterator.next();
			table.put(current.get(buildJoinAttribute), current);
			
			// TODO check max memory
		}
		scan(output, table);
		
		return output;
	}

	private void scan(TemporaryRelation output, Hashtable<Object, Tuple> table) {
		Iterator<Tuple> iterator = probe.iterator();
		
		while (iterator.hasNext()) {
			Tuple current = iterator.next();
			if (table.containsKey(current.get(probeJoinAttribute))) {
				Tuple joinedTuple = new Tuple(table.get(current.get(probeJoinAttribute)));
				joinedTuple.putAll(current);
				try {
					output.addTuple(joinedTuple);
				} catch (IncompatibleNumberOfElementsException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
