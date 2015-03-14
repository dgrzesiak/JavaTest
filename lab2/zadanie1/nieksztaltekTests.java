import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;


public class nieksztaltekTests {
	Psikus ksztaltek;
	@Before
	public void init()
	{
		ksztaltek = new Kontrakt();
	}
	@Test
	public void czyZwrociArgument() {
		int expected = ksztaltek.nieksztaltek(124);
		assertThat(expected, is(124));
	}
	@Test
	public void czyZamieni3() {
		int expected = ksztaltek.nieksztaltek(453);
		assertThat(expected, is(458));
	}
	@Test
	public void czyZamieni7(){
		int expected = ksztaltek.nieksztaltek(874);
		assertThat(expected, is(814));
	}
	@Test
	public void czyZamieni6(){
		int expected = ksztaltek.nieksztaltek(624);
		assertThat(expected, is(924));
	}
}
