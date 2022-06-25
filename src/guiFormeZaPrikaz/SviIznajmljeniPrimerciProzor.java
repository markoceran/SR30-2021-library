package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import entiteti.PrimerakKnjige;
import guiDodatneFormeZaIzmenu.PrimerciForma;
import guiDodatneFormeZaIzmenu.SviIznajmljeniPrimerciForma;
import main.BibliotekaMain;
import osobe.ClanBiblioteke;

public class SviIznajmljeniPrimerciProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private JButton btnAdd = new JButton("  ");
	private JButton btnRemove = new JButton("  ");
	
	protected ArrayList<PrimerakKnjige> sviIznajmljeni = new ArrayList<PrimerakKnjige>();
	
	
	public SviIznajmljeniPrimerciProzor(Biblioteka biblioteka) {
		
	
		this.biblioteka = biblioteka;
		setTitle("Svi iznajmljeni primerci");
		setSize(1300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		
		btnAdd.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/add.png")));
		toolBar.add(btnAdd);
		
		
		btnRemove.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/remove.png")));
		toolBar.add(btnRemove);
		
		
		/*************************************************************************************/
		
		//Lista iznajmljenih primeraka
		for(PrimerakKnjige j : biblioteka.sviNeobrisaniPrimerci()) {
			if(j.isIznajmljena()==true && j.isObrisan()==false) {
				
				sviIznajmljeni.add(j);
				
			}
		}
		
		/*************************************************************************************/
		
		
		String[] zaglavlja = new String[] {"ID", "Broj strana", "Tvrd povez", "Godina štampanja", "Iznajmljena", "Knjiga kojoj pripada", "Jezik Štampanja", "Obrisan"};
		Object[][] sadrzaj = new Object[sviIznajmljeni.size()][zaglavlja.length];
		
		
		for(int i=0; i<sviIznajmljeni.size(); i++) {
			
				PrimerakKnjige primerak = sviIznajmljeni.get(i);
			
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
			
			/*************************************************************************************/
			
			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SviIznajmljeniPrimerciForma sp = new SviIznajmljeniPrimerciForma(biblioteka, null);
					sp.setVisible(true);
					
				}
			});
			
			/*************************************************************************************/
			
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
								"Da li ste sigurni da zelite da obrisete iznajmljeni primerak?", 
								primerciId + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
						
						if(select == JOptionPane.YES_OPTION) {
							
							p.setIznajmljena(false);
							tableModel.removeRow(red);
							biblioteka.snimiPrimerkeKnjiga(BibliotekaMain.PRIMERCIKNJIGA_FAJL);
							
						}
					}
				}
			});
			
			/*************************************************************************************/
			
	}
}
