package zadanie1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator();
	@Test
	public void addTest() {
		
		assertEquals(5, calc.add(2,3));
		assertNotEquals(4, calc.add(3,3));
	}
	@Test
	public void subTest() {
		assertEquals(3, calc.sub(4, 1));
		assertNotEquals(4, calc.sub(3,3));
	}
	@Test
	public void multiTest() {
		assertEquals(9, calc.multi(3, 3));
		assertNotEquals(5, calc.multi(3,3));
	}
	@Test
	public void divTest() {
		assertEquals(3, calc.div(9, 3));
		assertNotEquals(2, calc.div(3,3));
	}
	@Test
	public void greaterTest() {
		assertTrue(calc.greater(3, 2));
		assertFalse(calc.greater(4, 5));
	}
	@Test
	public void div0Test() {
		try{
			calc.div(1, 0);
			fail ("Nie dziel przez 0!");
			} catch (ArithmeticException e) {
				
			}
	}

}
