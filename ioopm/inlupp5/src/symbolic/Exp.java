package symbolic;

import java.util.Map;

public class Exp extends Unary {

	public Exp(Sexpr a) {
		super(a);
	}

	public Sexpr eval(Map<String, Sexpr> variables) {
		return Symbolic.exp(argument.eval(variables));
	}

	public String getName() {
		return "Exp";
	}

}
