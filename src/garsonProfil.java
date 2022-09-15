import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class garsonProfil extends JFrame {

	private JPanel contentPane;
	private static String username="A";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profil frame = new profil(username);
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
	public garsonProfil(String username) {
		setUndecorated(true);
		this.username=username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 639);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel maasField = new JLabel("Maa\u015F");
		maasField.setIcon(new ImageIcon(profil.class.getResource("/money.png")));
		maasField.setForeground(new Color(255, 255, 0));
		maasField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		maasField.setBounds(129, 449, 196, 53);
		contentPane.add(maasField);
		
		JLabel cinsiyetField = new JLabel("Cinsiyeti");
		cinsiyetField.setIcon(new ImageIcon(profil.class.getResource("/transgender.png")));
		cinsiyetField.setForeground(new Color(255, 255, 0));
		cinsiyetField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		cinsiyetField.setBounds(129, 375, 196, 53);
		contentPane.add(cinsiyetField);
		
		JLabel mailField = new JLabel("Mail adresi");
		mailField.setIcon(new ImageIcon(profil.class.getResource("/mail.png")));
		mailField.setForeground(new Color(102, 102, 102));
		mailField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		mailField.setBounds(132, 288, 297, 53);
		contentPane.add(mailField);
		
		JLabel telefonField = new JLabel("Telefon numaras\u0131");
		telefonField.setIcon(new ImageIcon(profil.class.getResource("/call.png")));
		telefonField.setForeground(new Color(102, 102, 102));
		telefonField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		telefonField.setBounds(129, 202, 196, 53);
		contentPane.add(telefonField);
		
		JLabel usernameField = new JLabel("Y\u00F6netici username");
		
		usernameField.setForeground(new Color(102, 102, 102));
		usernameField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		usernameField.setBounds(129, 131, 196, 49);
		contentPane.add(usernameField);
		
		JLabel soyadField = new JLabel("Y\u00F6netici soyad\u0131");
		soyadField.setHorizontalAlignment(SwingConstants.LEFT);
		soyadField.setForeground(new Color(128, 128, 128));
		soyadField.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		soyadField.setBounds(275, 72, 171, 49);
		contentPane.add(soyadField);
		
		JLabel adField = new JLabel("Y\u00F6netici ad\u0131");
		adField.setHorizontalAlignment(SwingConstants.CENTER);
		adField.setForeground(new Color(128, 128, 128));
		adField.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		adField.setBounds(98, 72, 178, 49);
		contentPane.add(adField);
		
		JLabel lblNewLabel = new JLabel("Geri");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(lblNewLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(lblNewLabel);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				garsonMenu m = new garsonMenu();
				dispose();
				m.setVisible(true);

			}
		});
		lblNewLabel.setBackground(new Color(51, 51, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(186, 561, 95, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setBounds(402, 0, 71, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(profil.class.getResource("/kapak.jpg")));
		lblNewLabel_2.setBounds(0, 0, 473, 639);
		contentPane.add(lblNewLabel_2);
		
	
		
		
		
		
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//driver
		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
			System.out.println("Baþarýyla baðlandý veritabanýna");

		String sql = "SELECT * FROM users where username=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			adField.setText(rs.getString("fname"));
			soyadField.setText(rs.getString("lname"));
			usernameField.setText(rs.getString("username"));
			telefonField.setText(rs.getString("telefonno"));
			mailField.setText(rs.getString("mail"));
			cinsiyetField.setText(rs.getString("cinsiyet"));
			maasField.setText(rs.getString("maas"));
			

		}
	
	            }  catch (SQLException ep) {
		            JOptionPane.showMessageDialog(null,"Veritabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
		            
	            }
		if(cinsiyetField.getText().equals("Erkek"))
		{
			usernameField.setIcon(new ImageIcon(profil.class.getResource("/user.png")));
		}
		else
			usernameField.setIcon(new ImageIcon(profil.class.getResource("/kadin.png")));
		
		
		
		
		
		
		
		
		 setLocationRelativeTo(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(51,51,51));
	}
}
