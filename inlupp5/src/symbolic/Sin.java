package symbolic;

import java.util.*;

public class Sin extends Unary {

	public Sin(Sexpr a) {
		super(a);
	}

	public Sexpr eval(Map<String, Sexpr> variables) {
		return Symbolic.sin(argument.eval(variables));
	}

	public String getName() {
		return "Sin";
	}

}
