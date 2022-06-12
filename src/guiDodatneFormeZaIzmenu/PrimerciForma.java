package guiDodatneFormeZaIzmenu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import entiteti.Knjiga;
import entiteti.PrimerakKnjige;
import entiteti.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;

public class PrimerciForma extends JFrame {
	
	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbBrojStrana = new JLabel("Broj strana");
	private JTextField txtBrojStrana = new JTextField(25);
	private JLabel lbTvrdPovez = new JLabel("Tvrd povez");
	private JComboBox<Boolean> boxTvrdeKorice = new JComboBox<Boolean>();
	private JLabel lbGodina = new JLabel("Godina štampanja");
	private JTextField txtGodina = new JTextField(25);
	private JLabel lbIznajmljen = new JLabel("Iznajmljen");
	private JComboBox<Boolean> boxIznajmljen = new JComboBox<Boolean>();
	private JLabel lbKnjiga = new JLabel("Knjiga kojoj pripada");
	private JComboBox<Integer> boxKnjiga = new JComboBox<Integer>();
	private JLabel lbJezik = new JLabel("Jezik štampanja");
	private JTextField txtJezik = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> txtObrisan = new JComboBox<Boolean>();
		
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private PrimerakKnjige primerak;
	private Biblioteka biblioteka;

	
	public PrimerciForma(Biblioteka biblioteka, PrimerakKnjige primerak) {
		
		this.biblioteka = biblioteka;
		this.primerak = primerak;
		if(primerak == null) {
			setTitle("Dodavanje primerka knjige :");
		}else {
			setTitle("Izmena podataka primerka knjige [" + primerak.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		txtObrisan.addItem(true);
		txtObrisan.addItem(false);
		boxTvrdeKorice.addItem(true);
		boxTvrdeKorice.addItem(false);
		boxIznajmljen.addItem(true);
		boxIznajmljen.addItem(false);
		
		boxKnjiga.addItem(0);
		for(Knjiga knjiga : biblioteka.sveNeobrisaneKnjige()) {
			boxKnjiga.addItem(knjiga.getId());
		}
		
		if(primerak != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbId);
		add(txtId);
		add(lbBrojStrana);
		add(txtBrojStrana);
		add(lbTvrdPovez);
		add(boxTvrdeKorice);
		add(lbGodina);
		add(txtGodina);
		add(lbIznajmljen);
		add(boxIznajmljen);
		add(lbKnjiga);
		add(boxKnjiga);
		add(lbJezik);
		add(txtJezik);
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
				PrimerciForma.this.dispose();
				PrimerciForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());	
					int brojStrana = Integer.parseInt(txtBrojStrana.getText().trim());
					Boolean povez = (Boolean) boxTvrdeKorice.getSelectedItem();
					int godina = Integer.parseInt(txtGodina.getText().trim());
					Boolean iznajmljen = (Boolean) boxIznajmljen.getSelectedItem();
					int knjigaId = (int) boxKnjiga.getSelectedItem();
					Knjiga knjiga = biblioteka.pronadjiKnjigu(knjigaId);
					String jezik = txtJezik.getText().trim();
					Boolean obrisan = (Boolean) txtObrisan.getSelectedItem();
					
					if(primerak == null) {
						PrimerakKnjige novi = new PrimerakKnjige (id, brojStrana, povez, godina, iznajmljen, knjiga, jezik, obrisan);
						biblioteka.dodajPrimerakKnjige(novi);
					}else {
						primerak.setBrojStrana(brojStrana);
						primerak.setTvrdPovez(povez);
						primerak.setGodinaStampanja(godina);
						primerak.setIznajmljena(iznajmljen);
						primerak.setKnjigaKojojPrimerakPripada(knjiga);
						primerak.setJezikStampanja(jezik);
						primerak.setObrisan(obrisan);
					}
					biblioteka.snimiPrimerkeKnjiga(BibliotekaMain.PRIMERCIKNJIGA_FAJL);
					PrimerciForma.this.dispose();
					PrimerciForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtId.setText(String.valueOf(primerak.getId()));
		txtBrojStrana.setText(""+ primerak.getBrojStrana() + "");
		boxTvrdeKorice.setSelectedItem(primerak.isTvrdPovez());
		txtGodina.setText("" + primerak.getGodinaStampanja() + "");
		boxIznajmljen.setSelectedItem(primerak.isIznajmljena());
		boxKnjiga.setSelectedItem(primerak.getKnjigaKojojPrimerakPripada().getId());
		txtJezik.setText(primerak.getJezikStampanja());
		txtObrisan.setSelectedItem(primerak.isObrisan());
		
		
		
	}
	
	
	private boolean validacija() {
		
		return true;
	}
	

}
