import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MemberRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String usernames;
	public static String passwords;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRegister frame = new MemberRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usernames = "";
		passwords = "";
		setBounds(700, 250, 472, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminRegister = new JLabel("Member Register");
		lblAdminRegister.setForeground(Color.BLACK);
		lblAdminRegister.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblAdminRegister.setBounds(145, 24, 218, 23);
		contentPane.add(lblAdminRegister);
		
		JLabel label_2 = new JLabel("Username:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		label_2.setBounds(88, 62, 105, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Password:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		label_3.setBounds(88, 103, 105, 14);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 60, 159, 20);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 101, 159, 20);
		contentPane.add(passwordField);
		
		JButton button_2 = new JButton("Register");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				String userName = textField.getText();
				String password = new String(passwordField.getPassword());
				if(usernames.contains(userName)){
					JOptionPane.showMessageDialog(null, "That username already exists, please try again!");
					textField.setText("");
					passwordField.setText("");
				}
				else if((!usernames.contains(userName))&&(!passwords.contains(password))) {
					usernames+=userName;
					passwords+=password;
					dispose();
					MemberLogin obj = new MemberLogin();
					obj.setVisible(true);
					JOptionPane.showMessageDialog(null, "Your Standard User account has been created! Please login to access your account.");
					try {
						FileWriter fw = new FileWriter ("userProfiles.txt");
						fw.write (userName+" "+password);
						fw.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		button_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		button_2.setBounds(171, 187, 112, 23);
		contentPane.add(button_2);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblEmail.setBounds(88, 147, 105, 14);
		contentPane.add(lblEmail);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MemberLogin obj = new MemberLogin();
				obj.setVisible(true);
			}
		});
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//return.png");
		button.setIcon(new ImageIcon(b));
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		button.setBounds(13, 12, 75, 33);
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 146, 162, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		Image c = Toolkit.getDefaultToolkit().getImage("Icons//Background.png");
		label.setIcon(new ImageIcon(c));
		label.setBounds(0, 0, 455, 262);
		contentPane.add(label);
	}
}