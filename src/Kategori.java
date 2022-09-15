import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Kategori extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField adField;
	private int kategoriID;
	private String secilen;
	private String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kategori frame = new Kategori("a");
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
	public Kategori(String username) {
		this.username = username;
		setUndecorated(true);
		setTitle("\u00C7e\u015Fitler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 54, 418, 409);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255,127,80));
		table.setRowHeight(25);
		table.setIntercellSpacing(new Dimension(0, 0));
		
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"cesit_id", "cesit_ismi"
			}
		));
		scrollPane.setViewportView(table);
		
		idField = new JTextField();
		idField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		idField.setForeground(new Color(0, 139, 139));
		idField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 99, 71)));
		idField.setColumns(10);
		idField.setBounds(184, 163, 126, 20);
		contentPane.add(idField);
		
		JLabel lblCesitId = new JLabel(" Kategori ID");
		lblCesitId.setForeground(new Color(0, 139, 139));
		lblCesitId.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblCesitId.setBounds(10, 146, 126, 27);
		contentPane.add(lblCesitId);
		
		adField = new JTextField();
		adField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		adField.setForeground(new Color(0, 139, 139));
		adField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 99, 71)));
		adField.setColumns(10);
		adField.setBounds(184, 221, 126, 20);
		contentPane.add(adField);
		
		JLabel lblCesitAd = new JLabel("Kategori Ad\u0131");
		lblCesitAd.setForeground(new Color(0, 139, 139));
		lblCesitAd.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblCesitAd.setBounds(10, 217, 146, 27);
		contentPane.add(lblCesitAd);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setForeground(new Color(255, 127, 80));
		btnGeri.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnGeri.setIcon(new ImageIcon(Kategori.class.getResource("/return.png")));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Yemekler y = new Yemekler(username);
				y.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(50, 347, 106, 45);
		contentPane.add(btnGeri);
		
		JButton btnKaytEt = new JButton("Ekle");
		btnKaytEt.setForeground(new Color(34, 139, 34));
		btnKaytEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			
				try {
					
				if(adField.getText().equals("") ||
					idField.getText().equals("") 
					)
				{
					JOptionPane.showMessageDialog(null, "Lütfen tüm alanlarý doldurunuz !!!","HATA",JOptionPane.WARNING_MESSAGE);
					throw new Exception();
				}
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//driver
			
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ths?useSSL=false","root", "admin")) {
				System.out.println("Baþarýyla baðlandý veritabanýna");
		    String ad = adField.getText();
			int ID = Integer.parseInt(idField.getText());
			String sqlArama = "SELECT * FROM kategori where Kategori_ID=?";
			PreparedStatement pst = connection.prepareStatement(sqlArama);
			pst.setInt(1, ID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				JOptionPane.showMessageDialog(null, "Ayný ID'ye sahip baþka bir altkategori var, Lütfen tekrar deneyin","HATA",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				
			String sql = "INSERT into kategori values (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, ID);
			preparedStatement.setString(2, ad);
			
			 preparedStatement.executeUpdate();
			 connection.close();
			 JOptionPane.showMessageDialog(null,ad+" adlý kategori baþarýyla kaydedildi.","" ,JOptionPane.INFORMATION_MESSAGE);	
			 adField.setText("");			
			 idField.setText("");
			 ShowData();
		
			 
					
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
		btnKaytEt.setIcon(new ImageIcon(Kategori.class.getResource("/ekle.png")));
		btnKaytEt.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnKaytEt.setBounds(229, 347, 106, 45);
		contentPane.add(btnKaytEt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.GRAY);
		panel_2.setBackground(new Color(255, 99, 71));
		panel_2.setBounds(0, 0, 831, 55);
		contentPane.add(panel_2);
		
		JLabel lblYemekler_1 = new JLabel("Kategori");
		lblYemekler_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYemekler_1.setForeground(Color.WHITE);
		lblYemekler_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		lblYemekler_1.setBounds(372, 0, 134, 47);
		panel_2.add(lblYemekler_1);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(760, 0, 71, 30);
		panel_2.add(lblNewLabel_1);
	
		
		
		
		
		
		 setLocationRelativeTo(null);
	
		
			
		ShowData();
	}
	
	
	
	
	
	
	
	private void ShowData()
	{
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Kategori ID");
		model.addColumn("Kategori Ýsmi");
		
		
		
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ths?useSSL=false","root", "admin");
			String query = "select * from kategori";
			Statement st = connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			
		
		    
			
			
			
			
			
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("Kategori_ID"),
						rs.getString("Kategori_ismi"),
				
						
				});
			}
			rs.close();
			st.close();
			connection.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(209);
			table.getColumnModel().getColumn(1).setPreferredWidth(205);
		
			
			
			
		
		}catch(Exception e)
		{
			System.out.println("Exc");
		}
		
		
	}

}
