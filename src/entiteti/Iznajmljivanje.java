package entiteti;
import java.time.LocalDate;
import osobe.ClanBiblioteke;
import osobe.Zaposleni;

public class Iznajmljivanje {

    
    private LocalDate datumIznajmljivanja;
    private LocalDate datumVracanja;
    private Zaposleni zaposleni;
    private ClanBiblioteke clan;
    private PrimerakKnjige primerakKnjige;
    private boolean obrisan;
    
    
	public Iznajmljivanje() {
		
		this.datumIznajmljivanja = LocalDate.of(0,0,0);
		this.datumVracanja = LocalDate.of(0,0,0);
		this.zaposleni = new Zaposleni();
		this.clan = new ClanBiblioteke();
		this.primerakKnjige = new PrimerakKnjige();
		this.obrisan = false;
	}


	public Iznajmljivanje(LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, PrimerakKnjige primerakKnjige,boolean obrisan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerakKnjige = primerakKnjige;
		this.obrisan = obrisan;
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


	public PrimerakKnjige getPrimerakKnjige() {
		return primerakKnjige;
	}


	public void setPrimerakKnjige(PrimerakKnjige primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}
	
	


	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}


	@Override
	public String toString() {
		return "Iznajmljivanje [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", zaposleni=" + zaposleni + ", clan=" + clan + ", primerakKnjige=" + primerakKnjige + " , obrisan=" + obrisan + "]";
	}
	
	
	


}