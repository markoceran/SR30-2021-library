package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import entiteti.TipClanarine;
import guiDodatneFormeZaIzmenu.BibliotekaForma;
import guiDodatneFormeZaIzmenu.ClanoviForma;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;

public class ObracunavanjeProzor extends JFrame {
	
	
	private JLabel lbClan = new JLabel ("Član biblioteke :");
	private JComboBox<String> boxClan = new JComboBox<String>();
	private JLabel lbMeseci = new JLabel ("Broj meseci uplate :");
	private JComboBox<String> boxMeseci = new JComboBox<String>();
	
	
	private JButton btnOK = new JButton("Obračunaj");
	private JButton btnCancel = new JButton("Otkaži");

	
	private Biblioteka biblioteka;
	

	

	public ObracunavanjeProzor(Biblioteka biblioteka) {
		
		this.biblioteka = biblioteka;

		setTitle("Obračun člana :");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}



	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[]25[]", "[]15[]10[]");
		getContentPane().setLayout(layout);
		
		
		for(ClanBiblioteke clan : biblioteka.sviNeobrisaniClanovi()) {
			
			boxClan.addItem(clan.getId() + " - " + clan.getIme() + " " + clan.getPrezime());
			
		}
		
		for(int i=1; i<=12; i++) {
			
			boxMeseci.addItem(String.valueOf(i));
			
		}
		
		getContentPane().add(lbClan, "cell 0 0");
		getContentPane().add(boxClan, "cell 1 0");
		getContentPane().add(lbMeseci, "cell 0 1");
		getContentPane().add(boxMeseci,"cell 1 1");
		getContentPane().add(new JLabel(), "cell 0 2");
		getContentPane().add(new JLabel(), "cell 1 2");
		getContentPane().add(new JLabel(), "cell 0 3");
		getContentPane().add(btnOK, "flowx,cell 1 4");
		getContentPane().add(btnCancel, "cell 1 4");
		
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ObracunavanjeProzor.this.dispose();
				ObracunavanjeProzor.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String n = boxClan.getSelectedItem().toString();
				int ClanId = Integer.parseInt(String.valueOf(n.charAt(0)));
				
				String brojMeseci = boxMeseci.getSelectedItem().toString();
				
				ClanBiblioteke clan = biblioteka.pronadjiClana(ClanId);
				
				clan.setBrojMeseciClanarine(Integer.parseInt(brojMeseci));
				clan.setAktivan(true);
				clan.setDatumPoslednjeUplate(LocalDate.now());
				biblioteka.snimiClanove(BibliotekaMain.CLANOVI_FAJL);
				
				int uplaceniBrojMeseci = clan.getBrojMeseciClanarine();
				
				double cena = clan.getTipClanarine().getCena();
				
				String poruka;
				
				if(uplaceniBrojMeseci == 6) {
					
					cena = (cena * 90) / 100;
					poruka = "Ostvarili ste popust od 10%";
					
				}else {
					
					if(uplaceniBrojMeseci == 12) {
						
						cena = (cena * 80) / 100;
						poruka = "Ostvarili ste popust od 20%";
						
					}else {
						
						poruka = "Niste ostvarili popust";
						
					}
				}
				
				JOptionPane.showMessageDialog(null, "Vas racun iznosi:  " + cena + " din " + " (" + poruka + ")", "Racun :", JOptionPane.INFORMATION_MESSAGE);
				ObracunavanjeProzor.this.dispose();
				ObracunavanjeProzor.this.setVisible(false);	
				
				}
			});
		
	}
	
	
}
