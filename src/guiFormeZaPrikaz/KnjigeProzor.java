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
import entiteti.Knjiga;
import guiDodatneFormeZaIzmenu.KnjigeForma;
import main.BibliotekaMain;
import osobe.ClanBiblioteke;

public class KnjigeProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable knjigeTabela;
	
	private JButton btnAdd = new JButton("  ");
	private JButton btnEdit = new JButton("  ");
	private JButton btnRemove = new JButton("  ");
	private JToolBar toolBar = new JToolBar();
	
	public KnjigeProzor(Biblioteka biblioteka) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(KnjigeProzor.class.getResource("/slike/book.jpg")));
		this.biblioteka = biblioteka;
		setTitle("Knjige");
		setSize(1300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		gui();
		initAction();
	}

	


	private void gui() {
		
		
		toolBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnAdd.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/add.png")));
		toolBar.add(btnAdd);
		
		
		btnEdit.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/edit.png")));
		toolBar.add(btnEdit);
		
		
		btnRemove.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/remove.png")));
		toolBar.add(btnRemove);
		
		
		String[] zaglavlja = new String[] {"ID", "Naslov", "Originalni naslov", "Pisac", "Godina objavljivanja", "Opis knjige", "Žanr", "Jezik originala", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sveNeobrisaneKnjige().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sveNeobrisaneKnjige().size(); i++) {
			Knjiga knjiga = biblioteka.sveNeobrisaneKnjige().get(i);
			sadrzaj[i][0] = knjiga.getId();
			sadrzaj[i][1] = knjiga.getNaslov();
			sadrzaj[i][2] = knjiga.getOriginalniNaslov();
			sadrzaj[i][3] = knjiga.getPisac();
			sadrzaj[i][4] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i][5] = knjiga.getOpisKnjige();
			sadrzaj[i][6] = knjiga.getZanr();
			sadrzaj[i][7] = knjiga.getJezikOriginala();
			sadrzaj[i][8] = knjiga.isObrisan();
	
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		knjigeTabela = new JTable(tableModel);
		
		knjigeTabela.setRowSelectionAllowed(true);
		knjigeTabela.setColumnSelectionAllowed(false);
		knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigeTabela.setDefaultEditor(Object.class, null);
		knjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjigeTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
		
	
	private void initAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeForma kf = new KnjigeForma(biblioteka, null);
				kf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjigeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					String knjigaId = tableModel.getValueAt(red, 0).toString();
					Knjiga k = biblioteka.pronadjiKnjigu(Integer.parseInt(knjigaId));
					KnjigeForma kf = new KnjigeForma(biblioteka, k);
						kf.setVisible(true);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjigeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int knjigaID = (int) tableModel.getValueAt(red, 0);
					Knjiga k = biblioteka.pronadjiKnjigu(knjigaID);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete knjigu?", 
							knjigaID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						k.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiKnjige(BibliotekaMain.KNJIGE_FAJL);
					}
				}
			}
		});
		
	}

}
