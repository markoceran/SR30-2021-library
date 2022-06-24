package guiDodatneFormeZaIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	private JLabel lbID = new JLabel ("ID");
	private JTextField txtID = new JTextField(25);
	private JLabel lbDatumIznajmljivanja = new JLabel ("Datum iznajmljivanja");
	private JTextField txtDatumIznajmljivanja = new JTextField(25);
	private JLabel lbDatumVracanja= new JLabel("Datum vraćanja");
	private JTextField txtDatumVracanja = new JTextField(25);
	private JLabel lbZaposleni = new JLabel("Zaposleni");
	private JComboBox<Integer> boxZaposleni = new JComboBox<Integer>();
	private JLabel lbClan = new JLabel("Član biblioteke");
	private JComboBox<Integer> boxClan = new JComboBox<Integer>();
	private JLabel lbPrimerak = new JLabel("Primerak knjige");
	private ArrayList<String> primerci = new ArrayList<String>();
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> txtObrisan = new JComboBox<Boolean>();
	
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private Iznajmljivanje iznajmljivanje;
	private Biblioteka biblioteka;
	
	
	private JCheckBox checkBox;
	private ArrayList<JCheckBox> boxLista = new ArrayList<JCheckBox>();

	public IznajmljivanjeForma(Biblioteka biblioteka, Iznajmljivanje iznajmljivanje) {
		
		this.biblioteka = biblioteka;
		this.iznajmljivanje = iznajmljivanje;
		if(iznajmljivanje == null) {
			setTitle("Dodavanje iznajmljivanja :");
		}else {
			setTitle("Izmena podataka o iznajmljivanju");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,700);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		txtObrisan.addItem(true);
		txtObrisan.addItem(false);
		
		
		for(Zaposleni z : biblioteka.sviNeobrisaniZaposleni()) {
			boxZaposleni.addItem(z.getId());
		}
		
		
		for(ClanBiblioteke c : biblioteka.sviNeobrisaniClanovi()) {
			boxClan.addItem(c.getId());
		}
		
		
		
		
		if(iznajmljivanje != null) {
			popuniPolja();
		}
		
		add(lbID);
		add(txtID);
		add(lbDatumIznajmljivanja);
		add(txtDatumIznajmljivanja);
		add(lbDatumVracanja);
		add(txtDatumVracanja);
		add(lbZaposleni);
		add(boxZaposleni);
		add(lbClan);
		add(boxClan);
		add(lbPrimerak , "wrap");
		
		
		for(PrimerakKnjige p : biblioteka.sviNeobrisaniPrimerci()) {
			
			String i = String.valueOf(p.getId());
			
			checkBox  = new JCheckBox("" + i +"" + " - Knjiga: " + p.getKnjigaKojojPrimerakPripada().getOriginalniNaslov());  
			checkBox.setName(i);
	        add(checkBox);
	        boxLista.add(checkBox);
	       
	        
		}
		

		add(lbObrisan);
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
					
					int id = Integer.parseInt(txtID.getText().trim()) ;
					LocalDate datumIz = LocalDate.parse(txtDatumIznajmljivanja.getText().trim()) ;
					LocalDate datumVr = LocalDate.parse(txtDatumVracanja.getText().trim());
					int zaposleniId = (int) boxZaposleni.getSelectedItem();
					Zaposleni zaposleni = biblioteka.pronadjiZaposlenog(zaposleniId); 
					int clanId = (int) boxClan.getSelectedItem();
					ClanBiblioteke clan = biblioteka.pronadjiClana(clanId); 
					Boolean obrisan = (Boolean) txtObrisan.getSelectedItem();
					
					for(JCheckBox i : boxLista) {
						
					
						if(i.isSelected()) {
				        	primerci.add(i.getName());
				        }
						
					}
					

					System.out.println(primerci);
					if(iznajmljivanje == null) {
						Iznajmljivanje novo = new Iznajmljivanje (id, datumIz, datumVr, zaposleni, clan, primerci , obrisan);
						biblioteka.dodajIznajmljivanje(novo);
					}else {
						
						iznajmljivanje.setId(id);
						iznajmljivanje.setDatumIznajmljivanja(datumIz);
						iznajmljivanje.setDatumVracanja(datumVr);
						iznajmljivanje.setZaposleni(zaposleni);
						iznajmljivanje.setClan(clan);
						iznajmljivanje.setPrimerakKnjige(primerci);
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
		
		txtID.setText(String.valueOf(iznajmljivanje.getId()));
		txtDatumIznajmljivanja.setText(String.valueOf(iznajmljivanje.getDatumIznajmljivanja()));
		txtDatumVracanja.setText(String.valueOf(iznajmljivanje.getDatumVracanja()));
		boxZaposleni.setSelectedItem(iznajmljivanje.getZaposleni().getId());
		boxClan.setSelectedItem(iznajmljivanje.getClan().getId());
		txtObrisan.setSelectedItem(iznajmljivanje.isObrisan());
	
				
			
}
			

	
	
	
	private boolean validacija() {
		
		boolean ok = true;
		String poruka = "";
		
		
		try {
			Integer.parseInt(txtID.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "ID mora biti broj\n";
			ok = false;
		}
		
		if(iznajmljivanje == null) {
			String id = txtID.getText().trim();
			Iznajmljivanje pronadjeno = biblioteka.pronadjiIznajmljivanja(Integer.parseInt(id));
			if(pronadjeno != null) {
				poruka += "Iznajmljivanje sa unetim ID već postoji\n";
				ok = false;
			}
		}
		
		if(txtID.getText().trim().equals("") ||  txtDatumIznajmljivanja.getText().trim().equals("") || txtDatumVracanja.getText().trim().equals("")) {
			
			poruka += "Morate popuniti sva polja\n";
		    ok = false;
	
		} 
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	

}
	

