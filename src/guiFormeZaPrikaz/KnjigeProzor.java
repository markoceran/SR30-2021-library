package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import entiteti.Knjiga;
import osobe.ClanBiblioteke;

public class KnjigeProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable knjigeTabela;

	public KnjigeProzor(Biblioteka biblioteka) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(KnjigeProzor.class.getResource("/slike/book.jpg")));
		this.biblioteka = biblioteka;
		setTitle("Knjige");
		setSize(1300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("  ");
		btnNewButton.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/add.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  ");
		btnNewButton_1.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/edit.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("  ");
		btnNewButton_2.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/remove.png")));
		toolBar.add(btnNewButton_2);
		
		
		String[] zaglavlja = new String[] {"ID", "Naslov", "Originalni naslov", "Pisac", "Godina objavljivanja", "Opis knjige", "Žanr", "Jezik originala", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
		
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
		
}
