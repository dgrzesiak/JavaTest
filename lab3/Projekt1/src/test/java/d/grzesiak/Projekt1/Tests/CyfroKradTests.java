package d.grzesiak.Projekt1.Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import d.grzesiak.Projekt1.cwiczenie2.IPsikus;
import d.grzesiak.Projekt1.cwiczenie2.Psikus;

public class CyfroKradTests {
Psikus psikus;
@Before
public void init()
{
psikus = new IPsikus();
}
@Test
public void cyfrokradTestIsThat() {
int expected = psikus.cyfrokrad(37);
assertThat(expected,anyOf(is(30), is(7)));
System.out.println("liczba po zabraniu 1 cyfry:"+expected);
}
@Test
public void cyfrokradTestNull()
{
assertThat(psikus.cyfrokrad(4), is(nullValue()));
}
@Test
public void cyfrokradTestIsThat3() {
int expected = psikus.cyfrokrad(137);
assertThat(expected,anyOf(is(130), is(107), is(37)));
System.out.println("3 cyfrowa liczba z zabrana 1 cyfra:"+expected);
}
}