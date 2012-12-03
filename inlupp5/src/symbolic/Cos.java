package symbolic;

import java.util.HashMap;

public class Cos extends Unary {

	public Cos(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public Sexpr eval(HashMap<String,Sexpr> variables){
		return Symbolic.cos(argument.eval(variables));
	}

}
