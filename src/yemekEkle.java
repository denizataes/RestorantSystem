import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class yemekEkle extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField adField;
	private JTextField fiyatField;
	private JTable table;
	private String secilen;
	private JComboBox c;
	private int cesit_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yemekEkle frame = new yemekEkle();
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
	public yemekEkle() {
		setUndecorated(true);
		setTitle("Yemek Ekle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("Yemek id");
		id.setBounds(336, 238, 135, 34);
		id.setForeground(new Color(46, 139, 87));
		id.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(id);
		
		idField = new JTextField();
		idField.setForeground(new Color(46, 139, 87));
		idField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		idField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		idField.setBounds(496, 236, 86, 20);
		idField.setColumns(10);
		contentPane.add(idField);
		
		adField = new JTextField();
		adField.setForeground(new Color(46, 139, 87));
		adField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		adField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		adField.setBounds(496, 294, 86, 20);
		adField.setColumns(10);
		contentPane.add(adField);
		
		JLabel add = new JLabel("Yemek ad\u0131");
		add.setBounds(336, 296, 135, 34);
		add.setForeground(new Color(46, 139, 87));
		add.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(add);
		
		JLabel fiyatdd = new JLabel("Fiyat");
		fiyatdd.setBounds(336, 362, 135, 34);
		fiyatdd.setForeground(new Color(46, 139, 87));
		fiyatdd.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		contentPane.add(fiyatdd);
		
		fiyatField = new JTextField();
		fiyatField.setForeground(new Color(46, 139, 87));
		fiyatField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		fiyatField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		fiyatField.setBounds(496, 360, 86, 20);
		fiyatField.setColumns(10);
		contentPane.add(fiyatField);
		
		JButton btnKaytEt = new JButton("Ekle");
		btnKaytEt.setForeground(new Color(34, 139, 34));
		btnKaytEt.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
		btnKaytEt.setIcon(new ImageIcon(yemekEkle.class.getResource("/ekle.png")));
		btnKaytEt.setBounds(509, 428, 106, 45);
		btnKaytEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 secilenBul();
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//driver
				
				
				
				try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
					System.out.println("Baþarýyla baðlandý veritabanýna");
			    String ad = adField.getText();
				Float fiyat = Float.parseFloat(fiyatField.getText());
				int ID = Integer.parseInt(idField.getText());
				String sqlArama = "SELECT * FROM yemekler where yemek_id=?";
				PreparedStatement pst = connection.prepareStatement(sqlArama);
				pst.setInt(1, ID);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					
					JOptionPane.showMessageDialog(null, "Ayný ID'ye sahip baþka bir yemek var, Lütfen tekrar deneyin","HATA",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					
				String sql = "INSERT into yemekler values (?,?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
				preparedStatement.setInt(1, ID);
				preparedStatement.setInt(2,cesit_id);
				preparedStatement.setString(3,ad);
				preparedStatement.setFloat(4,fiyat);
			
			
				
				 preparedStatement.executeUpdate();
				 connection.close();
				 JOptionPane.showMessageDialog(null,ad+" adlý yemek baþarýyla kaydedildi.","" ,JOptionPane.INFORMATION_MESSAGE);	
				 ShowData();//Refresh
				 adField.setText("");			
				fiyatField.setText("");
				idField.setText("");
				
				 
						
				}
			            }  catch (SQLException ep) {
				            JOptionPane.showMessageDialog(null,"Veritabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
				            
			            }
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		contentPane.add(btnKaytEt);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setIcon(new ImageIcon(yemekEkle.class.getResource("/return.png")));
		btnGeri.setForeground(new Color(244, 164, 96));
		btnGeri.setBounds(365, 428, 106, 45);
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yemekler y = new Yemekler();
				y.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnGeri);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 326, 535);
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
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"cesit_id","yemek_id", "Yemek Ad\u0131", "Fiyat"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblYemekler_1 = new JLabel("YEMEK EKLE");
		lblYemekler_1.setForeground(new Color(0, 128, 0));
		lblYemekler_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		lblYemekler_1.setBounds(413, 55, 154, 45);
		contentPane.add(lblYemekler_1);
		
		 c = new JComboBox();
		 c.setForeground(new Color(46, 139, 87));
		 c.setBackground(new Color(255, 255, 255));
		 c.setOpaque(false);
		 c.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 c.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			
			String query = "select cesit_ismi from cesitler";
			Statement st = connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			

			while(rs.next())
			{
			c.addItem(rs.getString("cesit_ismi"));
			}
			
			

			rs.close();
			st.close();
			connection.close();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
	
		
	
		c.setBounds(467, 174, 135, 26);
		contentPane.add(c);
		
		JLabel lbleitler = new JLabel("\u00C7e\u015Fitler");
		lbleitler.setForeground(new Color(46, 139, 87));
		lbleitler.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lbleitler.setBounds(336, 166, 135, 34);
		contentPane.add(lbleitler);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(34, 139, 34));
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(575, 0, 71, 30);
		contentPane.add(lblNewLabel_1);
		 setLocationRelativeTo(null);
		
		 ShowData();
	}
	
	
	private void ShowData()
	{
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Yemek_id");
		model.addColumn("Cesit_id");
		model.addColumn("Yemek adý");
		model.addColumn("Fiyat");
		
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String query = "Select * from yemekler";
			Statement st = connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			
		
		    
			
			
			
			
			
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("yemek_id"),
						rs.getString("cesit_id"),
						rs.getString("yemek_ismi"),
						rs.getString("fiyat"),
					
						
				});
			}
			rs.close();
			st.close();
			connection.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(185);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			
			
			
			
		
		}catch(Exception e)
		{
			System.out.println("Exc");
		}
		
		
	}
	
	

	private void secilenBul() {
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//driver
	
	
	secilen = (String) c.getSelectedItem();
	try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
		System.out.println("Baþarýyla baðlandý veritabanýna");
    
	String query = "SELECT cesit_id FROM cesitler where cesit_ismi='"+secilen+"'";
	Statement st = connection.createStatement();
	ResultSet rs= st.executeQuery(query);
	while(rs.next())
	{	
	cesit_id=rs.getInt("cesit_id");
	}
	
	System.out.println("Bulunan cesit_id = "+cesit_id);		
	}
         catch (SQLException ep) {
	            JOptionPane.showMessageDialog(null,"Veritabaný hatasým !!!","" ,JOptionPane.WARNING_MESSAGE);
	            
            }
	}
	
	

}
