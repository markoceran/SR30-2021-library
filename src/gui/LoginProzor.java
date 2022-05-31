package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import biblioteka.Biblioteka;
import net.miginfocom.swing.MigLayout;
import osobe.Zaposleni;



public class LoginProzor extends JFrame {
	
	Image icon = Toolkit.getDefaultToolkit().getImage("src/slike/61457.png");    
	
	private JLabel lbPoruka = new JLabel("MOLIMO DA SE PRIJAVITE:");
	private JLabel lbKorisnickoIme = new JLabel("Korisničko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lbLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	
	
	public LoginProzor(Biblioteka biblioteka) {
		setResizable(false);
		getContentPane().setBackground(new Color(240, 248, 255));
		this.biblioteka = biblioteka;
		setTitle("PRIJAVA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(icon);
		initGUI();
		initActions();
		pack();
		
	}

	private void initGUI() {
		
		MigLayout mig = new MigLayout("wrap 1", "[]", "15[]20[]10[]10[]");
		getContentPane().setLayout(mig);
		
		getContentPane().add(lbPoruka);
		getContentPane().add(lbKorisnickoIme);
		getContentPane().add(txtKorisnickoIme);
		getContentPane().add(lbLozinka);
		getContentPane().add(pfLozinka);
		getContentPane().add(new JLabel());
		getContentPane().add(btnOk, "split 2");
		getContentPane().add(btnCancel);
		
	}

	private void initActions() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnikoIme = txtKorisnickoIme.getText().trim();
				String lozinka = new String(pfLozinka.getPassword()).trim();
				
				if(korisnikoIme.equals("") || lozinka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu!", "Greška", JOptionPane.WARNING_MESSAGE);
				}else {
					Zaposleni prijavljeni = biblioteka.login(korisnikoIme, lozinka);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogrešni login podaci!", "Greška", JOptionPane.WARNING_MESSAGE);
					}else {
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeni);
						gp.setVisible(true);
					}
				}
			}
		});
		
		
	}


	
}
