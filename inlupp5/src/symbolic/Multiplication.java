package symbolic;

import java.util.Map;

public class Multiplication extends Binary {
	public Multiplication(Sexpr sum, Sexpr sexpr) {
		super(sum,sexpr);
	}
	public String getName() { 
		return "*";
	}
	public Sexpr eval(Map<String, Sexpr> Variables) {
		return Symbolic.multiplication(left.eval(Variables),right.eval(Variables));
		}
	public int priority() {
		return 2;
	}

}
