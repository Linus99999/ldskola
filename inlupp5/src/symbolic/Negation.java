package symbolic;

import java.util.Map;

public class Negation extends Unary {

	public Negation(Sexpr a) {
		super(a);
	}

	@Override
	public String getName() {

		return "~";
	}

	public Sexpr eval(Map<String, Sexpr> variables) {
		return Symbolic.negation(argument.eval(variables));
	}

}
