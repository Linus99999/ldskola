package symbolic;

import java.util.Map;

public class Subtraction extends Binary {
	public Subtraction(Sexpr sum, Sexpr sexpr) {
		super(sum, sexpr);
	}

	public String getName() {
		return "-";
	}

	public Sexpr eval(Map<String, Sexpr> Variables) {
		return Symbolic
				.subtraction(left.eval(Variables), right.eval(Variables));
	}

	public int priority() {
		return 1;
	}
}
