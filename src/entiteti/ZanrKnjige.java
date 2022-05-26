package entiteti;

public class ZanrKnjige {

   
    private String oznaka;
    private String opis;
    
	public ZanrKnjige() {
		this.oznaka = "";
		this.opis = "";
	}

	public ZanrKnjige(String oznaka, String opis) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "ZanrKnjige [oznaka=" + oznaka + ", opis=" + opis + "]";
	}
	
	
    

}