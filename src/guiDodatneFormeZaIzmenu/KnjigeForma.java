package guiDodatneFormeZaIzmenu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import biblioteka.Biblioteka;
import entiteti.Knjiga;
import gui.LoginProzor;
import net.miginfocom.swing.MigLayout;


public class KnjigeForma extends JFrame {

	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbNaslov = new JLabel("Naslov");
	private JTextField txtNaslov = new JTextField(25);
	private JLabel lbOriginalniNaslov = new JLabel("Originalni naslov");
	private JTextField txtOriginalniNaslov = new JTextField(25);
	private JLabel lbPisac = new JLabel("Pisac");
	private JTextField txtPisac = new JTextField(25);
	private JLabel lbGodinaObjavljivanja = new JLabel("Godina objavljivanja");
	private JTextField txtGodinaObjavljivanja = new JTextField(25);
	private JLabel lbOpisKnjige = new JLabel("Opis knjige");
	private JTextArea txtOpisKnjige = new JTextArea();
	private JLabel lbZanr = new JLabel("Zanr");
	private JTextField txtZanr = new JTextField(25);
	private JLabel lbJezik = new JLabel("Jezik originala");
	private JTextField txtJezik = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JTextField txtObrisan = new JTextField(25);
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private Knjiga knjiga;
	private Biblioteka biblioteka;
	
	public KnjigeForma(Biblioteka biblioteka, Knjiga knjiga) {
		
		this.biblioteka = biblioteka;
		this.knjiga = knjiga;
		if(knjiga == null) {
			setTitle("Dodavanje knjige :");
		}else {
			setTitle("Izmena podataka knjige [" + knjiga.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,420);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(knjiga != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		txtOpisKnjige.setPreferredSize(new Dimension(200,400));
		
		add(lbId);
		add(txtId);
		add(lbNaslov);
		add(txtNaslov);
		add(lbOriginalniNaslov);
		add(txtOriginalniNaslov);
		add(lbPisac);
		add(txtPisac);
		add(lbGodinaObjavljivanja);
		add(txtGodinaObjavljivanja);
		add(lbZanr);
		add(txtZanr);
		add(lbJezik);
		add(txtJezik);
		add(lbObrisan);
		add(txtObrisan);
		add(lbOpisKnjige);
		add(txtOpisKnjige);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeForma.this.dispose();
				KnjigeForma.this.setVisible(false);
			}
		});
		
	}
	
	
	
	private void popuniPolja() {
		
		txtId.setText(String.valueOf(knjiga.getId()));
		txtNaslov.setText(knjiga.getNaslov());
		txtOriginalniNaslov.setText(knjiga.getOriginalniNaslov());
		txtPisac.setText(knjiga.getPisac());
		txtGodinaObjavljivanja.setText(String.valueOf(knjiga.getGodinaObjavljivanja()));
		txtOpisKnjige.setText(knjiga.getOpisKnjige());
		txtZanr.setText(String.valueOf(knjiga.getZanr()));
		txtObrisan.setText(String.valueOf(knjiga.isObrisan()));
		txtJezik.setText(knjiga.getJezikOriginala());
		
	}
	
}
