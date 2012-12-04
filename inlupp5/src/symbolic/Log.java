package symbolic;

import java.util.Map;

public class Log extends Unary {

	public Log(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public Sexpr eval(Map<String,Sexpr> variables){
		return Symbolic.log(argument.eval(variables));
	}
	public String getName() { 
		return "Log";
	}

}
