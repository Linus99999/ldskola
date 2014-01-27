import static org.junit.Assert.*;

import org.junit.Test;


public class CarTest {

	@Test
	public void testCarInt() {
		Car car = new Car(1);
		assertSame("Born time is wrong",1, car.getbornTime());
	}

	@Test
	public void testCarIntInt() {
		Car car = new Car(1,2);
		assertSame("Destination is wrong",2, car.getdestination());
	}

	@Test
	public void testGetbornTime() {
		Car car = new Car(1);
		
		assertSame("Born time is wrong",1, car.getbornTime());
	}

	@Test
	public void testGetdestination() {
		Car car = new Car(1,2);
		assertSame("Destination is wrong",2, car.getdestination());
	}


}
