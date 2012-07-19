package tw.test;

import org.junit.Test;
import tw.main.Movie;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: sony
 * Date: 12-7-19
 * Time: 下午1:07
 * To change this template use File | Settings | File Templates.
 */
public class TestMovie {
    @Test
    public void testToString(){
        Movie movie = new Movie("Movie1", "Director1", "5");
        assertEquals("Movie1\tDirector1\t5", movie.toString());
    }
}
