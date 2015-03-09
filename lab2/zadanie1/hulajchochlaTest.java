import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;


public class hulajchochlaTest {
	Psikus hulaj;
	@Before
	public void init()
	{
		hulaj = new Kontrakt();
	}
	@Test
	public void hulajTest() throws NieduanyPsikusException {
		int expected = hulaj.hultajchochla(37);
		int wynik = 73;
		assertThat(wynik,is(expected));
	}
	@Test
	public void hulajTest3() throws NieduanyPsikusException {
		int expected = hulaj.hultajchochla(123);
		//123 132 213 231 312 321
		if(expected==132){
			int wynik = 132;
		assertThat(wynik,is(expected));
		}else
			if(expected == 213)
			{
				int wynik = 213;
				assertThat(wynik,is(expected));
			}
			else if(expected == 231)
			{
				int wynik = 231;
				assertThat(wynik,is(expected));
			} else if (expected == 312)
			{
				int wynik = 312;
				assertThat(wynik,is(expected));
			}
			else if (expected == 321)
			{
				int wynik = 321;
				assertThat(wynik,is(expected));
			} else
				fail("Nie trafiłeś");
	}
	
}
