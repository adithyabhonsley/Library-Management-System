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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Book>catalog;
	private static JList <String> list;
	private static DefaultListModel<String> model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
					catalog = new ArrayList<Book>();
					model = new DefaultListModel<String>();
					list = new JList<String>(model);
					Scanner sc = new Scanner(new File("books.txt"));
					while(sc.hasNextLine()) {
						String [] arr = sc.nextLine().split(" by ");
						boolean p = !(arr[2].equals("false"));
						String s = "";
						if(p) s = arr[2];
						Book b = new Book(arr[0],arr[1],Integer.toString((int)(Math.random()*1000)),s,p);
						catalog.add(b);
						model.addElement(b.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 1078, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblAdminPage = new JLabel("Administrator");
		lblAdminPage.setFont(new Font("Tw Cen MT", Font.BOLD, 60));
		lblAdminPage.setForeground(Color.BLACK);
		lblAdminPage.setBounds(146, 15, 404, 64);
		contentPane.add(lblAdminPage);
		
		JLabel lblLibraryCatalog = new JLabel("Information Catalog");
		lblLibraryCatalog.setIcon(new ImageIcon("C:\\Users\\Adithya\\Desktop\\graph.png"));
		lblLibraryCatalog.setForeground(Color.BLACK);
		lblLibraryCatalog.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 32));
		lblLibraryCatalog.setBounds(15, 153, 255, 39);
		contentPane.add(lblLibraryCatalog);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 200, 447, 423);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.YELLOW);
		panel_2.setBorder(new TitledBorder(null, "Add Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 25)));
		panel_2.setBackground(new Color(0,0,0,5));
		panel_2.setBounds(488, 362, 265, 141);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("Title:");
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label.setBounds(13, 28, 115, 33);
		panel_2.add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(89, 30, 176, 20);
		panel_2.add(textField_3);
		
		JLabel label_1 = new JLabel("Author:");
		label_1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_1.setBounds(13, 51, 115, 39);
		panel_2.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(89, 56, 176, 20);
		panel_2.add(textField_4);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tit = textField_3.getText();
				String aut = textField_4.getText();
				Book b = new Book(tit,aut,Integer.toString((int)(Math.random()*1000)),"",false);
				model.addElement(b.toString());
				textField_3.setText("");
				textField_4.setText("");
				JOptionPane.showMessageDialog(null, "The book "+tit+" by "+aut+" has been added to the library.");

			}
		});
		btnAddBook.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnAddBook.setBounds(67, 89, 151, 33);
		panel_2.add(btnAddBook);
		
		JLabel lblW = new JLabel("");
		Image a = Toolkit.getDefaultToolkit().getImage("Icons//graph.png");
		lblW.setIcon(new ImageIcon(a));
		lblW.setBounds(15, -34, 277, 220);
		contentPane.add(lblW);
		
		JLabel lblControlPage = new JLabel("Control Page");
		lblControlPage.setForeground(Color.BLACK);
		lblControlPage.setFont(new Font("Tw Cen MT", Font.BOLD, 60));
		lblControlPage.setBounds(146, 82, 404, 64);
		contentPane.add(lblControlPage);
		
		JLabel lblTit = new JLabel("Title:");
		lblTit.setBounds(488, 200, 115, 33);
		contentPane.add(lblTit);
		lblTit.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(488, 219, 115, 39);
		contentPane.add(lblAuthor);
		lblAuthor.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(564, 202, 176, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(564, 224, 176, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Book Specific Information");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(488, 158, 253, 33);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(564, 250, 176, 20);
		contentPane.add(textField_2);
		
		JLabel lblBookId = new JLabel("Book ID:");
		lblBookId.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblBookId.setBounds(488, 247, 115, 33);
		contentPane.add(lblBookId);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.YELLOW);
		panel.setBorder(new TitledBorder(null, "Remove Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 25)));
		panel.setBackground(new Color(0, 0, 0, 5));
		panel.setBounds(488, 518, 265, 141);
		contentPane.add(panel);
		
		JLabel label_2 = new JLabel("Title:");
		label_2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_2.setBounds(13, 28, 115, 33);
		panel.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(89, 30, 176, 20);
		panel.add(textField_5);
		
		JLabel label_3 = new JLabel("Author:");
		label_3.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_3.setBounds(13, 51, 115, 39);
		panel.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(89, 56, 176, 20);
		panel.add(textField_6);
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = catalog.size();
				String t = textField_3.getText();
				model.removeAllElements();
				for(int i = 0; i<catalog.size();i++){
					if(!(catalog.get(i).getTitle().equals(t)))
						model.addElement(catalog.get(i).toString());	
					else {
						catalog.remove(i);
					}
				}
			JOptionPane.showMessageDialog(null, "The book "+t+" has been removed from the library");
		}});
		btnRemoveBook.setBounds(62, 89, 158, 33);
		panel.add(btnRemoveBook);
		btnRemoveBook.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		
		JButton btnUpdateCatalog = new JButton("Update Catalog");
		btnUpdateCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.removeAllElements();
				for(Book b : catalog)
					model.addElement(b.toString());

			}
		});
		btnUpdateCatalog.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnUpdateCatalog.setBounds(269, 156, 193, 39);
		contentPane.add(btnUpdateCatalog);
		
		JButton btnAdminList = new JButton("Admin List");
		btnAdminList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				model.removeAllElements();
				model.addElement("ABhonsley (Houston)");
			}
		});
		btnAdminList.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnAdminList.setBounds(804, 158, 201, 39);
		contentPane.add(btnAdminList);
		
		JButton btnMemberList = new JButton("Member List");
		btnMemberList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				model.removeAllElements();
			}
		});
		btnMemberList.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnMemberList.setBounds(804, 210, 201, 39);
		contentPane.add(btnMemberList);
		
		JButton btnCheckedOutBooks = new JButton("Checked Out Books");
		btnCheckedOutBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				for(Book b : catalog)
					if(b.isCheckedOut())
						model.addElement(b.toString());
			}
		});
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(564, 281, 176, 20);
		contentPane.add(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setName("Expert Rating");
		btnCheckedOutBooks.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnCheckedOutBooks.setBounds(799, 259, 206, 39);
		contentPane.add(btnCheckedOutBooks);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Plese enter your original password: ");
				JOptionPane.showInputDialog("Plese enter your new password: ");
				JOptionPane.showMessageDialog(null, "Your password has been succesfully changed.");
			}
		});
		btnChangePassword.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnChangePassword.setBounds(799, 360, 206, 39);
		contentPane.add(btnChangePassword);
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog(null, "Please enter a username: (5 - 10 Characters)");
				String p = JOptionPane.showInputDialog(null, "Please enter a password: (5 - 10 Characters)");
				String l = JOptionPane.showInputDialog(null, "Please enter the library location: ");
				model.addElement(s+" "+"("+l+")");
			}
		});
		btnAddAdmin.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnAddAdmin.setBounds(799, 410, 206, 39);
		contentPane.add(btnAddAdmin);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog(null, "Please enter a username: (5 - 10 Characters)");
				String p = JOptionPane.showInputDialog(null, "Please enter a password: (5 - 10 Characters)");
				String l = JOptionPane.showInputDialog(null, "Please enter the library location: ");
				model.addElement(s+" "+"("+l+")");
			}
		});
		btnAddMember.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnAddMember.setBounds(799, 464, 206, 39);
		contentPane.add(btnAddMember);
		
		JButton btnAvailableBooks = new JButton("Available Books");
		btnAvailableBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				for(Book b : catalog) {
					if(!(b.isCheckedOut())) {
						model.addElement(b.toString());
					}
				}
			}
		});
		btnAvailableBooks.setBounds(799, 308, 206, 39);
		contentPane.add(btnAvailableBooks);
		btnAvailableBooks.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		
		JButton button = new JButton(">>>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectedIndex(list.getSelectedIndex()+1);
				String book = (String)(model.getElementAt(list.getSelectedIndex()));
				textField.setText(book.substring(book.indexOf(") ")+2,book.indexOf(" by")));
				textField_1.setText(book.substring(book.indexOf("by ")+3,book.indexOf(":")));
				textField_2.setText(book.substring(book.indexOf("(")+1,book.indexOf(")")));
				progressBar.setValue((int)(Math.random()*30)+70);
			}
		});
		button.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		button.setBounds(536, 308, 85, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("<<<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectedIndex(list.getSelectedIndex()-1);
				String book = (String)(model.getElementAt(list.getSelectedIndex()));
				textField.setText(book.substring(book.indexOf(") ")+2,book.indexOf(" by")));
				textField_1.setText(book.substring(book.indexOf("by ")+3,book.indexOf(":")));
				textField_2.setText(book.substring(book.indexOf("(")+1,book.indexOf(")")));
				progressBar.setValue((int)(Math.random()*100)+50);
			}
		});
		button_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		button_1.setBounds(630, 308, 85, 33);
		contentPane.add(button_1);
		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Library d = new Library();
				d.setVisible(true);
			}
		});
		Image b = Toolkit.getDefaultToolkit().getImage("Icons//home.png");
		btnReturnHome.setIcon(new ImageIcon(b));
		btnReturnHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnReturnHome.setBounds(840, 15, 165, 33);
		contentPane.add(btnReturnHome);
		

		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblRating.setBounds(488, 272, 115, 33);
		contentPane.add(lblRating);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.YELLOW);
		panel_1.setBorder(new TitledBorder(null, "Search Books", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 25)));
		panel_1.setBackground(new Color(0, 0, 0, 5));
		panel_1.setBounds(766, 518, 265, 141);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("Title:");
		label_4.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		label_4.setBounds(13, 28, 115, 33);
		panel_1.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(89, 30, 176, 20);
		panel_1.add(textField_7);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField_7.getText();
				String k = textField_8.getText();
				model.removeAllElements();
				for(Book b : catalog)
					if(b.getTitle().equals(s)||b.getBookID().equals(k))
						model.addElement(b.toString());
			}
		});
		btnSearch.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		btnSearch.setBounds(62, 89, 146, 33);
		panel_1.add(btnSearch);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblId.setBounds(13, 57, 115, 33);
		panel_1.add(lblId);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(89, 59, 176, 20);
		panel_1.add(textField_8);
		JLabel label_6 = new JLabel("");
		Image c = Toolkit.getDefaultToolkit().getImage("Icons//Background.png");
		label_6.setIcon(new ImageIcon(c));
		label_6.setBounds(0, -20, 1046, 679);
		contentPane.add(label_6);
		


	}
}