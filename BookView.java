import java.util.List;

public class BookView {
    public void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println();
        }
    }
}
