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
		// TODO Auto-generated method stub
		return null;
	}

}
