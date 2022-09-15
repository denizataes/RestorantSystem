import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JLabel lblYemekler = new JLabel("YEMEKLER");
	private final JLabel lblCalsanlar = new JLabel("CALISANLAR");
	private final JLabel lblIstenCkar = new JLabel("PERSONEL \u00C7IKART");
	private final JLabel lblIseAl = new JLabel("PERSONEL AL");
	private final JLabel lblYnetimBilgilendirmeSistemi = new JLabel("YONETIM BILGILENDIRME SISTEMI");
	private final JLabel lblCks = new JLabel("CIKIS");
	private final JLabel profil = new JLabel("");
	private static String username="a";
	private static String password="b";
	private String cinsiyet="Kadýn";
	private final JLabel calisanlarx = new JLabel("");
	private final JLabel yemeklerx = new JLabel("");
	private final JLabel istencikarx = new JLabel("");
	private final JLabel isealx = new JLabel("");
	private final JLabel cikisx = new JLabel("");
	private final JLabel lblNewLabel_2_2_1 = new JLabel("copyright \u00A9 DAE");
	private final JLabel profilx = new JLabel("");
	private final JLabel lblNewLabel_1_1 = new JLabel("Kapat");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(username,password);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setUndecorated(true);
	
		System.out.println("Giriþ yapan kiþi"+username+password);
		setTitle("Y\u00F6netim Bilgilendirme Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(0, 94, 210, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		lblYemekler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Yemekler y = new Yemekler();
				y.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				yemeklerx.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				yemeklerx.setVisible(false);
			}
			
		});
		lblYemekler.setIcon(new ImageIcon(Menu.class.getResource("/burger.png")));
		lblYemekler.setForeground(new Color(128, 128, 0));
		lblYemekler.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblYemekler.setBounds(10, 159, 140, 47);
		
		panel.add(lblYemekler);
		lblCalsanlar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				calisanGoster c = new calisanGoster();
					c.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				calisanlarx.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				calisanlarx.setVisible(false);
			}
			
		});
		lblCalsanlar.setIcon(new ImageIcon(Menu.class.getResource("/garsona.png")));
		lblCalsanlar.setForeground(new Color(128, 128, 0));
		lblCalsanlar.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblCalsanlar.setBounds(10, 40, 162, 52);
		
		panel.add(lblCalsanlar);
		lblIstenCkar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				istenCikarma i = new istenCikarma();
				i.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				istencikarx.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				istencikarx.setVisible(false);
			}
		});
		lblIstenCkar.setIcon(new ImageIcon(Menu.class.getResource("/fired.png")));
		lblIstenCkar.setForeground(new Color(128, 128, 0));
		lblIstenCkar.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblIstenCkar.setBounds(10, 268, 190, 47);
		
		panel.add(lblIstenCkar);
		lblIseAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				KayýtOlma k = new KayýtOlma();
				k.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				isealx.setVisible(true);
				
			}
			public void mouseExited(MouseEvent e) {
				isealx.setVisible(false);
				
			}
		});
		lblIseAl.setIcon(new ImageIcon(Menu.class.getResource("/deal.png")));
		lblIseAl.setForeground(new Color(128, 128, 0));
		lblIseAl.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblIseAl.setBounds(10, 382, 190, 37);
		
		panel.add(lblIseAl);
		lblCks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, username+" hesabýnýzdan çýkmak istediðinize emin misiniz?","Seçim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        // 0=yes, 1=no, 2=cancel
				if(input == 0) {
					Baslangic b = new Baslangic();
					b.setVisible(true);
					dispose();
				}
				
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cikisx.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				cikisx.setVisible(false);
			}
		});
		lblCks.setIcon(new ImageIcon(Menu.class.getResource("/exit.png")));
		lblCks.setForeground(new Color(128, 128, 0));
		lblCks.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblCks.setBounds(10, 486, 103, 47);
		
		panel.add(lblCks);
		calisanlarx.setForeground(Color.ORANGE);
		calisanlarx.setVisible(false);
		calisanlarx.setBackground(new Color(255, 204, 153));
		calisanlarx.setOpaque(true);
		calisanlarx.setBounds(10, 103, 162, 7);
		
		panel.add(calisanlarx);
		yemeklerx.setForeground(Color.ORANGE);
		yemeklerx.setVisible(false);
		yemeklerx.setBackground(new Color(255, 204, 153));
		yemeklerx.setOpaque(true);
		yemeklerx.setBounds(10, 212, 140, 7);
		
		panel.add(yemeklerx);
		istencikarx.setForeground(Color.ORANGE);
		istencikarx.setVisible(false);
		istencikarx.setBackground(new Color(255, 204, 153));
		istencikarx.setOpaque(true);
		istencikarx.setBounds(10, 326, 190, 7);
		
		panel.add(istencikarx);
		isealx.setForeground(Color.ORANGE);
		isealx.setVisible(false);
		isealx.setBackground(new Color(255, 204, 153));
		isealx.setOpaque(true);
		isealx.setBounds(10, 430, 190, 7);
		
		panel.add(isealx);
		cikisx.setForeground(Color.ORANGE);
		cikisx.setVisible(false);
		cikisx.setBackground(new Color(255, 204, 153));
		cikisx.setOpaque(true);
		cikisx.setBounds(10, 536, 90, 7);
		
		panel.add(cikisx);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(86, 532, 124, 33);
		
		panel.add(lblNewLabel_2_2_1);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setForeground(Color.GRAY);
		panel_2.setBounds(0, 0, 901, 95);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		lblYnetimBilgilendirmeSistemi.setForeground(new Color(107, 142, 35));
		lblYnetimBilgilendirmeSistemi.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		lblYnetimBilgilendirmeSistemi.setBounds(253, 23, 457, 47);
		panel_2.add(lblYnetimBilgilendirmeSistemi);
		profil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profil p = new profil(username);
				p.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				profilx.setVisible(true);
				
			}
			public void mouseExited(MouseEvent e) {
				profilx.setVisible(false);
				
			}
			
		});
		profil.setForeground(new Color(128, 128, 0));
		profil.setFont(new Font("Segoe UI Historic", Font.BOLD, 10));
		profil.setBounds(768, 23, 123, 47);
		profil.setText(username);
		
		panel_2.add(profil);
		profilx.setVisible(false);
		profilx.setBackground(new Color(255, 204, 153));
		profilx.setOpaque(true);
		profilx.setBounds(768, 68, 123, 5);
		
		panel_2.add(profilx);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(218, 165, 32));
		lblNewLabel_1_1.setBounds(803, 0, 88, 14);
		
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/menukapak.jpg")));
		lblNewLabel_1.setBounds(208, 94, 693, 565);
		contentPane.add(lblNewLabel_1);
		 setLocationRelativeTo(null);
			cinsiyet=cinsiyetBelirle();
			if(cinsiyet.equals("Erkek")) {
			profil.setIcon(new ImageIcon(Menu.class.getResource("/user.png")));
			}
			else
			profil.setIcon(new ImageIcon(Menu.class.getResource("/kadin.png")));
	}
	
	
	
	
	
	
	
	public Menu(String username,String password) {
		 this.username=username;
		this.password=password;
		setUndecorated(true);
		
		System.out.println("Giriþ yapan kiþi"+username+password);
		setTitle("Y\u00F6netim Bilgilendirme Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(0, 94, 210, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		lblYemekler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Yemekler y = new Yemekler();
				y.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				yemeklerx.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				yemeklerx.setVisible(false);
			}
			
		});
		lblYemekler.setIcon(new ImageIcon(Menu.class.getResource("/burger.png")));
		lblYemekler.setForeground(new Color(128, 128, 0));
		lblYemekler.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblYemekler.setBounds(10, 159, 140, 47);
		
		panel.add(lblYemekler);
		lblCalsanlar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				calisanGoster c = new calisanGoster();
					c.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				calisanlarx.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				calisanlarx.setVisible(false);
			}
			
		});
		lblCalsanlar.setIcon(new ImageIcon(Menu.class.getResource("/garsona.png")));
		lblCalsanlar.setForeground(new Color(128, 128, 0));
		lblCalsanlar.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblCalsanlar.setBounds(10, 40, 162, 52);
		
		panel.add(lblCalsanlar);
		lblIstenCkar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				istenCikarma i = new istenCikarma();
				i.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				istencikarx.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				istencikarx.setVisible(false);
			}
		});
		lblIstenCkar.setIcon(new ImageIcon(Menu.class.getResource("/fired.png")));
		lblIstenCkar.setForeground(new Color(128, 128, 0));
		lblIstenCkar.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblIstenCkar.setBounds(10, 268, 190, 47);
		
		panel.add(lblIstenCkar);
		lblIseAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				KayýtOlma k = new KayýtOlma();
				k.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				isealx.setVisible(true);
				
			}
			public void mouseExited(MouseEvent e) {
				isealx.setVisible(false);
				
			}
		});
		lblIseAl.setIcon(new ImageIcon(Menu.class.getResource("/deal.png")));
		lblIseAl.setForeground(new Color(128, 128, 0));
		lblIseAl.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblIseAl.setBounds(10, 382, 190, 37);
		
		panel.add(lblIseAl);
		lblCks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, username+" hesabýnýzdan çýkmak istediðinize emin misiniz?","Seçim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        // 0=yes, 1=no, 2=cancel
				if(input == 0) {
					Baslangic b = new Baslangic();
					b.setVisible(true);
					dispose();
				}
				
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cikisx.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				cikisx.setVisible(false);
			}
		});
		lblCks.setIcon(new ImageIcon(Menu.class.getResource("/exit.png")));
		lblCks.setForeground(new Color(128, 128, 0));
		lblCks.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblCks.setBounds(10, 486, 103, 47);
		
		panel.add(lblCks);
		calisanlarx.setForeground(Color.ORANGE);
		calisanlarx.setVisible(false);
		calisanlarx.setBackground(new Color(255, 204, 153));
		calisanlarx.setOpaque(true);
		calisanlarx.setBounds(10, 103, 162, 7);
		
		panel.add(calisanlarx);
		yemeklerx.setForeground(Color.ORANGE);
		yemeklerx.setVisible(false);
		yemeklerx.setBackground(new Color(255, 204, 153));
		yemeklerx.setOpaque(true);
		yemeklerx.setBounds(10, 212, 140, 7);
		
		panel.add(yemeklerx);
		istencikarx.setForeground(Color.ORANGE);
		istencikarx.setVisible(false);
		istencikarx.setBackground(new Color(255, 204, 153));
		istencikarx.setOpaque(true);
		istencikarx.setBounds(10, 326, 190, 7);
		
		panel.add(istencikarx);
		isealx.setForeground(Color.ORANGE);
		isealx.setVisible(false);
		isealx.setBackground(new Color(255, 204, 153));
		isealx.setOpaque(true);
		isealx.setBounds(10, 430, 190, 7);
		
		panel.add(isealx);
		cikisx.setForeground(Color.ORANGE);
		cikisx.setVisible(false);
		cikisx.setBackground(new Color(255, 204, 153));
		cikisx.setOpaque(true);
		cikisx.setBounds(10, 536, 90, 7);
		
		panel.add(cikisx);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(86, 532, 124, 33);
		
		panel.add(lblNewLabel_2_2_1);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setForeground(Color.GRAY);
		panel_2.setBounds(0, 0, 901, 95);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		lblYnetimBilgilendirmeSistemi.setForeground(new Color(107, 142, 35));
		lblYnetimBilgilendirmeSistemi.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		lblYnetimBilgilendirmeSistemi.setBounds(253, 23, 457, 47);
		panel_2.add(lblYnetimBilgilendirmeSistemi);
		profil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profil p = new profil(username);
				p.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				profilx.setVisible(true);
				
			}
			public void mouseExited(MouseEvent e) {
				profilx.setVisible(false);
				
			}
			
		});
		profil.setForeground(new Color(128, 128, 0));
		profil.setFont(new Font("Segoe UI Historic", Font.BOLD, 10));
		profil.setBounds(768, 23, 123, 47);
		profil.setText(username);
		
		panel_2.add(profil);
		profilx.setVisible(false);
		profilx.setBackground(new Color(255, 204, 153));
		profilx.setOpaque(true);
		profilx.setBounds(768, 68, 123, 5);
		
		panel_2.add(profilx);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(218, 165, 32));
		lblNewLabel_1_1.setBounds(803, 0, 88, 14);
		
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/menukapak.jpg")));
		lblNewLabel_1.setBounds(208, 94, 693, 565);
		contentPane.add(lblNewLabel_1);
		 setLocationRelativeTo(null);
			cinsiyet=cinsiyetBelirle();
			if(cinsiyet.equals("Erkek")) {
			profil.setIcon(new ImageIcon(Menu.class.getResource("/user.png")));
			}
			else
			profil.setIcon(new ImageIcon(Menu.class.getResource("/kadin.png")));
	}
	
	private String cinsiyetBelirle()
	{
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//driver
		
		
	
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
			System.out.println("Baþarýyla baðlandý veritabanýna");
	    
		String query = "select cinsiyet from users where username='"+username+"'";
		Statement st = connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next())
		{	
		cinsiyet=rs.getString("cinsiyet");
		}
			
		}
	         catch (SQLException ep) {
		            JOptionPane.showMessageDialog(null,"Veritabaný hatasým !!!","" ,JOptionPane.WARNING_MESSAGE);            
	            }
	
		return cinsiyet;
	}
}
