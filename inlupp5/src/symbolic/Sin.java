package symbolic;

import java.util.*;

public class Sin extends Unary {

	public Sin(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public Sexpr eval(HashMap<String,Sexpr> variables){
		return Symbolic.sin(argument.eval(variables));
	}
	public String getName() { 
		return "Sin";
	}

}
