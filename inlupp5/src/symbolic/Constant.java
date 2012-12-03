package symbolic;

import java.util.HashMap;

public class Constant extends Atom {
	private double value;

	public Constant(double s) {
		value = s;
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
		return value;
	}
	public boolean isConstant() {
		if (value == 0) 
			return false;
		else
			return true;
	}

}
