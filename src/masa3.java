import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class masa3 extends JFrame {

	private JPanel contentPane;
	private int cesit_id=1,sip_id;
	String secilen;
	private JComboBox c;
	private JTable table;
	private JTextField adetField;
	private String yemek_ismi;
	private float fiyat=0,sagAdet,sagFiyat,toplam=0;
	private JTable table2;
	private String sagYemekIsmi;
	private JTextField toplamField;
	private static int sayac=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					masa3 frame = new masa3();
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
	public masa3() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 398, 554);
		contentPane.add(scrollPane);
		
		 c = new JComboBox();
		 c.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 c.setBackground(new Color(255, 255, 255));
		 c.setForeground(new Color(0, 0, 0));
		 c.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		
		 
		 scrollPane.setRowHeaderView(c);
		 
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
			table.getTableHeader().setBackground(new Color(0,191,255));
			table.getTableHeader().setForeground(new Color(255,255,255));
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{null, null},
		 	},
		 	new String[] {
		 		"Yemek_ismi", "Fiyat"
		 	}
		 ));
		 scrollPane.setViewportView(table);
		 
		 JButton btnNewButton = new JButton("Se\u00E7");
		 btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		 
		 
		 comboBoxDoldur();
		
		 
		 
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		comboBox();
		 		ShowData();
		 	
		 		
		 	}
		 });
		 btnNewButton.setBounds(136, 565, 86, 74);
		 contentPane.add(btnNewButton);
		
		 JLabel n1 = new JLabel("1");
		 n1.setOpaque(true);
		 n1.setBounds(447, 164, 60, 59);
		 contentPane.add(n1);
		 n1.setHorizontalAlignment(SwingConstants.CENTER);
		 n1.setForeground(Color.BLACK);
		 n1.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n1.setBackground(Color.WHITE);
		 
		 JLabel n2 = new JLabel("2");
		 n2.setOpaque(true);
		 n2.setHorizontalAlignment(SwingConstants.CENTER);
		 n2.setForeground(Color.BLACK);
		 n2.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n2.setBackground(Color.WHITE);
		 n2.setBounds(537, 164, 60, 59);
		 contentPane.add(n2);
		 
		 JLabel n3 = new JLabel("3");
		 n3.setOpaque(true);
		 n3.setHorizontalAlignment(SwingConstants.CENTER);
		 n3.setForeground(Color.BLACK);
		 n3.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n3.setBackground(Color.WHITE);
		 n3.setBounds(635, 164, 60, 59);
		 contentPane.add(n3);
		 
		 JLabel n4 = new JLabel("4");
		 n4.setOpaque(true);
		 n4.setHorizontalAlignment(SwingConstants.CENTER);
		 n4.setForeground(Color.BLACK);
		 n4.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n4.setBackground(Color.WHITE);
		 n4.setBounds(447, 246, 60, 59);
		 contentPane.add(n4);
		 
		 JLabel n5 = new JLabel("5");
		 n5.setOpaque(true);
		 n5.setHorizontalAlignment(SwingConstants.CENTER);
		 n5.setForeground(Color.BLACK);
		 n5.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n5.setBackground(Color.WHITE);
		 n5.setBounds(537, 246, 60, 59);
		 contentPane.add(n5);
		 
		 JLabel n6 = new JLabel("6");
		 n6.setOpaque(true);
		 n6.setHorizontalAlignment(SwingConstants.CENTER);
		 n6.setForeground(Color.BLACK);
		 n6.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n6.setBackground(Color.WHITE);
		 n6.setBounds(635, 246, 60, 59);
		 contentPane.add(n6);
		 
		 
		 JLabel n7 = new JLabel("7");
		 n7.setOpaque(true);
		 n7.setHorizontalAlignment(SwingConstants.CENTER);
		 n7.setForeground(Color.BLACK);
		 n7.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n7.setBackground(Color.WHITE);
		 n7.setBounds(447, 335, 60, 59);
		 contentPane.add(n7);
		 
		 JLabel n8 = new JLabel("8");
		 n8.setOpaque(true);
		 n8.setHorizontalAlignment(SwingConstants.CENTER);
		 n8.setForeground(Color.BLACK);
		 n8.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n8.setBackground(Color.WHITE);
		 n8.setBounds(537, 335, 60, 59);
		 contentPane.add(n8);
		 
		 JLabel n9 = new JLabel("9");
		 n9.setOpaque(true);
		 n9.setHorizontalAlignment(SwingConstants.CENTER);
		 n9.setForeground(Color.BLACK);
		 n9.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		 n9.setBackground(Color.WHITE);
		 n9.setBounds(635, 335, 60, 59);
		 contentPane.add(n9);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setOpaque(true);
		 lblNewLabel.setBackground(new Color(0, 191, 255));
		 lblNewLabel.setBounds(437, 156, 271, 250);
		 contentPane.add(lblNewLabel);
		 
		 adetField = new JTextField();
		 adetField.setHorizontalAlignment(SwingConstants.CENTER);
		 adetField.setOpaque(false);
		 adetField.setForeground(new Color(255, 0, 0));
		 adetField.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 15));
		 adetField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 adetField.setBounds(456, 450, 86, 40);
		 contentPane.add(adetField);
		 adetField.setColumns(10);
		 
		 JLabel lblNewLabel_1 = new JLabel("Adet");
		 lblNewLabel_1.setForeground(new Color(30, 144, 255));
		 lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		 lblNewLabel_1.setBounds(466, 425, 58, 39);
		 contentPane.add(lblNewLabel_1);
		 
		 JButton btnKaytEt = new JButton("Ekle");
		 btnKaytEt.setForeground(new Color(0, 128, 0));
		 btnKaytEt.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Random r=new Random(); //random sýnýfý
		 		
		 		if(adetField.getText().equals(""))
		 		{
		 			  JOptionPane.showMessageDialog(null,"Lütfen adet kýsmýný doldurunuz !!!","Adet Seçilmedi" ,JOptionPane.WARNING_MESSAGE); 
		 		}
		 		else if(fiyat==0)
		 		{
		 			 JOptionPane.showMessageDialog(null,"Lütfen sol taraftan eklenecek yemeði seçiniz !!!","Yemek Seçilmedi" ,JOptionPane.WARNING_MESSAGE); 
		 			
		 		}
		 		else
		 		{
		 			
					try {
						Class.forName("org.postgresql.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//driver
					
					try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
						System.out.println("Baþarýyla baðlandý veritabanýna");
						
						sip_id=r.nextInt(10000);
						while(kontrolEt(sip_id)!=0) {
							sip_id=r.nextInt(10000);
						}
				   
				
					String sql = "INSERT into masalar values (?,?,?,?,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
					int adet= Integer.parseInt(adetField.getText());
					preparedStatement.setInt(1, sip_id);
					preparedStatement.setInt(2, 3);
					preparedStatement.setInt(3, adet);
					preparedStatement.setString(4, yemek_ismi);
					preparedStatement.setFloat(5, fiyat);
					 preparedStatement.executeUpdate();
					 connection.close();
					 
					 ShowDataSag();
				
					 
							
					
				            } 
		 			catch (SQLException ep) {
					            JOptionPane.showMessageDialog(null,"Veritabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
					            
				            }
						catch(Exception eb)
						{
							System.out.println("Exc");
						}
		 			
		 			
		 			
		 		}
		 			
		 			
		 			
		 			
		 		
		 	}
		 });
		 btnKaytEt.setIcon(new ImageIcon(masa1.class.getResource("/ekle.png")));
		 btnKaytEt.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		 btnKaytEt.setBounds(580, 447, 106, 45);
		 contentPane.add(btnKaytEt);
		 
		 JButton btnSil = new JButton("\u00C7\u0131kart");
		 btnSil.setForeground(new Color(255, 0, 0));
		 btnSil.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException ed) {
					ed.printStackTrace();
				}//driver
				try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
		            {
					String sql = "DELETE from masalar where sip_id=?";
					PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
					preparedStatement.setInt(1,sip_id);
					 preparedStatement.executeUpdate();
					 connection.close();		
					
					 DefaultTableModel model = (DefaultTableModel)table2.getModel();
					 model.setRowCount(0);
					 ShowDataSag();//Refresh
		            }
				catch(SQLException es)
				{
					JOptionPane.showMessageDialog(null,"Veri Tabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
				}
		 		
		 		
		 		
		 	}
		 });
		 btnSil.setIcon(new ImageIcon(masa1.class.getResource("/close.png")));
		 btnSil.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		 btnSil.setBounds(845, 618, 106, 45);
		 contentPane.add(btnSil);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(746, 0, 398, 554);
		 contentPane.add(scrollPane_1);
		 
		 table2 = new JTable();
		 table2.setForeground(new Color(0, 0, 0));
			table2.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
			table2.setShowGrid(false);
			table2.setShowVerticalLines(false);
			table2.setSelectionBackground(new Color(232, 57, 95));
			table2.setRowHeight(25);
			table2.setIntercellSpacing(new Dimension(0, 0));
			
			table2.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
			table2.getTableHeader().setOpaque(false);
			table2.getTableHeader().setBackground(new Color(0,191,255));
			table2.getTableHeader().setForeground(new Color(255,255,255));
		 scrollPane_1.setViewportView(table2);
		 
		 JButton btnGeri = new JButton("Geri");
		 btnGeri.setForeground(new Color(255, 165, 0));
		 btnGeri.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		garsonMenu g = new garsonMenu();
		 		g.setVisible(true);
		 		dispose();
		 	}
		 });
		 btnGeri.setIcon(new ImageIcon(masa1.class.getResource("/return.png")));
		 btnGeri.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		 btnGeri.setBounds(518, 618, 106, 45);
		 contentPane.add(btnGeri);
		 
		 JButton btnNewButton_1 = new JButton("Hesab\u0131 Kapat");
		 btnNewButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		masaKapat();
		 		
		 		
		 		
		 	}
		 });
		 btnNewButton_1.setBounds(1011, 620, 106, 45);
		 contentPane.add(btnNewButton_1);
		 
		 toplamField = new JTextField();
		 toplamField.setForeground(new Color(0, 0, 0));
		 toplamField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 0, 0)));
		 toplamField.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		 toplamField.setBounds(977, 565, 98, 31);
		 contentPane.add(toplamField);
		 toplamField.setColumns(10);
		 
		 JLabel lblNewLabel_1_1 = new JLabel("Toplam");
		 lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		 lblNewLabel_1_1.setBounds(881, 565, 194, 31);
		 contentPane.add(lblNewLabel_1_1);
		 
		 JPanel panel_2 = new JPanel();
		 panel_2.setLayout(null);
		 panel_2.setForeground(Color.GRAY);
		 panel_2.setBackground(new Color(255, 99, 71));
		 panel_2.setBounds(396, 0, 351, 48);
		 contentPane.add(panel_2);
		 
		 JLabel lblMasa = new JLabel("MASA 3");
		 lblMasa.setHorizontalAlignment(SwingConstants.CENTER);
		 lblMasa.setForeground(Color.WHITE);
		 lblMasa.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		 lblMasa.setBounds(56, 0, 251, 47);
		 panel_2.add(lblMasa);
		 
		 JLabel profil = new JLabel("a");
		 profil.setForeground(Color.WHITE);
		 profil.setFont(new Font("Segoe UI Historic", Font.BOLD, 10));
		 profil.setBounds(542, 11, 98, 47);
		 panel_2.add(profil);
		 setLocationRelativeTo(null);
		 n1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n1);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n1);
				}
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		adetField.setText("1");
		 	}
			});
		 n2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n2);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n2);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("2");
				}
				
			});
		 n3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n3);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n3);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("3");
				}
			});
		 n4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n4);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n4);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("4");
				}
			});
		 n5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n5);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n5);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("5");
				}
			});
		 n6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n6);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n6);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("6");
				}
			});
		 n7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n7);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n7);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("7");
				}
			});
		 n8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n8);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n8);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("8");
				}
			});
		 
		 n9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setColor(n9);
						
				}
				@Override
				public void mouseExited(MouseEvent e) {
					resetColor(n9);
				}
				@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		adetField.setText("9");
				}
			});
		 
		 table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
			
						int row = table.getSelectedRow();
						 yemek_ismi =(table.getModel().getValueAt(row, 0).toString());
						 fiyat =Float.parseFloat(((table.getModel().getValueAt(row, 1).toString())));
						System.out.println(yemek_ismi+fiyat);
				}
					
				
			});
		 
		 table2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
			
						int row = table2.getSelectedRow();
					     sip_id=Integer.parseInt((table2.getModel().getValueAt(row, 0).toString()));
						 sagAdet =Integer.parseInt((table2.getModel().getValueAt(row, 1).toString()));
						 sagYemekIsmi = (table2.getModel().getValueAt(row, 2).toString());
						 sagFiyat =Float.parseFloat(((table2.getModel().getValueAt(row, 3).toString())));
				
				}
					
				
			});
		 
		 
		 
		 
		 
		 
			
			
	ShowDataSag();
		
	
		
	}
	private void masaKapat()
	{
		if(toplam!=0) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ed) {
			ed.printStackTrace();
		}//driver
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1"))
            {
			String sql = "DELETE from masalar where masa_id=3";
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			 preparedStatement.executeUpdate();
			 connection.close();		
			 DefaultTableModel model = (DefaultTableModel)table2.getModel();
			 model.setRowCount(0);
			 ShowDataSag();//Refresh
            }
		catch(SQLException es)
		{
			JOptionPane.showMessageDialog(null,"Veri Tabaný hatasý !!!","" ,JOptionPane.WARNING_MESSAGE);
		}
		JOptionPane.showMessageDialog(null,"Hesap Ödemesi Baþarýlý.","HESAP ÖDENDÝ" ,JOptionPane.INFORMATION_MESSAGE);
		}
		else
		JOptionPane.showMessageDialog(null,"Masaya bir þey eklenmedi !!!","MASA BOÞ" ,JOptionPane.WARNING_MESSAGE);
	}
	
	private void ShowData()
	{
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Yemek ismi");
		model.addColumn("Fiyat");
		
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String query = "Select yemek_ismi,fiyat from yemekler where cesit_id="+cesit_id;
			Statement st = connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] {
						
						rs.getString("yemek_ismi"),
						rs.getString("fiyat"),
				});
			}
			table.setModel(model);
			rs.close();
			st.close();
			connection.close();
			
					
		
		}catch(SQLException e)
		{
			System.out.println("SQL HATA");
		}
		catch(Exception e)
		{
			System.out.println("SQL HATA");
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
		ShowData();
		
		
		System.out.println("Bulunan cesit_id = "+cesit_id);		
		}
	         catch (SQLException ep) {
		            JOptionPane.showMessageDialog(null,"Veritabaný hatasým !!!","" ,JOptionPane.WARNING_MESSAGE);
		            
	            }
		}
	private void comboBoxDoldur()
	{
		
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
	}


private void comboBox()
{
	try {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
		
		String query = "select cesit_ismi from cesitler";
		Statement st = connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		
		
		while(rs.next())
		{
	//c.addItem(rs.getString("cesit_ismi"));
	}
		 secilenBul();
		
		

		rs.close();
		st.close();
		connection.close();
		
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
public void setColor(JLabel p)
{
p.setBackground(new Color(192,192,192));
}
public void resetColor(JLabel p)
{
p.setBackground(new Color(255,255,255));
}

private void ShowDataSag()
{
	
	DefaultTableModel model = new DefaultTableModel();
	model.addColumn("Sipariþ_id");
	model.addColumn("Adet");
	model.addColumn("Yemek ismi");
	model.addColumn("Fiyat");
	
	
	
	
	try {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
		String query = "Select sip_id,adet,yemek_ismi,fiyat from masalar where masa_id="+3;
		Statement st = connection.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next())
		{
			model.addRow(new Object[] {
					rs.getString("sip_id"),
					rs.getString("adet"),
					rs.getString("yemek_ismi"),
					rs.getString("fiyat"),
			});
		}
		table2.setModel(model);
		rs.close();
		st.close();
		connection.close();
				
	
	}catch(SQLException e)
	{
		System.out.println("SQL HATA");
	}
	catch(Exception e)
	{
		System.out.println("SQL HATA");
	}
	toplamField.setText(String.valueOf(hesapBul()));
	
}

private int kontrolEt(int sip_idr)
{
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//driver
	
	
	
	try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
		System.out.println("Baþarýyla baðlandý veritabanýna");
  
	String sqlArama = "SELECT * FROM masalar where sip_id=?";
	PreparedStatement pst = connection.prepareStatement(sqlArama);
	pst.setInt(1, sip_idr);
	ResultSet rs = pst.executeQuery();
	if(rs.next()) {
		
		return 1;
	}
	else return 0;
	}
	catch(SQLException e)
	{
		System.out.println("exc");
	}
	return 0;
	
	
	
}
private float hesapBul()
{
	 
	try {
	Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}//driver



try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1")) {
	String query = "select SUM(masalar.adet*masalar.fiyat) as toplam from masalar where masa_id=3";
	Statement st = connection.createStatement();
	ResultSet rs= st.executeQuery(query);
	while(rs.next())
	{
		
				toplam=rs.getFloat("toplam");
				
		
	}	
	
}
catch(SQLException e)
{
	System.out.println("exc");
}
	return toplam;
}
}
