package guiDodatneFormeZaIzmenu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.LineBreakMeasurer;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import entiteti.Knjiga;
import entiteti.TipClanarine;
import entiteti.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;
import osobe.Pol;

public class ClanoviForma extends JFrame {
	
	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(25);
	private JLabel lbPrezime = new JLabel ("Prezime");
	private JTextField txtPrezime = new JTextField(25);
	private JLabel lbJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(25);
	private JLabel lbAdresa = new JLabel ("Adresa");
	private JTextField txtAdresa = new JTextField(25);
	private JLabel lbPol = new JLabel("Pol");
	private JComboBox<String> boxPol = new JComboBox<String>();
	private JLabel lbBrkarte = new JLabel ("Broj Ä�lanske karte");
	private JTextField txtBrkarte = new JTextField(25);
	private JLabel lbDatum = new JLabel("Datum poslednje uplate");
	private JTextField txtDatum = new JTextField(25);
	private JLabel lbBrmesec = new JLabel("Broj meseci Ä�lanarine");
	private JTextField txtBrmesec = new JTextField(25);
	private JLabel lbAktivan = new JLabel("Aktivan");
	private JComboBox<Boolean> boxAktivan = new JComboBox<Boolean>();
	private JLabel lbTipclanarine = new JLabel("Tip Ä�lanarine");
	private JComboBox<Integer> boxTipclanarine = new JComboBox<Integer>();
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> boxObrisan = new JComboBox<Boolean>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private ClanBiblioteke clan;
	private Biblioteka biblioteka;
	
	
	public ClanoviForma(Biblioteka biblioteka, ClanBiblioteke clan) {
		
		this.biblioteka = biblioteka;
		this.clan = clan;
		if(clan == null) {
			setTitle("Dodavanje Ä�lana :");
		}else {
			setTitle("Izmena podataka Ä�lana [" + clan.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 550);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		boxObrisan.addItem(true);
		boxObrisan.addItem(false);
		boxPol.addItem("MUSKI");
		boxPol.addItem("ZENSKI");
		boxAktivan.addItem(true);
		boxAktivan.addItem(false);
		
		for(TipClanarine tip : biblioteka.sviNeobrisaniTipovi()) {
			boxTipclanarine.addItem(tip.getId());
		}
		
		if(clan != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbId);
		add(txtId);
		add(lbIme);
		add(txtIme);
		add(lbPrezime);
		add(txtPrezime);
		add(lbJmbg);
		add(txtJmbg);
		add(lbAdresa);
		add(txtAdresa);
		add(lbPol);
		add(boxPol);
		add(lbBrkarte);
		add(txtBrkarte);
		add(lbDatum);
		add(txtDatum);
		add(lbBrmesec);
		add(txtBrmesec);
		add(lbAktivan);
		add(boxAktivan);
		add(lbTipclanarine);
		add(boxTipclanarine);
		add(lbObrisan);
		add(boxObrisan);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanoviForma.this.dispose();
				ClanoviForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());	
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					String pol =  (String) boxPol.getSelectedItem();
					String brKarte = txtBrkarte.getText().trim();
					LocalDate datum = LocalDate.parse(txtDatum.getText().trim()) ;
					int meseci = Integer.parseInt(txtBrmesec.getText().trim()) ;
					Boolean aktivan = (Boolean) boxAktivan.getSelectedItem();
					int tipId = (int) boxTipclanarine.getSelectedItem();
					TipClanarine tipClanarine = biblioteka.pronadjiTipClanarine(tipId) ;
					Boolean obrisan = (Boolean) boxObrisan.getSelectedItem();
					
					if(clan == null) {
						ClanBiblioteke novi = new ClanBiblioteke (id, ime, prezime, jmbg, adresa, Pol.valueOf(pol), brKarte, datum, meseci, aktivan, tipClanarine, obrisan );
						biblioteka.dodajClana(novi);
					}else {
						clan.setId(id);
						clan.setIme(ime);
						clan.setPrezime(prezime);
						clan.setJMBG(jmbg);
						clan.setAdresa(adresa);
						clan.setPol(Pol.valueOf(pol));
						clan.setBrojClanskeKarte(brKarte);
						clan.setDatumPoslednjeUplate(datum);
						clan.setBrojMeseciClanarine(meseci);
						clan.setAktivan(aktivan);
						clan.setTipClanarine(tipClanarine);
						clan.setObrisan(obrisan);
					}
					biblioteka.snimiClanove(main.BibliotekaMain.CLANOVI_FAJL);
					ClanoviForma.this.dispose();
					ClanoviForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtId.setText(String.valueOf(clan.getId()));
		txtIme.setText(clan.getIme());
		txtPrezime.setText(clan.getPrezime());
		txtJmbg.setText(clan.getJMBG());
		txtAdresa.setText(clan.getAdresa());
		txtBrkarte.setText(clan.getBrojClanskeKarte());
		txtDatum.setText(clan.getDatumPoslednjeUplate().toString());
		txtBrmesec.setText("" + clan.getBrojMeseciClanarine() + "" );
		boxAktivan.setSelectedItem(clan.isAktivan());
		boxTipclanarine.setSelectedItem(clan.getTipClanarine().getId());
		boxObrisan.setSelectedItem(clan.isObrisan());
		
		
	}
	
	
	private boolean validacija() {
		
		return true;
	}
}
