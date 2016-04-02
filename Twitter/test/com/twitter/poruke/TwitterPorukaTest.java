package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	
	TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		String korisnik = null;
		tp.setKorisnik(korisnik);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		String korisnik = "";
		tp.setKorisnik(korisnik);
	}
	
	@Test
	public void testSetKorisnik() {
		String korisnik = "Petar Jovanovic";
		tp.setKorisnik(korisnik);
		assertEquals("Petar Jovanovic", tp.getKorisnik());
	}
	

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		String poruka = null;
		tp.setPoruka(poruka);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrekoracenje(){		
		//String od 150 karaktera
		String poruka = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		/*Ako atribut klase poruka ima vrednost null, zbog greske u metodi "this.poruka.length()>140"
		 * umesto "poruka.length()>140", oborio bi se test*/
		tp.setPoruka(poruka);
	
	}
	@Test
	public void testSetPoruka() {
		String poruka = "Ovo je poruka.";
		tp.setPoruka(poruka);
		//zbog greske u metodi "return "poruka";" umesto "return poruka;", oborio bi se test
		assertEquals("Ovo je poruka.", tp.getPoruka());
	}

	@Test
	public void testToString() {
		String vrednost= tp.toString();
		assertTrue(vrednost.equals("KORISNIK:"+tp.getKorisnik()+" PORUKA:"+tp.getPoruka()));
	}

}
