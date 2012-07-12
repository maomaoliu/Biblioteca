package tw;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: noam
 * Date: 12-7-11
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class TestBiblioteca {

    private Biblioteca biblioteca = new Biblioteca();

    @Test
    public void testGetWelcome (){
        assertEquals("Welcome customer!", biblioteca.showWelcome());
    }

    @Test
    public void testShowMenuList() {
        List<String> menuList = new ArrayList<String>();
        menuList.add("1. View books in library.");
        menuList.add("2. Check library number.");
        assertEquals(menuList, biblioteca.getMenuList());
    }

    @Test
    public void shouldViewBooksWithInput1(){
        assertEquals(MenuOption.ViewBooks, biblioteca.selectMenuOption(1));
    }

    @Test
    public void shouldViewBooksWithInput2(){
        assertEquals(MenuOption.CheckLibNumber, biblioteca.selectMenuOption(2));
    }

    @Test
    public void shouldViewBooksWithInput3(){
        assertEquals(MenuOption.Error, biblioteca.selectMenuOption(3));
    }

    @Test
    public void testShowErrorMessage(){
        assertEquals("Select a valid option!!", biblioteca.showErrorMessage());
    }

    @Test
    public void testShowBookList(){
        List<String> books = BookList.getInstance().getBooks();
        assertEquals(books, biblioteca.getBooks());
    }

    @Test
    public void shouldReserveBookWithBook_1(){
        assertEquals("Thank You! Enjoy the book.", biblioteca.reserveBook("Book_1"));
    }

    @Test
    public void shouldSaySorryWithBook_NotExist(){
        assertEquals("Sorry we don't have that book yet.", biblioteca.reserveBook("Book_NotExist"));
    }

    @Test
    public void testShowCheckNumberMessage(){
        assertEquals("Please talk to Librarian. Thank you.", biblioteca.checkNumber());
    }
}
