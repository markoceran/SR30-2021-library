package guiDodatneFormeZaIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import biblioteka.Biblioteka;
import entiteti.Knjiga;
import entiteti.PrimerakKnjige;
import entiteti.ZanrKnjige;
import guiFormeZaPrikaz.SviIznajmljeniPrimerciProzor;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;

public class SviIznajmljeniPrimerciForma extends JFrame {
		
	private JComboBox<String> primerciCombo = new JComboBox<String>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private PrimerakKnjige primerak;
	private Biblioteka biblioteka;
	
	
	public SviIznajmljeniPrimerciForma(Biblioteka biblioteka, PrimerakKnjige primerak) {
		
		this.biblioteka = biblioteka;
		this.primerak = primerak;
		
		setTitle("Dodavanje iznajmljenog primerka :");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,170);
		setLocationRelativeTo(null);
		
		gui();
		initAction();

	}
	
	
	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "120[][][]", "30[]");
		setLayout(layout);
		
		
		for(PrimerakKnjige p : biblioteka.sviNeobrisaniPrimerci()) {
			if(p.isIznajmljena() == false) {
				
				primerciCombo.addItem(String.valueOf(p.getId()) + "- Knjiga: " + p.getKnjigaKojojPrimerakPripada().getOriginalniNaslov());
				
			}
			
		}
		
		add(primerciCombo);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SviIznajmljeniPrimerciForma.this.dispose();
				SviIznajmljeniPrimerciForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String primerak = primerciCombo.getSelectedItem().toString();
				
				String primerakId = String.valueOf(primerak.charAt(0));
				
				PrimerakKnjige p = biblioteka.pronadjiPrimerak(Integer.parseInt(primerakId));
				p.setIznajmljena(true);
				
				biblioteka.snimiPrimerkeKnjiga(BibliotekaMain.PRIMERCIKNJIGA_FAJL);
				
				SviIznajmljeniPrimerciForma.this.dispose();
				SviIznajmljeniPrimerciForma.this.setVisible(false);
					
			}
		});
		
	}
}
