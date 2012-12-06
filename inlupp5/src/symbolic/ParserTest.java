package symbolic;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.Test;

import symbolic.Parser.InvalidInputException;

public class ParserTest {

	@Test
	public void testParser() throws IOException, InvalidInputException {
		Map<String, Sexpr> variables = new HashMap<String, Sexpr>();
		String input = "5+5\n" +
				"7+7\n" +
				"2*(5-2)\n" +
				"1/(2+8) = a\n" +
				"2=x=y\n" +
				"(x+y=z) - (z-1)*(1=x)\n" +
				"-sin(exp(a*a*10))\n" +
				"---x\n" +
				"b\n" +
				"1=a\n" +
				"a+b\n" +
				"b+a=c\n"
				;
		Parser p = new Parser(new InputStreamReader(new ByteArrayInputStream(
				input.getBytes())));
		double[] s = {10.0,14.0,6.0,0.1,2.0,1.0,-0.8935409432921488 
,-1.0};
		Sexpr e;
		for (int x= 0; x < 8; x++) {
			e = p.statement();
			assertEquals(true, e.eval(variables).getValue() == s[x]);
		}
		e = p.statement();
		assertEquals(true, e.eval(variables).getName().equals("b"));
		e = p.statement();
		assertEquals(true, e.eval(variables).getValue()==1.0);
		e = p.statement();
		assertEquals(true, e.eval(variables).toString().equals("1.0+b"));
		e = p.statement();
		assertEquals(true, e.eval(variables).toString().equals("b+1.0"));
	}

}
