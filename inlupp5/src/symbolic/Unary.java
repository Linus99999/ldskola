package symbolic;

	public abstract class Unary extends Sexpr {
	Sexpr argument;
	public Unary(Sexpr a){
	argument = a;
	}
	public String getName() {return "";
	}
	
	public String toString() {
		return getName() + "(" + argument.toString() + ")";
}
	public int priority() {return 4;}


}
