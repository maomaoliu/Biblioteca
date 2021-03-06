package tw.movie;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private static MovieList movieList;
    private List<Movie> movies;

    private MovieList() {
        String[] ratings = {"10", "8", "3", "7", "7", "2", "N/A", "3", "9", "6", "N/A", "4", "8", "N/A", "1"};
        movies = new ArrayList<Movie>(15);
        for(int i=0; i<15; i++){
            String number = String.valueOf(i+1);
            Movie movie = new Movie("Movie"+number, "Director"+number, ratings[i]);
            movies.add(movie);
        }
    }

    public static MovieList getInstance() {
        if(movieList==null) movieList = new MovieList();
        return movieList;
    }

    public List<Movie> getMovies() {
        return movies;
    }

}
