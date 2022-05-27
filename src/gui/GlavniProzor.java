package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import osobe.Zaposleni;
import biblioteka.Biblioteka;


public class GlavniProzor extends JFrame {
	
	Image icon = Toolkit.getDefaultToolkit().getImage("src/slike/download.png");

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu zanrovi = new JMenu("Zanrovi");
	private JMenu tipoviClanarine = new JMenu("Tipovi clanarine");
	
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik) {
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Zaposleni: " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(icon);
		initMenu();
		initActions();
	}
	
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(zanrovi);
		mainMenu.add(tipoviClanarine);
		
	}
	
	private void initActions() {
		zanrovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
}
