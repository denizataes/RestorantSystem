import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class yemekGuncelle extends JFrame {

	private JPanel contentPane;
	private JTextField yemekField;
	private JTextField adField;
	private JTextField fiyatField;
	private JTable table;
	private JTextField cesitField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yemekGuncelle frame = new yemekGuncelle();
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
	public yemekGuncelle() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(255, 255, 255));
		contentPane_1.setBounds(0, 0, 809, 436);
		contentPane.add(contentPane_1);
		
		JLabel id = new JLabel("Yemek id");
		id.setForeground(new Color(255, 0, 0));
		id.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		id.setBounds(197, 358, 78, 30);
		contentPane_1.add(id);
		
		yemekField = new JTextField();
		yemekField.setForeground(new Color(0, 206, 209));
		yemekField.setOpaque(false);
		yemekField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 206, 209)));
		yemekField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		yemekField.setColumns(10);
		yemekField.setBounds(200, 383, 86, 20);
		contentPane_1.add(yemekField);
		
		adField = new JTextField();
		adField.setForeground(new Color(0, 206, 209));
		adField.setOpaque(false);
		adField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 206, 209)));
		adField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		adField.setColumns(10);
		adField.setBounds(363, 383, 117, 20);
		contentPane_1.add(adField);
		
		JLabel add = new JLabel("Yemek ad\u0131");
		add.setForeground(new Color(255, 0, 0));
		add.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add.setBounds(376, 358, 89, 30);
		contentPane_1.add(add);
		
		JLabel fiyatdd = new JLabel("Fiyat");
		fiyatdd.setForeground(new Color(255, 0, 0));
		fiyatdd.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		fiyatdd.setBounds(584, 358, 78, 30);
		contentPane_1.add(fiyatdd);
		
		fiyatField = new JTextField();
		fiyatField.setForeground(new Color(0, 206, 209));
		fiyatField.setOpaque(false);
		fiyatField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 206, 209)));
		fiyatField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		fiyatField.setColumns(10);
		fiyatField.setBounds(572, 383, 86, 20);
		contentPane_1.add(fiyatField);
		
		JButton guncelle = new JButton("G\u00FCncelle");
		guncelle.setForeground(new Color(186, 85, 211));
		guncelle.setIcon(new ImageIcon(yemekGuncelle.class.getResource("/update.png")));
		guncelle.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		guncelle.setBounds(665, 152, 116, 45);
		contentPane_1.add(guncelle);
		yemekField.setEditable(false);
		
		guncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}//driver
				try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
		            {
					
					
					  String ad = adField.getText();
						Float fiyat = Float.parseFloat(fiyatField.getText());
						int ID = Integer.parseInt(yemekField.getText());
						int cesitID = Integer.parseInt(cesitField.getText());
					String sql = "UPDATE yemekler SET yemek_id='"+ID+"',cesit_id='"+cesitID+"',yemek_ismi='"+ad+"',fiyat='"+fiyat+"'where yemek_id='"+ID+"'";
				//	String sqlArama = "SELECT * FROM yemekler where yemek_id=?";
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
					 
					 JOptionPane.showMessageDialog(null,ad+" adlý yemek baþarýyla güncellendi.","" ,JOptionPane.INFORMATION_MESSAGE);	
					 DefaultTableModel model = (DefaultTableModel)table.getModel();
					 model.setRowCount(0);
					 ShowData();//Refresh
		            }
				catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null,"Veri Tabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			
		}});
		
		
		
		
		
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setForeground(new Color(255, 140, 0));
		btnGeri.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnGeri.setIcon(new ImageIcon(yemekGuncelle.class.getResource("/return.png")));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yemekler y = new Yemekler();
				y.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(665, 243, 116, 45);
		contentPane_1.add(btnGeri);
		
		JLabel lblYemekler_1 = new JLabel("YEMEK GUNCELLE");
		lblYemekler_1.setForeground(new Color(255, 99, 71));
		lblYemekler_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		lblYemekler_1.setBounds(237, 0, 311, 47);
		contentPane_1.add(lblYemekler_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 635, 293);
		contentPane_1.add(scrollPane);
		
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
				"yemek_id","cesit_id", "Yemek ad\u0131", "Fiyat"
			}
		));
		scrollPane.setViewportView(table);
		
		cesitField = new JTextField();
		cesitField.setForeground(new Color(0, 206, 209));
		cesitField.setOpaque(false);
		cesitField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 206, 209)));
		cesitField.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		cesitField.setEditable(false);
		cesitField.setColumns(10);
		cesitField.setBounds(38, 383, 86, 20);
		contentPane_1.add(cesitField);
		
		JLabel lblCesitId = new JLabel("Cesit id");
		lblCesitId.setForeground(new Color(255, 0, 0));
		lblCesitId.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblCesitId.setBounds(51, 358, 56, 30);
		contentPane_1.add(lblCesitId);
		
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
		lblNewLabel_1.setBounds(738, 0, 71, 30);
		contentPane_1.add(lblNewLabel_1);
		
		JTextPane txtpnGncellemekIstediinizYemei = new JTextPane();
		txtpnGncellemekIstediinizYemei.setText("G\u00FCncellemek istedi\u011Finiz yeme\u011Fi a\u015Fa\u011F\u0131da se\u00E7tikten sonra g\u00FCncellemek istedi\u011Finiz de\u011Feri de\u011Fi\u015Ftirip g\u00FCncelle tu\u015Funa bas\u0131n\u0131z.");
		txtpnGncellemekIstediinizYemei.setRequestFocusEnabled(false);
		txtpnGncellemekIstediinizYemei.setForeground(Color.GRAY);
		txtpnGncellemekIstediinizYemei.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		txtpnGncellemekIstediinizYemei.setEditable(false);
		txtpnGncellemekIstediinizYemei.setBackground(Color.WHITE);
		txtpnGncellemekIstediinizYemei.setBounds(471, 0, 208, 58);
		contentPane_1.add(txtpnGncellemekIstediinizYemei);
		
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
						String sql = "SELECT * FROM yemekler where yemek_id='"+Table_click+"' ";
						PreparedStatement pst = connection.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							String add1=rs.getString("yemek_id");
							yemekField.setText(add1);
							String add2=rs.getString("cesit_id");
							cesitField.setText(add2);
							String add3=rs.getString("yemek_ismi");
							adField.setText(add3);
							Float add4=rs.getFloat("fiyat");
							fiyatField.setText(String.valueOf(add4));
							cesitField.setEditable(false);
							yemekField.setEditable(false);
							
							
							
						}
						
							
							
						}catch(SQLException e)
						{
						System.out.println("exc");
						}
						
					}
					catch(Exception e) {
						System.out.println("Hata");
						
					}
					
					
					
					
					
					
				}
			});
		
		
		
		
		 setLocationRelativeTo(null);
		 ShowData();
	}
	
	
	private void ShowData()
	{
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("yemek_id");
		model.addColumn("cesit_id");
		model.addColumn("Yemek Ýsmi");
		model.addColumn("Fiyat");
		
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String query = "Select *from yemekler";
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
			table.getColumnModel().getColumn(0).setPreferredWidth(190);
			table.getColumnModel().getColumn(1).setPreferredWidth(190);
			table.getColumnModel().getColumn(2).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(200);
			
			
			
			
		
		}catch(Exception e)
		{
			System.out.println("Exc");
		}
		
		
	}
}
