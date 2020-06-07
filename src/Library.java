import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Library extends JFrame {

	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 499, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Library");
		lblWelcomeToThe.setForeground(Color.BLACK);
		lblWelcomeToThe.setFont(new Font("Tw Cen MT", Font.BOLD, 48));
		lblWelcomeToThe.setBounds(175, 48, 158, 61);
		contentPane.add(lblWelcomeToThe);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBackground(Color.WHITE);
		btnAdminLogin.setForeground(Color.BLACK);
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AdminLogin obj = new AdminLogin();
				obj.setVisible(true);
			}
		});
		btnAdminLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnAdminLogin.setBounds(98, 322, 128, 40);
		contentPane.add(btnAdminLogin);
		
		JButton btnMemberLogin = new JButton("User Login");
		btnMemberLogin.setBackground(Color.WHITE);
		btnMemberLogin.setForeground(Color.BLACK);
		btnMemberLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MemberLogin obj = new MemberLogin();
				obj.setVisible(true);
			}
		});
		btnMemberLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnMemberLogin.setBounds(256, 322, 128, 40);
		contentPane.add(btnMemberLogin);
		
		JLabel lblPleaseSelectThe = new JLabel("Management");
		lblPleaseSelectThe.setForeground(Color.BLACK);
		lblPleaseSelectThe.setFont(new Font("Tw Cen MT", Font.BOLD, 48));
		lblPleaseSelectThe.setBounds(175, 108, 261, 50);
		contentPane.add(lblPleaseSelectThe);
		
		JLabel label = new JLabel(".");
		label.setForeground(Color.WHITE);
		Image a = Toolkit.getDefaultToolkit().getImage("Icons//bookshelf.png");
		label.setIcon(new ImageIcon(a));
		label.setBounds(38, 36, 128, 133);
		contentPane.add(label);
		
		JLabel lblWelcomeToThe_1 = new JLabel("Welcome to the Library Management System");
		lblWelcomeToThe_1.setForeground(Color.BLACK);
		lblWelcomeToThe_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblWelcomeToThe_1.setBounds(58, 172, 378, 40);
		contentPane.add(lblWelcomeToThe_1);
		
		JLabel lblNewLabel = new JLabel("Please select the appropriate login.");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel.setBounds(98, 208, 286, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnSaveAndExit = new JButton("Save and Exit");
		btnSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(10);
			}
		});
		btnSaveAndExit.setBackground(Color.WHITE);
		btnSaveAndExit.setForeground(Color.BLACK);
		btnSaveAndExit.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnSaveAndExit.setBounds(170, 377, 143, 33);
		contentPane.add(btnSaveAndExit);
		
		JLabel label_2 = new JLabel(".");
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//admin-icon.png");
		label_2.setIcon(new ImageIcon(b));
		label_2.setBounds(133, 245, 66, 64);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(".");
		Image c = Toolkit.getDefaultToolkit().getImage("Icons//man-user.png");
		label_3.setIcon(new ImageIcon(c));
		label_3.setBounds(292, 245, 66, 64);
		contentPane.add(label_3);
		
		JLabel label_1 = new JLabel(".");
		Image d = Toolkit.getDefaultToolkit().getImage("Icons//Background.jpg");
		label_1.setIcon(new ImageIcon(d));
		label_1.setBounds(0, -25, 499, 541);
		contentPane.add(label_1);
	}
}