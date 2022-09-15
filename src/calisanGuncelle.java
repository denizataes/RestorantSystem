import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class calisanGuncelle extends JFrame {

	private JPanel contentPane;

	private JTable table;
	private JTextField user_idField;
	private JTextField ridField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField mailField;
	private JTextField cinsiyetField;
	private JTextField telefonField;
	private JTextField maasField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calisanGuncelle frame = new calisanGuncelle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */private void ShowData()
		{
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("user_id");
			model.addColumn("pid");
			model.addColumn("username");
			model.addColumn("upassword");
			model.addColumn("fname");
			model.addColumn("lname");
			model.addColumn("mail");
			model.addColumn("cinsiyet");
			model.addColumn("telefonno");
			model.addColumn("maas");
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
				String query = "Select * from users";
				Statement st = connection.createStatement();
				ResultSet rs= st.executeQuery(query);
				while(rs.next())
				{
					model.addRow(new Object[] {
							rs.getString("user_id"),
							rs.getString("rid"),
							rs.getString("username"),
							rs.getString("upassword"),
							rs.getString("fname"),
							rs.getString("lname"),
							rs.getString("mail"),
							rs.getString("cinsiyet"),
							rs.getString("telefonno"),
							rs.getString("maas")
							
					});
				}
				rs.close();
				st.close();
				connection.close();
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(25);
				table.getColumnModel().getColumn(1).setPreferredWidth(25);
				table.getColumnModel().getColumn(2).setPreferredWidth(90);
				table.getColumnModel().getColumn(3).setPreferredWidth(90);
				table.getColumnModel().getColumn(4).setPreferredWidth(90);
				table.getColumnModel().getColumn(5).setPreferredWidth(90);
				table.getColumnModel().getColumn(6).setPreferredWidth(112);
				table.getColumnModel().getColumn(7).setPreferredWidth(90);
				table.getColumnModel().getColumn(8).setPreferredWidth(100);
				table.getColumnModel().getColumn(9).setPreferredWidth(69);
				
				
				
			
			}catch(Exception e)
			{
				System.out.println("Exc");
			}
			
			
		}
	public calisanGuncelle() {
		setUndecorated(true);

		setTitle("Garson \u0130\u015Ften \u00C7\u0131karma");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 578);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 63, 780, 417);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(232, 57, 95));
		table.setRowHeight(25);
		table.setIntercellSpacing(new Dimension(0, 0));
		
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(60,179,113));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String Table_click =(table.getModel().getValueAt(row, 0).toString());
					try {
						Class.forName("org.postgresql.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//driver
					try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
					String sql = "SELECT * FROM users where user_id='"+Table_click+"' ";
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
					
						String add1=rs.getString("user_id");
						user_idField.setText(add1);
						user_idField.setEditable(false);
						String add2=rs.getString("rid");
						ridField.setText(add2);
						ridField.setEditable(false);
						String add3=rs.getString("username");
						usernameField.setText(add3);
						String add4=rs.getString("upassword");
						passwordField.setText(add4);
						String add5=rs.getString("fname");
						fnameField.setText(add5);
						String add6=rs.getString("lname");
						lnameField.setText(add6);
						String add7=rs.getString("mail");
						mailField.setText(add7);
						String add8=rs.getString("cinsiyet");
						cinsiyetField.setText(add8);
						String add9=rs.getString("telefonno");
						telefonField.setText(add9);
						String add10=rs.getString("maas");
						maasField.setText(add10);
						
						
					}
					
						
						
					}catch(SQLException e)
					{
						JOptionPane.showMessageDialog(null,"Kullanýcý adý ya da þifre hatalý !");
					}
					
				}
				catch(Exception e) {
					System.out.println("Hata");
					
				}
				
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"user_id", "Role_id", "username", "\u015Eifre", "Ad", "Soyad", "Mail", "Cinsiyet", "Telefon", "Maa\u015F"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(60, 179, 113)));
		panel.setBounds(0, 63, 311, 513);
		contentPane.add(panel);
		panel.setLayout(null);
		
		user_idField = new JTextField();
		user_idField.setOpaque(false);
		user_idField.setForeground(new Color(255, 0, 153));
		user_idField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		user_idField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		user_idField.setBounds(135, 33, 86, 20);
		panel.add(user_idField);
		user_idField.setColumns(10);
		
		ridField = new JTextField();
		ridField.setOpaque(false);
		ridField.setForeground(new Color(255, 0, 153));
		ridField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		ridField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		ridField.setBounds(135, 84, 86, 20);
		panel.add(ridField);
		ridField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setForeground(new Color(255, 0, 153));
		usernameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		usernameField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		usernameField.setBounds(135, 127, 86, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("\u015Eifre");
		lblPassword.setForeground(new Color(105, 105, 105));
		lblPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblPassword.setBounds(23, 166, 86, 35);
		panel.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(105, 105, 105));
		lblUsername.setBounds(24, 117, 101, 38);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		JLabel lblRid = new JLabel("rid");
		lblRid.setForeground(new Color(105, 105, 105));
		lblRid.setBounds(24, 71, 63, 35);
		panel.add(lblRid);
		lblRid.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		JLabel lblUserid = new JLabel("user_id");
		lblUserid.setForeground(new Color(105, 105, 105));
		lblUserid.setBounds(24, 24, 85, 36);
		panel.add(lblUserid);
		lblUserid.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		passwordField = new JTextField();
		passwordField.setForeground(new Color(255, 0, 153));
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		passwordField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		passwordField.setBounds(135, 174, 86, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblFname = new JLabel("Ad");
		lblFname.setForeground(new Color(105, 105, 105));
		lblFname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblFname.setBounds(23, 219, 86, 35);
		panel.add(lblFname);
		
		fnameField = new JTextField();
		fnameField.setForeground(new Color(255, 0, 153));
		fnameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		fnameField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		fnameField.setBounds(135, 227, 86, 20);
		panel.add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblLname = new JLabel("Soyad");
		lblLname.setForeground(new Color(105, 105, 105));
		lblLname.setBounds(24, 274, 85, 40);
		panel.add(lblLname);
		lblLname.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		
		lnameField = new JTextField();
		lnameField.setForeground(new Color(255, 0, 153));
		lnameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		lnameField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		lnameField.setBounds(135, 285, 86, 20);
		panel.add(lnameField);
		lnameField.setColumns(10);
		
		mailField = new JTextField();
		mailField.setForeground(new Color(255, 0, 153));
		mailField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		mailField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		mailField.setColumns(10);
		mailField.setBounds(135, 333, 128, 20);
		panel.add(mailField);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setForeground(new Color(105, 105, 105));
		lblMail.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblMail.setBounds(23, 325, 86, 35);
		panel.add(lblMail);
		
		cinsiyetField = new JTextField();
		cinsiyetField.setForeground(new Color(255, 0, 153));
		cinsiyetField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		cinsiyetField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		cinsiyetField.setColumns(10);
		cinsiyetField.setBounds(135, 387, 86, 20);
		panel.add(cinsiyetField);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet");
		lblCinsiyet.setForeground(new Color(105, 105, 105));
		lblCinsiyet.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblCinsiyet.setBounds(23, 378, 86, 29);
		panel.add(lblCinsiyet);
		
		telefonField = new JTextField();
		telefonField.setForeground(new Color(255, 0, 153));
		telefonField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		telefonField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		telefonField.setColumns(10);
		telefonField.setBounds(135, 433, 108, 20);
		panel.add(telefonField);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(new Color(105, 105, 105));
		lblTelefon.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblTelefon.setBounds(23, 418, 86, 35);
		panel.add(lblTelefon);
		
		maasField = new JTextField();
		maasField.setForeground(new Color(255, 0, 153));
		maasField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 100, 0)));
		maasField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		maasField.setColumns(10);
		maasField.setBounds(135, 472, 86, 20);
		panel.add(maasField);
		
		JLabel maas = new JLabel("Maas");
		maas.setForeground(new Color(105, 105, 105));
		maas.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		maas.setBounds(23, 472, 86, 18);
		panel.add(maas);
		
		JLabel lblNewLabel = new JLabel("GARSON G\u00DCNCELLEME");
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(452, 11, 327, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("G\u00FCncelle");
		btnNewButton.setBackground(new Color(123, 104, 238));
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(791, 496, 101, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Geri");
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		 setLocationRelativeTo(null);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setBounds(486, 496, 101, 55);
		contentPane.add(btnNewButton_1);
		
		JTextPane alan = new JTextPane();
		alan.setEditable(false);
		alan.setRequestFocusEnabled(false);
		alan.setFont(new Font("Segoe UI Light", Font.ITALIC, 12));
		alan.setForeground(new Color(128, 128, 128));
		alan.setBackground(new Color(255, 255, 255));
		alan.setText("G\u00FCncellemek istedi\u011Finiz \u00E7al\u0131\u015Fan\u0131 sa\u011F tarafta se\u00E7tikten sonra a\u015Fa\u011F\u0131da g\u00FCncellemek istedi\u011Finiz de\u011Feri de\u011Fi\u015Ftirip g\u00FCncelle tu\u015Funa bas\u0131n\u0131z.");
		alan.setBounds(0, 11, 311, 58);
		contentPane.add(alan);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(238, 130, 238));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(1046, 0, 71, 40);
		contentPane.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}//driver
				try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
		            {
					
					
					String ad = fnameField.getText();
					String soyad = lnameField.getText();
					String username = usernameField.getText();
					String password = passwordField.getText();
					String telefonNo = telefonField.getText();
					String mail = mailField.getText();
					String cins = cinsiyetField.getText();
					int maas =Integer.parseInt(maasField.getText());
					int ID = Integer.parseInt(user_idField.getText());
					int rid= Integer.parseInt(ridField.getText());
					String sql = "UPDATE users SET user_id='"+ID+"',rid='"+rid+"',username='"+username+"',upassword='"+password+"',fname='"+ad+"',lname='"+soyad+"',mail='"+mail+"',cinsiyet='"+cins+"',telefonno='"+telefonNo+"',maas='"+maas+"'where user_id='"+ID+"'";
					String sqlArama = "SELECT * FROM users where user_id=?";
//					PreparedStatement pst = connection.prepareStatement(sqlArama);
//					pst.setInt(1, ID);
//					ResultSet rs = pst.executeQuery();
//					if(rs.next()) {
//						
//						JOptionPane.showMessageDialog(null, "Ayný ID'ye sahip baþka bir çalýþan var, Lütfen tekrar deneyin","HATA",JOptionPane.WARNING_MESSAGE);
//						throw new Exception();
//					}
				PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
					
					
					
//					preparedStatement.setInt(1,ID);
//					preparedStatement.setInt(2,2);
//					preparedStatement.setString(3,username);
//					preparedStatement.setString(4,password);
//					preparedStatement.setString(5, ad);
//					preparedStatement.setString(6,soyad);
//					preparedStatement.setString(7,mail);
//					preparedStatement.setString(8,cins);
//					preparedStatement.setString(9,telefonNo);
//					preparedStatement.setInt(10,maas);
					 preparedStatement.execute();
					 
					 JOptionPane.showMessageDialog(null,ad+" "+soyad+" adlý çalýþan baþarýyla güncellendi.","" ,JOptionPane.INFORMATION_MESSAGE);	
					 DefaultTableModel model = (DefaultTableModel)table.getModel();
					 model.setRowCount(0);
					 ShowData();//Refresh
		            }
				catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null,"Veri Tabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			
		}});
	
	}
}
