import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class KayýtOlma extends JFrame {

	private JPanel contentPane;
	private JTextField adField;
	private JTextField soyadField;
	private JTextField usernameField;
	private JPasswordField passField;
	private JTextField IDField;
	private JTextField telefonField;
	private JTextField mailField;
	private static int cinsiyetSayac=0;
	private static int sayac=0;
	private JTextField maasField;
	private String cins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayýtOlma frame = new KayýtOlma();
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
	public KayýtOlma() {
		setUndecorated(true);
		setTitle("Kay\u0131t ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 639);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnKaytEt = new JButton("Kay\u0131t et");
		btnKaytEt.setBackground(new Color(255, 215, 0));
		
		btnKaytEt.setBounds(301, 587, 89, 23);
		contentPane.add(btnKaytEt);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setBackground(new Color(255, 215, 0));
		
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
				
			}
		});
		btnGeri.setBounds(112, 587, 89, 23);
		contentPane.add(btnGeri);
		
		JLabel lblGarsonKaytYeri = new JLabel("PERSONEL KAYIT");
		lblGarsonKaytYeri.setForeground(new Color(105, 105, 105));
		lblGarsonKaytYeri.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		lblGarsonKaytYeri.setBounds(128, 26, 227, 62);
		contentPane.add(lblGarsonKaytYeri);
		
		JLabel lblGarsonIsmi = new JLabel("Personel Ad\u0131");
		lblGarsonIsmi.setForeground(new Color(128, 128, 128));
		lblGarsonIsmi.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGarsonIsmi.setBounds(60, 131, 141, 28);
		contentPane.add(lblGarsonIsmi);
		
		JLabel lblGarsonSoyad = new JLabel("Personel Soyad\u0131");
		lblGarsonSoyad.setForeground(new Color(128, 128, 128));
		lblGarsonSoyad.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGarsonSoyad.setBounds(60, 170, 126, 31);
		contentPane.add(lblGarsonSoyad);
		
		JLabel lblGarsonUsername = new JLabel("Personel Username");
		lblGarsonUsername.setForeground(new Color(128, 128, 128));
		lblGarsonUsername.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGarsonUsername.setBounds(60, 212, 163, 31);
		contentPane.add(lblGarsonUsername);
		
		JLabel lblGarsonifresi = new JLabel("Personel \u015Eifresi");
		lblGarsonifresi.setForeground(new Color(0, 0, 0));
		lblGarsonifresi.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGarsonifresi.setBounds(60, 254, 141, 18);
		contentPane.add(lblGarsonifresi);
		
		adField = new JTextField();
		adField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		adField.setForeground(new Color(105, 105, 105));
		adField.setOpaque(false);
		adField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(105, 105, 105)));
		adField.setBounds(233, 129, 86, 20);
		contentPane.add(adField);
		adField.setColumns(10);
		
		soyadField = new JTextField();
		soyadField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		soyadField.setForeground(new Color(105, 105, 105));
		soyadField.setOpaque(false);
		soyadField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(105, 105, 105)));
		soyadField.setBounds(233, 168, 86, 20);
		contentPane.add(soyadField);
		soyadField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		usernameField.setForeground(new Color(105, 105, 105));
		usernameField.setOpaque(false);
		usernameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(105, 105, 105)));
		usernameField.setBounds(233, 210, 86, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		passField.setForeground(new Color(105, 105, 105));
		passField.setOpaque(false);
		passField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(105, 105, 105)));
		passField.setBounds(233, 252, 86, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		
		final JCheckBox check = new JCheckBox("\u015Eifreyi g\u00F6ster");
		check.setOpaque(false);
		check.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		check.setForeground(new Color(105, 105, 105));
		check.setBackground(Color.DARK_GRAY);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(check.isSelected()) {
					passField.setEchoChar((char)0);
				}else
				{
					passField.setEchoChar('*');
				}
			}
		});
		
		check.setBounds(339, 251, 97, 23);
		contentPane.add(check);
		
		JLabel GarsonIDLabel = new JLabel("Personel ID");
		GarsonIDLabel.setForeground(new Color(255, 215, 0));
		GarsonIDLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		GarsonIDLabel.setBounds(60, 301, 126, 28);
		contentPane.add(GarsonIDLabel);
		
		IDField = new JTextField();
		IDField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		IDField.setOpaque(false);
		IDField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(105, 105, 105)));
		IDField.setBounds(233, 299, 86, 20);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JLabel lblTelefonNumaras = new JLabel("Personel Numaras\u0131");
		lblTelefonNumaras.setForeground(new Color(255, 215, 0));
		lblTelefonNumaras.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblTelefonNumaras.setBounds(60, 352, 163, 18);
		contentPane.add(lblTelefonNumaras);
		
		telefonField = new JTextField();
		telefonField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		telefonField.setForeground(new Color(105, 105, 105));
		telefonField.setOpaque(false);
		telefonField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(105, 105, 105)));
		telefonField.setColumns(10);
		telefonField.setBounds(233, 350, 86, 20);
		contentPane.add(telefonField);
		
		JLabel lblAdresi = new JLabel("Mail adresi");
		lblAdresi.setForeground(new Color(255, 215, 0));
		lblAdresi.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblAdresi.setBounds(60, 403, 141, 23);
		contentPane.add(lblAdresi);
		
		mailField = new JTextField();
		mailField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		mailField.setForeground(new Color(255, 215, 0));
		mailField.setOpaque(false);
		mailField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 215, 0)));
		mailField.setColumns(10);
		mailField.setBounds(233, 401, 86, 20);
		contentPane.add(mailField);
		
		JLabel GarsonIDLabel_3 = new JLabel("Cinsiyeti");
		GarsonIDLabel_3.setForeground(new Color(255, 215, 0));
		GarsonIDLabel_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		
		
		GarsonIDLabel_3.setBounds(60, 453, 141, 20);
		contentPane.add(GarsonIDLabel_3);
		JRadioButton erkek = new JRadioButton("Erkek");
		erkek.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		erkek.setOpaque(false);
		erkek.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				if(erkek.isSelected())
				{
				cins="Erkek";
				sayac=1;
				}
				
				
			}
		});
		JRadioButton kadýn = new JRadioButton("Kad\u0131n");
		kadýn.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		kadýn.setOpaque(false);
		kadýn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(kadýn.isSelected())
				{
					
 					cins="Kadýn";
 					sayac=1;
				}
				
			}
		});
		
				
				
				
		
		kadýn.setForeground(new Color(255, 215, 0));
		kadýn.setBackground(Color.DARK_GRAY);
		kadýn.setBounds(314, 450, 64, 23);
		contentPane.add(kadýn);
		
		
	
			
	
		ButtonGroup bg = new ButtonGroup();
		bg.add(erkek);
		bg.add(kadýn);
		
		erkek.setForeground(new Color(255, 215, 0));
		erkek.setBackground(Color.DARK_GRAY);
		erkek.setBounds(233, 450, 64, 23);
		contentPane.add(erkek);
		
		maasField = new JTextField();
		maasField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		maasField.setForeground(new Color(255, 215, 0));
		maasField.setOpaque(false);
		maasField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 215, 0)));
		maasField.setColumns(10);
		maasField.setBounds(233, 492, 86, 20);
		contentPane.add(maasField);
		
		JLabel lblMaa = new JLabel("Maa\u015F");
		lblMaa.setForeground(new Color(255, 215, 0));
		lblMaa.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblMaa.setBounds(60, 494, 116, 28);
		contentPane.add(lblMaa);
		
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
		lblNewLabel_1.setBounds(402, 0, 71, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(KayýtOlma.class.getResource("/kapak.jpg")));
		lblNewLabel.setBounds(0, 0, 473, 639);
		contentPane.add(lblNewLabel);
		
		btnKaytEt.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
				if(adField.getText().equals("") ||
				   soyadField.getText().equals("") ||
					passField.getText().equals("") ||	
					usernameField.getText().equals("") ||
					IDField.getText().equals("") ||
				    mailField.getText().equals("") ||
					telefonField.getText().equals("") ||
					maasField.getText().equals("") 
					
					)
				{
					JOptionPane.showMessageDialog(null, "Lütfen tüm alanlarý doldurunuz !!!","HATA",JOptionPane.WARNING_MESSAGE);
				}
				else if(sayac==0) {
					JOptionPane.showMessageDialog(null, "Lütfen cinsiyet alanýný doldurunuz  !!!","HATA",JOptionPane.WARNING_MESSAGE);
					throw new Exception();
				}
				
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//driver
			
			try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
				System.out.println("Baþarýyla baðlandý veritabanýna");
		    String ad = adField.getText();
			String soyad = soyadField.getText();
			String username = usernameField.getText();
			String password = passField.getText();
			String telefonNo = telefonField.getText();
			String mail = mailField.getText();
			
			int maas =Integer.parseInt(maasField.getText());
			
			int ID = Integer.parseInt(IDField.getText());
			String sqlArama = "SELECT * FROM users where user_id=?";
			PreparedStatement pst = connection.prepareStatement(sqlArama);
			pst.setInt(1, ID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				JOptionPane.showMessageDialog(null, "Ayný ID'ye sahip baþka bir çalýþan var, Lütfen tekrar deneyin","HATA",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				
			String sql = "INSERT into users values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, ID);
			preparedStatement.setInt(2,2);
			preparedStatement.setString(3,username);
			preparedStatement.setString(4,password);
			preparedStatement.setString(5, ad);
			preparedStatement.setString(6,soyad);
			preparedStatement.setString(7,mail);
			preparedStatement.setString(8,cins);
			preparedStatement.setString(9,telefonNo);
			preparedStatement.setInt(10,maas);
			System.out.println("ID ="+ID+"ROLEID = 2"+username+password+ad+soyad);
			 preparedStatement.executeUpdate();
			 connection.close();
			 JOptionPane.showMessageDialog(null,ad+" "+soyad+" adlý çalýþan baþarýyla kaydedildi.","" ,JOptionPane.INFORMATION_MESSAGE);	
			 adField.setText("");			
			soyadField.setText("");
			usernameField.setText("");
			passField.setText("");
			telefonField.setText("");
			 mailField.setText("");
			 IDField.setText("");
			 maasField.setText("");
			 
					
			}
		            }  catch (SQLException ep) {
			            JOptionPane.showMessageDialog(null,"Veritabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
			            
		            }
				}catch(Exception eb)
				{
					System.out.println("Exc");
				}
					 
			
			

			}
			});
		
		
		
		
		
		
	
		 setLocationRelativeTo(null);
			
		}
		}
		

