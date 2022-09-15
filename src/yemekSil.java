import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class yemekSil extends JFrame {

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
					yemekSil frame = new yemekSil();
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
	public yemekSil() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(255, 255, 255));
		contentPane_1.setBounds(0, 0, 792, 430);
		contentPane.add(contentPane_1);
		
		JLabel id = new JLabel("Yemek id");
		id.setForeground(new Color(147, 112, 219));
		id.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		id.setBounds(179, 358, 89, 23);
		contentPane_1.add(id);
		
		yemekField = new JTextField();
		yemekField.setForeground(new Color(240, 128, 128));
		yemekField.setOpaque(false);
		yemekField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 140, 0)));
		yemekField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		yemekField.setColumns(10);
		yemekField.setBounds(167, 383, 86, 20);
		contentPane_1.add(yemekField);
		
		adField = new JTextField();
		adField.setForeground(new Color(240, 128, 128));
		adField.setOpaque(false);
		adField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 140, 0)));
		adField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		adField.setColumns(10);
		adField.setBounds(343, 383, 116, 20);
		contentPane_1.add(adField);
		
		JLabel add = new JLabel("Yemek ad\u0131");
		add.setForeground(new Color(147, 112, 219));
		add.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add.setBounds(359, 358, 116, 23);
		contentPane_1.add(add);
		
		JLabel fiyatdd = new JLabel("Fiyat");
		fiyatdd.setForeground(new Color(147, 112, 219));
		fiyatdd.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		fiyatdd.setBounds(548, 358, 70, 23);
		contentPane_1.add(fiyatdd);
		
		fiyatField = new JTextField();
		fiyatField.setForeground(new Color(240, 128, 128));
		fiyatField.setOpaque(false);
		fiyatField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 140, 0)));
		fiyatField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		fiyatField.setColumns(10);
		fiyatField.setBounds(532, 383, 86, 20);
		contentPane_1.add(fiyatField);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setForeground(new Color(255, 0, 0));
		btnSil.setIcon(new ImageIcon(yemekSil.class.getResource("/close.png")));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(    yemekField.getText().equals("")||
						adField.getText().equals("")||
						fiyatField.getText().equals("")
					) {
						JOptionPane.showMessageDialog(null,"Lütfen tüm alanlarý doldurun !!!","" ,JOptionPane.WARNING_MESSAGE);
						
					}
					else {
					try {
						Class.forName("org.postgresql.Driver");
					} catch (ClassNotFoundException ed) {
						ed.printStackTrace();
					}//driver
					try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
			            {
						String sql = "DELETE from yemekler where yemek_id=?";
						PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
						preparedStatement.setInt(1,Integer.parseInt(yemekField.getText()));
						 preparedStatement.executeUpdate();
						 connection.close();		
						 JOptionPane.showMessageDialog(null,adField.getText()+" adlý yemek baþarýyla silindi.","" ,JOptionPane.INFORMATION_MESSAGE);
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
		});
		btnSil.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnSil.setBounds(665, 152, 106, 45);
		contentPane_1.add(btnSil);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setForeground(new Color(255, 140, 0));
		btnGeri.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnGeri.setIcon(new ImageIcon(yemekSil.class.getResource("/return.png")));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yemekler y = new Yemekler();
				y.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(665, 243, 106, 45);
		contentPane_1.add(btnGeri);
		
		JLabel lblYemekler_1 = new JLabel("YEMEK SIL");
		lblYemekler_1.setForeground(new Color(34, 139, 34));
		lblYemekler_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		lblYemekler_1.setBounds(290, -4, 134, 47);
		contentPane_1.add(lblYemekler_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 635, 293);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(240,128,128));
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
		
		cesitField = new JTextField();
		cesitField.setForeground(new Color(240, 128, 128));
		cesitField.setOpaque(false);
		cesitField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 140, 0)));
		cesitField.setFont(new Font("Segoe UI Light", Font.ITALIC, 15));
		cesitField.setColumns(10);
		cesitField.setBounds(30, 383, 86, 20);
		contentPane_1.add(cesitField);
		
		JLabel lblCeitid = new JLabel("Cesit id");
		lblCeitid.setForeground(new Color(147, 112, 219));
		lblCeitid.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblCeitid.setBounds(44, 358, 89, 23);
		contentPane_1.add(lblCeitid);
		
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
		lblNewLabel_1.setBounds(721, 7, 71, 30);
		contentPane_1.add(lblNewLabel_1);
		 setLocationRelativeTo(null);
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
							adField.setEditable(false);
							fiyatField.setEditable(false);
							
							
							
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
