package symbolic;

import java.util.Map;

public class Variable extends Atom {
	private String Ident;
	public Variable(String s) {
		Ident = s;
	}
	public String getName() {
		return Ident;
	}

	public Sexpr eval(Map<String, Sexpr> variables) {
		if (variables.containsKey(Ident)) {
			return variables.get(Ident);
		}
		variables.put(Ident, new Variable(Ident));
		return this;
	}

}
