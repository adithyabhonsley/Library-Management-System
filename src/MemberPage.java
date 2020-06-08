import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private static ArrayList<Book> booksOnHold;
	private JTextField textField_5;
	private JTextField textField_6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberPage frame = new MemberPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MemberPage() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		Image a = Toolkit.getDefaultToolkit().getImage("Icons//man-user.png");
		label.setIcon(new ImageIcon(a));
		label.setBounds(23, 15, 139, 140);
		contentPane.add(label);
		
		JLabel lblUser = new JLabel("MyLibrary");
		lblUser.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblUser.setBounds(114, 39, 232, 43);
		contentPane.add(lblUser);
		
		JLabel lblMainPage = new JLabel("Personal User Portal");
		lblMainPage.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblMainPage.setBounds(114, 76, 293, 55);
		contentPane.add(lblMainPage);
		
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(23, 202, 462, 268);
		contentPane.add(scrollPane);
		
		catalog = new ArrayList<Book>();
		booksOnHold = new ArrayList<Book>();
		
		Scanner sc = new Scanner(new File("books.txt"));
		while(sc.hasNextLine()) {
			String [] arr = sc.nextLine().split(" by ");
			String a1 = arr[0];
			String b1 = arr[1].substring(0, arr[1].indexOf("("));
			Book c1 = new Book(a1,b1,(int)(Math.random()*1000000),"",false);
			catalog.add(c1);
			model.addElement(c1.toString());
		}
		
		model2 = new DefaultListModel<String>();
		list2 = new JList<String>(model2);
		
		JScrollPane scrollPane_1 = new JScrollPane(list2);
		scrollPane_1.setBounds(519, 202, 503, 268);
		contentPane.add(scrollPane_1);
		
		JLabel lblLibraryMainPage = new JLabel("Library Catalog");
		lblLibraryMainPage.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblLibraryMainPage.setBounds(23, 167, 263, 33);
		contentPane.add(lblLibraryMainPage);
		
		JLabel lblNewLabel_1 = new JLabel("Currently Checked Out");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
		lblNewLabel_1.setBounds(519, 167, 333, 33);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.YELLOW);
		panel.setBorder(new TitledBorder(null, "Search Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD, 25)));
		panel.setBackground(new Color(0, 0, 0, 5));
		panel.setBounds(353, 493, 303, 190);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Title:");
		label_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_1.setBounds(17, 47, 115, 33);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(96, 55, 184, 20);
		panel.add(textField);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField.getText().equals("") ? "Null" : textField.getText();
				int k = textField_1.getText().equals("") ? Integer.MIN_VALUE : Integer.parseInt(textField_1.getText());
	
				model.removeAllElements();
				
				int counter = 0;
				for(Book b : catalog) {
					if(b.getTitle().contains(s) || b.getBookID() == k) {
						model.addElement(b.toString());
						++counter;
					}
				}
				
				if (counter!=0)
					JOptionPane.showMessageDialog(null, "Your search brought up "+counter+" results");
				else
					JOptionPane.showMessageDialog(null, "Your search brought up 0 results. Please ensure title spelling or ID is exact!");
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		button.setBounds(90, 132, 146, 33);
		panel.add(button);
		
		
		JLabel lblBookId = new JLabel("Book ID:");
		lblBookId.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblBookId.setBounds(17, 76, 115, 33);
		panel.add(lblBookId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 84, 184, 20);
		panel.add(textField_1);
		
		JLabel label_4 = new JLabel("Title:");
		label_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_4.setBounds(33, 519, 115, 33);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(114, 527, 203, 20);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(114, 549, 203, 20);
		
		JLabel label_5 = new JLabel("Author:");
		label_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_5.setBounds(33, 538, 115, 39);
		
		JLabel label_6 = new JLabel("Book ID:");
		label_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_6.setBounds(32, 566, 115, 33);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(114, 571, 203, 20);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setName("Expert Rating");
		progressBar.setBounds(103, 599, 203, 20);
		
		JLabel label_7 = new JLabel("Rating:");
		label_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		label_7.setBounds(33, 586, 115, 33);
		
		JButton button_1 = new JButton(">>>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectedIndex(list.getSelectedIndex()+1);
				String book = (String)(model.getElementAt(list.getSelectedIndex()));
				textField_2.setText(book.substring(book.indexOf(") ")+2,book.indexOf(" by")));
				textField_3.setText(book.substring(book.indexOf("by ")+3,book.indexOf(":")));
				textField_4.setText(book.substring(book.indexOf("(")+1,book.indexOf(")")));
				progressBar.setValue((int)(Math.random()*100)+50);
			}
		});
		button_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		button_1.setBounds(75, 626, 85, 33);
		
		JButton button_2 = new JButton("<<<");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectedIndex(list.getSelectedIndex()-1);
				String book = (String)(model.getElementAt(list.getSelectedIndex()));
				textField_2.setText(book.substring(book.indexOf(") ")+2,book.indexOf(" by")));
				textField_3.setText(book.substring(book.indexOf("by ")+3,book.indexOf(":")));
				textField_4.setText(book.substring(book.indexOf("(")+1,book.indexOf(")")));
				progressBar.setValue((int)(Math.random()*100)+50);
			}
		});
		button_2.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		button_2.setBounds(169, 626, 85, 33);
		
		JButton btnNewButton = new JButton("Checkout Selected");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnNewButton.setBounds(314, 174, 165, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				int bookID = Integer.parseInt(model.get(i).substring(2,model.get(i).indexOf(")")));
				System.out.println(catalog.remove(1));
				for(int j = 0; j < catalog.size(); j++) {
					if(catalog.get(j).getBookID() == bookID) {
						catalog.get(j).checkOut();
						booksOnHold.add(0, catalog.get(j));
						catalog.remove(j);
						break;
					}
				}
				model2.addElement(booksOnHold.get(0).toString());
				model.remove(i);
			}
		});
		
		JButton btnReturnSelected = new JButton("Return Selected");
		btnReturnSelected.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnReturnSelected.setBounds(809, 172, 213, 27);
		contentPane.add(btnReturnSelected);
		btnReturnSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = list2.getSelectedIndex();
				int bookID = Integer.parseInt(model2.get(j).substring(2,model2.get(j).indexOf(")")));
				for(int k = 0; k < booksOnHold.size(); k++) {
					if(booksOnHold.get(k).getBookID() == bookID) {
						catalog.add(booksOnHold.get(k));
						booksOnHold.get(k).returnBook();
						booksOnHold.remove(k);
						break;
					}
				}
				model.addElement(catalog.get(catalog.size()-1).toString());
				model2.remove(j);
			}		
		});
		
		JButton button_3 = new JButton("Return Home");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Library ob = new Library();
				ob.setVisible(true);
			}
		});
		button_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button_3.setBounds(857, 15, 165, 33);
		contentPane.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.YELLOW);
		panel_1.setBorder(new TitledBorder(null, "Change Password", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD, 25)));
		panel_1.setBackground(new Color(0, 0, 0, 5));
		panel_1.setBounds(688, 493, 334, 190);
		contentPane.add(panel_1);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblOldPassword.setBounds(17, 48, 130, 33);
		panel_1.add(lblOldPassword);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnChange.setBounds(114, 132, 146, 33);
		panel_1.add(btnChange);
		
		JLabel lblNewPassword = new JLabel("New Password: ");
		lblNewPassword.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewPassword.setBounds(17, 77, 140, 33);
		panel_1.add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 48, 157, 21);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(159, 80, 159, 21);
		panel_1.add(passwordField_1);
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//Background.png");
		
		JButton btnNewButton_1 = new JButton("All Books");
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnNewButton_1.setBounds(202, 173, 115, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				for(Book b : catalog)
					model.addElement(b.toString());
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(23, 493, 313, 190);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setForeground(Color.YELLOW);
		panel_3.setBorder(new TitledBorder(null, "Book Specific Information", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD, 25)));
		panel_3.setBackground(new Color(0, 0, 0, 5));
		
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		contentPane.add(label_4);
		contentPane.add(label_5);
		contentPane.add(label_6);
		contentPane.add(label_7);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1080, 726);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon(b));
		
	}
}