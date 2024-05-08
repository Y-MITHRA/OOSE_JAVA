public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        BookView bookView = new BookView();
        BookController bookController = new BookController(bookDAO, bookView);

        // Display all books
        System.out.println("All Books:");
        bookController.displayAllBooks();

        // Add a new book
        bookController.addBook("Java Programming", "John Doe");
        System.out.println("Book added successfully.");

        // Display all books after adding
        System.out.println("\nAll Books after adding:");
        bookController.displayAllBooks();
		
		bookController.updateBook(1, "New Java Programming", "Jane Doe");
        System.out.println("Book updated successfully.");

        // Display all books after updating
        System.out.println("\nAll Books after updating:");
        bookController.displayAllBooks();

        // Delete a book
        bookController.deleteBook(1);
        System.out.println("Book deleted successfully.");

        // Display all books after deleting
        System.out.println("\nAll Books after deleting:");
        bookController.displayAllBooks();

    }
}
