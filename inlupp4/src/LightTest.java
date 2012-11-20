import static org.junit.Assert.*;

import org.junit.Test;


public class LightTest {

	@Test
	public void testLight() {
		Light test = new Light(10,6);
	}

	

	@Test
	public void testIsGreen() {
		Light test = new Light(10,6);
		assertSame("IsGreen ger ut fel värde!", true, test.isGreen());
	}

}
