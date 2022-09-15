import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Yemekler extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yemekler frame = new Yemekler();
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
	public Yemekler() {
		setUndecorated(true);
		setTitle("Yemekler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		scrollPane.setBounds(264, 69, 637, 590);
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
				"Yemek_id", "Yemek Ad\u0131", "Fiyat"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
	  
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 69, 268, 590);
		contentPane.add(panel);
		
		JLabel lblYemekler = new JLabel("Yemek Sil");
		lblYemekler.setIcon(new ImageIcon(Yemekler.class.getResource("/deletefood.png")));
	
		lblYemekler.setForeground(new Color(30, 144, 255));
		lblYemekler.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblYemekler.setBounds(25, 291, 191, 47);
		panel.add(lblYemekler);
		
		JLabel lblCalsanlar = new JLabel("Yemek Ekle");
	
		lblCalsanlar.setIcon(new ImageIcon(Yemekler.class.getResource("/addfood.png")));
		lblCalsanlar.setForeground(new Color(30, 144, 255));
		lblCalsanlar.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblCalsanlar.setBounds(25, 94, 191, 47);
		panel.add(lblCalsanlar);
		
		JLabel lblIstenCkar = new JLabel("Yemek G\u00FCncelle");
	
		lblIstenCkar.setIcon(new ImageIcon(Yemekler.class.getResource("/updatefood.png")));
		lblIstenCkar.setForeground(new Color(30, 144, 255));
		lblIstenCkar.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblIstenCkar.setBounds(25, 381, 233, 47);
		panel.add(lblIstenCkar);
		
		JLabel Geri = new JLabel("Geri");
		Geri.setIcon(new ImageIcon(Yemekler.class.getResource("/return.png")));
		Geri.setForeground(new Color(30, 144, 255));
		Geri.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		Geri.setBounds(25, 465, 191, 47);
		panel.add(Geri);
		
		JLabel lblYemekeidiEkle = new JLabel("Cesit Ekle");
		lblYemekeidiEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cesitEkle c = new cesitEkle();
				c.setVisible(true);
				dispose();
				}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		lblYemekeidiEkle.setIcon(new ImageIcon(Yemekler.class.getResource("/library.png")));
		lblYemekeidiEkle.setForeground(new Color(30, 144, 255));
		lblYemekeidiEkle.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		lblYemekeidiEkle.setBounds(25, 189, 191, 47);
		panel.add(lblYemekeidiEkle);
		
		JLabel eklex = new JLabel("");
		eklex.setBackground(new Color(232, 57, 95));
		eklex.setVisible(false);
		eklex.setOpaque(true);
		eklex.setBounds(66, 132, 110, 4);
		panel.add(eklex);
		
		JLabel eklex_1 = new JLabel("");
		eklex_1.setBackground(new Color(232, 57, 95));
		eklex_1.setVisible(false);
		eklex_1.setOpaque(true);
		eklex_1.setBounds(62, 226, 95, 4);
		panel.add(eklex_1);
		
		JLabel eklex_2 = new JLabel("");
		eklex_2.setBackground(new Color(232, 57, 95));
		eklex_2.setVisible(false);
		eklex_2.setOpaque(true);
		eklex_2.setBounds(64, 328, 105, 4);
		panel.add(eklex_2);
		
		JLabel eklex_3 = new JLabel("");
		eklex_3.setBackground(new Color(255, 165, 0));
		eklex_3.setVisible(false);
		eklex_3.setOpaque(true);
		eklex_3.setBounds(62, 508, 40, 4);
		panel.add(eklex_3);
		
		JLabel eklex_4 = new JLabel("");
		eklex_4.setBackground(new Color(232, 57, 95));
		eklex_4.setVisible(false);
		eklex_4.setOpaque(true);
		eklex_4.setBounds(64, 422, 160, 4);
		panel.add(eklex_4);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("copyright \u00A9 DAE");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(144, 557, 124, 33);
		panel.add(lblNewLabel_2_2_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.GRAY);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 901, 70);
		contentPane.add(panel_2);
		
		JLabel lblYemekler_1 = new JLabel("YEMEKLER");
		lblYemekler_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYemekler_1.setForeground(new Color(30, 144, 255));
		lblYemekler_1.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
		lblYemekler_1.setBounds(375, 11, 173, 47);
		panel_2.add(lblYemekler_1);
		
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
		lblNewLabel_1.setBounds(830, 0, 71, 30);
		panel_2.add(lblNewLabel_1);
		
		
		lblCalsanlar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yemekEkle y = new yemekEkle();
				y.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				eklex.setVisible(true);
				
				
			}
			public void mouseExited(MouseEvent e) {
				eklex.setVisible(false);
				
				
			}
		
		});
		
		
		lblYemekeidiEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cesitEkle c = new cesitEkle();
				c.setVisible(true);
				dispose();
				}
			@Override
			public void mouseEntered(MouseEvent e) {
				eklex_1.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				eklex_1.setVisible(false);
				
				
			}
			
		});
		lblYemekler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yemekSil y = new yemekSil();
				y.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				eklex_2.setVisible(true);
				
			}
			public void mouseExited(MouseEvent e) {
				eklex_2.setVisible(false);
				
				
			}
		});
		lblIstenCkar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yemekGuncelle y = new yemekGuncelle();
				y.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				eklex_4.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				eklex_4.setVisible(false);
				
				
			}
		});
		
		
		
		  Geri.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Menu m = new Menu();
					m.setVisible(true);
					dispose();
				}
		  	@Override
		  	public void mouseEntered(MouseEvent e) {
		  		eklex_3.setVisible(true);
		  	}
		  	public void mouseExited(MouseEvent e) {
				eklex_3.setVisible(false);
				
				
			}
		  	
			});
		
		
		
		
		
		ShowData();
		 setLocationRelativeTo(null);
	}
	private void ShowData()
	{
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Çeþitler");
		model.addColumn("Yemek Ýsmi");
		model.addColumn("Fiyat");
		
		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restorant","postgres", "ataidil1");
			String query = "Select cesit_ismi,yemek_ismi,fiyat from cesitler join yemekler on yemekler.cesit_id=cesitler.cesit_id";
			Statement st = connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			
		
		    
			
			
			
			
			
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("cesit_ismi"),
						rs.getString("yemek_ismi"),
						rs.getString("fiyat"),
					
						
				});
			}
			rs.close();
			st.close();
			connection.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(168);
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			
			
			
			
		
		}catch(Exception e)
		{
			System.out.println("Exc");
		}
		
		
	}
}
