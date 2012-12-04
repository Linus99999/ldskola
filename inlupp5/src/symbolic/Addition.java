package symbolic;

import java.util.Map;

public class Addition extends Binary {
	public Addition(Sexpr sum, Sexpr sexpr) {
		super(sum, sexpr);
	}
	public String getName() {
		return "+";
		}
	public Sexpr eval(Map<String, Sexpr> Variables) {
		return Symbolic.addition(left.eval(Variables),right.eval(Variables));
		}
	public int priority() {
		return 1;
	}


}
