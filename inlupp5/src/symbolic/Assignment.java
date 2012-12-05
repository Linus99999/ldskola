package symbolic;

import java.util.Map;

public class Assignment extends Binary {
	public Assignment(Sexpr sum, Sexpr r) {
		super(sum, r);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return "=";
		}
	public Sexpr eval(Map<String, Sexpr> Variables) {
		Variables.put(right.getName(),left);
		
		return left.eval(Variables);
		
	}
}
