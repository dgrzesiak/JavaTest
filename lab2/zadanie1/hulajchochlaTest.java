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
		int wynik =73;
		assertThat(wynik,is(expected));
	}
	
}
