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
import entiteti.PrimerakKnjige;

public class IznajmljivanjeProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjeTabela;

	public IznajmljivanjeProzor(Biblioteka biblioteka) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(IznajmljivanjeProzor.class.getResource("/slike/transfer.png")));
		this.biblioteka = biblioteka;
		setTitle("Iznajmljivanje");
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
		
		
		String[] zaglavlja = new String[] {"Datum iznajmljivanja", "Datum vracanja", "Zaposleni", "Član", "Primerak knjige", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.svaNeobrisanaIznajmljivanja().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.svaNeobrisanaIznajmljivanja().size(); i++) {
			Iznajmljivanje iznajmljivanje = biblioteka.svaNeobrisanaIznajmljivanja().get(i);
			sadrzaj[i][0] = iznajmljivanje.getDatumIznajmljivanja();
			sadrzaj[i][1] = iznajmljivanje.getDatumVracanja();
			sadrzaj[i][2] = iznajmljivanje.getZaposleni();
			sadrzaj[i][3] = iznajmljivanje.getClan();
			sadrzaj[i][4] = iznajmljivanje.getPrimerakKnjige();
			sadrzaj[i][5] = iznajmljivanje.isObrisan();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		iznajmljivanjeTabela = new JTable(tableModel);
		
		iznajmljivanjeTabela.setRowSelectionAllowed(true);
		iznajmljivanjeTabela.setColumnSelectionAllowed(false);
		iznajmljivanjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iznajmljivanjeTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjeTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
