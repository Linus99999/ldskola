package symbolic;

import java.util.HashMap;

public class Binary extends Sexpr {
	Sexpr left;
	Sexpr right;

	public Binary() {}
	public String getName() { return "";}
	public String toString() {
		return getName() + "(" + right.toString() + ")";
}
	@Override
	public Sexpr eval(HashMap<String, Sexpr> variables) {
		// TODO Auto-generated method stub
		return null;
	}
}
