package tw.movie;

import org.junit.Test;
import tw.movie.Movie;

import static org.junit.Assert.assertEquals;

public class TestMovie {
    @Test
    public void testToString(){
        Movie movie = new Movie("Movie1", "Director1", "5");
        assertEquals("Movie1\tDirector1\t5", movie.toString());
    }
}
