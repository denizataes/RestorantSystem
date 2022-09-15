import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Baslangic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baslangic frame = new Baslangic();
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
	public Baslangic() {
		setUndecorated(true);
		
		setTitle("Se\u00E7im ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 659);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 setLocationRelativeTo(null);
		
		JLabel yoneticiLabel = new JLabel("Y\u00D6NET\u0130C\u0130");
		yoneticiLabel.setOpaque(true);
		yoneticiLabel.setBackground(Color.WHITE);
		yoneticiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yoneticiLabel.setForeground(new Color(102, 102, 51));
		yoneticiLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		yoneticiLabel.setBounds(119, 566, 152, 26);
		contentPane.add(yoneticiLabel);
		
		JLabel yonetici = new JLabel("");
		yonetici.setBackground(Color.WHITE);
		yonetici.setOpaque(true);
		
		yonetici.setIcon(new ImageIcon(Baslangic.class.getResource("/basyonet.jpg")));
		yonetici.setBounds(30, 63, 382, 491);
		contentPane.add(yonetici);
		
		JLabel yonetici_1 = new JLabel("New label");
	
		yonetici_1.setIcon(new ImageIcon(Baslangic.class.getResource("/garsonyeni.jpg")));
		yonetici_1.setBounds(472, 63, 382, 491);
	
		contentPane.add(yonetici_1);
		
		JLabel lblNewLabel = new JLabel("KAPAT");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor1(lblNewLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor1(lblNewLabel);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Kapatmak istediðinize emin misiniz?","Seçim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        // 0=yes, 1=no, 2=cancel
				if(input == 0) {
		        System.out.println(input);
				System.exit(0);
				}
			}
		});
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(276, 602, 343, 46);
		contentPane.add(lblNewLabel);
		
		JLabel garsonLabel = new JLabel("GARSON");
		garsonLabel.setBackground(Color.WHITE);
		garsonLabel.setOpaque(true);
		garsonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		garsonLabel.setForeground(new Color(102, 102, 51));
		garsonLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		garsonLabel.setBounds(598, 566, 152, 26);
		contentPane.add(garsonLabel);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("copyright \u00A9 DAE");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_2_2_1.setBounds(776, 628, 124, 33);
		contentPane.add(lblNewLabel_2_2_1);
		
		
		yonetici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log l = new Log(1);
			
				l.setVisible(true);
				dispose();
			
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(yoneticiLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(yoneticiLabel);
			}
		});
		
		
		
		yonetici_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log l = new Log(2);
			
				l.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(garsonLabel);
			}
			public void mouseExited(MouseEvent e) {
				resetColor(garsonLabel);
			}
		});
		
		
	}
	public void setColor(JLabel p)
	{
	p.setBackground(new Color(0,204,204));
	}
	public void resetColor(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}
	
	
	
	
	public void setColor1(JLabel p)
	{
	p.setBackground(new Color(255,0,0));
	}
	public void resetColor1(JLabel p)
	{
	p.setBackground(new Color(255,255,255));
	}
	
	
	
}
