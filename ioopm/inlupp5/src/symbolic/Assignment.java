package symbolic;

import java.util.Map;

public class Assignment extends Binary {
	public Assignment(Sexpr sum, Sexpr r) {
		super(sum, r);
	}

	public String getName() {
		return "=";
	}

	public Sexpr eval(Map<String, Sexpr> Variables) {
		//if (Variables.containsKey(left.getName()))
		//	Variables.put(right.getName(),
		//			Variables.get(left.getName()).eval(Variables));
	//	else
			Variables.put(right.getName(), left.eval(Variables));

		return Variables.get(right.getName());

	}
}
