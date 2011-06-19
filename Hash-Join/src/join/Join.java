package join;

import relation.Relation;

public abstract class Join {
	
	protected Relation build, probe;
	protected String joinAttribute;
	
	public Join(Relation r1, Relation r2, String attribute) {
		if (r1.numberOfTuples() <= r2.numberOfTuples()) {
			build = r1;
			probe = r2;
		} else {
			build = r2;
			probe = r1;
		}
		this.joinAttribute = attribute;
	}
	
	public abstract int cost();
	public abstract Relation execute();
}
