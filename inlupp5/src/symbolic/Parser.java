package symbolic;
import java.io.*;
import java.util.*;
public class Parser {
Reader r = new BufferedReader(new InputStreamReader(System.in));
	StreamTokenizer st = new StreamTokenizer(r);
	public Sexpr statement() throws IOException {
		st.nextToken();
		if(st.ttype == StreamTokenizer.TT_WORD ) {
			if (st.sval == "exp" || st.sval == "sin" || st.sval == "cos" || st.sval == "log" || st.ttype == '-') {
				return assignment();
			} 
			else {
			System.err.print("command");
			return command();
			}
		} else {
			System.err.print("1");
			return assignment();
		}
	}
	public Sexpr term() throws IOException {
		System.err.print("4");
		Sexpr sum = factor();
		while (st.ttype=='*' || st.ttype=='/') {
			int operation = st.ttype;
			st.nextToken();
			if (operation=='*')
				sum = new Multiplication(sum, factor());
			else
				sum = new Division(sum, factor());
		}
		return sum;
	}

	public Sexpr expression() throws IOException {
		System.err.print("3");
		Sexpr sum = term();
		while (st.ttype=='+' || st.ttype=='-') {
			int operation = st.ttype;
			st.nextToken();
			if (operation=='+')
				sum = new Addition(sum, term());
			else
				sum = new Subtraction(sum, term());
		}
		return sum;
	}
	public Sexpr identifier() {
		return null;
	}
	public Sexpr factor() throws IOException {
		return primary();

	}
	public Sexpr primary() throws IOException {
		System.err.print("5");
		Sexpr temp;
		if (st.ttype == '(') {
			temp = assignment();
		}
		else if (st.ttype == StreamTokenizer.TT_NUMBER) {
			temp = number();
		}
		else if (st.sval == "exp" || st.sval == "sin" || st.sval == "cos" || st.sval == "log" || st.ttype == '-') {
			temp = unary();
		}
		else {
			temp = identifier();
		}
		return temp;

	}
	public Sexpr unary() throws IOException {
		Sexpr sum = null;
		if (st.sval == "exp") {
			sum = new Exp(primary());
		} else if (st.sval == "log") {
			sum = new Log(primary());
		} else if (st.sval == "sin") {
			sum = new Sin(primary());
		} else if (st.sval == "cos") {
			sum = new Cos(primary());
		} else {
			sum = new Negation(primary());
		}
		return sum;
	}
	public Sexpr assignment() throws IOException {
		System.err.print("2");
		Sexpr sum = expression();
		if(st.ttype == '=')
		{
			identifier();
		}
		return sum;
	}
	public Sexpr number() throws IOException {
		System.err.print("6");
		Sexpr temp = new Constant(st.nval);
		st.nextToken();
		return temp;

	}
	public Sexpr command() {
		if (st.sval == "quit") {
			System.exit(0);
		} else if (st.sval == "vars") {
			System.exit(0);
		}
		System.exit(0);
		return null;
	}


	public static void main(String[] args) throws IOException {
		Parser p = new Parser();
		Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
		while(true) {
			System.out.print("? ");
			Sexpr e = p.statement();
			System.out.println("Inläst uttryck: " + e); // För kontroll
			System.out.println(e);
			System.out.println(e.eval(variables));
			System.out.println(e);
		}
	}
}

