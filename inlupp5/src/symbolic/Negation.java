package symbolic;

import java.util.Map;

public class Negation extends Unary {

	public Negation(Sexpr a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		
		return "Negation";
	}

		public Sexpr eval(Map<String,Sexpr> variables){
			return Symbolic.negation(argument.eval(variables));
	}

}
