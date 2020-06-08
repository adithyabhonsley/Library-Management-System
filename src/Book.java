public class Book {
	private String title;
	private String author;
	private int bookID;
	private String holder;
	private boolean checkedOut;
	
	public Book(String a, String b, int c, String f, boolean d) {
		title = a; 
		author = b; 
		bookID = c; 
		holder = f; 
		checkedOut = d;
	}
	
	public String getTitle() { 
		return title; 
	}
	
	public String getAuthor() { 
		return author; 
	}
	
	public int getBookID() { 
		return bookID;
	}
	
	public String getHolder() { 
		return holder; 
	}
	
	public String isAvailable() {
		if(!checkedOut) 
			return "Available"; 
		else 
			return "Held by: You";
	}
	
	public void setHolder(String newHolder) { 
		holder = newHolder; 
	}
	
	public boolean isCheckedOut() { 
		return checkedOut;
	}
	public void checkOut() { 
		checkedOut = true;
	}
	
	public void returnBook() { 
		checkedOut = false;
	}
	
	public String toString() { 
		return " ("+bookID+") "+title+" by "+author+": "+isAvailable();
	}

}
