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
import entiteti.TipClanarine;
import entiteti.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;
import osobe.Pol;

public class ZanroviForma extends JFrame {
	
	private JLabel lbOznaka = new JLabel ("Oznaka");
	private JTextField txtOznaka = new JTextField(25);
	private JLabel lbOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> boxObrisan = new JComboBox<Boolean>();
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private ZanrKnjige zanr;
	private Biblioteka biblioteka;
	

	public ZanroviForma(Biblioteka biblioteka, ZanrKnjige zanr) {
		
		this.biblioteka = biblioteka;
		this.zanr = zanr;
		if(zanr == null) {
			setTitle("Dodavanje žanra knjige :");
		}else {
			setTitle("Izmena podataka žanra [" + zanr.getOznaka() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(350, 350);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		boxObrisan.addItem(true);
		boxObrisan.addItem(false);
		

		if(zanr != null) {
			txtOznaka.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbOznaka);
		add(txtOznaka);
		add(lbOpis);
		add(txtOpis);
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
				ZanroviForma.this.dispose();
				ZanroviForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String oznaka = txtOznaka.getText().trim();	
					String opis = txtOpis.getText().trim();
					Boolean obrisan = (Boolean) boxObrisan.getSelectedItem();
					
					if(zanr == null) {
						ZanrKnjige novi = new ZanrKnjige (oznaka, opis, obrisan);
						biblioteka.dodajZanr(novi);
					}else {
						zanr.setOznaka(oznaka);
						zanr.setOpis(opis);
						zanr.setObrisan(obrisan);
						
					}
					biblioteka.snimiZanrove(BibliotekaMain.ZANROVI_FAJL);
					ZanroviForma.this.dispose();
					ZanroviForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtOznaka.setText(String.valueOf(zanr.getOznaka()));
		txtOpis.setText(zanr.getOpis());
		boxObrisan.setSelectedItem(zanr.isObrisan());
		
		
	}
	
	
	private boolean validacija() {
		
		return true;
	}
}


