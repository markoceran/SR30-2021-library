package guiFormeZaPrikaz;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import biblioteka.Biblioteka;
import osobe.ClanBiblioteke;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Toolkit;

public class ClanoviProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable clanoviTabela;

	public ClanoviProzor(Biblioteka biblioteka) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClanoviProzor.class.getResource("/slike/reader.png")));
		this.biblioteka = biblioteka;
		setTitle("Članovi biblioteke");
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
		
		
		
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj članske karte", "Datum poslednje uplate", "Broj meseci članarine", "Aktivan", "Tip članarine", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniClanovi().size(); i++) {
			ClanBiblioteke clan = biblioteka.sviNeobrisaniClanovi().get(i);
			sadrzaj[i][0] = clan.getId();
			sadrzaj[i][1] = clan.getIme();
			sadrzaj[i][2] = clan.getPrezime();
			sadrzaj[i][3] = clan.getJMBG();
			sadrzaj[i][4] = clan.getAdresa();
			sadrzaj[i][5] = clan.getPol();
			sadrzaj[i][6] = clan.getBrojClanskeKarte();
			sadrzaj[i][7] = clan.getDatumPoslednjeUplate();
			sadrzaj[i][8] = clan.getBrojMeseciClanarine();
			sadrzaj[i][9] = clan.isAktivan();
			sadrzaj[i][10] = clan.getTipClanarine();
			sadrzaj[i][11] = clan.isObrisan();
			
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanoviTabela = new JTable(tableModel);
		
		clanoviTabela.setRowSelectionAllowed(true);
		clanoviTabela.setColumnSelectionAllowed(false);
		clanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanoviTabela.setDefaultEditor(Object.class, null);
		clanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanoviTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}


}