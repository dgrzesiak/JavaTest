package Cwiczenie1.zad2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTests {
private static Calculator calc1;
	@BeforeClass
	    public static void initCalculator() {
		
		calc1 = new Calculator();

	    }

	@Test
	public void addTest() {
		double expected= calc1.add(2.4,3.25);
		assertEquals(5.65, expected,0.01);
		System.out.println(expected);
	}
	@Test
	public void subTest() {
		double expected= calc1.sub(4.4, 1.3);
		assertEquals(3.1, expected,0.1);
	}
	@Test
	public void multiTest() {
		double expected= calc1.multi(3, 3);
		assertEquals(9, expected,1);
	}
	@Test
	public void divTest() {
		double expected= calc1.div(11, 4);
		assertEquals(2.75, expected,0.01);
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
