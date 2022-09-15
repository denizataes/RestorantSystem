import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class istenCikarma extends JFrame {

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
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					istenCikarma frame = new istenCikarma();
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
	public istenCikarma() {
		setUndecorated(true);
		setTitle("Garson \u0130\u015Ften \u00C7\u0131karma");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		scrollPane.setBounds(302, 63, 780, 296);
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
		table.getTableHeader().setBackground(new Color(0, 191, 255));
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
						String add2=rs.getString("rid");
						ridField.setText(add2);
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
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(0, 191, 255)));
		panel.setBounds(0, 63, 301, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		user_idField = new JTextField();
		user_idField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		user_idField.setForeground(new Color(255, 20, 147));
		user_idField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		user_idField.setBounds(135, 22, 88, 20);
		panel.add(user_idField);
		user_idField.setColumns(10);
		
		ridField = new JTextField();
		ridField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		ridField.setForeground(new Color(255, 20, 147));
		ridField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		ridField.setBounds(135, 69, 88, 20);
		panel.add(ridField);
		ridField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		usernameField.setForeground(new Color(255, 20, 147));
		usernameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		usernameField.setBounds(135, 115, 88, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(new Color(105, 105, 105));
		lblPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblPassword.setBounds(23, 166, 86, 14);
		panel.add(lblPassword);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setForeground(new Color(105, 105, 105));
		lblUsername.setBounds(24, 117, 103, 14);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		
		JLabel lblRid = new JLabel("rid");
		lblRid.setForeground(new Color(105, 105, 105));
		lblRid.setBounds(24, 71, 46, 14);
		panel.add(lblRid);
		lblRid.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		
		JLabel lblUserid = new JLabel("user_id");
		lblUserid.setForeground(new Color(105, 105, 105));
		lblUserid.setBounds(24, 24, 74, 14);
		panel.add(lblUserid);
		lblUserid.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		passwordField.setForeground(new Color(255, 20, 147));
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		passwordField.setBounds(135, 164, 88, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblFname = new JLabel("fname");
		lblFname.setForeground(new Color(105, 105, 105));
		lblFname.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblFname.setBounds(23, 219, 46, 14);
		panel.add(lblFname);
		
		fnameField = new JTextField();
		fnameField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		fnameField.setForeground(new Color(255, 20, 147));
		fnameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		fnameField.setBounds(135, 217, 88, 20);
		panel.add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblLname = new JLabel("lname");
		lblLname.setForeground(new Color(105, 105, 105));
		lblLname.setBounds(24, 274, 46, 14);
		panel.add(lblLname);
		lblLname.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		
		lnameField = new JTextField();
		lnameField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lnameField.setForeground(new Color(255, 20, 147));
		lnameField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		lnameField.setBounds(135, 272, 88, 20);
		panel.add(lnameField);
		lnameField.setColumns(10);
		
		mailField = new JTextField();
		mailField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		mailField.setForeground(new Color(255, 20, 147));
		mailField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		mailField.setColumns(10);
		mailField.setBounds(134, 323, 144, 20);
		panel.add(mailField);
		
		JLabel lblMail = new JLabel("mail");
		lblMail.setForeground(new Color(105, 105, 105));
		lblMail.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblMail.setBounds(23, 325, 46, 14);
		panel.add(lblMail);
		
		cinsiyetField = new JTextField();
		cinsiyetField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		cinsiyetField.setForeground(new Color(255, 20, 147));
		cinsiyetField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		cinsiyetField.setColumns(10);
		cinsiyetField.setBounds(134, 376, 89, 20);
		panel.add(cinsiyetField);
		
		JLabel lblCinsiyet = new JLabel("cinsiyet");
		lblCinsiyet.setForeground(new Color(105, 105, 105));
		lblCinsiyet.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblCinsiyet.setBounds(23, 378, 86, 14);
		panel.add(lblCinsiyet);
		
		telefonField = new JTextField();
		telefonField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		telefonField.setForeground(new Color(255, 20, 147));
		telefonField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		telefonField.setColumns(10);
		telefonField.setBounds(134, 416, 89, 20);
		panel.add(telefonField);
		
		JLabel lblTelefon = new JLabel("telefon");
		lblTelefon.setForeground(new Color(105, 105, 105));
		lblTelefon.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblTelefon.setBounds(23, 418, 46, 14);
		panel.add(lblTelefon);
		
		maasField = new JTextField();
		maasField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		maasField.setForeground(new Color(255, 20, 147));
		maasField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		maasField.setColumns(10);
		maasField.setBounds(134, 459, 89, 20);
		panel.add(maasField);
		
		JLabel maas = new JLabel("maas");
		maas.setForeground(new Color(105, 105, 105));
		maas.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		maas.setBounds(23, 461, 46, 14);
		panel.add(maas);
		
		JLabel lblNewLabel = new JLabel("PERSONEL \u0130\u015ETEN \u00C7IKARMA");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(452, 11, 327, 47);
		contentPane.add(lblNewLabel);
		 setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(1021, 0, 71, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00C7\u0131kart");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(user_idField.getText().equals("")||
						ridField.getText().equals("")||
						usernameField.getText().equals("")||
						passwordField.getText().equals("")||
						fnameField.getText().equals("")||
						lnameField.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Lütfen tüm alanlarý doldurun !!!","" ,JOptionPane.WARNING_MESSAGE);
						
					}
					else {
					try {
						Class.forName("org.postgresql.Driver");
					} catch (ClassNotFoundException esd) {
						esd.printStackTrace();
					}//driver
					try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
			            {
						String sql = "DELETE from users where user_id=?";
						PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
						preparedStatement.setInt(1,Integer.parseInt(user_idField.getText()));
						 preparedStatement.executeUpdate();
						 connection.close();		
						 JOptionPane.showMessageDialog(null,fnameField.getText()+" "+lnameField.getText()+" kiþisi baþarýyla silindi.","" ,JOptionPane.INFORMATION_MESSAGE);
						 DefaultTableModel model = (DefaultTableModel)table.getModel();
						 model.setRowCount(0);
						 ShowData();//Refresh
			            }
					catch(SQLException es)
					{
						JOptionPane.showMessageDialog(null,"Veri Tabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
					}
					
					
					
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(lblNewLabel_2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetColor(lblNewLabel_2);
			}
		});
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(847, 420, 103, 47);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Geri");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu m = new Menu();
				dispose();
				m.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(lblNewLabel_3);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(lblNewLabel_3);
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(418, 423, 103, 41);
		contentPane.add(lblNewLabel_3);
	}
	private void ShowData()
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
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(232, 57, 95));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}
}