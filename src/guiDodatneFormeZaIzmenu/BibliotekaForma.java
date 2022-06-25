package guiDodatneFormeZaIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import entiteti.TipClanarine;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;
import osobe.Pol;


public class BibliotekaForma extends JFrame {

	private JLabel lbNaziv = new JLabel ("Naziv");	
	private JTextField txtNaziv = new JTextField(25);
	private JLabel lbAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(25);
	private JLabel lbBroj = new JLabel ("Broj telefona");
	private JTextField txtBroj = new JTextField(25);
	private JLabel lbRadnoVreme = new JLabel ("Radno vreme");
	private JTextField txtRadnoVreme = new JTextField(25);
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	

	Biblioteka biblioteka;
	
	
	public BibliotekaForma(Biblioteka biblioteka) {
		
		this.biblioteka = biblioteka;
		setTitle("Izmena podataka biblioteke :");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 210);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[]15[]", "[]10[]10[]10[]10[]30[]");
		setLayout(layout);
		
		
		add(lbNaziv);
		add(txtNaziv);
		add(lbAdresa);
		add(txtAdresa);
		add(lbBroj);
		add(txtBroj);
		add(lbRadnoVreme);
		add(txtRadnoVreme);
		
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
		
		popuniPolja();
		
	}
	
	private void popuniPolja() {
		
		txtNaziv.setText(String.valueOf(biblioteka.getNaziv()));
		txtAdresa.setText(biblioteka.getAdresa());
		txtBroj.setText(biblioteka.getBrojTelefona());
		txtRadnoVreme.setText(biblioteka.getRadnoVreme());
		
	}
	
	
	
	private void initAction() {
		
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekaForma.this.dispose();
				BibliotekaForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Biblioteka b = biblioteka.ucitajBiblioteku(BibliotekaMain.BIBLIOTEKA_FAJL);
				
					if(!txtNaziv.getText().trim().equals("")) {
						String naziv = txtNaziv.getText().trim();
						b.setNaziv(naziv);
					}
					if(!txtAdresa.getText().trim().equals("")) {
						String adresa = txtAdresa.getText().trim();
						b.setAdresa(adresa);
					}
					if(!txtBroj.getText().trim().equals("")) {
						String broj = txtBroj.getText().trim();
						b.setBrojTelefona(broj);
					}
					if(!txtRadnoVreme.getText().trim().equals("")) {
						String radnovr = txtRadnoVreme.getText().trim();
						b.setRadnoVreme(radnovr);
					}
					
				
					
					b.snimiBiblioteku(BibliotekaMain.BIBLIOTEKA_FAJL);
					BibliotekaForma.this.dispose();
					BibliotekaForma.this.setVisible(false);
				
					
				}
			});
	
	}
}
