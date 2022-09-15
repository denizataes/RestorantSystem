import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.DropMode;
import java.awt.SystemColor;

public class Log extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;
	private static int roleID=1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log(roleID);
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
	public Log(final int roleID) {
		setUndecorated(true);
		setTitle("Giri\u015F ");
		this.roleID = roleID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 659);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.GRAY);
		if(roleID==2)
		lblNewLabel.setIcon(new ImageIcon(Log.class.getResource("/LoginArka.jpg")));
		else if(roleID==1)
		lblNewLabel.setIcon(new ImageIcon(Log.class.getResource("/yonetim.jpg")));
			
		lblNewLabel.setBounds(0, 0, 485, 661);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pass.requestFocusInWindow();
			}
		});
		username.setFocusTraversalPolicyProvider(true);
		username.setFocusCycleRoot(true);
		username.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		username.setToolTipText("");
		
	
	
		username.setForeground(Color.GRAY);
		username.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		username.setBounds(661, 188, 189, 33);
		contentPane.add(username);
		username.setColumns(10);
		
		pass = new JPasswordField();
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException es) {
					es.printStackTrace();
				}//driver
				try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
		            {
				//	JOptionPane.showMessageDialog(null,"Baðlandý","" ,JOptionPane.WARNING_MESSAGE);
					
					if(roleID == 1) {
						String sql = "SELECT * FROM users where username=? and upassword=? and rid=1";
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.setString(1, username.getText());
						pst.setString(2, pass.getText());
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							
							Menu m = new Menu(username.getText(),pass.getText());
							m.setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Kullanýcý adý ya da þifre hatalý !");
							pass.setText("");
							
							
							
						}
						connection.close();
							
						
					}
					else {
						String sql = "SELECT * FROM users where username=? and upassword=? and rid=2";
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.setString(1, username.getText());
						pst.setString(2, pass.getText());
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							
							garsonMenu g = new garsonMenu(username.getText(),pass.getText());
							g.setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Kullanýcý adý ya da þifre hatalý !");
							pass.setText("");
							
							
							
						}
						connection.close();
							
					}
					
					
					
					
					
		     		}           
		      catch (SQLException ep) {
			            JOptionPane.showMessageDialog(null,"Connection to Database failed","" ,JOptionPane.WARNING_MESSAGE);	
		      }
				
				
				
				
				
			}
		});
		pass.setForeground(Color.GRAY);
		pass.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		pass.setBackground(Color.WHITE);
		pass.setDisabledTextColor(Color.LIGHT_GRAY);
		pass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		pass.setBounds(661, 253, 189, 33);
		contentPane.add(pass);
		pass.setColumns(10);
		
		final JCheckBox check = new JCheckBox("\u015Eifremi G\u00F6ster");
		check.setBackground(Color.WHITE);
		check.setForeground(Color.GRAY);
		check.setFont(new Font("Arial", Font.PLAIN, 11));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check.isSelected()) {
					pass.setEchoChar((char)0);
				}else
				{
					pass.setEchoChar('*');
				
					
				}
			
				
			}
		});
		check.setBounds(661, 311, 97, 23);
		contentPane.add(check);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(816, 11, 74, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel btnGiri = new JLabel("Giri\u015F");
		btnGiri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnGiri);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(btnGiri);
			}
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}//driver
				try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
		            {
				//	JOptionPane.showMessageDialog(null,"Baðlandý","" ,JOptionPane.WARNING_MESSAGE);
					
					if(roleID == 1) {
						String sql = "SELECT * FROM users where username=? and upassword=? and rid=1";
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.setString(1, username.getText());
						pst.setString(2, pass.getText());
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							
							Menu m = new Menu(username.getText(),pass.getText());
							m.setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Kullanýcý adý ya da þifre hatalý !");
							pass.setText("");
							
							
							
						}
						connection.close();
							
						
					}
					else {
						String sql = "SELECT * FROM users where username=? and upassword=? and rid=2";
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.setString(1, username.getText());
						pst.setString(2, pass.getText());
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							
							garsonMenu g = new garsonMenu(username.getText(),pass.getText());
							g.setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Kullanýcý adý ya da þifre hatalý !");
							pass.setText("");
							
							
							
						}
						connection.close();
							
					}
					
					
					
					
					
		     		}           
		      catch (SQLException ep) {
			            JOptionPane.showMessageDialog(null,"Connection to Database failed","" ,JOptionPane.WARNING_MESSAGE);	
		      }
				
				
			
			}
			
		});
		btnGiri.setOpaque(true);
		btnGiri.setBackground(new Color(0, 153, 0));
		btnGiri.setForeground(Color.WHITE);
		btnGiri.setHorizontalAlignment(SwingConstants.CENTER);
		btnGiri.setBounds(761, 475, 97, 33);
		contentPane.add(btnGiri);
		
		JLabel lblNewLabel_2_1 = new JLabel("Geri");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBackground(new Color(0, 153, 0));
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(584, 475, 97, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kullan\u0131c\u0131 ad\u0131");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(509, 186, 124, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u015Eifre");
		lblNewLabel_2_2.setForeground(Color.GRAY);
		lblNewLabel_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(509, 251, 124, 33);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("copyright \u00A9 DAE");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(776, 628, 124, 33);
		contentPane.add(lblNewLabel_2_2_1);
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(lblNewLabel_2_1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(lblNewLabel_2_1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Baslangic b = new Baslangic();
				b.setVisible(true);
				dispose();
			}
		});
		 setLocationRelativeTo(null);
	}
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(255,102,153));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(0,153,0));
	}
}
