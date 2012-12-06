package symbolic;

public class Symbolic {
	public static Sexpr sin(Sexpr arg){
		if (arg.isConstant())
			return new Constant(Math.sin(arg.getValue()));
		else
			return new Sin(arg);
	}

	public static Sexpr cos(Sexpr arg){
		if (arg.isConstant())
			return new Constant(Math.cos(arg.getValue()));
		else
			return new Cos(arg);
	}
	public static Sexpr exp(Sexpr arg){
		if (arg.isConstant())
			return new Constant(Math.exp(arg.getValue()));
		else
			return new Exp(arg);
	}
	public static Sexpr log(Sexpr arg){
		if (arg.isConstant())
			return new Constant(Math.log(arg.getValue()));
		else
			return new Log(arg);
	}
	public static Sexpr negation(Sexpr arg) {
		if (arg.isConstant())
			return new Constant(arg.getValue()*-1);
		else
			return new Negation(arg);
	}
	public static Sexpr addition(Sexpr arg1, Sexpr arg2) {
		if (arg1.isConstant() && arg2.isConstant())
			return new Constant(arg1.getValue() + arg2.getValue());
		else
			return new Addition(arg1,arg2);
	}
	public static Sexpr division(Sexpr arg1, Sexpr arg2) {
		if (arg1.isConstant() && arg2.isConstant())
			return new Constant(arg1.getValue() / arg2.getValue());
		else
			return new Division(arg1,arg2);
	}
	public static Sexpr subtraction(Sexpr arg1, Sexpr arg2) {
		if (arg1.isConstant() && arg2.isConstant())
			return new Constant(arg1.getValue() - arg2.getValue());
		else
			return new Subtraction(arg1,arg2);
	}
	public static Sexpr multiplication(Sexpr arg1, Sexpr arg2) {
		if (arg1.isConstant() && arg2.isConstant())
			return new Constant(arg1.getValue() * arg2.getValue());
		else
			return new Multiplication(arg1,arg2);
	}
}