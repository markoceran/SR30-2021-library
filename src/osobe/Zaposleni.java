package osobe;

public class Zaposleni extends Osoba {

   
    protected String korisnickoIme;
    protected String korisnickaLozinka;
    protected double plata;
    
    
	public Zaposleni() {
		super();
		this.korisnickoIme = "";
		this.korisnickaLozinka = "";
		this.plata = 0;
		
	}

	public Zaposleni(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaLozinka, double plata, boolean obrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, obrisan);
		this.korisnickoIme = korisnickoIme;
		this.korisnickaLozinka = korisnickaLozinka;
		this.plata = plata;
		
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getKorisnickaLozinka() {
		return korisnickaLozinka;
	}

	public void setKorisnickaLozinka(String korisnickaLozinka) {
		this.korisnickaLozinka = korisnickaLozinka;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	
	

	@Override
	public String toString() {
		return "Zaposleni [korisnickoIme=" + korisnickoIme + ", korisnickaLozinka=" + korisnickaLozinka + ", plata="
				+ plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa="
				+ adresa + ", pol=" + pol + ", obrisan=" + obrisan + "]";
	}



}