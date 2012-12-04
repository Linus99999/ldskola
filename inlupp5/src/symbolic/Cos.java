package symbolic;

import java.util.Map;

public class Cos extends Unary {

	public Cos(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public Sexpr eval(Map<String,Sexpr> variables){
		return Symbolic.cos(argument.eval(variables));
	}
	public String getName() { 
		return "Cos";
	}

}
