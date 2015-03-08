import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;



public class KotraktTests {
	Psikus kontrakt;
	@Before
	public void init()
	{
		kontrakt = new Kontrakt();
	}
	
	@Test
	public void cyfrokradTestIsThat() {
		
		int expected = kontrakt.cyfrokrad(37);
		if(expected==3)
		{
		int wynik1 = 3;
		assertThat(wynik1,is(expected));
		}
		else if(expected==7)
		{
		int wynik2 = 7;
		assertThat(wynik2,is(expected));
		}
		else
		{
			fail("zly test!");
		}
	}
	@Test
	public void cyfrokradTestNull()
	{
		assertThat(kontrakt.cyfrokrad(4), is(nullValue()));
	}
}
