package symbolic;

import java.util.HashMap;

public class Constant extends Atom {
	double value;
	
	public Constant(double s) {

	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		// TODO Auto-generated method stub
		return null;
	}
	public double getValue() {
		return 5;
	}
	public boolean isConstant() {
		return true;
	}

}
