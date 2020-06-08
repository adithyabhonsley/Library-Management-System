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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class AdminRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String usernames;
	public static String passwords;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister frame = new AdminRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 325);
		contentPane = new JPanel();
		usernames = "";
		passwords = "";
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image b = Toolkit.getDefaultToolkit().getImage("icons//Background.png");
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblUsername.setBounds(66, 66, 105, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblPassword.setBounds(66, 99, 105, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(187, 58, 159, 20);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 91, 159, 20);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		comboBox.setBounds(187, 156, 159, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Select Library Location:");
		comboBox.addItem("Houston");
		comboBox.addItem("Dallas");
		comboBox.addItem("Austin");
		comboBox.addItem("San Francisco");
		comboBox.addItem("New York");
		comboBox.addItem("Chicago");
		comboBox.addItem("Seattle");
		comboBox.addItem("Washington DC");
		
		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
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
					AdminLogin obj = new AdminLogin();
					obj.setVisible(true);
					JOptionPane.showMessageDialog(null, "Your Administrator account has been created! Please login to access your account.");
					try {
						FileWriter fw = new FileWriter ("adminProfiles.txt", false);
						fw.write (userName+" "+password+" "+comboBox.getSelectedItem().toString());
						fw.close();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					 
				}
				
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		button.setBounds(156, 198, 112, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AdminLogin obj = new AdminLogin();
				obj.setVisible(true);
				
			}
		});
		
		Image a = Toolkit.getDefaultToolkit().getImage("icons//return.png");
		button_1.setIcon(new ImageIcon(a));
		button_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		button_1.setBounds(10, 11, 75, 33);
		contentPane.add(button_1);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setForeground(Color.BLACK);
		lblEmailAddress.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblEmailAddress.setBounds(66, 132, 105, 14);
		contentPane.add(lblEmailAddress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 124, 159, 20);
		contentPane.add(textField_1);
		
		JLabel lblLibraryLocation = new JLabel("Library Location");
		lblLibraryLocation.setForeground(Color.BLACK);
		lblLibraryLocation.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblLibraryLocation.setBounds(66, 165, 164, 14);
		contentPane.add(lblLibraryLocation);
		
		JLabel lblAdministratorRegistration = new JLabel("Administrator Registration");
		lblAdministratorRegistration.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblAdministratorRegistration.setBounds(97, 11, 275, 33);
		contentPane.add(lblAdministratorRegistration);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 524, 356);
		Image c = Toolkit.getDefaultToolkit().getImage("icons//Background.png");
		lblNewLabel.setIcon(new ImageIcon(c));
		contentPane.add(lblNewLabel);
		
	}
}