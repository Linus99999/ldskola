package symbolic;

import java.util.Map;

public class Division extends Binary {
	public Division(Sexpr sum, Sexpr sexpr) {
		super(sum, sexpr);
	}

	public String getName() {
		return "/";
	}

	public Sexpr eval(Map<String, Sexpr> Variables) {
		return Symbolic.division(left.eval(Variables), right.eval(Variables));
	}

	public int priority() {
		return 2;
	}
}
