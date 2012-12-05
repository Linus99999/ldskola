package symbolic;
import java.io.*;
import java.util.*;
public class Parser {
	Sexpr ans;
	Reader r = new BufferedReader(new InputStreamReader(System.in));
	StreamTokenizer st = new StreamTokenizer(r);
	public Sexpr statement() throws IOException {
		st.eolIsSignificant(false);
		st.nextToken();
		if(st.ttype == StreamTokenizer.TT_WORD ) {
			if (st.sval.equals("quit") || st.sval.equals("vars")) {
				System.err.print("1");
				return command();
			} 
			else {
				System.err.print("1");
				return assignment();
			}
		}
		else {
			System.err.print("1");
			return assignment();
		}
	}
	public Sexpr term() throws IOException {
		System.err.print("4");
		Sexpr sum = factor();
		while (st.ttype=='%' || st.ttype=='*') {
			int operation = st.ttype;
			st.nextToken();
			if (operation=='*') {
				System.err.print("mul");
				sum = new Multiplication(sum, factor());
			}	else {
				System.err.print("div");
				sum = new Division(sum, factor());
			}
		}
		return sum;
	}

	public Sexpr expression() throws IOException {
		System.err.print("3");
		Sexpr sum = term();
		while (st.ttype=='+' || st.ttype=='~') {
			int operation = st.ttype;
			st.nextToken();
			if (operation=='+') {
				System.err.print("add");
				sum = new Addition(sum, term());
			}
			else {
				System.err.print("sub");
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
		System.err.print("5");
		Sexpr temp;
		if (st.ttype == '(') {
			st.nextToken();
			temp = assignment();
			if (st.ttype == ')') { 
				st.nextToken();
			}
			
		}
		else if (st.ttype == StreamTokenizer.TT_NUMBER) {
			temp = number();
		}
		else if (st.ttype == StreamTokenizer.TT_WORD) {
			String s = st.sval;
			if (s.equals("exp") || s.equals("sin") || s.equals("cos") || s.equals("log")) {
				temp = unary();
			}
			
			else {
				temp = new Variable(st.sval);
			}
		}
		else { System.out.print("fail");
		temp = null;
		}
		return temp;
	}	
	public Sexpr unary() throws IOException {
		Sexpr sum = null;
		System.err.print("7");
		//	while (st.sval.equals("exp") || st.sval.equals("sin") || st.sval.equals("cos") || st.sval.equals("log")) {
		String s = st.sval;
		st.nextToken();
		if (s.equals("exp")) {
			sum = new Exp(primary());
		} else if (s.equals("log")) {
			sum = new Log(primary());
		} else if (s.equals("sin")) {
			sum = new Sin(primary());
		} else if (s.equals("cos")) {
			sum = new Cos(primary());
		} else {
			sum = new Negation(primary());
	//	}
		}
		return sum;
	}
	public Sexpr assignment() throws IOException {
		System.err.print("2");
		Sexpr sum = expression();
		while (st.ttype == '=')
		{
			st.nextToken();
			sum = identifier(sum);
		}
		return sum;
	}
	public Sexpr number() throws IOException {
		System.err.print("6");
		Sexpr temp = new Constant(st.nval);
		st.nextToken();
		System.err.print("asd");
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
		Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
		while(true) {
			System.out.print("? ");
			Sexpr e = p.statement();
			System.out.println("Inläst uttryck: " + e); // För kontroll
			System.out.println(e.eval(variables));
			variables.put("ans",e.eval(variables));
		}
	}
}

