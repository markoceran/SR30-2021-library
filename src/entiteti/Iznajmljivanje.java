package entiteti;
import java.time.LocalDate;
import java.util.ArrayList;

import osobe.ClanBiblioteke;
import osobe.Zaposleni;

public class Iznajmljivanje {

    private int id;
    private LocalDate datumIznajmljivanja;
    private LocalDate datumVracanja;
    private Zaposleni zaposleni;
    private ClanBiblioteke clan;
    private ArrayList<String> primerakKnjige;
    private boolean obrisan;
    
    
	public Iznajmljivanje() {
		
		this.id = 0;
		this.datumIznajmljivanja = LocalDate.of(0,0,0);
		this.datumVracanja = LocalDate.of(0,0,0);
		this.zaposleni = new Zaposleni();
		this.clan = new ClanBiblioteke();
		this.primerakKnjige = new ArrayList<String>();
		this.obrisan = false;
	}


	public Iznajmljivanje(int id, LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, ArrayList<String> primerakKnjige,boolean obrisan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerakKnjige = primerakKnjige;
		this.obrisan = obrisan;
		this.id = id;
	}


	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}


	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}


	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}


	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}


	public Zaposleni getZaposleni() {
		return zaposleni;
	}


	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}


	public ClanBiblioteke getClan() {
		return clan;
	}


	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}


	public ArrayList<String> getPrimerakKnjige() {
		return primerakKnjige;
	}


	public void setPrimerakKnjige(ArrayList<String> primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}


	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + ", datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", zaposleni=" + zaposleni + ", clan=" + clan + ", primerakKnjige=" + primerakKnjige + " , obrisan=" + obrisan + "]";
	}
	
	
	


}