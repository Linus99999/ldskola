package symbolic;

import java.util.Map;

public class Constant extends Atom {
	private double value;

	public Constant(double s) {
		value = s;
	}
	public String getName() {
		return getValue()+"";
	}

	public Sexpr eval(Map<String, Sexpr> variables) {
		return this;
	}
	public double getValue() {
		return value;
	}
	public boolean isConstant() {
		return true;
	}

}
