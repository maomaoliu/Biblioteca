package tw;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tw.book.TestBookAction;
import tw.movie.TestMovieAction;
import tw.uitools.TestInputTools;
import tw.uitools.TestPrintTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestBiblioteca {

    private Biblioteca biblioteca = new Biblioteca();

    @BeforeClass
    public static void before() throws Exception {
        TestInputTools.before();
        TestPrintTools.before();
    }

    @AfterClass
    public static void after() throws Exception {
        TestInputTools.after();
        TestPrintTools.after();
    }

    @Before
    public void setUp() throws Exception {
        TestInputTools.flush();
        TestPrintTools.flush();
    }

    @Test
    public void testGetWelcome() {
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
    public void shouldViewBooksWithInput1() {
        Assert.assertEquals(MenuOption.ViewBooks, biblioteca.selectMenuOption("1"));
    }

    @Test
    public void shouldCheckLibNumberWithInput2() {
        assertEquals(MenuOption.CheckLibNumber, biblioteca.selectMenuOption("2"));
    }

    @Test
    public void shouldViewMoviesWithInput3() {
        assertEquals(MenuOption.ViewMovies, biblioteca.selectMenuOption("3"));
    }

    @Test
    public void shouldShowLoginWithInputLOGIN() {
        assertEquals(MenuOption.Login, biblioteca.selectMenuOption("login"));
    }

    @Test
    public void shouldShowErrorWithInput4() {
        assertEquals(MenuOption.Error, biblioteca.selectMenuOption("4"));
    }

    @Test
    public void testShowErrorMessage() {
        assertEquals("Select a valid option!!", biblioteca.showErrorMessage());
    }

    @Test
    public void shouldShowTipsWithoutLoginWhenCheckLibraryNumber() {
        assertEquals("Please talk to Librarian. Thank you.", biblioteca.checkNumber());
        shouldShowNumberWithLoginWhenCheckLibraryNumber();
    }

    @Test
    public void shouldShowNumberWithLoginWhenCheckLibraryNumber() {
        String username = "111-1113";
        biblioteca.setUsername(username);
        assertEquals("Number is: " + username, biblioteca.checkNumber());
    }

    @Test
    public void testShowWelcomeAndMenu() throws IOException {
        biblioteca.showWelcomeAndMenu();
        showWelcomeAndMenuAsserts(false);
    }

    @Test
    public void testActionWithViewBook() throws Exception {
        TestInputTools.inputLine("Book_1");
        TestInputTools.inputLine("tomenu");
        biblioteca.action(MenuOption.ViewBooks);
        TestBookAction testBookAction = new TestBookAction();
        testBookAction.showBooksAsserts();
        assertEquals("Thank You! Enjoy the book.", TestPrintTools.getLineFromSystemOut());
        showWelcomeAndMenuAsserts(false);
    }

    @Test
    public void testActionWithViewMovie() throws Exception {
        TestInputTools.inputLine("Any");
        biblioteca.action(MenuOption.ViewMovies);
        TestMovieAction testMovieAction = new TestMovieAction();
        testMovieAction.actionAssert();
        showWelcomeAndMenuAsserts(false);
    }

    @Test
    public void shouldLoginWhenTestActionWithLogin() throws Exception {
        TestInputTools.inputLine("111-1111");
        TestInputTools.inputLine("pw1");
        biblioteca.action(MenuOption.Login);
        assertEquals("Input username, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Input password, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("User 111-1111, welcome here!", TestPrintTools.getLineFromSystemOut());
        assertEquals("111-1111", biblioteca.getUsername());
        showWelcomeAndMenuAsserts(true);
    }

    @Test
    public void testActionWithCheckLibNumberWhenNotLogin() throws Exception {
        TestInputTools.inputLine("111-11121");
        TestInputTools.inputLine("pw1");
        biblioteca.action(MenuOption.Login);
        assertEquals("Input username, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Input password, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Username/password is not correct.", TestPrintTools.getLineFromSystemOut());
        assertEquals(null, biblioteca.getUsername());
        showWelcomeAndMenuAsserts(false);
    }

    @Test
    public void testActionWithCheckLibNumberWhenLogin() throws Exception {
        TestInputTools.inputLine("111-1111");
        TestInputTools.inputLine("pw1");
        biblioteca.action(MenuOption.Login);
        assertEquals("Input username, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("Input password, please.", TestPrintTools.getLineFromSystemOut());
        assertEquals("User 111-1111, welcome here!", TestPrintTools.getLineFromSystemOut());
        assertEquals("111-1111", biblioteca.getUsername());
        showWelcomeAndMenuAsserts(true);
        biblioteca.action(MenuOption.CheckLibNumber);
        assertEquals("Number is: " + "111-1111", TestPrintTools.getLineFromSystemOut());
    }

    @Test
    public void testActionWithError() throws Exception {
        biblioteca.action(MenuOption.CheckLibNumber);
        assertEquals("Please talk to Librarian. Thank you.", TestPrintTools.getLineFromSystemOut());
    }

    public void showWelcomeAndMenuAsserts(boolean hasLogin) throws IOException {
        String startsLine = "******************************************";
        assertEquals(startsLine, TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars(biblioteca.showWelcome()), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars(" "), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("MENU"), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("1. View books in library."), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("2. Check library number."), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("3. View movies in library."), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars(" "), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("Input NUMBER to choose menu options."), TestPrintTools.getLineFromSystemOut());
        if (!hasLogin) {
            assertEquals(TestPrintTools.getStringWithStars("Input LOGIN to log in."), TestPrintTools.getLineFromSystemOut());
        }
        assertEquals(TestPrintTools.getStringWithStars("Input 'QUIT' to terminate."), TestPrintTools.getLineFromSystemOut());
        assertEquals(startsLine, TestPrintTools.getLineFromSystemOut());
    }
}
