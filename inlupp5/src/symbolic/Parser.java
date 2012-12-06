package symbolic;

import java.io.*;
import java.util.*;

public class Parser {
	class InvalidInputException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String msg;

		InvalidInputException(int s) {
			if (s == StreamTokenizer.TT_EOL)
				msg = "End";
			else
				msg = (char) s + "";
		}

		public String getError() {
			return msg;
		}
	}

	Sexpr ans;
	StreamTokenizer st;

	public Parser(InputStreamReader readr) {
		Reader r = new BufferedReader(readr);
		st = new StreamTokenizer(r);
		st.ordinaryChar('/');
		st.ordinaryChar('-');
	}

	public Sexpr statement() throws IOException, InvalidInputException {
		Sexpr ret;
		int failMsg;

		st.nextToken();
		if (st.ttype == StreamTokenizer.TT_WORD) {
			if (st.sval.equals("quit") || st.sval.equals("vars")) {

				ret = command();
			} else {
				ret = assignment();
			}
		} else {
			st.eolIsSignificant(true);
			ret = assignment();
		}
		if (st.ttype != StreamTokenizer.TT_EOL) {
			failMsg = st.ttype;
			while (st.ttype != StreamTokenizer.TT_EOL)
				st.nextToken();

			throw new InvalidInputException(failMsg);
		}
		return ret;
	}

	public Sexpr term() throws IOException, InvalidInputException {
		Sexpr sum = factor();
		while (st.ttype == '/' || st.ttype == '*') {
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

	public Sexpr expression() throws IOException, InvalidInputException {
		Sexpr sum = term();
		while (st.ttype == '+' || st.ttype == '-') {
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

	public Sexpr factor() throws IOException, InvalidInputException {
		return primary();

	}

	public Sexpr primary() throws IOException, InvalidInputException {
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
		} else if (st.ttype == '-')
			temp = unary();
		else {
			int s = st.ttype;
			while (st.ttype != StreamTokenizer.TT_EOL)
				st.nextToken();
			throw new InvalidInputException(s);
		}
		return temp;
	}

	public Sexpr unary() throws IOException, InvalidInputException {
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

	public Sexpr assignment() throws IOException, InvalidInputException {
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

	public Sexpr command() throws IOException {
		String s = st.sval;
		if (s.equals("quit")) {
			System.exit(0);
			return null;
		} else {
			st.eolIsSignificant(true);
			st.nextToken();
			return new Vars();
		}
	}

	public static void main(String[] args) throws IOException {
		Parser p = new Parser(new InputStreamReader(System.in));
		Map<String, Sexpr> variables = new HashMap<String, Sexpr>();
		Sexpr e = null;
		while (true) {
			try {
				System.out.print("? ");
				e = p.statement();
				System.out.println(e.eval(variables));
				variables.put("ans", e.eval(variables));
			} catch (InvalidInputException err) {
				System.err.println("*** Syntax Error: Unexpected: "
						+ err.getError());
			}

		}

	}
}
