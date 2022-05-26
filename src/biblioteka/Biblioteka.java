package biblioteka;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import entiteti.Iznajmljivanje;
import entiteti.Knjiga;
import entiteti.PrimerakKnjige;
import entiteti.TipClanarine;
import entiteti.ZanrKnjige;
import osobe.ClanBiblioteke;
import osobe.Pol;
import osobe.Zaposleni;


public class Biblioteka {

    
    private String naziv;
    private String adresa;
    private String brojTelefona;
    private String radnoVreme;
    private ArrayList<Zaposleni> listaZaposlenih;
    private ArrayList<ClanBiblioteke> listaClanova;
    private ArrayList<TipClanarine> listaTipovaClanarine;
    private ArrayList<Iznajmljivanje> listaIznajmljivanja;
    private ArrayList<PrimerakKnjige> listaPrimerakaKnjiga;
    private ArrayList<Knjiga> listaKnjiga;
    private ArrayList<ZanrKnjige> listaZanrova;
    
    
    
	public Biblioteka() {
		
		this.naziv = "";
		this.adresa = "";
		this.brojTelefona = "";
		this.radnoVreme = "";
		this.listaZaposlenih = new ArrayList<Zaposleni>();
		this.listaClanova = new ArrayList<ClanBiblioteke>();
		this.listaTipovaClanarine = new ArrayList<TipClanarine>();
		this.listaIznajmljivanja = new ArrayList<Iznajmljivanje>();
		this.listaPrimerakaKnjiga = new ArrayList<PrimerakKnjige>();
		this.listaKnjiga = new ArrayList<Knjiga>();
		this.listaZanrova = new ArrayList<ZanrKnjige>();
		
	}


	public Biblioteka(String naziv, String adresa, String brojTelefona, String radnoVreme,
			ArrayList<Zaposleni> listaZaposlenih, ArrayList<ClanBiblioteke> listaClanova,
			ArrayList<TipClanarine> listaTipovaClanarine, ArrayList<Iznajmljivanje> listaIznajmljivanja,
			ArrayList<PrimerakKnjige> listaPrimerakaKnjiga, ArrayList<Knjiga> listaKnjiga, ArrayList<ZanrKnjige> listaZanrova) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.radnoVreme = radnoVreme;
		this.listaZaposlenih = listaZaposlenih;
		this.listaClanova = listaClanova;
		this.listaTipovaClanarine = listaTipovaClanarine;
		this.listaIznajmljivanja = listaIznajmljivanja;
		this.listaPrimerakaKnjiga = listaPrimerakaKnjiga;
		this.listaKnjiga = listaKnjiga;
		this.listaZanrova = listaZanrova;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getBrojTelefona() {
		return brojTelefona;
	}


	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	public String getRadnoVreme() {
		return radnoVreme;
	}


	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}


	public ArrayList<Zaposleni> getListaZaposlenih() {
		return listaZaposlenih;
	}


	public void setListaZaposlenih(ArrayList<Zaposleni> listaZaposlenih) {
		this.listaZaposlenih = listaZaposlenih;
	}


	public ArrayList<ClanBiblioteke> getListaClanova() {
		return listaClanova;
	}


	public void setListaClanova(ArrayList<ClanBiblioteke> listaClanova) {
		this.listaClanova = listaClanova;
	}


	public ArrayList<TipClanarine> getListaTipovaClanarine() {
		return listaTipovaClanarine;
	}


	public void setListaTipovaClanarine(ArrayList<TipClanarine> listaTipovaClanarine) {
		this.listaTipovaClanarine = listaTipovaClanarine;
	}


	public ArrayList<Iznajmljivanje> getListaIznajmljivanja() {
		return listaIznajmljivanja;
	}


	public void setListaIznajmljivanja(ArrayList<Iznajmljivanje> listaIznajmljivanja) {
		this.listaIznajmljivanja = listaIznajmljivanja;
	}


	public ArrayList<PrimerakKnjige> getListaPrimerakaKnjiga() {
		return listaPrimerakaKnjiga;
	}


	public void setListaPrimerakaKnjiga(ArrayList<PrimerakKnjige> listaPrimerakaKnjiga) {
		this.listaPrimerakaKnjiga = listaPrimerakaKnjiga;
	}


	public ArrayList<Knjiga> getListaKnjiga() {
		return listaKnjiga;
	}


	public void setListaKnjiga(ArrayList<Knjiga> listaKnjiga) {
		this.listaKnjiga = listaKnjiga;
	}
	
	public ArrayList<ZanrKnjige> getListaZanrova() {
		return listaZanrova;
	}


	public void setListaZanrova(ArrayList<ZanrKnjige> listaZanrova) {
		this.listaZanrova = listaZanrova;
	}
	

	

	/******************************************************************************************************/
	
	

	public void snimiTipClanarine(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (TipClanarine tip : listaTipovaClanarine) {
				content += tip.getId() + "|" + tip.getNaziv() + "|" + tip.getCena() + "|" + tip.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja tipa clanarine.");
		}
	}
	

	public void snimiZaposlene(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Zaposleni zaposleni : listaZaposlenih) {
				content += zaposleni.getId() + "|" + zaposleni.getIme() + "|" 
						+ zaposleni.getPrezime() + "|" + zaposleni.getJMBG() + "|"
						+ zaposleni.getAdresa() + "|" + zaposleni.getPol() + "|" + zaposleni.getKorisnickoIme() + "|" 
						+ zaposleni.getKorisnickaLozinka() + zaposleni.getPlata() + "|" + zaposleni.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja zaposlenih.");
		}
	}
	

	

	public void snimiZanrove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (ZanrKnjige zanr : listaZanrova) {
				content += zanr.getOznaka() + "|" + zanr.getOpis() + "|" + zanr.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja zanrova.");
		}
	}
	

	public void snimiKnjige(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Knjiga knjiga : listaKnjiga) {
				content += knjiga.getId() + "|" + knjiga.getNaslov() + "|"
						+ knjiga.getOriginalniNaslov() + "|" + knjiga.getPisac() + "|"
						+ knjiga.getGodinaObjavljivanja() + "|" + knjiga.getOpisKnjige() + "|" + knjiga.getZanr() + "|" + knjiga.getJezikOriginala() + "|" + knjiga.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja knjiga.");
		}
	}

	
	public void snimiClanove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (ClanBiblioteke clan : listaClanova) {
				content += clan.getId() + "|" + clan.getIme() + "|" 
						+ clan.getPrezime() + "|" + clan.getJMBG() + "|"
						+ clan.getAdresa() + "|" + clan.getPol() + "|" + clan.getBrojClanskeKarte()
						+ "|" + clan.getDatumPoslednjeUplate() + "|" + clan.getBrojMeseciClanarine() 
						+ "|" + clan.isAktivan() + "|" + clan.getTipClanarine() + "|" + clan.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja clanova.");
		}
	}

	
	public void snimiPrimerkeKnjiga(String imeFajla) {

		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (PrimerakKnjige primerak : listaPrimerakaKnjiga) {
				content += primerak.getId() + "|" + primerak.getBrojStrana() + "|" 
						+ primerak.isTvrdPovez() + "|" + primerak.getGodinaStampanja() + "|"
						+ primerak.isIznajmljena() + "|" + primerak.getKnjigaKojojPrimerakPripada() + "|" + primerak.getJezikStampanja() + "|" + primerak.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja primeraka knjiga.");
		}
	}

	
	public void snimiIznajmljivanje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Iznajmljivanje iznajmljivanje : listaIznajmljivanja) {
				content += iznajmljivanje.getDatumIznajmljivanja() + "|" + iznajmljivanje.getDatumVracanja() + "|" 
						+ iznajmljivanje.getZaposleni() + "|" + iznajmljivanje.getClan() + "|"
						+ iznajmljivanje.getPrimerakKnjige() + "|" + iznajmljivanje.isObrisan() + "\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja iznajmljivanja.");
		}
	}

	
	
	/********************************************************************************************/
	
	
	
	public ZanrKnjige pronadjiZanr(String id) {
		for (ZanrKnjige zanr : listaZanrova) {
			if(zanr.getOznaka().equals(id)) {
				return zanr;
			}
		}
		return null;
	}

	
	public TipClanarine pronadjiTipClanarine(int id) {
		for (TipClanarine tip : listaTipovaClanarine) {
			if(tip.getId() == id) {
				return tip;
			}
		}
		return null;
	}
	
	
	public Knjiga pronadjiKnjigu(int id) {
		for (Knjiga knjiga : listaKnjiga) {
			if(knjiga.getId() == id) {
				return knjiga;
			}
		}
		return null;
	}

	
	public Zaposleni pronadjiZaposlenog(int id) {
		for (Zaposleni zaposleni : listaZaposlenih) {
			if(zaposleni.getId() == id) {
				return zaposleni;
			}
		}
		return null;
	}
	
	
	public ClanBiblioteke pronadjiClana(int id) {
		for (ClanBiblioteke clan : listaClanova) {
			if(clan.getId() == id) {
				return clan;
			}
		}
		return null;
	}

	
	public PrimerakKnjige pronadjiPrimerak(int id) {
		for (PrimerakKnjige primerak : listaPrimerakaKnjiga) {
			if(primerak.getId() == id) {
				return primerak;
			}
		}
		return null;
	}
	
	
	
	/********************************************************************************************/
	
	
	
	public void ucitajTipClanarine(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				int id = Integer.parseInt(split[0]);
				String naziv = split[1];
				double cena = Double.parseDouble(split[2]);
				boolean obrisan = Boolean.parseBoolean(split[3]);
				
				
				TipClanarine tip = new TipClanarine(id, naziv, cena, obrisan);
				listaTipovaClanarine.add(tip);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o tipu clanarine");
			e.printStackTrace();
		}
	}

	
	public void ucitajZaposlene(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				int id = Integer.parseInt(split[0]);
				String ime = split[1];
				String prezime = split[2];
				String JMBG = split[3];
				String adresa = split[4];
				int polInt = Integer.parseInt(split[5]);
				Pol pol = Pol.values()[polInt];
				String korisnickoIme = split[6];
				String korisnickaLozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				boolean obrisan = Boolean.parseBoolean(split[9]);
				
				
				Zaposleni zaposleni = new Zaposleni(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaLozinka, plata, obrisan);
				listaZaposlenih.add(zaposleni);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o zaposlenom");
			e.printStackTrace();
		}
	}

	
	public void ucitajZanrove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				String oznaka = split[0];
				String opis = split[1];
				boolean obrisan = Boolean.parseBoolean(split[2]);
				
				
				ZanrKnjige zanr = new ZanrKnjige(oznaka, opis, obrisan);
				listaZanrova.add(zanr);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o zanrovima");
			e.printStackTrace();
		}
	}

	
	public void ucitajKnjige(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				int id = Integer.parseInt(split[0]);
				String naslov = split[1];
				String originalniNaslov = split[2];
				String pisac = split[3];
				int godinaObjavljivanja = Integer.parseInt(split[4]);
				String opisKnjige = split[5];
				
				String zanrId = split[6];
				ZanrKnjige zanr = (ZanrKnjige) pronadjiZanr(zanrId);
				
				String jezikOriginala = split[7];
				
				boolean obrisan = Boolean.parseBoolean(split[8]);
				
				
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, pisac, godinaObjavljivanja, opisKnjige, zanr, jezikOriginala, obrisan);
				listaKnjiga.add(knjiga);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o knjigama");
			e.printStackTrace();
		}
	}

	
	public void ucitajClanove(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				int id = Integer.parseInt(split[0]);
				String ime = split[1];
				String prezime = split[2];
				String JMBG = split[3];
				String adresa = split[4];
				int polInt = Integer.parseInt(split[5]);
				Pol pol = Pol.values()[polInt];
				String brojClanskeKarte = split[6];
				LocalDate datumPoslednjeUplate = LocalDate.parse(split[7]);
				int brojMeseciClanarine = Integer.parseInt(split[8]);
				boolean aktivan = Boolean.parseBoolean(split[9]);
				
				int tipClanarineId = Integer.parseInt(split[10]);
				TipClanarine tipClanarine = (TipClanarine) pronadjiTipClanarine(tipClanarineId);
				
				boolean obrisan = Boolean.parseBoolean(split[11]);
				
				
				ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, JMBG, adresa, pol, brojClanskeKarte, datumPoslednjeUplate, brojMeseciClanarine, aktivan, tipClanarine, obrisan);
				listaClanova.add(clan);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o clanovima");
			e.printStackTrace();
		}
	}

	
	public void ucitajPrimerkeKnjiga(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				int id = Integer.parseInt(split[0]);
				int brojStrana = Integer.parseInt(split[1]);
				boolean tvrdPovez = Boolean.parseBoolean(split[2]);
				int godinaStampanja = Integer.parseInt(split[3]);
				boolean iznajmljena = Boolean.parseBoolean(split[4]);
				
				int KnjigaId = Integer.parseInt(split[5]);
				Knjiga knjigaKojojPrimerakPripada = (Knjiga) pronadjiKnjigu(KnjigaId);
				
				String jezikStampanja = split[6];
				
				boolean obrisan = Boolean.parseBoolean(split[7]);
				
				
				
				
				PrimerakKnjige primerak = new PrimerakKnjige(id, brojStrana, tvrdPovez, godinaStampanja, iznajmljena, knjigaKojojPrimerakPripada, jezikStampanja, obrisan);
				listaPrimerakaKnjiga.add(primerak);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o primercima knjiga");
			e.printStackTrace();
		}
	}

	
	public void ucitajIznajmljivanje(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				
				String[] split = line.split("\\|");
				
				LocalDate datumIznajmljivanja = LocalDate.parse(split[0]);
				LocalDate datumVracanja = LocalDate.parse(split[1]);
				
				int ZaposleniId = Integer.parseInt(split[2]);
				Zaposleni zaposleni = (Zaposleni) pronadjiZaposlenog(ZaposleniId);
				
				int ClanId = Integer.parseInt(split[3]);
				ClanBiblioteke clan = (ClanBiblioteke) pronadjiClana(ClanId);
				
				int PrimerakKnjigeId = Integer.parseInt(split[4]);
				PrimerakKnjige primerakKnjige = (PrimerakKnjige) pronadjiPrimerak(PrimerakKnjigeId);
				
				boolean obrisan = Boolean.parseBoolean(split[5]);
				
				
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(datumIznajmljivanja, datumVracanja, zaposleni, clan, primerakKnjige, obrisan);
				listaIznajmljivanja.add(iznajmljivanje);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
			e.printStackTrace();
		}
	}


	
	/******************************************************************************************************/
	
	
	public void dodajTipClanarine(TipClanarine tip) {
		this.listaTipovaClanarine.add(tip);
	}
	
	public void dodajZaposlenog(Zaposleni zaposleni) {
		this.listaZaposlenih.add(zaposleni);
	}
	
	public void dodajZanr(ZanrKnjige zanr) {
		this.listaZanrova.add(zanr);
	}
	
	public void dodajKnjigu(Knjiga knjiga) {
		this.listaKnjiga.add(knjiga);
		
	}
	
	public void dodajClana(ClanBiblioteke clan) {
		this.listaClanova.add(clan);
		
	}
	
	public void dodajPrimerakKnjige(PrimerakKnjige primerak) {
		this.listaPrimerakaKnjiga.add(primerak);
		
	}
	
	public void dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.listaIznajmljivanja.add(iznajmljivanje);
		
	}
	
	
	/******************************************************************************************************/

	
	public void obrisiTipClanarine(TipClanarine tip) {
		this.listaTipovaClanarine.remove(tip);
	}
	
	public void obrisiZaposlenog(Zaposleni zaposleni) {
		this.listaZaposlenih.remove(zaposleni);
	}
	
	public void obrisiZanr(ZanrKnjige zanr) {
		this.listaZanrova.remove(zanr);
	}
	
	public void obrisiKnjigu(Knjiga knjiga) {
		this.listaKnjiga.remove(knjiga);
		
	}
	
	public void obrisiClana(ClanBiblioteke clan) {
		this.listaClanova.remove(clan);
		
	}
	
	public void obrisiPrimerakKnjige(PrimerakKnjige primerak) {
		this.listaPrimerakaKnjiga.remove(primerak);
		
	}
	
	public void obrisiIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.listaIznajmljivanja.remove(iznajmljivanje);
		
	}
	
	
	/******************************************************************************************************/
	
	
	public ArrayList<TipClanarine> sviNeobrisaniTipovi() {
		ArrayList<TipClanarine> neobrisani = new ArrayList<TipClanarine>();
		for(TipClanarine tip : listaTipovaClanarine) {
			if(!tip.isObrisan()) {
				neobrisani.add(tip);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Zaposleni> sviNeobrisaniZaposleni() {
		ArrayList<Zaposleni> neobrisani = new ArrayList<Zaposleni>();
		for(Zaposleni zap : listaZaposlenih) {
			if(!zap.isObrisan()) {
				neobrisani.add(zap);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<ZanrKnjige> sviNeobrisaniZanrovi() {
		ArrayList<ZanrKnjige> neobrisani = new ArrayList<ZanrKnjige>();
		for(ZanrKnjige zanr : listaZanrova) {
			if(!zanr.isObrisan()) {
				neobrisani.add(zanr);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Knjiga> sveNeobrisaneKnjige() {
		ArrayList<Knjiga> neobrisane = new ArrayList<Knjiga>();
		for(Knjiga k : listaKnjiga) {
			if(!k.isObrisan()) {
				neobrisane.add(k);
			}
		}
		return neobrisane;
	}
	
	public ArrayList<ClanBiblioteke> sviNeobrisaniClanovi() {
		ArrayList<ClanBiblioteke> neobrisani = new ArrayList<ClanBiblioteke>();
		for(ClanBiblioteke c : listaClanova) {
			if(!c.isObrisan()) {
				neobrisani.add(c);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<PrimerakKnjige> sviNeobrisaniPrimerci() {
		ArrayList<PrimerakKnjige> neobrisani = new ArrayList<PrimerakKnjige>();
		for(PrimerakKnjige p : listaPrimerakaKnjiga) {
			if(!p.isObrisan()) {
				neobrisani.add(p);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Iznajmljivanje> svaNeobrisanaIznajmljivanja() {
		ArrayList<Iznajmljivanje> neobrisana = new ArrayList<Iznajmljivanje>();
		for(Iznajmljivanje i : listaIznajmljivanja) {
			if(!i.isObrisan()) {
				neobrisana.add(i);
			}
		}
		return neobrisana;
	}
	
}