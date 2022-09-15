import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class calisanGoster extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel calisanField,maxMaasField,toplamMaasField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calisanGoster frame = new calisanGoster();
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
	public calisanGoster() {
		setUndecorated(true);
		setTitle("\u00C7al\u0131\u015Fanlar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 59, 907, 291);
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
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"user_id", "Role_id", "username", "\u015Eifre", "Ad", "Soyad", "Mail", "Cinsiyet", "Telefon", "Maa\u015F"
				}
			));
		scrollPane.setViewportView(table);
		
		calisanField = new JLabel("Toplam \u00C7al\u0131\u015Fan :");
		calisanField.setForeground(new Color(147, 112, 219));
		calisanField.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		calisanField.setBounds(253, 384, 205, 38);
		contentPane.add(calisanField);
		
	   toplamMaasField = new JLabel("Toplam Maa\u015F :");
	   toplamMaasField.setForeground(new Color(147, 112, 219));
		toplamMaasField.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		toplamMaasField.setBounds(253, 444, 205, 38);
		contentPane.add(toplamMaasField);
		
		JLabel lblEkle = new JLabel("Ekle");
		lblEkle.setForeground(new Color(221, 160, 221));
	
		lblEkle.setIcon(new ImageIcon(calisanGoster.class.getResource("/add.png")));
		lblEkle.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblEkle.setBounds(732, 362, 101, 61);
		contentPane.add(lblEkle);
		
		JLabel lblkar = new JLabel("\u00C7\u0131kar");
		lblkar.setForeground(new Color(0, 191, 255));
		
		lblkar.setIcon(new ImageIcon(calisanGoster.class.getResource("/delete.png")));
		lblkar.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblkar.setBounds(732, 431, 101, 61);
		contentPane.add(lblkar);
		
		JLabel lblGncelle = new JLabel("G\u00FCncelle");
		lblGncelle.setForeground(new Color(147, 112, 219));
	
		lblGncelle.setIcon(new ImageIcon(calisanGoster.class.getResource("/update.png")));
		lblGncelle.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblGncelle.setBounds(732, 503, 127, 62);
		contentPane.add(lblGncelle);
		
		 maxMaasField = new JLabel("En Y\u00FCksek Maa\u015F:");
		 maxMaasField.setForeground(new Color(147, 112, 219));
		maxMaasField.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		maxMaasField.setBounds(253, 493, 306, 38);
		contentPane.add(maxMaasField);
		
		JLabel lblNewLabel_1 = new JLabel("Kapat");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(46, 139, 87));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(828, 0, 74, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Geri");
	
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 140, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(418, 601, 82, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel calisanField_1 = new JLabel("Toplam \u00C7al\u0131\u015Fan :");
		calisanField_1.setForeground(new Color(147, 112, 219));
		calisanField_1.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		calisanField_1.setBounds(57, 384, 205, 38);
		contentPane.add(calisanField_1);
		
		JLabel calisanField_2 = new JLabel("Toplam Maa\u015F :");
		calisanField_2.setForeground(new Color(147, 112, 219));
		calisanField_2.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		calisanField_2.setBounds(57, 444, 205, 38);
		contentPane.add(calisanField_2);
		
		JLabel calisanField_3 = new JLabel("En Y\u00FCksek Maa\u015F :");
		calisanField_3.setForeground(new Color(147, 112, 219));
		calisanField_3.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		calisanField_3.setBounds(57, 493, 205, 38);
		contentPane.add(calisanField_3);
		
		JLabel lblPersonelBlgler = new JLabel("PERSONEL BILGILERI");
		lblPersonelBlgler.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonelBlgler.setForeground(new Color(0, 128, 128));
		lblPersonelBlgler.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		lblPersonelBlgler.setBounds(300, 1, 306, 47);
		contentPane.add(lblPersonelBlgler);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(0, 0, 899, 648);
		contentPane.add(lblNewLabel);
		
		JLabel eklex = new JLabel("");
		eklex.setBackground(new Color(221, 160, 221));
		eklex.setOpaque(true);
		eklex.setBounds(770, 410, 35, 5);
		contentPane.add(eklex);
		
		JLabel cikarx = new JLabel("");
		cikarx.setOpaque(true);
		cikarx.setBackground(new Color(0, 191, 255));
		cikarx.setBounds(770, 477, 46, 5);
		contentPane.add(cikarx);
		
		JLabel guncellex = new JLabel("");
		guncellex.setOpaque(true);
		guncellex.setBackground(new Color(186, 85, 211));
		guncellex.setBounds(770, 547, 83, 5);
		contentPane.add(guncellex);
		
		JLabel gerix = new JLabel("");
		gerix.setOpaque(true);
		gerix.setBackground(new Color(255, 140, 0));
		gerix.setBounds(441, 632, 40, 5);
		contentPane.add(gerix);
		setLocationRelativeTo(null);
		maasGoster();
		toplamCalisan();
		ShowData();
		maxMaas();
		eklex.setVisible(false);
		cikarx.setVisible(false);
		guncellex.setVisible(false);
		gerix.setVisible(false);
		
		lblEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KayýtOlma k = new KayýtOlma();
				k.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				eklex.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				eklex.setVisible(false);
			}
		});
	
		
		lblkar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				istenCikarma i = new istenCikarma();
				i.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				cikarx.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				cikarx.setVisible(false);
			}
			
		});
		
		lblGncelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				calisanGuncelle c = new calisanGuncelle();
				c.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				guncellex.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				guncellex.setVisible(false);
			}
			
		});
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu m = new Menu();
				
				m.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				gerix.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				gerix.setVisible(false);
			}
		});
		
		
		
		
		
		
		
		
	}
	private void maasGoster()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String sql = "select sum(maas) from users";
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rse= sta.executeQuery();
			if(rse.next()) {
			String ekle=rse.getString(1);
			toplamMaasField.setText(ekle);
		
			}


		
	
	}catch(Exception e)
	{
		System.out.println("Exceptioooooooon");

	}
	}
	private void maxMaas()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String sql = "SELECT fname,lname, max(maas) from users where maas=(select max(maas) from users) group by fname,lname";
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rse= sta.executeQuery();
			if(rse.next()) {
			String ekle=rse.getString(1);
			String ekle2=rse.getString(2);
			String ekle3=rse.getString(3);
			maxMaasField.setText(ekle+" "+ekle2+" "+ekle3+" TL");
		
			}


		
	
	}catch(Exception e)
	{
		System.out.println("Exceptioooooooon");

	}
	}
	private void toplamCalisan()
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String sql = "select count(user_id) from users";
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rse= sta.executeQuery();
			if(rse.next()) {
			String ekle=rse.getString(1);
			calisanField.setText(ekle);
			}


		
	
	}catch(Exception e)
	{
		System.out.println("Exceptioooooooon");

	}
	}
		
	private void ShowData()
	{
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("User_id");
		model.addColumn("Role_id");
		model.addColumn("Username");
		model.addColumn("Þifre");
		model.addColumn("Ad");
		model.addColumn("Soyad");
		model.addColumn("Mail");
		model.addColumn("Cinsiyet");
		model.addColumn("Telefon");
		model.addColumn("Maaþ");
		
		
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
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			table.getColumnModel().getColumn(1).setPreferredWidth(90);
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			table.getColumnModel().getColumn(4).setPreferredWidth(90);
			table.getColumnModel().getColumn(5).setPreferredWidth(90);
			table.getColumnModel().getColumn(6).setPreferredWidth(112);
			table.getColumnModel().getColumn(7).setPreferredWidth(90);
			table.getColumnModel().getColumn(8).setPreferredWidth(90);
			table.getColumnModel().getColumn(9).setPreferredWidth(90);
			
			
			
		
		}catch(Exception e)
		{
			System.out.println("Exc");
		}
		
		
	}
}
