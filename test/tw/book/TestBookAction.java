package tw.book;

import org.junit.*;
import tw.uitools.TestInputTools;
import tw.uitools.TestPrintTools;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestBookAction {
    BookAction action = new BookAction();

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
    public void testShowBookList() {
        List<Book> books = BookList.getInstance().getBooks();
        assertEquals(books, action.getBooks());
    }

    @Test
    public void shouldReserveBookWithBook_1() {
        assertEquals("Thank You! Enjoy the book.", action.reserveBook("Book_1"));
    }

    @Test
    public void shouldSaySorryWithBook_NotExist() {
        assertEquals("Sorry we don't have that book yet.", action.reserveBook("Book_NotExist"));
    }

    @Test
    public void testShowBooks() throws Exception {
        action.showBooks();
        showBooksAsserts();
    }

    @Test
    public void testActionWithInput_TOMENU() throws Exception {
        TestInputTools.inputLine("tomenu");
        action.action();
        showBooksAsserts();
    }

    @Test
    public void testActionWithInput_Book_1_And_TOMENU() throws Exception {
        TestInputTools.inputLine("Book_1");
        TestInputTools.inputLine("tomenu");
        action.action();
        showBooksAsserts();
        assertEquals(action.reserveBook("Book_1"), TestPrintTools.getLineFromSystemOut());
    }

    @Test
    public void testActionWithInput_Book_7_And_TOMENU() throws Exception {
        TestInputTools.inputLine("Book_7");
        TestInputTools.inputLine("tomenu");
        action.action();
        showBooksAsserts();
        assertEquals(action.reserveBook("Book_7"), TestPrintTools.getLineFromSystemOut());
    }

    public void showBooksAsserts() throws IOException {
        String startsLine = "******************************************";
        TestPrintTools testPrintTools = new TestPrintTools();
        assertEquals(startsLine, TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("BOOK LIST"), TestPrintTools.getLineFromSystemOut());
        for (Book book : action.getBooks())
            assertEquals(TestPrintTools.getStringWithStars(book.toString()), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars(" "), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("Input BOOK NAME to reserve books."), TestPrintTools.getLineFromSystemOut());
        assertEquals(TestPrintTools.getStringWithStars("Input 'TOMENU' to return to menu."), TestPrintTools.getLineFromSystemOut());
        assertEquals(startsLine, TestPrintTools.getLineFromSystemOut());
    }

}
