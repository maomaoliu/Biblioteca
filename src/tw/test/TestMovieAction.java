package tw.test;

import org.junit.Test;
import tw.main.MovieAction;
import tw.main.MovieList;

import static org.junit.Assert.assertEquals;

public class TestMovieAction {
    MovieAction action = new MovieAction();

    @Test
    public void testShowMovies() {
        StringBuilder moviesString = new StringBuilder("Movie name\tDirector\tRating\n");
        moviesString.append(MovieList.getInstance().getListString());
        assertEquals(moviesString.toString(), action.showMovies());
    }
}
