package symbolic;

import java.util.HashMap;

public class Log extends Unary {

	public Log(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public Sexpr eval(HashMap<String,Sexpr> variables){
		return Symbolic.log(argument.eval(variables));
	}
	public String getName() { 
		return "Log";
	}

}
