package tw.test;

import junit.framework.Assert;
import org.junit.Test;
import tw.main.Biblioteca;
import tw.main.MenuOption;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

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
        menuList.add("3. View movies in library.");
        assertEquals(menuList, biblioteca.getMenuList());
    }

    @Test
    public void shouldViewBooksWithInput1(){
        Assert.assertEquals(MenuOption.ViewBooks, biblioteca.selectMenuOption("1"));
    }

    @Test
    public void shouldCheckLibNumberWithInput2(){
        assertEquals(MenuOption.CheckLibNumber, biblioteca.selectMenuOption("2"));
    }

    @Test
    public void shouldViewMoviesWithInput3(){
        assertEquals(MenuOption.ViewMovies, biblioteca.selectMenuOption("3"));
    }

    @Test
    public void shouldShowLoginWithInputLOGIN(){
        assertEquals(MenuOption.Login, biblioteca.selectMenuOption("login"));
    }

    @Test
    public void shouldShowErrorWithInput4(){
        assertEquals(MenuOption.Error, biblioteca.selectMenuOption("4"));
    }

    @Test
    public void testShowErrorMessage(){
        assertEquals("Select a valid option!!", biblioteca.showErrorMessage());
    }

    @Test
    public void testShowCheckNumberMessage(){
        assertEquals("Please talk to Librarian. Thank you.", biblioteca.checkNumber());
        String username = "111-1113"   ;
        biblioteca.setUsername(username);
        assertEquals("Number is: "+username, biblioteca.checkNumber());
    }

}
