package symbolic;

public abstract class Binary extends Sexpr {
	protected Sexpr left;
	protected Sexpr right;

	public Binary(Sexpr sum, Sexpr r) {
		left = sum;
		right = r;
	}
	public String toString() {
		return left.toString() + getName() + right.toString();
}
}

