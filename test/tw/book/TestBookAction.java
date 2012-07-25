package tw.book;

import org.junit.Test;
import tw.book.Book;
import tw.book.BookAction;
import tw.book.BookList;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBookAction {
     BookAction action = new BookAction();

    @Test
    public void testShowBookList(){
        List<Book> books = BookList.getInstance().getBooks();
        assertEquals(books, action.getBooks());
    }

    @Test
    public void shouldReserveBookWithBook_1(){
        assertEquals("Thank You! Enjoy the book.", action.reserveBook("Book_1"));
    }

    @Test
    public void shouldSaySorryWithBook_NotExist(){
        assertEquals("Sorry we don't have that book yet.", action.reserveBook("Book_NotExist"));
    }

}
