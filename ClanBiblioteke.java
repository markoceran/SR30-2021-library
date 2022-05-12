package osobe;
import java.time.LocalDate;
import entiteti.TipClanarine;

public class ClanBiblioteke extends Osoba {

    
    private String brojClanskeKarte;
    private LocalDate datumPoslednjeUplate;
    private int brojMeseciClanarine;
    private boolean aktivan;
    private TipClanarine tipClanarine;
    
	public ClanBiblioteke() {
		super();
		this.brojClanskeKarte = "";
		this.datumPoslednjeUplate = LocalDate.of(0,0,0);
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
		this.tipClanarine = new TipClanarine();
		
	}

	public ClanBiblioteke(int id, String ime, String prezime, String jMBG, String adresa, Pol pol,
			String brojClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine, boolean aktivan,
			TipClanarine tipClanarine) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.brojClanskeKarte = brojClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		this.tipClanarine = tipClanarine;
	}

	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrojMeseciClanarine() {
		return brojMeseciClanarine;
	}

	public void setBrojMeseciClanarine(int brojMeseciClanarine) {
		this.brojMeseciClanarine = brojMeseciClanarine;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}

	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}

	@Override
	public String toString() {
		return "ClanBiblioteke [brojClanskeKarte=" + brojClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseciClanarine=" + brojMeseciClanarine + ", aktivan=" + aktivan + ", tipClanarine="
				+ tipClanarine + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa="
				+ adresa + ", pol=" + pol + "]";
	}
	
	
	
	

}