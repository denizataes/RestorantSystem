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

public class cesitEkle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField adField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cesitEkle frame = new cesitEkle();
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
	public cesitEkle() {
		setUndecorated(true);
		setTitle("\u00C7e\u015Fitler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 55, 236, 246);
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
		idField.setBounds(148, 99, 86, 20);
		contentPane.add(idField);
		
		JLabel lblCesitId = new JLabel("Cesit id");
		lblCesitId.setForeground(new Color(0, 139, 139));
		lblCesitId.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblCesitId.setBounds(10, 90, 96, 27);
		contentPane.add(lblCesitId);
		
		adField = new JTextField();
		adField.setFont(new Font("Segoe UI Light", Font.ITALIC, 20));
		adField.setForeground(new Color(0, 139, 139));
		adField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 99, 71)));
		adField.setColumns(10);
		adField.setBounds(148, 156, 86, 20);
		contentPane.add(adField);
		
		JLabel lblCesitAd = new JLabel("Cesit ad\u0131");
		lblCesitAd.setForeground(new Color(0, 139, 139));
		lblCesitAd.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblCesitAd.setBounds(10, 147, 106, 27);
		contentPane.add(lblCesitAd);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setForeground(new Color(255, 127, 80));
		btnGeri.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnGeri.setIcon(new ImageIcon(cesitEkle.class.getResource("/return.png")));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Yemekler y = new Yemekler();
				y.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(84, 255, 106, 45);
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
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//driver
			
			try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
				System.out.println("Baþarýyla baðlandý veritabanýna");
		    String ad = adField.getText();
			int ID = Integer.parseInt(idField.getText());
			String sqlArama = "SELECT * FROM cesitler where cesit_id=?";
			PreparedStatement pst = connection.prepareStatement(sqlArama);
			pst.setInt(1, ID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				JOptionPane.showMessageDialog(null, "Ayný ID'ye sahip baþka bir çeþit yemek var, Lütfen tekrar deneyin","HATA",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				
			String sql = "INSERT into cesitler values (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, ID);
			preparedStatement.setString(2, ad);
			 preparedStatement.executeUpdate();
			 connection.close();
			 JOptionPane.showMessageDialog(null,ad+" adlý yemek çeþidi baþarýyla kaydedildi.","" ,JOptionPane.INFORMATION_MESSAGE);	
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
		btnKaytEt.setIcon(new ImageIcon(cesitEkle.class.getResource("/ekle.png")));
		btnKaytEt.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnKaytEt.setBounds(148, 199, 106, 45);
		contentPane.add(btnKaytEt);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setForeground(new Color(135, 206, 235));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			sil();
				
				
				
				
			}
		});
		btnSil.setIcon(new ImageIcon(cesitEkle.class.getResource("/delete.png")));
		btnSil.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		btnSil.setBounds(20, 199, 106, 45);
		contentPane.add(btnSil);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.GRAY);
		panel_2.setBackground(new Color(255, 99, 71));
		panel_2.setBounds(0, 0, 506, 55);
		contentPane.add(panel_2);
		
		JLabel lblYemekler_1 = new JLabel("CESITLER");
		lblYemekler_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYemekler_1.setForeground(Color.WHITE);
		lblYemekler_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 25));
		lblYemekler_1.setBounds(184, 5, 134, 47);
		panel_2.add(lblYemekler_1);
		
		JLabel profil = new JLabel("a");
		profil.setForeground(Color.WHITE);
		profil.setFont(new Font("Segoe UI Historic", Font.BOLD, 10));
		profil.setBounds(542, 11, 98, 47);
		panel_2.add(profil);
		
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
		lblNewLabel_1.setBounds(435, 0, 71, 30);
		panel_2.add(lblNewLabel_1);
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
						String sql = "SELECT * FROM cesitler where cesit_id='"+Table_click+"' ";
						PreparedStatement pst = connection.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						if(rs.next()) {
							String add1=rs.getString("cesit_id");
							idField.setText(add1);
							String add2=rs.getString("cesit_ismi");
							adField.setText(add2);
							
							
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
		model.addColumn("cesit_id");
		model.addColumn("cesit_ismi");
		
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String query = "Select * from cesitler";
			Statement st = connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			
		
		    
			
			
			
			
			
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("cesit_id"),
						rs.getString("cesit_ismi"),
				
						
				});
			}
			rs.close();
			st.close();
			connection.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(73);
			table.getColumnModel().getColumn(1).setPreferredWidth(143);
		
			
			
			
		
		}catch(Exception e)
		{
			System.out.println("Exc");
		}
		
		
	}
	private void sil()
	{
		if(    adField.getText().equals("")||
				idField.getText().equals("")
				
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
				String sql = "DELETE from cesitler where cesit_id=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
				preparedStatement.setInt(1,Integer.parseInt(idField.getText()));
				 preparedStatement.executeUpdate();
				 connection.close();		
				 JOptionPane.showMessageDialog(null,adField.getText()+" adlý yemek çeþidi baþarýyla silindi.","" ,JOptionPane.INFORMATION_MESSAGE);
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
}
