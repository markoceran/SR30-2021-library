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
import entiteti.PrimerakKnjige;
import guiDodatneFormeZaIzmenu.KnjigeForma;
import guiDodatneFormeZaIzmenu.PrimerciForma;
import main.BibliotekaMain;

public class PrimerciKnjigaProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private JButton btnAdd = new JButton("  ");
	private JButton btnEdit = new JButton("  ");
	private JButton btnRemove = new JButton("  ");
	
	public PrimerciKnjigaProzor(Biblioteka biblioteka) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrimerciKnjigaProzor.class.getResource("/slike/rsz.png")));
		this.biblioteka = biblioteka;
		setTitle("Primerci knjiga");
		setSize(1150, 400);
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
		
		
		String[] zaglavlja = new String[] {"ID", "Broj strana", "Tvrd povez", "Godina štampanja", "Iznajmljena", "Knjiga kojoj pripada", "Jezik Štampanja", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimerci().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniPrimerci().size(); i++) {
			PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerci().get(i);
			sadrzaj[i][0] = primerak.getId();
			sadrzaj[i][1] = primerak.getBrojStrana();
			sadrzaj[i][2] = primerak.isTvrdPovez();
			sadrzaj[i][3] = primerak.getGodinaStampanja();
			sadrzaj[i][4] = primerak.isIznajmljena();
			sadrzaj[i][5] = primerak.getKnjigaKojojPrimerakPripada();
			sadrzaj[i][6] = primerak.getJezikStampanja();
			sadrzaj[i][7] = primerak.isObrisan();
			
	
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		initAction();
	}
	
	private void initAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerciForma pf = new PrimerciForma(biblioteka, null);
				pf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int primerakId = (int) tableModel.getValueAt(red, 0);
					PrimerakKnjige p = biblioteka.pronadjiPrimerak(primerakId);
					PrimerciForma pf = new PrimerciForma(biblioteka, p);
					pf.setVisible(true);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int primerciId = (int) tableModel.getValueAt(red, 0);
					PrimerakKnjige p = biblioteka.pronadjiPrimerak(primerciId);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete primerak knjige?", 
							primerciId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						p.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiPrimerkeKnjiga(BibliotekaMain.PRIMERCIKNJIGA_FAJL);
					}
				}
			}
		});
		
	}
}
