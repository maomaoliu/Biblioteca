package tw.test;

import org.junit.Test;
import tw.main.BookList;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: sony
 * Date: 12-7-19
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class TestBookList {

    private BookList bookList = BookList.getInstance();

    @Test
    public void testGetBooks(){
        assertEquals("Book_2", bookList.getBooks().get(1));
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
