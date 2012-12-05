package symbolic;

import java.util.Map;

public class Vars extends Command {

	public String getName() {
		return "Vars";
	}

	public Sexpr eval(Map<String, Sexpr> variables) {
		System.out.print(variables.values());
		return null; 
	}
	public String toString() {
		return getName();
	}

}
