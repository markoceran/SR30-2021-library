package entiteti;


public class TipClanarine {


    private int id;
    private String naziv;
    private double cena;
    
	public TipClanarine() {
		
		this.id = 0;
		this.naziv = "";
		this.cena = 0;
	}

	public TipClanarine(int id, String naziv, double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "TipClanarine [id=" + id + ", naziv=" + naziv + ", cena=" + cena + "]";
	}
	
	
    

}