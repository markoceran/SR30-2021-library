package entiteti;

public class Knjiga {

    
    private int id;
    private String naslov;
    private String originalniNaslov;
    private String pisac;
    private int godinaObjavljivanja;
    private String opisKnjige;
    private ZanrKnjige zanr;
    private String jezikOriginala;
    private boolean obrisan;
   
    
    
	public Knjiga() {

		this.id = 0;
		this.naslov = "";
		this.originalniNaslov = "";
		this.pisac = "";
		this.godinaObjavljivanja = 0;
		this.opisKnjige = "";
		this.zanr = new ZanrKnjige();
		this.jezikOriginala = "";
		this.obrisan = false;
		
		
	}

	public Knjiga(int id, String naslov, String originalniNaslov, String pisac, int godinaObjavljivanja,
			String opisKnjige, ZanrKnjige zanr, String jezikOriginala, boolean obrisan) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pisac = pisac;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opisKnjige = opisKnjige;
		this.zanr = zanr;
		this.jezikOriginala = jezikOriginala;
		this.obrisan = obrisan;
	
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getOpisKnjige() {
		return opisKnjige;
	}

	public void setOpisKnjige(String opisKnjige) {
		this.opisKnjige = opisKnjige;
	}

	public ZanrKnjige getZanr() {
		return zanr;
	}

	public void setZanr(ZanrKnjige zanr) {
		this.zanr = zanr;
	}

	public String getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(String jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	


	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naslov=" + naslov + ", originalniNaslov=" + originalniNaslov + ", pisac=" + pisac
				+ ", godinaObjavljivanja=" + godinaObjavljivanja + ", opisKnjige=" + opisKnjige + ", zanr=" + zanr
				+ ", jezikOriginala=" + jezikOriginala + ", obrisan=" + obrisan + "]";
	}
    
	
	
 

}