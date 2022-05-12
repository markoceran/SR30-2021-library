package entiteti;


public class PrimerakKnjige {

    
    private int id;
    private int brojStrana;
    private boolean tvrdPovez;
    private int godinaStampanja;
    private boolean iznajmljena;
    private Knjiga knjigaKojojPrimerakPripada;
    private String jezikStampanja;
    
    
	public PrimerakKnjige() {
		
		this.id = 0;
		this.brojStrana = 0;
		this.tvrdPovez = false;
		this.godinaStampanja = 0;
		this.iznajmljena = false;
		this.knjigaKojojPrimerakPripada = new Knjiga();
		this.jezikStampanja = "";
	}


	public PrimerakKnjige(int id, int brojStrana, boolean tvrdPovez, int godinaStampanja, boolean iznajmljena,
			Knjiga knjigaKojojPrimerakPripada, String jezikStampanja) {
		super();
		this.id = id;
		this.brojStrana = brojStrana;
		this.tvrdPovez = tvrdPovez;
		this.godinaStampanja = godinaStampanja;
		this.iznajmljena = iznajmljena;
		this.knjigaKojojPrimerakPripada = knjigaKojojPrimerakPripada;
		this.jezikStampanja = jezikStampanja;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBrojStrana() {
		return brojStrana;
	}


	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}


	public boolean isTvrdPovez() {
		return tvrdPovez;
	}


	public void setTvrdPovez(boolean tvrdPovez) {
		this.tvrdPovez = tvrdPovez;
	}


	public int getGodinaStampanja() {
		return godinaStampanja;
	}


	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}


	public boolean isIznajmljena() {
		return iznajmljena;
	}


	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}


	public Knjiga getKnjigaKojojPrimerakPripada() {
		return knjigaKojojPrimerakPripada;
	}


	public void setKnjigaKojojPrimerakPripada(Knjiga knjigaKojojPrimerakPripada) {
		this.knjigaKojojPrimerakPripada = knjigaKojojPrimerakPripada;
	}


	public String getJezikStampanja() {
		return jezikStampanja;
	}


	public void setJezikStampanja(String jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}


	@Override
	public String toString() {
		return "PrimerakKnjige [id=" + id + ", brojStrana=" + brojStrana + ", tvrdPovez=" + tvrdPovez
				+ ", godinaStampanja=" + godinaStampanja + ", iznajmljena=" + iznajmljena
				+ ", knjigaKojojPrimerakPripada=" + knjigaKojojPrimerakPripada + ", jezikStampanja=" + jezikStampanja
				+ "]";
	}
	
	
    

}