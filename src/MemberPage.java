import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MemberPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private static JList<String>list;
	private static JList<String>list2;
	private static DefaultListModel <String> model;
	private static DefaultListModel<String>model2;
	private static ArrayList<Book> catalog;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberPage frame = new MemberPage();
					frame.setVisible(true);
					catalog = new ArrayList<Book>();
					model = new DefaultListModel<String>();
					list = new JList<String>(model);
					model2 = new DefaultListModel<String>();
					list2 = new JList<String>(model2);
					Scanner sc = new Scanner(new File("books.txt"));
					while(sc.hasNextLine()) {
						String [] arr = sc.nextLine().split(" by ");
						boolean p = !(arr[2].equals("false"));
						String s = "";
						if(p) s = arr[2];
						Book b = new Book(arr[0],arr[1],Integer.toString((int)(Math.random()*1000)),s,p);
						catalog.add(b);
						model.addElement(b.toString());
				}} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MemberPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 1080, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		Image a = Toolkit.getDefaultToolkit().getImage("Icons//man-user.png");
		label.setIcon(new ImageIcon(a));
		label.setBounds(13, 15, 139, 140);
		contentPane.add(label);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblUser.setBounds(155, 28, 192, 43);
		contentPane.add(lblUser);
		
		JLabel lblMainPage = new JLabel("Main Page");
		lblMainPage.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblMainPage.setBounds(155, 77, 222, 55);
		contentPane.add(lblMainPage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 202, 462, 268);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(519, 202, 503, 268);
		contentPane.add(scrollPane_1);
		
		scrollPane_1.setViewportView(list2);
		
		JLabel lblLibraryMainPage = new JLabel("Library Catalog");
		lblLibraryMainPage.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 27));
		lblLibraryMainPage.setBounds(23, 167, 263, 33);
		contentPane.add(lblLibraryMainPage);
		
		JLabel lblNewLabel_1 = new JLabel("Currently Checked Out");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(519, 167, 333, 33);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.YELLOW);
		panel.setBorder(new TitledBorder(null, "Search Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 25)));
		panel.setBackground(new Color(0, 0, 0, 5));
		panel.setBounds(272, 474, 265, 141);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Title:");
		label_1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_1.setBounds(13, 28, 115, 33);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(89, 30, 123, 20);
		panel.add(textField);
		
		JButton button = new JButton("Search");
		button.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		button.setBounds(62, 89, 146, 33);
		panel.add(button);
		
		JLabel label_2 = new JLabel("ID:");
		label_2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_2.setBounds(13, 57, 115, 33);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(89, 59, 123, 20);
		panel.add(textField_1);
		
		JLabel label_3 = new JLabel("Book Specific Information");
		label_3.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 23));
		label_3.setBounds(26, 473, 253, 33);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Title:");
		label_4.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_4.setBounds(27, 498, 115, 33);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 500, 155, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 522, 155, 20);
		contentPane.add(textField_3);
		
		JLabel label_5 = new JLabel("Author:");
		label_5.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_5.setBounds(27, 517, 115, 39);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Book ID:");
		label_6.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_6.setBounds(27, 545, 115, 33);
		contentPane.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 548, 155, 20);
		contentPane.add(textField_4);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setName("Expert Rating");
		progressBar.setBounds(103, 579, 155, 20);
		contentPane.add(progressBar);
		
		JLabel label_7 = new JLabel("Rating:");
		label_7.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_7.setBounds(27, 570, 115, 33);
		contentPane.add(label_7);
		
		JButton button_1 = new JButton(">>>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectedIndex(list.getSelectedIndex()+1);
				String book = (String)(model.getElementAt(list.getSelectedIndex()));
				textField.setText(book.substring(book.indexOf(") ")+2,book.indexOf(" by")));
				textField_1.setText(book.substring(book.indexOf("by ")+3,book.indexOf(":")));
				textField_2.setText(book.substring(book.indexOf("(")+1,book.indexOf(")")));
				progressBar.setValue((int)(Math.random()*100)+50);
			}
		});
		button_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		button_1.setBounds(75, 606, 85, 33);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("<<<");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectedIndex(list.getSelectedIndex()-1);
				String book = (String)(model.getElementAt(list.getSelectedIndex()));
				textField.setText(book.substring(book.indexOf(") ")+2,book.indexOf(" by")));
				textField_1.setText(book.substring(book.indexOf("by ")+3,book.indexOf(":")));
				textField_2.setText(book.substring(book.indexOf("(")+1,book.indexOf(")")));
				progressBar.setValue((int)(Math.random()*100)+50);
			}
		});
		button_2.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		button_2.setBounds(169, 606, 85, 33);
		contentPane.add(button_2);
		
		JButton btnNewButton = new JButton("Checkout Selected");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnNewButton.setBounds(272, 172, 213, 27);
		contentPane.add(btnNewButton);
		
		JButton btnReturnSelected = new JButton("Return Selected");
		btnReturnSelected.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnReturnSelected.setBounds(809, 172, 213, 27);
		contentPane.add(btnReturnSelected);
		
		JButton button_3 = new JButton("Return Home");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Library ob = new Library();
				ob.setVisible(true);
			}
		});
		button_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button_3.setBounds(868, 34, 165, 33);
		contentPane.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.YELLOW);
		panel_1.setBorder(new TitledBorder(null, "Change Password", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 25)));
		panel_1.setBackground(new Color(0, 0, 0, 5));
		panel_1.setBounds(518, 474, 265, 141);
		contentPane.add(panel_1);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblOldPassword.setBounds(13, 28, 130, 33);
		panel_1.add(lblOldPassword);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnChange.setBounds(60, 89, 146, 33);
		panel_1.add(btnChange);
		
		JLabel lblNewPassword = new JLabel("New Password: ");
		lblNewPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewPassword.setBounds(13, 57, 140, 33);
		panel_1.add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 30, 90, 21);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(147, 59, 92, 21);
		panel_1.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//Background.png");
		lblNewLabel.setIcon(new ImageIcon(b));
		lblNewLabel.setBounds(0, -53, 1048, 747);
		contentPane.add(lblNewLabel);
	}
}