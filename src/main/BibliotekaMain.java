package main;
import java.time.LocalDate;
import java.util.ArrayList;
import biblioteka.Biblioteka;
import entiteti.Iznajmljivanje;
import entiteti.Knjiga;
import entiteti.PrimerakKnjige;
import entiteti.TipClanarine;
import entiteti.ZanrKnjige;
import osobe.ClanBiblioteke;
import osobe.Pol;
import osobe.Zaposleni;



public class BibliotekaMain {
	
	
	
	private static String CLANOVI_FAJL = "clanovi.txt";
	private static String IZNAJMLJIVANJE_FAJL = "iznajmljivanje.txt";
	private static String KNJIGE_FAJL = "knjige.txt";
	private static String PRIMERCIKNJIGA_FAJL = "primerciKnjiga.txt";
	private static String TIPOVICLANARINE_FAJL = "tipoviClanarine.txt";
	private static String ZANROVI_FAJL = "zanrovi.txt";
	private static String ZAPOSLENI_FAJL = "zaposleni.txt";
	
	
	
	
	public static void main(String[] args) {

		
		Biblioteka biblioteka = new Biblioteka();
		
		biblioteka.ucitajTipClanarine(TIPOVICLANARINE_FAJL);
		biblioteka.ucitajZaposlene(ZAPOSLENI_FAJL);
		biblioteka.ucitajClanove(CLANOVI_FAJL);
		biblioteka.ucitajZanrove(ZANROVI_FAJL);
		biblioteka.ucitajKnjige(KNJIGE_FAJL);
		biblioteka.ucitajPrimerkeKnjiga(PRIMERCIKNJIGA_FAJL);
		biblioteka.ucitajIznajmljivanje(IZNAJMLJIVANJE_FAJL);
		
		
		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("----------------------------------------------");
		ispisiSvePodatke(biblioteka);
		System.out.println("----------------------------------------------");
		
		
		
		
		
		//System.out.println("Dodavanje test podataka: ");
		
		
		//ClanBiblioteke testClan = new ClanBiblioteke(5,"Marko","Peric","6551546542","test adresa",Pol.MUSKI,"006", LocalDate.of(2022, 02, 19), 24, true, biblioteka.pronadjiTipClanarine(2));
		//biblioteka.dodajClana(testClan);
		
		
		//System.out.println("Snimanje dodanih podataka: ");
		//biblioteka.snimiClanove(CLANOVI_FAJL);
		
		//biblioteka.obrisiTipClanarine(biblioteka.pronadjiTipClanarine(1));
		//System.out.println(biblioteka.sviNeobrisaniTipovi());
	
	}
	
	
	
	
	
	/**************************************************************************************************************************/
	
	
	public static void ispisiSvePodatke(Biblioteka biblioteka) {
		
		
		for(Zaposleni zaposlen : biblioteka.getListaZaposlenih()) {
			System.out.println(zaposlen + "\n");
		}
		
		for(TipClanarine tip : biblioteka.getListaTipovaClanarine()) {
			System.out.println(tip + "\n");
		}
		
		for(ClanBiblioteke clan : biblioteka.getListaClanova()) {
			System.out.println(clan + "\n");
		}
		
		for(ZanrKnjige zanr : biblioteka.getListaZanrova()) {
			System.out.println(zanr + "\n");
		}
		
		for(Knjiga knjiga : biblioteka.getListaKnjiga()) {
			System.out.println(knjiga + "\n");
		}
		
		for(PrimerakKnjige primerci : biblioteka.getListaPrimerakaKnjiga()) {
			System.out.println(primerci + "\n");
		}
		
		for(Iznajmljivanje iznajmljivanje : biblioteka.getListaIznajmljivanja()) {
			System.out.println(iznajmljivanje + "\n");
		}
		
	}
	
	
	/**************************************************************************************************************************/

	
	
}
