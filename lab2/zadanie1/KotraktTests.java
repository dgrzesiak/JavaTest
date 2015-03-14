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
		assertThat(expected,anyOf(is(30), is(7)));
		System.out.println("liczba po zabraniu 1 cyfry:"+expected);
	}
	@Test
	public void cyfrokradTestNull()
	{
		assertThat(kontrakt.cyfrokrad(4), is(nullValue()));
	}
	@Test
public void cyfrokradTestIsThat3() {
		
		int expected = kontrakt.cyfrokrad(137);
		assertThat(expected,anyOf(is(130), is(107), is(37)));
		System.out.println("3 cyfrowa liczba z zabrana 1 cyfra:"+expected);
	}
}
