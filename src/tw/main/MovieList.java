package tw.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sony
 * Date: 12-7-19
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */
public class MovieList {
    private static MovieList movieList;
    private static List<Movie> movies;

    public MovieList() {
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

    public String getListString() {
        StringBuilder movieListString = new StringBuilder();
        for(int i=0; i<15; i++){
            movieListString.append(movies.get(i));
            if(i<14) movieListString.append("\n");
        }
        return movieListString.toString();
    }
}
