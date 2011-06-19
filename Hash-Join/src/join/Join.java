package join;

import relation.Attribute;
import relation.Relation;

public abstract class Join {
	
	protected String outputName;
	protected Relation build, probe;
	protected Attribute buildJoinAttribute, probeJoinAttribute;
	
	public Join(String outputName, Relation r1, Relation r2, Attribute r1JoinAttribute, Attribute r2JoinAttribute) {
		this.outputName = outputName;
		if (r1.numberOfTuples() <= r2.numberOfTuples()) {
			build = r1;
			probe = r2;
			buildJoinAttribute = r1JoinAttribute;
			probeJoinAttribute = r2JoinAttribute;
		} else {
			build = r2;
			probe = r1;
			buildJoinAttribute = r2JoinAttribute;
			probeJoinAttribute = r1JoinAttribute;
		}
	}
	
	public abstract int cost();
	public abstract Relation execute();
}
