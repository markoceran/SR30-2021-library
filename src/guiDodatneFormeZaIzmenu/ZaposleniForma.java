package guiDodatneFormeZaIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import entiteti.PrimerakKnjige;
import entiteti.TipClanarine;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;
import osobe.Pol;
import osobe.Uloga;
import osobe.Zaposleni;

public class ZaposleniForma extends JFrame {
	
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
	private JComboBox<Pol> boxPol = new JComboBox<Pol>(Pol.values());
	private JLabel lbKorisnickoIme = new JLabel ("Korisničko ime");
	private JTextField txtKorisnickoIme = new JTextField(25);
	private JLabel lbLozinka = new JLabel("Korisnička lozinka");
	private JPasswordField txtLozinka = new JPasswordField(25);
	private JLabel lbPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(25);
	private JLabel lbUloga = new JLabel("Uloga");
	private JComboBox<Uloga> boxUloga = new JComboBox<Uloga>(Uloga.values());
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> boxObrisan = new JComboBox<Boolean>();
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private Zaposleni zaposleni;
	private Biblioteka biblioteka;
	
	
	public ZaposleniForma(Biblioteka biblioteka, Zaposleni zaposleni) {
		
		this.biblioteka = biblioteka;
		this.zaposleni = zaposleni;
		if(zaposleni == null) {
			setTitle("Dodavanje zaposlenog :");
		}else {
			setTitle("Izmena podataka zaposlenog [" + zaposleni.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 550);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[]15[]", "[]10[]10[]10[]20[]20[]");
		setLayout(layout);
		
		boxObrisan.addItem(true);
		boxObrisan.addItem(false);
		boxObrisan.setSelectedItem(false);
	
		
		if(zaposleni != null) {
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
		add(lbKorisnickoIme);
		add(txtKorisnickoIme);
		add(lbLozinka);
		add(txtLozinka);
		add(lbPlata);
		add(txtPlata);
		add(lbUloga);
		add(boxUloga);
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
				ZaposleniForma.this.dispose();
				ZaposleniForma.this.setVisible(false);
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
					Pol pol =  (Pol) boxPol.getSelectedItem();
					String kIme = txtKorisnickoIme.getText().trim();
					@SuppressWarnings("deprecation")
					String lozinka = txtLozinka.getText().trim();
					Double plata = Double.parseDouble(txtPlata.getText().trim());
					Uloga uloga = (Uloga) boxUloga.getSelectedItem();
					Boolean obrisan = (Boolean) boxObrisan.getSelectedItem();
					
					if(zaposleni == null) {
						Zaposleni novi = new Zaposleni (id, ime, prezime, jmbg, adresa, pol, kIme, lozinka, plata, obrisan, uloga);
						biblioteka.dodajZaposlenog(novi);
					}else {
						zaposleni.setId(id);
						zaposleni.setIme(ime);
						zaposleni.setPrezime(prezime);
						zaposleni.setJMBG(jmbg);
						zaposleni.setAdresa(adresa);
						zaposleni.setPol(pol);
						zaposleni.setKorisnickoIme(kIme);
						zaposleni.setKorisnickaLozinka(lozinka);
						zaposleni.setPlata(plata);
						zaposleni.setUloga(uloga);
						zaposleni.setObrisan(obrisan);
					}
					biblioteka.snimiZaposlene(BibliotekaMain.ZAPOSLENI_FAJL);
					ZaposleniForma.this.dispose();
					ZaposleniForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	

	
	
	private void popuniPolja() {
		
		
		txtId.setText(String.valueOf(zaposleni.getId()));
		txtIme.setText(zaposleni.getIme());
		txtPrezime.setText(zaposleni.getPrezime());
		txtJmbg.setText(zaposleni.getJMBG());
		txtAdresa.setText(zaposleni.getAdresa());
		txtKorisnickoIme.setText(zaposleni.getKorisnickoIme());
		txtLozinka.setText(zaposleni.getKorisnickaLozinka());
		txtPlata.setText("" + zaposleni.getPlata() + "" );
		boxObrisan.setSelectedItem(zaposleni.isObrisan());
		boxPol.setSelectedItem(zaposleni.getPol());
		boxUloga.setSelectedItem(zaposleni.getUloga());
		
		
	}
	
	
	private boolean validacija() {
		
		boolean ok = true;
		String poruka = "";
		
		
		try {
			Integer.parseInt(txtId.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "ID mora biti broj\n";
			ok = false;
		}
		
		if(zaposleni == null) {
			String id = txtId.getText().trim();
			Zaposleni pronadjen = biblioteka.pronadjiZaposlenog(Integer.parseInt(id));
			if(pronadjen != null) {
				poruka += "Zaposleni sa unetim ID već postoji\n";
				ok = false;
			}
		}
		
		try {
			Integer.parseInt(txtJmbg.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "JMBG mora biti broj\n";
			ok = false;
		}
		
		
		if(txtId.getText().trim().equals("")) {
			poruka += "Morate uneti ID \n";
			ok = false;
		}
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "Morate uneti ime \n";
			ok = false;
		}
		
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "Morate uneti prezime\n";
			ok = false;
		}
		
		
		if (txtJmbg.getText().trim().equals("")) {
			poruka += "Morate uneti jmbg \n";
			ok = false;
		}
		
		
		if (txtAdresa.getText().trim().equals("")) {
			poruka += "Morate uneti adresu\n";
			ok = false;
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}

}
