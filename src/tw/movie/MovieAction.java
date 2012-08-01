package tw.movie;

import tw.uitools.InputTools;
import tw.uitools.PrintTools;

public class MovieAction {

    public String showMovies() {
        StringBuilder movies = new StringBuilder("Movie name\tDirector\tRating\n");
        for (Movie movie: MovieList.getInstance().getMovies()){
            movies.append(movie).append("\n");
        }
        return movies.toString();
    }

    public void action() {
        PrintTools.println("MOVIE LIST");
        PrintTools.println(this.showMovies());
        PrintTools.println("Input ENTER to return to menu.");
        InputTools.getLine();
    }
}
