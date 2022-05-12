package osobe;

public class Bibliotekar extends Zaposleni {

    
    public Bibliotekar() {
    	super();
    }
    

	@Override
	public String toString() {
		return "Bibliotekar [korisnickoIme=" + korisnickoIme + ", korisnickaLozinka=" + korisnickaLozinka + ", plata="
				+ plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa="
				+ adresa + ", pol=" + pol + "]";
	}
    

}