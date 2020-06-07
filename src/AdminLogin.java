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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminLogin extends AdminRegister {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static int count;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean check(String u, String p) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("adminProfiles.txt"));
		while(sc.hasNextLine()) {
			String [] arr = sc.nextLine().split(" ");
			if(arr[0].equals(u)&&arr[1].equals(p))
				return true;
		}
		return false;
	}

	
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 450, 368);
		contentPane = new JPanel();
		count = 0;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministratorLogin = new JLabel("Administrator Login");
		lblAdministratorLogin.setForeground(Color.BLACK);
		lblAdministratorLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblAdministratorLogin.setBounds(120, 28, 226, 23);
		contentPane.add(lblAdministratorLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblUsername.setBounds(73, 79, 105, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblPassword.setBounds(73, 104, 105, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(175, 71, 159, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 102, 159, 20);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(178, 34, 34));
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label.setBounds(117, 274, 261, 28);
		contentPane.add(label);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			AdminRegister x = new AdminRegister();
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				label.setText("");
				count++;
					try {
						if(check(username,password)) {
							dispose();
							AdminPage obj = new AdminPage();
							obj.setVisible(true);
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
								
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnLogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnLogin.setBounds(185, 134, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblCreateAdministratorAccount = new JLabel("Don't have an account?");
		lblCreateAdministratorAccount.setForeground(Color.BLACK);
		lblCreateAdministratorAccount.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
		lblCreateAdministratorAccount.setBounds(88, 207, 235, 23);
		contentPane.add(lblCreateAdministratorAccount);
		
		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminRegister obj = new AdminRegister();
				obj.setVisible(true);
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		button.setBounds(266, 209, 112, 23);
		contentPane.add(button);
		
		JButton btnHome = new JButton("");
		
		Image a = Toolkit.getDefaultToolkit().getImage("Icons//home.png");
		btnHome.setIcon(new ImageIcon(a));
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//man-user.png");
		btnHome.setSelectedIcon(new ImageIcon(b));
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Library obj = new Library();
				obj.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnHome.setBounds(7, 12, 70, 28);
		contentPane.add(btnHome);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setForeground(Color.BLACK);
		lblForgotPassword.setFont(new Font("Tw Cen MT", Font.ITALIC, 15));
		lblForgotPassword.setBounds(88, 180, 118, 23);
		contentPane.add(lblForgotPassword);
		
		JButton btnRequestPassword = new JButton("New Password");
		btnRequestPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Please enter your username:");
				JOptionPane.showMessageDialog(null, "An email has been sent to the associated account!");
			}
		});
		btnRequestPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnRequestPassword.setBounds(266, 182, 112, 23);
		contentPane.add(btnRequestPassword);
		
		JLabel label_1 = new JLabel(".");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		Image c = Toolkit.getDefaultToolkit().getImage("Icons//Background.png");
		label_1.setIcon(new ImageIcon(c));
		label_1.setBounds(0, 0, 492, 388);
		contentPane.add(label_1);
		
		
		
	}
}