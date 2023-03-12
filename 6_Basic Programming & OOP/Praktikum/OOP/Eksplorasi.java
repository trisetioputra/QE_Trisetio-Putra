package OOP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;    

public class Eksplorasi {
	public static void main(String[] args) {
		
		BookController bookController= new BookController();
		String welcomeString="";
		welcomeString+="Welcome to book management app \n";
		welcomeString+="Please choose your menu \n";
		welcomeString+="1. Create a new book \n";
		welcomeString+="2. Get all books \n";
		welcomeString+="3. Get book by ID \n";
		welcomeString+="4. Update book \n";
		welcomeString+="5. Delete book \n";
		welcomeString+="6. Exit \n";
		Scanner scanner= new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.print(welcomeString);
			int command=scanner.nextInt();
			scanner.nextLine();
			switch(command) {
			case(1):
				System.out.println("Enter title");
				String title=scanner.nextLine();
				System.out.println("Enter author");
				String author=scanner.nextLine();
				System.out.println("Enter category");
				String category=scanner.nextLine();
				bookController.create(title, author, category);
				break;
			case(2):
				bookController.getInfo();
				break;
			case(3):
				System.out.println("Enter Book ID");
				bookController.get(scanner.nextLine());
				break;
			case(4):
				System.out.println("Enter book ID");
				String ID=scanner.nextLine();
				System.out.println("Enter title");
				String newTitle=scanner.nextLine();
				System.out.println("Enter author");
				String newAuthor=scanner.nextLine();
				System.out.println("Enter category");
				String newCategory=scanner.nextLine();
				bookController.update(ID, newTitle, newAuthor, newCategory);
				break;
			case(5):
				System.out.println("Enter book ID");
				String deletedId=scanner.nextLine();
				bookController.delete(deletedId);
				break;
			case(6):
				System.out.println("Bye...");
				flag=false;
			}
		}
		scanner.close();
	}
		
}

class BookController{
	private HashMap<UUID, Book> books = new HashMap<UUID, Book>();
	
	protected void create(String title, String author, String category) {
		UUID uuid=UUID.randomUUID();
		Book buku=new Book(title, author, category,uuid);
		books.put(uuid, buku);
		System.out.print("Book created!");
		getInfo(uuid);
	}
	
	protected void get(String uuid) {
		try {
			UUID uuidTransform= UUID.fromString(uuid);
			getInfo(uuidTransform);
		}
		catch(Exception e) {
			System.out.println("UUID is wrong!");
		}
	}
	
	protected void delete(String uuid) {
		try {
			UUID uuidTransform= UUID.fromString(uuid);
			if(books.get(uuidTransform)==null) {
				System.out.print("No books found \n");
			}
			else {
				books.remove(uuidTransform);
				System.out.print("Book deleted! \n");
			}
		}
		catch(Exception e) {
			System.out.print("UUID is wrong!");
		}
	}
	
	protected void update(String uuid,String title, String author, String category) {
		try {
			UUID uuidTransform= UUID.fromString(uuid);
			if(books.get(uuidTransform)==null) {
				System.out.print("No books found \n");
			}
			else {			
				books.get(uuidTransform).setTitle(title);
				books.get(uuidTransform).setAuthor(author);
				books.get(uuidTransform).setCategory(category);
				System.out.print("Book updated! \n");
				getInfo(uuidTransform);
			}
		}
		catch(Exception e) {
			System.out.println("UUID is wrong!");
		}
	}
	
	protected void getInfo() {
		if(books.isEmpty()) {
			System.out.print("Still empty\n");
			return;
		}
		String result="===ALL BOOKS===\n";
		for(Book book:books.values()) {
			result+="===\n";
			result+=String.format("ID: %s \n", book.getId().toString());
			result+=String.format("Title: %s \n", book.getTitle());
			result+=String.format("Author: %s \n", book.getAuthor());
			result+=String.format("Category: %s \n", book.getCategory());
			result+="===\n";
		}
		System.out.print(result);
	}
	
	protected void getInfo(UUID uuid) {
		if(books.get(uuid)!=null) {
			Book book=books.get(uuid);
			String result="";
			result+="===\n";
			result+=String.format("ID: %s \n", book.getId().toString());
			result+=String.format("Title: %s \n", book.getTitle());
			result+=String.format("Author: %s \n", book.getAuthor());
			result+=String.format("Category: %s \n", book.getCategory());
			result+="===\n";
			System.out.print(result);
		}
		else {
			String result="No book matches the ID \n";
			System.out.print(result);
		}
	}
}

class Book{
	private String title;
	private String author;
	private String category;
	private UUID id;
	protected Book(String title, String author, String category, UUID id) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.id = id;
	}
	protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	protected String getAuthor() {
		return author;
	}
	protected void setAuthor(String author) {
		this.author = author;
	}
	protected String getCategory() {
		return category;
	}
	protected void setCategory(String category) {
		this.category = category;
	}
	protected UUID getId() {
		return id;
	}
	protected void setId(UUID id) {
		this.id = id;
	}
}
