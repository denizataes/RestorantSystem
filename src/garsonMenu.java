import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class garsonMenu extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private static String username="admin";
	private static String password;
	private String cinsiyet="Erkek";
	private JLabel profil_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					garsonMenu frame = new garsonMenu(username,password);
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
	public garsonMenu() {
		setUndecorated(true);
		setTitle("Garson Menu");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 993, 606);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(75, 41, 208, 215);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel masa1 = new JLabel("MASA 1");
		masa1.setIcon(null);
		masa1.setBackground(new Color(0, 0, 0));
		masa1.setForeground(new Color(255, 255, 255));
		masa1.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa1.setHorizontalAlignment(SwingConstants.CENTER);
		
		masa1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				masa1 m = new masa1();
				m.setVisible(true);
				dispose();
			}
		});
	
		masa1.setBounds(0, 0, 208, 215);
		panel_1.add(masa1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 191, 255));
		panel_1_1.setBounds(389, 41, 208, 215);
		panel.add(panel_1_1);
		
		JLabel masa2 = new JLabel("MASA 2");
		masa2.setForeground(new Color(255, 255, 255));
		masa2.setHorizontalAlignment(SwingConstants.CENTER);
		masa2.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa2.setBounds(0, 0, 208, 215);
		panel_1_1.add(masa2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(0, 191, 255));
		panel_1_2.setBounds(701, 41, 208, 215);
		panel.add(panel_1_2);
		
		JLabel masa3 = new JLabel("MASA 3");
		masa3.setForeground(new Color(255, 255, 255));
		masa3.setHorizontalAlignment(SwingConstants.CENTER);
		masa3.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa3.setBounds(0, 0, 208, 215);
		panel_1_2.add(masa3);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(new Color(0, 191, 255));
		panel_1_3.setBounds(75, 318, 208, 215);
		panel.add(panel_1_3);
		
		JLabel masa4 = new JLabel("MASA 4");
		masa4.setForeground(new Color(255, 255, 255));
		masa4.setHorizontalAlignment(SwingConstants.CENTER);
		masa4.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa4.setBounds(0, 0, 208, 215);
		panel_1_3.add(masa4);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBackground(new Color(0, 191, 255));
		panel_1_4.setBounds(389, 318, 208, 215);
		panel.add(panel_1_4);
		
		profil_1 = new JLabel(username);
		profil_1.setForeground(new Color(105, 105, 105));
		profil_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		cinsiyet=cinsiyetBelirle();
		if(cinsiyet.equals("Erkek")) {
		profil_1.setIcon(new ImageIcon(garsonMenu.class.getResource("/user.png")));
		}
		else
		profil_1.setIcon(new ImageIcon(garsonMenu.class.getResource("/kadin.png")));
	
		profil_1.setBounds(913, 546, 80, 60);
		profil_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				garsonProfil p = new garsonProfil(username);
				p.setVisible(true);
				dispose();
			}
			
		});
		
		panel.add(profil_1);
		
		
		
		JLabel masa5 = new JLabel("MASA 5");
		masa5.setForeground(new Color(255, 255, 255));
		masa5.setHorizontalAlignment(SwingConstants.CENTER);
		masa5.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa5.setBounds(0, 0, 208, 215);
		panel_1_4.add(masa5);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBackground(new Color(0, 191, 255));
		panel_1_5.setBounds(701, 318, 208, 215);
		panel.add(panel_1_5);
		
		JLabel masa6 = new JLabel("MASA 6");
		masa6.setForeground(new Color(255, 255, 255));
		masa6.setHorizontalAlignment(SwingConstants.CENTER);
		masa6.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa6.setBounds(0, 0, 208, 215);
		panel_1_5.add(masa6);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F");
		btnNewButton.setIcon(new ImageIcon(garsonMenu.class.getResource("/return.png")));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int input = JOptionPane.showConfirmDialog(null,username+" hesabýnýzdan çýkmak istediðinize emin misiniz?","Seçim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        // 0=yes, 1=no, 2=cancel
				if(input == 0) {
					Baslangic b = new Baslangic();
					b.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(451, 544, 101, 51);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(922, 0, 71, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("copyright \u00A9 DAE");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(0, 572, 124, 33);
		panel.add(lblNewLabel_2_2_1);
		
		
		
		masa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_1);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				masa2 m = new masa2();
				m.setVisible(true);
				dispose();
			}
		});
		masa3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_2);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_2);
			}
			public void mouseClicked(MouseEvent e) {
				masa3 m = new masa3();
				m.setVisible(true);
				dispose();
			}
		});
		masa4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_3);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_3);
			}
			public void mouseClicked(MouseEvent e) {
				masa4 m = new masa4();
				m.setVisible(true);
				dispose();
			}
		});
		masa5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_4);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_4);
			}
			public void mouseClicked(MouseEvent e) {
				masa5 m = new masa5();
				m.setVisible(true);
				dispose();
			}
		});
		masa6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_5);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_5);
			}
			public void mouseClicked(MouseEvent e) {
				masa6 m = new masa6();
				m.setVisible(true);
				dispose();
			}
		});
		
		
		 setLocationRelativeTo(null);
	}
	public garsonMenu(String username , String password) {
		this.username = username;
		this.password = password;
		
		setUndecorated(true);
		setTitle("Garson Menu");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 993, 606);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(75, 41, 208, 215);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel masa1 = new JLabel("MASA 1");
		masa1.setIcon(null);
		masa1.setBackground(new Color(0, 0, 0));
		masa1.setForeground(new Color(255, 255, 255));
		masa1.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa1.setHorizontalAlignment(SwingConstants.CENTER);
		
		masa1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				masa1 m = new masa1();
				m.setVisible(true);
				dispose();
			}
		});
	
		masa1.setBounds(0, 0, 208, 215);
		panel_1.add(masa1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 191, 255));
		panel_1_1.setBounds(389, 41, 208, 215);
		panel.add(panel_1_1);
		
		JLabel masa2 = new JLabel("MASA 2");
		masa2.setForeground(new Color(255, 255, 255));
		masa2.setHorizontalAlignment(SwingConstants.CENTER);
		masa2.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa2.setBounds(0, 0, 208, 215);
		panel_1_1.add(masa2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(0, 191, 255));
		panel_1_2.setBounds(701, 41, 208, 215);
		panel.add(panel_1_2);
		
		JLabel masa3 = new JLabel("MASA 3");
		masa3.setForeground(new Color(255, 255, 255));
		masa3.setHorizontalAlignment(SwingConstants.CENTER);
		masa3.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa3.setBounds(0, 0, 208, 215);
		panel_1_2.add(masa3);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(new Color(0, 191, 255));
		panel_1_3.setBounds(75, 318, 208, 215);
		panel.add(panel_1_3);
		
		JLabel masa4 = new JLabel("MASA 4");
		masa4.setForeground(new Color(255, 255, 255));
		masa4.setHorizontalAlignment(SwingConstants.CENTER);
		masa4.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa4.setBounds(0, 0, 208, 215);
		panel_1_3.add(masa4);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBackground(new Color(0, 191, 255));
		panel_1_4.setBounds(389, 318, 208, 215);
		panel.add(panel_1_4);
		
		profil_1 = new JLabel(username);
		profil_1.setForeground(new Color(105, 105, 105));
		profil_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		cinsiyet=cinsiyetBelirle();
		if(cinsiyet.equals("Erkek")) {
		profil_1.setIcon(new ImageIcon(garsonMenu.class.getResource("/user.png")));
		}
		else
		profil_1.setIcon(new ImageIcon(garsonMenu.class.getResource("/kadin.png")));
	
		profil_1.setBounds(913, 546, 80, 60);
		profil_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				garsonProfil p = new garsonProfil(username);
				p.setVisible(true);
				dispose();
			}
			
		});
		
		panel.add(profil_1);
		
		
		
		JLabel masa5 = new JLabel("MASA 5");
		masa5.setForeground(new Color(255, 255, 255));
		masa5.setHorizontalAlignment(SwingConstants.CENTER);
		masa5.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa5.setBounds(0, 0, 208, 215);
		panel_1_4.add(masa5);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBackground(new Color(0, 191, 255));
		panel_1_5.setBounds(701, 318, 208, 215);
		panel.add(panel_1_5);
		
		JLabel masa6 = new JLabel("MASA 6");
		masa6.setForeground(new Color(255, 255, 255));
		masa6.setHorizontalAlignment(SwingConstants.CENTER);
		masa6.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		masa6.setBounds(0, 0, 208, 215);
		panel_1_5.add(masa6);
		
		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F");
		btnNewButton.setIcon(new ImageIcon(garsonMenu.class.getResource("/return.png")));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int input = JOptionPane.showConfirmDialog(null,username+" hesabýnýzdan çýkmak istediðinize emin misiniz?","Seçim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        // 0=yes, 1=no, 2=cancel
				if(input == 0) {
					Baslangic b = new Baslangic();
					b.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(451, 544, 101, 51);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(922, 0, 71, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("copyright \u00A9 DAE");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(0, 572, 124, 33);
		panel.add(lblNewLabel_2_2_1);
		
		
		
		masa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_1);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				masa2 m = new masa2();
				m.setVisible(true);
				dispose();
			}
		});
		masa3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_2);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_2);
			}
			public void mouseClicked(MouseEvent e) {
				masa3 m = new masa3();
				m.setVisible(true);
				dispose();
			}
		});
		masa4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_3);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_3);
			}
			public void mouseClicked(MouseEvent e) {
				masa4 m = new masa4();
				m.setVisible(true);
				dispose();
			}
		});
		masa5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_4);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_4);
			}
			public void mouseClicked(MouseEvent e) {
				masa5 m = new masa5();
				m.setVisible(true);
				dispose();
			}
		});
		masa6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1_5);
				
				
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(panel_1_5);
			}
			public void mouseClicked(MouseEvent e) {
				masa6 m = new masa6();
				m.setVisible(true);
				dispose();
			}
		});
		
		
		 setLocationRelativeTo(null);
	}
	
	public void setColor(JPanel p)
	{
	p.setBackground(new Color(173,216,230));
	}
	public void resetColor(JPanel p)
	{
	p.setBackground(new Color(0,191,255));
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
