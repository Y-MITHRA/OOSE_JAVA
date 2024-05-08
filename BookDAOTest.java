import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BookDAOTest {
    private Connection connection;
    private BookDAO bookDAO;

    @Before
    public void setUp() throws Exception {
        connection = mock(Connection.class);
        bookDAO = new BookDAO(connection);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        // Prepare mock ResultSet
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, true, false);
        when(resultSet.getInt("id")).thenReturn(1, 2);
        when(resultSet.getString("title")).thenReturn("Book 1", "Book 2");
        when(resultSet.getString("author")).thenReturn("Author 1", "Author 2");

        // Prepare mock Statement
        Statement statement = mock(Statement.class);
        when(statement.executeQuery(anyString())).thenReturn(resultSet);
        when(connection.createStatement()).thenReturn(statement);

        // Expected result
        List<Book> expectedBooks = Arrays.asList(
            new Book(1, "Book 1", "Author 1"),
            new Book(2, "Book 2", "Author 2")
        );

        // Test
        List<Book> actualBooks = bookDAO.getAllBooks();
        assertEquals(expectedBooks, actualBooks);
    }
}
