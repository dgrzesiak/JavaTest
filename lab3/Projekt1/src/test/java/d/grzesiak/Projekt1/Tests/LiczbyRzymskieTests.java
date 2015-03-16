package d.grzesiak.Projekt1.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import d.grzesiak.Projekt1.zad3.LiczbyRzymskie;
public class LiczbyRzymskieTests {
LiczbyRzymskie rzymska;
@Before
public void init()
{
rzymska = new LiczbyRzymskie();
}
@Test
public void liczba10() {
rzymska.setLiczba(10);
assertEquals("X",rzymska.toString());
}
@Test
public void liczba53() {
rzymska.setLiczba(53);
assertEquals("LIII",rzymska.toString());
assertNotEquals("LII",rzymska.toString());
}
@Test
public void liczbaNotNull() {
rzymska.setLiczba(27);
assertNotNull(rzymska.toString());
}
@Test
	public void LiczbaUjemna() {
		
		rzymska.setLiczba(-4);
		//nie mialem pomyslu jak ma sie zachowac program gdy sie poda 
		//liczbe ujemna to dalem by zwracalo null'a
		assertNull(rzymska.toString());
	}
}
