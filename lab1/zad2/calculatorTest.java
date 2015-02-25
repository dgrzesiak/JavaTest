package zadanie2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	Calculator calc1 = new Calculator();
	@Test
	public void addTest() {
		
		assertEquals(5.6, calc1.add(2.4,3.2),0);
		assertNotEquals(4.0, calc1.add(3,3),1);
	}
	@Test
	public void subTest() {
		assertEquals(3, calc1.sub(4.3, 1.3),1);
		assertNotEquals(4, calc1.sub(3,3),1);
	}
	@Test
	public void multiTest() {
		assertEquals(9, calc1.multi(3, 3),1);
		assertNotEquals(5, calc1.multi(3,3));
	}
	@Test
	public void divTest() {
		assertEquals(2.75, calc1.div(11, 4),0);
		assertNotEquals(2, calc1.div(3,3),0);
	}
	@Test
	public void greaterTest() {
		assertTrue(calc1.greater(3, 2));
		assertFalse(calc1.greater(4, 5));
	}
	@Test
	public void div0Test() {
		try{
		calc1.div(1, 0);
		fail ("Nie dziel przez 0!");
		} catch (ArithmeticException e) {
			
		}
	}

}
