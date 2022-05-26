package osobe;

public class Administrator extends Zaposleni {

    
    public Administrator() {
    	super();
    }
    

	@Override
	public String toString() {
		return "Administrator [korisnickoIme=" + korisnickoIme + ", korisnickaLozinka=" + korisnickaLozinka + ", plata="
				+ plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa="
				+ adresa + ", pol=" + pol + ", obrisan=" + obrisan + "]";
	}
    
    

}