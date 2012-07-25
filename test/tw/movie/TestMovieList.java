package tw.movie;

import org.junit.Test;
import tw.movie.MovieList;

import static org.junit.Assert.assertEquals;

public class TestMovieList {
    @Test
    public void testShowMovieList(){
        StringBuilder movieListString = new StringBuilder();
        String[] ratings = {"10", "8", "3", "7", "7", "2", "N/A", "3", "9", "6", "N/A", "4", "8", "N/A", "1"};
        for(int i=1; i<16; i++){
            movieListString.append("Movie");
            movieListString.append(i);
            movieListString.append("\tDirector");
            movieListString.append(i);
            movieListString.append("\t");
            movieListString.append(ratings[i-1]);
            if(i<15)
                movieListString.append("\n");
        }
        assertEquals(movieListString.toString(), MovieList.getInstance().getListString());
    }
}
