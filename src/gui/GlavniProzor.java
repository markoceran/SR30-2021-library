package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import osobe.ClanBiblioteke;
import osobe.Uloga;
import osobe.Zaposleni;
import biblioteka.Biblioteka;
import guiDodatneFormeZaIzmenu.BibliotekaForma;
import guiFormeZaPrikaz.ClanoviProzor;
import guiFormeZaPrikaz.IznajmljivanjeProzor;
import guiFormeZaPrikaz.KnjigeProzor;
import guiFormeZaPrikaz.ObracunavanjeProzor;
import guiFormeZaPrikaz.PrimerciKnjigaProzor;
import guiFormeZaPrikaz.TipoviClanarineProzor;
import guiFormeZaPrikaz.ZanroviProzor;
import guiFormeZaPrikaz.ZaposleniProzor;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Font;


public final class GlavniProzor extends JFrame {
	
	Image icon = Toolkit.getDefaultToolkit().getImage("src/slike/download.png");
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu vise = new JMenu("Više");
	private JMenuItem zanrovi = new JMenuItem("Žanrovi knjiga");
	private JMenuItem tipoviClanarine = new JMenuItem("Tipovi članarine");
	private JMenu bibliotekaMenu = new JMenu("Biblioteka");
	private JMenuItem izmeni = new JMenuItem("Izmeni");
	
	
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	private final JButton btnNewButton = new JButton("Zaposleni");
	private final JButton btnNewButton_1 = new JButton("Primerci knjiga");
	private final JButton btnNewButton_2 = new JButton("Članovi biblioteke");
	private final JButton btnNewButton_3 = new JButton("Knjige");
	private final JButton btnNewButton_4 = new JButton("Iznajmljivanje");
	private final JButton btnObracun = new JButton("Obračunavanje");
	private final JLabel lblNewLabel = new JLabel();
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik) {
		
		getContentPane().setBackground(new Color(211, 211, 211));
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle(prijavljeniKorisnik.getUloga() + " : " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(900, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/slike/download.png")));
		setResizable(false);
		
		gui();
		initAction();
		
		/********************************/
		
		proveriAktivnostClanova();
		
		/********************************/
		
	}
	
	
	private void gui() {
		
		setJMenuBar(mainMenu);
		mainMenu.add(vise);
		mainMenu.add(bibliotekaMenu);
		zanrovi.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/rsz_2option-3.png")));
		vise.add(zanrovi);
		tipoviClanarine.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/rsz_2option-3.png")));
		vise.add(tipoviClanarine);
		izmeni.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/edit2.png")));
		bibliotekaMenu.add(izmeni);
		
		
		MigLayout mig = new MigLayout("wrap 1", "[250px:n,grow][360px:n,grow][250px:n]", "[200px:n,grow][50px:n][80px:n][80px:n][]");
		getContentPane().setLayout(mig);
		
		if(prijavljeniKorisnik.getUloga().equals(Uloga.values()[0])) {
			btnNewButton.setEnabled(false);
		}
		
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/slike/library.jpg")));
		
		getContentPane().add(lblNewLabel, "cell 0 0 3 1,alignx center");
		btnNewButton.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(240, 248, 255));
		
		getContentPane().add(btnNewButton, "cell 0 2,grow");
		btnNewButton_4.setFont(new Font("Gill Sans MT", Font.PLAIN, 21));
		btnNewButton_4.setBackground(new Color(240, 248, 255));
		
		
		btnNewButton_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		btnNewButton_2.setBackground(new Color(240, 248, 255));
		
		getContentPane().add(btnNewButton_2, "cell 2 2,grow");
		btnNewButton_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		btnNewButton_1.setBackground(new Color(240, 248, 255));
		
		getContentPane().add(btnNewButton_1, "cell 0 3,grow");
		btnNewButton_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		btnNewButton_3.setBackground(new Color(240, 248, 255));
		
		getContentPane().add(btnNewButton_3, "cell 2 3,grow");
		
		getContentPane().add(btnNewButton_4, "cell 1 2 1 2,grow");
		
		getContentPane().add(btnObracun, "cell 1 2 1 2,grow");
		btnObracun.setFont(new Font("Gill Sans MT", Font.PLAIN, 21));
		btnObracun.setBackground(new Color(240, 248, 255));
		
	}
		
	
	
	private void initAction() {
			
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClanoviProzor c = new ClanoviProzor(biblioteka);
				c.setVisible(true);
			}
		});
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor k = new KnjigeProzor(biblioteka);
				k.setVisible(true);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimerciKnjigaProzor p = new PrimerciKnjigaProzor(biblioteka);
				p.setVisible(true);
			}
		});
		
		zanrovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZanroviProzor z = new ZanroviProzor(biblioteka);
				z.setVisible(true);
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeProzor i = new IznajmljivanjeProzor(biblioteka);
				i.setVisible(true);
			}
		});
		
		tipoviClanarine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoviClanarineProzor t = new TipoviClanarineProzor(biblioteka);
				t.setVisible(true);
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ZaposleniProzor z = new ZaposleniProzor(biblioteka);
				z.setVisible(true);
			}
		});
		
		izmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BibliotekaForma b = new BibliotekaForma(biblioteka);
				b.setVisible(true);
			}
		});
		
		btnObracun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ObracunavanjeProzor o = new ObracunavanjeProzor(biblioteka);
				o.setVisible(true);
			}
		});	
		
	}
	
	
	private void proveriAktivnostClanova(){
		
		for(ClanBiblioteke c : biblioteka.sviNeobrisaniClanovi()) {
			
			int brojMeseci = c.getBrojMeseciClanarine();
			
			
			LocalDate datumPoslednjeUplate = c.getDatumPoslednjeUplate();
			int datumPoslednjeUplateDan = datumPoslednjeUplate.getDayOfMonth();
			Month getDatumPoslednjeUplateMesec = datumPoslednjeUplate.getMonth();
			
			int datumPoslednjeUplateMesec = 0;
		
			LocalDate danasnjiDatum = LocalDate.now();
		    int danasnjiDan = danasnjiDatum.getDayOfMonth();
		    Month getDanasnjiMesec = danasnjiDatum.getMonth();
		    
		    int danasnjiMesec = 0;
		    
		    
		    switch(getDatumPoslednjeUplateMesec.toString()) {
		    
		    case "JANUARY": 
		    	
		    	datumPoslednjeUplateMesec = 1;
		    	break;
		    
		    case "FEBRUARY": 
		    	
		    	datumPoslednjeUplateMesec = 2;
		    	break;
		    	
		    case "MARCH": 
			    	
			    datumPoslednjeUplateMesec = 3;
			    break;
			    
		    case "APRIL": 
		    	
			    datumPoslednjeUplateMesec = 4;
			    break;
			    
		    case "MAY": 
		    	
			    datumPoslednjeUplateMesec = 5;
			    break;
			    
		    case "JUNE": 
		    	
			    datumPoslednjeUplateMesec = 6;
			    break;
			    
		    case "JULY": 
		    	
			    datumPoslednjeUplateMesec = 7;
			    break;
			    
		    case "AUGUST": 
		    	
			    datumPoslednjeUplateMesec = 8;
			    break;
		    
		    case "SEPTEMBER": 
		    	
			    datumPoslednjeUplateMesec = 9;
			    break;
			    
		    case "OCTOBER": 
		    	
			    datumPoslednjeUplateMesec = 10;
			    break;
			    
		    case "NOVEMBER": 
		    	
			    datumPoslednjeUplateMesec = 11;
			    break;
			    
		    case "DECEMBER": 
		    	
			    datumPoslednjeUplateMesec = 12;
			    break;
		    }
		    
		    //System.out.println(datumPoslednjeUplateMesec);
		    
		    
		    switch(getDanasnjiMesec.toString()) {
		    
		    case "JANUARY": 
		    	
		    	danasnjiMesec = 1;
		    	break;
		    
		    case "FEBRUARY": 
		    	
		    	danasnjiMesec = 2;
		    	break;
		    	
		    case "MARCH": 
			    	
		    	danasnjiMesec = 3;
			    break;
			    
		    case "APRIL": 
		    	
		    	danasnjiMesec = 4;
			    break;
			    
		    case "MAY": 
		    	
		    	danasnjiMesec = 5;
			    break;
			    
		    case "JUNE": 
		    	
		    	danasnjiMesec = 6;
			    break;
			    
		    case "JULY": 
		    	
		    	danasnjiMesec = 7;
			    break;
			    
		    case "AUGUST": 
		    	
		    	danasnjiMesec = 8;
			    break;
		    
		    case "SEPTEMBER": 
		    	
		    	danasnjiMesec = 9;
			    break;
			    
		    case "OCTOBER": 
		    	
		    	danasnjiMesec = 10;
			    break;
			    
		    case "NOVEMBER": 
		    	
		    	danasnjiMesec = 11;
			    break;
			    
		    case "DECEMBER": 
		    	
		    	danasnjiMesec = 12;
			    break;
		    }
		    
		    //System.out.println(danasnjiMesec);
		    
		    
		    if((datumPoslednjeUplateDan == danasnjiDan) && (Math.abs(datumPoslednjeUplateMesec - danasnjiMesec) == brojMeseci)) {
		    	
		    	c.setAktivan(false);
		    	c.setBrojMeseciClanarine(0);
		    	biblioteka.snimiClanove(BibliotekaMain.CLANOVI_FAJL);
		    	
		    }
		    
		    
		    
		}
		
	}
	
}

