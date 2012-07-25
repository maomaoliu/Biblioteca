package tw.movie;

import org.junit.Test;
import tw.movie.MovieAction;
import tw.movie.MovieList;

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
