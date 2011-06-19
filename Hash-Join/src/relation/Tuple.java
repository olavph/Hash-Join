package relation;

import java.util.HashMap;
import java.util.Map;

public class Tuple extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;

	public Tuple(Relation format, Object ... elements) throws IncompatibleNumberOfElementsException {
		if(format.getColumns().size() != elements.length)
			throw new IncompatibleNumberOfElementsException();
		
		for (int i = 0; i < elements.length; i++) {
			put(format.getColumns().get(i), elements[i]);
		}
	}
	
	public Tuple(int initialCapacity) {
		super(initialCapacity);
	}

	public Tuple(Map<? extends String, ? extends Object> m) {
		super(m);
	}

	public Tuple(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

}
