package tw.book;

import org.junit.Test;
import tw.book.Book;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: sony
 * Date: 12-7-25
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class TestBook {
    @Test
    public void testShouldEquals(){
        Book book1 = new Book("Book_1");
        Book book2 = new Book("Book_1");
        assertEquals(book1, book1);
        assertEquals(book1, book2);
    }

    @Test
    public void testShouldNotEquals(){
        Book book1 = new Book("Book_1");
        Book book2 = new Book("Book_2");
        assertFalse(book1.equals(book2));
    }

    @Test
    public void testToString(){
        Book book1 = new Book("Book_1");
        assertEquals("Book_1", book1.toString());
    }
}
