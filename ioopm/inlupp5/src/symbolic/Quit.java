package symbolic;

import java.util.Map;

public class Quit extends Command {

	public String getName() {
		return "Quit";
	}

	@Override
	public Sexpr eval(Map<String, Sexpr> variables) {
		return null;
	}

}
