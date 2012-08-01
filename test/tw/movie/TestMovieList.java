package tw.movie;

import org.junit.Test;
import tw.movie.MovieList;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMovieList {
    @Test
    public void testGetMovies(){
        List<Movie> movies = MovieList.getInstance().getMovies();
        assertEquals(15, movies.size());
        assertEquals(new Movie("Movie1","Director1","10"), movies.get(0));
    }
}
