package symbolic;

import java.io.*;
import java.util.*;

public class Parser {
	Sexpr ans;
	Reader r = new BufferedReader(new InputStreamReader(System.in));
	StreamTokenizer st = new StreamTokenizer(r);

	public Sexpr statement() throws IOException {
		Sexpr ret;
		st.nextToken();
		if (st.ttype == StreamTokenizer.TT_WORD) {
			st.eolIsSignificant(false);
			if (st.sval.equals("quit") || st.sval.equals("vars")) {
				ret = command();
			} else {
				ret = assignment();
			}
		} else {
			st.eolIsSignificant(true);
			ret = assignment();
		}

		return ret;
	}

	public Sexpr term() throws IOException {
		Sexpr sum = factor();
		while (st.ttype == '%' || st.ttype == '*') {
			int operation = st.ttype;
			st.nextToken();
			if (operation == '*') {
				sum = new Multiplication(sum, factor());
			} else {
				sum = new Division(sum, factor());
			}
		}
		return sum;
	}

	public Sexpr expression() throws IOException {
		Sexpr sum = term();
		while (st.ttype == '+' || st.ttype == '~') {
			int operation = st.ttype;
			st.nextToken();
			if (operation == '+') {
				sum = new Addition(sum, term());
			} else {
				sum = new Subtraction(sum, term());
			}
		}
		return sum;
	}

	public Sexpr identifier(Sexpr r) throws IOException {
		String s = st.sval;
		st.nextToken();
		return new Assignment(r, new Variable(s));
	}

	public Sexpr factor() throws IOException {
		return primary();

	}

	public Sexpr primary() throws IOException {
		Sexpr temp;
		if (st.ttype == '(') {
			st.nextToken();
			temp = assignment();
			while (st.ttype == ')') {
				st.nextToken();
			}

		} else if (st.ttype == StreamTokenizer.TT_NUMBER) {
			temp = number();
		} else if (st.ttype == StreamTokenizer.TT_WORD) {
			String s = st.sval;
			if (s.equals("exp") || s.equals("sin") || s.equals("cos")
					|| s.equals("log")) {
				st.eolIsSignificant(true);
				temp = unary();
			}

			else {
				st.eolIsSignificant(true);
				st.nextToken();

				temp = new Variable(s);
			}
		} else if (st.ttype == '~')
			temp = unary();
		else {
			throw new IllegalArgumentException();
		}
		return temp;
	}

	public Sexpr unary() throws IOException {
		Sexpr sum;
		if (st.ttype == StreamTokenizer.TT_WORD) {
			String s = st.sval;
			st.nextToken();

			if (s.equals("exp")) {
				sum = new Exp(primary());
			} else if (s.equals("log")) {
				sum = new Log(primary());
			} else if (s.equals("sin")) {
				sum = new Sin(primary());
			} else {
				sum = new Cos(primary());
			}
		} else {
			st.nextToken();
			sum = new Negation(primary());
		}
		return sum;
	}

	public Sexpr assignment() throws IOException {
		Sexpr sum = expression();
		while (st.ttype == '=') {
			st.nextToken();
			sum = identifier(sum);
		}
		return sum;
	}

	public Sexpr number() throws IOException {
		Sexpr temp = new Constant(st.nval);
		st.nextToken();
		return temp;

	}

	public Sexpr command() {
		String s = st.sval;
		if (s.equals("quit")) {
			System.exit(0);
		} else if (s.equals("vars")) {
			return new Vars();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		Parser p = new Parser();
		Map<String, Sexpr> variables = new HashMap<String, Sexpr>();
		Sexpr e = null;
		while (true) {
			try {
				System.out.print("? ");
				e = p.statement();
				System.out.println("Inläst uttryck: " + e); // För kontroll
				System.out.println(e.eval(variables));
			} catch (IllegalArgumentException err) {
				System.err.print("incorrect input");
			}
			variables.put("ans", e.eval(variables));

		}

	}
}
