package tw.book;

import org.junit.Test;
import tw.book.BookList;

import static junit.framework.Assert.*;

public class TestBookList {

    private BookList bookList = BookList.getInstance();

    @Test
    public void testGetBooks(){
        Book book2 = new Book("Book_2");
        assertEquals(book2, bookList.getBooks().get(1));
    }

    @Test
    public void testShouldBookInListWithInputBook_1(){
        assertTrue(bookList.isBookInList("Book_1"));
    }

    @Test
    public void testShouldBookNotInListWithInputBook_0(){
        assertFalse(bookList.isBookInList("Book_0"));
    }
}
