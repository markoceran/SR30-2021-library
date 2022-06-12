package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import guiDodatneFormeZaIzmenu.ClanoviForma;
import guiDodatneFormeZaIzmenu.ZaposleniForma;
import main.BibliotekaMain;
import osobe.ClanBiblioteke;
import osobe.Zaposleni;

public class ZaposleniProzor extends JFrame {

	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable zaposleniTabela;
	
	
	private JButton btnAdd = new JButton("  ");
	private JButton btnEdit = new JButton("  ");
	private JButton btnRemove = new JButton("  ");

	public ZaposleniProzor(Biblioteka biblioteka) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClanoviProzor.class.getResource("/slike/employee.png")));
		this.biblioteka = biblioteka;
		setTitle("Zaposleni");
		setSize(1300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		
		btnAdd.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/add.png")));
		toolBar.add(btnAdd);
		
		
		btnEdit.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/edit.png")));
		toolBar.add(btnEdit);
		
		
		btnRemove.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/remove.png")));
		toolBar.add(btnRemove);
		
		
		
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol",  "Korisničko ime", "Korisnička lozinka", "Plata", "Obrisan", "Uloga"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniZaposleni().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniZaposleni().size(); i++) {
			Zaposleni zaposleni = biblioteka.sviNeobrisaniZaposleni().get(i);
			sadrzaj[i][0] = zaposleni.getId();
			sadrzaj[i][1] = zaposleni.getIme();
			sadrzaj[i][2] = zaposleni.getPrezime();
			sadrzaj[i][3] = zaposleni.getJMBG();
			sadrzaj[i][4] = zaposleni.getAdresa();
			sadrzaj[i][5] = zaposleni.getPol();
			sadrzaj[i][6] = zaposleni.getKorisnickoIme();
			sadrzaj[i][7] = zaposleni.getKorisnickaLozinka();
			sadrzaj[i][8] = zaposleni.getPlata();
			sadrzaj[i][9] = zaposleni.isObrisan();
			sadrzaj[i][10] = zaposleni.getUloga();
			
			
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zaposleniTabela = new JTable(tableModel);
		
		zaposleniTabela.setRowSelectionAllowed(true);
		zaposleniTabela.setColumnSelectionAllowed(false);
		zaposleniTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zaposleniTabela.setDefaultEditor(Object.class, null);
		zaposleniTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zaposleniTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		initAction();
	}
	
	
	private void initAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZaposleniForma zf = new ZaposleniForma(biblioteka, null);
				zf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zaposleniTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int zaposleniId = (int) tableModel.getValueAt(red, 0);
					Zaposleni z = biblioteka.pronadjiZaposlenog(zaposleniId);
					ZaposleniForma zf = new ZaposleniForma(biblioteka, z);
						zf.setVisible(true);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zaposleniTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int zaposleniId = (int) tableModel.getValueAt(red, 0);
					Zaposleni z = biblioteka.pronadjiZaposlenog(zaposleniId);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete zaposlenog?", 
							zaposleniId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						z.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiZaposlene(BibliotekaMain.ZAPOSLENI_FAJL);
					}
				}
			}
		});
		
	}

}
