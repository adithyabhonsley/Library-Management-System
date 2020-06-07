public class Book {
	private String title;
	private String author;
	private String bookID;
	private String holder;
	private boolean checkedOut;
	
	public Book(String a, String b, String c, String f, boolean d) {
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
	
	public String getBookID() { 
		return bookID;
	}
	
	public String getHolder() { 
		return holder; 
	}
	
	public String isAvailable() {
		if(!checkedOut) 
			return "Available"; 
		else 
			return "Held by: "+holder;
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
	
	public String toString() { 
		if(checkedOut)
			return "("+bookID+") "+title+" by "+author+" : Held by "+holder;
		return " ("+bookID+") "+title+" by "+author+" : "+isAvailable();
	}

}
