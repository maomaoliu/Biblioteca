package tw.movie;

import tw.uitools.InputTools;
import tw.uitools.PrintTools;

public class MovieAction {

    public String showMovies() {
        return "Movie name\tDirector\tRating\n" + MovieList.getInstance().getListString();
    }

    public void action() {
        PrintTools.println("MOVIE LIST");
        PrintTools.println(this.showMovies());
        PrintTools.println("Input ENTER to return to menu.");
        InputTools.getLine();
    }
}
