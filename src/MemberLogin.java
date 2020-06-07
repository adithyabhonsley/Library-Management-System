import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MemberLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static int count;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberLogin frame = new MemberLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static boolean check(String u, String p) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("userProfiles.txt"));
		while(sc.hasNextLine()) {
			String [] arr = sc.nextLine().split(" ");
			if(arr[0].equals(u)&&arr[1].equals(p))
				return true;
		}
		return false;
	}

	public MemberLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		count = 0;
		
		JLabel lblMemberLogin = new JLabel("Member Login");
		lblMemberLogin.setForeground(Color.BLACK);
		lblMemberLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblMemberLogin.setBounds(153, 13, 218, 23);
		contentPane.add(lblMemberLogin);
		
		JLabel label_2 = new JLabel("Username:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		label_2.setBounds(83, 55, 105, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		label_3.setBounds(83, 96, 105, 14);
		contentPane.add(label_3);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(165, 42, 42));
		label.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(92, 167, 330, 33);
		contentPane.add(label);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 53, 159, 20);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 94, 159, 20);
		contentPane.add(passwordField);
		
		
		
		JLabel lblNotAMember = new JLabel("Get a Library Membership today!");
		lblNotAMember.setForeground(Color.BLACK);
		lblNotAMember.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblNotAMember.setBounds(112, 206, 298, 23);
		contentPane.add(lblNotAMember);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberRegister obj = new MemberRegister();
				obj.setVisible(true);
				
			}
		});
		btnRegister.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		btnRegister.setBounds(173, 237, 112, 23);
		contentPane.add(btnRegister);
		
		JButton button_1 = new JButton("");
		Image a = Toolkit.getDefaultToolkit().getImage("Icons//home.png");
		button_1.setIcon(new ImageIcon(a));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Library obj = new Library();
				obj.setVisible(true);
			}
		});
		button_1.setFont(new Font("Aharoni", Font.PLAIN, 16));
		button_1.setBounds(10, 13, 64, 23);
		contentPane.add(button_1);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String username = textField.getText();
					String password = new String(passwordField.getPassword());
					count++;
					label.setText("");
					try {
						if(check(username,password)) {
							dispose();
							MemberPage obj = new MemberPage();
							obj.setVisible(true);
							JOptionPane.showMessageDialog(null, "Login Successful!");
						}
						else {
							if(count<5)
								label.setText("You have used "+(count)+" of your 5 alloted login attempts!");
								else {
									dispose();
									Library obj = new Library();
									obj.setVisible(true);
									JOptionPane.showMessageDialog(null, "Please contact an administrator if you require login help.");
						}
					}} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		button.setBounds(175, 138, 109, 23);
		contentPane.add(button);
		
		JLabel label231 = new JLabel(".");
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//Background.png");
		label231.setIcon(new ImageIcon(b));
		label231.setBounds(0, 0, 448, 284);
		contentPane.add(label231);
	}
}