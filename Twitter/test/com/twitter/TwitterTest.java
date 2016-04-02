package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();		
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}
		
	@Test 
	public void testUnesi(){
		String korisnik = "Maja Petrovic";
		String poruka = "Lep dan.";
		t.unesi(korisnik, poruka);
		//zbog greske u metodi "setKorisnik("korisnik");" umesto "setKorisnik(korisnik);", oborio bi se test
		assertTrue(t.vratiSvePoruke().getLast().getKorisnik().equals("Maja Petrovic") && 
				t.vratiSvePoruke().getLast().getPoruka().equals("Lep dan."));
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull(){
		String tag = null;
		int maxBroj = 10;
		int brPorSaTagomUListi=0;
		int brPorSaTagomUNizu=0;
		for (int i = 0; i < t.vratiSvePoruke().size(); i++){
			if (t.vratiSvePoruke().get(i).getPoruka().indexOf(tag)!=-1)
				brPorSaTagomUListi++;
		}
		TwitterPoruka[] poruke = t.vratiPoruke(maxBroj, tag);	
		
		if(brPorSaTagomUListi>poruke.length)
			brPorSaTagomUListi=poruke.length;
		
		if(brPorSaTagomUListi!=0){
		for (int i = 0; i < brPorSaTagomUListi; i++) {
				if(poruke[i].getPoruka().indexOf(tag)!=-1)
					brPorSaTagomUNizu++;
			}
		}
			assertEquals(brPorSaTagomUListi, brPorSaTagomUNizu);		
	}
		
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan(){
		String tag = "";
		int maxBroj = 10;
		int brPorSaTagomUListi=0;
		int brPorSaTagomUNizu=0;
		for (int i = 0; i < t.vratiSvePoruke().size(); i++){
			if (t.vratiSvePoruke().get(i).getPoruka().indexOf(tag)!=-1)
				brPorSaTagomUListi++;
		}
		TwitterPoruka[] poruke = t.vratiPoruke(maxBroj, tag);	
		
		if(brPorSaTagomUListi>poruke.length)
			brPorSaTagomUListi=poruke.length;
		
		if(brPorSaTagomUListi!=0){
		for (int i = 0; i < brPorSaTagomUListi; i++) {
				if(poruke[i].getPoruka().indexOf(tag)!=-1)
					brPorSaTagomUNizu++;
			}
		}
			assertEquals(brPorSaTagomUListi, brPorSaTagomUNizu);		
	}	
	
	@Test
	public void testVratiPorukePostojiTag(){
		String tag = "cool";
		int maxBroj = -1;
		int brPorSaTagomUListi=0;
		int brPorSaTagomUNizu=0;
		t.unesi("Maja", "#cool mesto");
		t.unesi("Ana", "#cool dan");
		t.unesi("Una", "ti si #cool");
		for (int i = 0; i < t.vratiSvePoruke().size(); i++){
			if (t.vratiSvePoruke().get(i).getPoruka().indexOf(tag)!=-1)
				brPorSaTagomUListi++;
		}
		
		TwitterPoruka[] poruke = t.vratiPoruke(maxBroj, tag);	
		
		if(brPorSaTagomUListi>poruke.length)
			brPorSaTagomUListi=poruke.length;
		
		if(brPorSaTagomUListi!=0){
		for (int i = 0; i < brPorSaTagomUListi; i++) {
			//zbog greske u metodi "rezultat[brojac+1]" umesto "rezultat[brojac]", bio bi NullPointerException
				if(poruke[i].getPoruka().indexOf(tag)!=-1)
					brPorSaTagomUNizu++;
			}
		}
		//ispis u konzoli radi provere ispravnosti testa
		System.out.println("testVratiPorukePostojiTag: ");
		System.out.println(brPorSaTagomUListi);
		System.out.println(brPorSaTagomUNizu);
		System.out.println("****************************");
			assertEquals(brPorSaTagomUListi, brPorSaTagomUNizu);		
	}
	@Test
	public void testVratiPorukeNePostojiTag(){
		String tag = "cool";
		int maxBroj = -1;
		int brPorSaTagomUListi=0;
		int brPorSaTagomUNizu=0;
		
		for (int i = 0; i < t.vratiSvePoruke().size(); i++){
			if (t.vratiSvePoruke().get(i).getPoruka().indexOf(tag)!=-1)
				brPorSaTagomUListi++;
		}
		
		TwitterPoruka[] poruke = t.vratiPoruke(maxBroj, tag);	
		
		if(brPorSaTagomUListi>poruke.length)
			brPorSaTagomUListi=poruke.length;
		
		if(brPorSaTagomUListi!=0){
		for (int i = 0; i < brPorSaTagomUListi; i++) {
			//zbog greske u metodi "rezultat[brojac+1]" umesto "rezultat[brojac]", bio bi NullPointerException
				if(poruke[i].getPoruka().indexOf(tag)!=-1)
					brPorSaTagomUNizu++;
			}
		}
		//ispis u konzoli radi provere ispravnosti testa
		System.out.println("testVratiPorukeNePostojiTag: ");
		System.out.println(brPorSaTagomUListi);
		System.out.println(brPorSaTagomUNizu);
		System.out.println("****************************");
			assertEquals(brPorSaTagomUListi, brPorSaTagomUNizu);		
	}
	

}
