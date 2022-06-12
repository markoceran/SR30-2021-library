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
import entiteti.Iznajmljivanje;
import entiteti.Knjiga;
import entiteti.TipClanarine;
import guiDodatneFormeZaIzmenu.KnjigeForma;
import guiDodatneFormeZaIzmenu.TipoviForma;
import main.BibliotekaMain;

public class TipoviClanarineProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable tipoviTabela;
	
	private JButton btnAdd = new JButton("  ");
	private JButton btnEdit = new JButton("  ");
	private JButton btnRemove = new JButton("  ");
	
	public TipoviClanarineProzor(Biblioteka biblioteka) {
		
		
		this.biblioteka = biblioteka;
		setTitle("Tipovi članarine");
		setSize(1000, 400);
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
		
		
		String[] zaglavlja = new String[] {"ID", "Naziv", "Cena", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniTipovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniTipovi().size(); i++) {
			TipClanarine tip = biblioteka.sviNeobrisaniTipovi().get(i);
			sadrzaj[i][0] = tip.getId();
			sadrzaj[i][1] = tip.getNaziv();
			sadrzaj[i][2] = tip.getCena();
			sadrzaj[i][3] = tip.isObrisan();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		tipoviTabela = new JTable(tableModel);
		
		tipoviTabela.setRowSelectionAllowed(true);
		tipoviTabela.setColumnSelectionAllowed(false);
		tipoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tipoviTabela.setDefaultEditor(Object.class, null);
		tipoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tipoviTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		initAction();
	}

	private void initAction() {
		
	
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TipoviForma tf = new TipoviForma(biblioteka, null);
				tf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tipoviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int tipId = (int) tableModel.getValueAt(red, 0);
					TipClanarine t = biblioteka.pronadjiTipClanarine(tipId);
					TipoviForma tf = new TipoviForma(biblioteka, t);
						tf.setVisible(true);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tipoviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int tipId = (int) tableModel.getValueAt(red, 0);
					TipClanarine t = biblioteka.pronadjiTipClanarine(tipId);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete tip clanarine?", 
							tipId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						t.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiTipClanarine(BibliotekaMain.TIPOVICLANARINE_FAJL);
					}
				}
			}
		});
		
	}
}	
	