package guiDodatneFormeZaIzmenu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import entiteti.Knjiga;
import entiteti.ZanrKnjige;
import gui.LoginProzor;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;


public class KnjigeForma extends JFrame {

	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbNaslov = new JLabel("Naslov");
	private JTextField txtNaslov = new JTextField(25);
	private JLabel lbOriginalniNaslov = new JLabel("Originalni naslov");
	private JTextField txtOriginalniNaslov = new JTextField(25);
	private JLabel lbPisac = new JLabel("Pisac");
	private JTextField txtPisac = new JTextField(25);
	private JLabel lbGodinaObjavljivanja = new JLabel("Godina objavljivanja");
	private JTextField txtGodinaObjavljivanja = new JTextField(25);
	private JLabel lbOpisKnjige = new JLabel("Opis knjige");
	private JTextArea txtOpisKnjige = new JTextArea();
	private JLabel lbZanr = new JLabel("Zanr");
	private JComboBox<String> boxZanr = new JComboBox<String>();
	private JLabel lbJezik = new JLabel("Jezik originala");
	private JTextField txtJezik = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> txtObrisan = new JComboBox<Boolean>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private Knjiga knjiga;
	private Biblioteka biblioteka;
	

	public KnjigeForma(Biblioteka biblioteka, Knjiga knjiga) {
		
		this.biblioteka = biblioteka;
		this.knjiga = knjiga;
		if(knjiga == null) {
			setTitle("Dodavanje knjige :");
		}else {
			setTitle("Izmena podataka knjige [" + knjiga.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,420);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		txtObrisan.addItem(true);
		txtObrisan.addItem(false);
		txtObrisan.setSelectedItem(false);
		
		for(ZanrKnjige zanr : biblioteka.sviNeobrisaniZanrovi()) {
			boxZanr.addItem(zanr.getOznaka());
		}
		
		if(knjiga != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		txtOpisKnjige.setPreferredSize(new Dimension(200,400));
		
		add(lbId);
		add(txtId);
		add(lbNaslov);
		add(txtNaslov);
		add(lbOriginalniNaslov);
		add(txtOriginalniNaslov);
		add(lbPisac);
		add(txtPisac);
		add(lbGodinaObjavljivanja);
		add(txtGodinaObjavljivanja);
		add(lbZanr);
		add(boxZanr);
		add(lbJezik);
		add(txtJezik);
		add(lbObrisan);
		add(txtObrisan);
		add(lbOpisKnjige);
		add(txtOpisKnjige);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeForma.this.dispose();
				KnjigeForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());	
					String naslov = txtNaslov.getText().trim();
					String origNaslov = txtOriginalniNaslov.getText().trim();
					String pisac = txtPisac.getText().trim();
					int godina = Integer.parseInt(txtGodinaObjavljivanja.getText().trim());
					String opis = txtOpisKnjige.getText().trim();
					String zanrId = boxZanr.getSelectedItem().toString();
					ZanrKnjige zanr = biblioteka.pronadjiZanr(zanrId);
					String jezik = txtJezik.getText().trim();
					Boolean obrisan = (Boolean) txtObrisan.getSelectedItem();
					
					if(knjiga == null) {
						Knjiga nova = new Knjiga (id, naslov, origNaslov, pisac, godina, opis, zanr, jezik, obrisan);
						biblioteka.dodajKnjigu(nova);
					}else {
						knjiga.setNaslov(naslov);
						knjiga.setOriginalniNaslov(origNaslov);
						knjiga.setPisac(pisac);
						knjiga.setGodinaObjavljivanja(godina);
						knjiga.setOpisKnjige(opis);
						knjiga.setZanr(zanr);
						knjiga.setJezikOriginala(jezik);
						knjiga.setObrisan(obrisan);
					}
					biblioteka.snimiKnjige(BibliotekaMain.KNJIGE_FAJL);
					KnjigeForma.this.dispose();
					KnjigeForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtId.setText(String.valueOf(knjiga.getId()));
		txtNaslov.setText(knjiga.getNaslov());
		txtOriginalniNaslov.setText(knjiga.getOriginalniNaslov());
		txtPisac.setText(knjiga.getPisac());
		txtGodinaObjavljivanja.setText(String.valueOf(knjiga.getGodinaObjavljivanja()));
		txtOpisKnjige.setText(knjiga.getOpisKnjige());
		boxZanr.setSelectedItem(knjiga.getZanr().getOznaka());
		txtObrisan.setSelectedItem(knjiga.isObrisan());
		txtJezik.setText(knjiga.getJezikOriginala());
		
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
		
		if(knjiga == null) {
			String id = txtId.getText().trim();
			Knjiga pronadjena = biblioteka.pronadjiKnjigu(Integer.parseInt(id));
			if(pronadjena != null) {
				poruka += "Knjiga sa unetim ID već postoji\n";
				ok = false;
			}
		}
		
		try {
			Integer.parseInt(txtGodinaObjavljivanja.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "Godina objavljivanja mora biti broj\n";
			ok = false;
		}
		
		
		if(txtNaslov.getText().trim().equals("")) {
			poruka += "Morate uneti naslov knjige\n";
			ok = false;
		}
		
		if(txtOriginalniNaslov.getText().trim().equals("")) {
			poruka += "Morate uneti originalni naslov\n";
			ok = false;
		}
		
		if(txtPisac.getText().trim().equals("")) {
			poruka += "Morate uneti pisca\n";
			ok = false;
		}
		
		
		if (txtOpisKnjige.getText().trim().equals("")) {
			poruka += "Morate uneti opis knjige\n";
			ok = false;
		}
		
		
		if (txtJezik.getText().trim().equals("")) {
			poruka += "Morate uneti jezik\n";
			ok = false;
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
