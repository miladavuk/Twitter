package com.twitter.poruke;
/**
 * klasa TwitterPoruka
 * @author Milada Vukovic
 *
 */
public class TwitterPoruka {
	/**
	 * atribut <b>koisnik</b> u kom cuvamo ime korisnika
	 */
	private String korisnik;
	/**
	 * atribut <b>poruka</b> u kom cuvamo sadrzaj poruke
	 */
	private String poruka;
	/**
	 * metoda koja vraca ime korisnika
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * metoda koja postavlja ime korisnika na vrednost parametra
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
		throw new RuntimeException(
		"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * metoda koja vraca sadrzaj poruke
	 * @return poruka
	 */
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * metoda koja postavlja sadrzaj poruke na vrednost parametra
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || this.poruka.length()>140)
		throw new RuntimeException(
		"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * redefinisana toString metoda koja vraca String sa atributima klase 
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}

}
