package symbolic;


public abstract class Binary extends Sexpr {
	private Sexpr left;
	private Sexpr right;

	public Binary() {}
	public String toString() {
		return left.toString() + getName() + right.toString();
}
}

