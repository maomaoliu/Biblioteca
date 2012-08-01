package tw.movie;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tw.uitools.TestInputTools;
import tw.uitools.TestPrintTools;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestMovieAction {
    MovieAction action = new MovieAction();

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
    public void testAction() throws Exception {
        TestInputTools.inputLine("any");
        action.action();
        actionAssert();
    }

    public void actionAssert() throws IOException {
        assertEquals("MOVIE LIST", TestPrintTools.getLineFromSystemOut());
        assertEquals("Movie name	Director	Rating", TestPrintTools.getLineFromSystemOut());
        for(Movie movie: MovieList.getInstance().getMovies()){
            assertEquals(movie.toString(), TestPrintTools.getLineFromSystemOut());
        }
        assertEquals("", TestPrintTools.getLineFromSystemOut());
        assertEquals("Input ENTER to return to menu.", TestPrintTools.getLineFromSystemOut());
    }
}
