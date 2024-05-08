import java.util.List;

public class BookController {
    private BookDAO bookDAO;
    private BookView bookView;

    public BookController(BookDAO bookDAO, BookView bookView) {
        this.bookDAO = bookDAO;
        this.bookView = bookView;
    }

    public void displayAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        bookView.displayBooks(books);
    }

    public void addBook(String title, String author) {
        Book book = new Book(0, title, author);
        bookDAO.addBook(book);
    }
	
	public void updateBook(int id, String title, String author) {
        Book book = new Book(id, title, author);
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
    // Other methods for updating and deleting books can be added here
}
