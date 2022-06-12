package guiDodatneFormeZaIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import entiteti.Iznajmljivanje;
import entiteti.PrimerakKnjige;
import entiteti.TipClanarine;
import entiteti.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;
import osobe.Zaposleni;

public class IznajmljivanjeForma extends JFrame {
	
	private JLabel lbDatumIznajmljivanja = new JLabel ("Datum iznajmljivanja");
	private JTextField txtDatumIznajmljivanja = new JTextField(25);
	private JLabel lbDatumVracanja= new JLabel("Datum vraćanja");
	private JTextField txtDatumVracanja = new JTextField(25);
	private JLabel lbZaposleni = new JLabel("Zaposleni");
	private JComboBox<Integer> boxZaposleni = new JComboBox<Integer>();
	private JLabel lbClan = new JLabel("Član biblioteke");
	private JComboBox<Integer> boxClan = new JComboBox<Integer>();
	private JLabel lbPrimerak = new JLabel("Primerak knjige");
	private JComboBox<Integer> boxPrimerak = new JComboBox<Integer>();
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> txtObrisan = new JComboBox<Boolean>();
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private Iznajmljivanje iznajmljivanje;
	private Biblioteka biblioteka;
	

	public IznajmljivanjeForma(Biblioteka biblioteka, Iznajmljivanje iznajmljivanje) {
		
		this.biblioteka = biblioteka;
		this.iznajmljivanje = iznajmljivanje;
		if(iznajmljivanje == null) {
			setTitle("Dodavanje iznajmljivanja :");
		}else {
			setTitle("Izmena podataka o iznajmljivanju");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(350,350);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		txtObrisan.addItem(true);
		txtObrisan.addItem(false);
		
		boxZaposleni.addItem(0);
		for(Zaposleni z : biblioteka.sviNeobrisaniZaposleni()) {
			boxZaposleni.addItem(z.getId());
		}
		
		boxClan.addItem(0);
		for(ClanBiblioteke c : biblioteka.sviNeobrisaniClanovi()) {
			boxClan.addItem(c.getId());
		}
		
		boxPrimerak.addItem(0);
		for(PrimerakKnjige p : biblioteka.sviNeobrisaniPrimerci()) {
			boxPrimerak.addItem(p.getId());
		}
		
		
		
		if(iznajmljivanje != null) {
			popuniPolja();
		}
		
		
		add(lbDatumIznajmljivanja);
		add(txtDatumIznajmljivanja);
		add(lbDatumVracanja);
		add(txtDatumVracanja);
		add(lbZaposleni);
		add(boxZaposleni);
		add(lbClan);
		add(boxClan);
		add(lbPrimerak);
		add(boxPrimerak);
		add(lbObrisan);
		add(txtObrisan);
		
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeForma.this.dispose();
				IznajmljivanjeForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					LocalDate datumIz = LocalDate.parse(txtDatumIznajmljivanja.getText().trim()) ;
					LocalDate datumVr = LocalDate.parse(txtDatumVracanja.getText().trim());
					Zaposleni zaposleni = biblioteka.pronadjiZaposlenog(Integer.parseInt((String) boxZaposleni.getSelectedItem()) ); 
					ClanBiblioteke clan = biblioteka.pronadjiClana(Integer.parseInt((String) boxClan.getSelectedItem()) ); 
					PrimerakKnjige primerak = biblioteka.pronadjiPrimerak(Integer.parseInt((String) boxPrimerak.getSelectedItem()) ); 
					Boolean obrisan = (Boolean) txtObrisan.getSelectedItem();
					
					if(iznajmljivanje == null) {
						Iznajmljivanje novo = new Iznajmljivanje (datumIz, datumVr, zaposleni, clan, primerak, obrisan);
						biblioteka.dodajIznajmljivanje(novo);
					}else {
						iznajmljivanje.setDatumIznajmljivanja(datumIz);
						iznajmljivanje.setDatumVracanja(datumVr);
						iznajmljivanje.setZaposleni(zaposleni);
						iznajmljivanje.setClan(clan);
						iznajmljivanje.setPrimerakKnjige(primerak);
						iznajmljivanje.setObrisan(obrisan);



					}
					biblioteka.snimiIznajmljivanje(BibliotekaMain.IZNAJMLJIVANJE_FAJL);
					IznajmljivanjeForma.this.dispose();
					IznajmljivanjeForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtDatumIznajmljivanja.setText(String.valueOf(iznajmljivanje.getDatumIznajmljivanja()));
		txtDatumVracanja.setText(String.valueOf(iznajmljivanje.getDatumVracanja()));
		boxZaposleni.setSelectedItem(iznajmljivanje.getZaposleni().getId());
		boxClan.setSelectedItem(iznajmljivanje.getClan().getId());
		boxPrimerak.setSelectedItem(iznajmljivanje.getPrimerakKnjige().getId());
		txtObrisan.setSelectedItem(iznajmljivanje.isObrisan());

	
		
	}
	
	
	private boolean validacija() {
		
		return true;
	
	}
	
}
