package tw.main;

public class MovieAction {

    public String showMovies() {
        return "Movie name\tDirector\tRating\n" + MovieList.getInstance().getListString();
    }

    public void action() {
        PrintTools.println("MOVIE LIST");
        PrintTools.println(this.showMovies());
        PrintTools.println("Input ENTER to return to menu.");
        System.console().readLine();
    }
}
