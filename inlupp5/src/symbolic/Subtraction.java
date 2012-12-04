package symbolic;

import java.util.Map;
public class Subtraction extends Binary {
	public Subtraction(Sexpr sum, Sexpr sexpr) {
		super(sum,sexpr);
	}
		// TODO Auto-generated constructor stub
	
	public String getName() { 
		return "-";
	}
	@Override
	public Sexpr eval(Map<String, Sexpr> Variables) {
		return Symbolic.subtraction(left.eval(Variables),right.eval(Variables));
		}
	public int priority() {
		return 1;
	}
}
