package symbolic;

import java.util.HashMap;

public class Exp extends Unary {

	public Exp(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public Sexpr eval(HashMap<String,Sexpr> variables){
		return Symbolic.exp(argument.eval(variables));
	}
	public String getName() { 
		return "Exp";
	}

}
