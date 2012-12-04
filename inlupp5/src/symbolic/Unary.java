package symbolic;

	public abstract class Unary extends Sexpr {
	protected Sexpr argument;
	public Unary(Sexpr a){
	argument = a;
	}
	public String toString() {
		return getName() + "(" + argument.toString() + ")";
}
	public int priority() {return 2;}


}
