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
import entiteti.TipClanarine;
import entiteti.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;

public class TipoviForma extends JFrame {
	
	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbNaziv = new JLabel("Naziv");
	private JTextField txtNaziv = new JTextField(25);
	private JLabel lbCena = new JLabel("Cena");
	private JTextField txtCena = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> txtObrisan = new JComboBox<Boolean>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private TipClanarine tip;
	private Biblioteka biblioteka;
	

	public TipoviForma(Biblioteka biblioteka, TipClanarine tip) {
		
		this.biblioteka = biblioteka;
		this.tip = tip;
		if(tip == null) {
			setTitle("Dodavanje tipa Ä�lanarine :");
		}else {
			setTitle("Izmena podataka tipa Ä�lanarine [" + tip.getId() + "]");
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
		
		
		
		if(tip != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbId);
		add(txtId);
		add(lbNaziv);
		add(txtNaziv);
		add(lbCena);
		add(txtCena);
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
				TipoviForma.this.dispose();
				TipoviForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());	
					String naziv = txtNaziv.getText().trim();
					double cena = Double.parseDouble(txtCena.getText().trim());
					Boolean obrisan = (Boolean) txtObrisan.getSelectedItem();
					
					if(tip == null) {
						TipClanarine novi = new TipClanarine (id, naziv, cena, obrisan);
						biblioteka.dodajTipClanarine(novi);
					}else {
						tip.setNaziv(naziv);
						tip.setCena(cena);
						tip.setObrisan(obrisan);
					}
					biblioteka.snimiTipClanarine(main.BibliotekaMain.TIPOVICLANARINE_FAJL);
					TipoviForma.this.dispose();
					TipoviForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtId.setText(String.valueOf(tip.getId()));
		txtNaziv.setText(tip.getNaziv());
		txtCena.setText(String.valueOf(tip.getCena()));
		txtObrisan.setSelectedItem(tip.isObrisan());
	
		
	}
	
	
	private boolean validacija() {
		
		return true;
	
	}
}