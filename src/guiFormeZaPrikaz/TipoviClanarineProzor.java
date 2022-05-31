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
import entiteti.Iznajmljivanje;
import entiteti.TipClanarine;

public class TipoviClanarineProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable tipoviTabela;

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
		
		JButton btnNewButton = new JButton("  ");
		btnNewButton.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/add.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  ");
		btnNewButton_1.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/edit.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("  ");
		btnNewButton_2.setIcon(new ImageIcon(ClanoviProzor.class.getResource("/slike/remove.png")));
		toolBar.add(btnNewButton_2);
		
		
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
	}
}
