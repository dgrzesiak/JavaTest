package Cwiczenie2.zadania;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;


public class HulajchochlaTests {
	Psikus hulaj;
	@Before
	public void init()
	{
		hulaj = new IPsikus();
	}
	@Test
	public void isNull() throws NieduanyPsikusException {
		int expected = hulaj.hultajchochla(37);
		assertThat(expected,is(notNullValue()));
	}
	@Test
	public void hulajTest() throws NieduanyPsikusException {
		int expected = hulaj.hultajchochla(37);
		int wynik = 73;
		assertThat(expected,is(wynik));
		System.out.println("test dla 2 cyfr:"+expected);
	}
	@Test
	public void hulajTest3() throws NieduanyPsikusException {
		int expected = hulaj.hultajchochla(123);
		//123=> 132 213 321 
		assertThat(expected, anyOf(is(132), is(213), is(321)));
		System.out.println("test dla 3 cyfr:"+expected);
	}
	@Test
	public void hulajTest4() throws NieduanyPsikusException {
		int expected = hulaj.hultajchochla(1234);
		//1234=> 1243 1432 4231 1324 3214 2134
		assertThat(expected, anyOf(is(1243), is(1432), is(4231),is(1324), is(3214), is(2134)));
		System.out.println("test dla 4 cyfr:"+expected);
	}
	@Test
	public void nieudanyPsikus() throws NieduanyPsikusException {
		boolean sprawdz = false;
		try {
			hulaj.hultajchochla(4);
		} catch(NieduanyPsikusException e)
		{
			sprawdz = true;
		}
		assertTrue(sprawdz);
	}
}
