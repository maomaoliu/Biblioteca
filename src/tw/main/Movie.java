package tw.main;

/**
 * Created by IntelliJ IDEA.
 * User: sony
 * Date: 12-7-19
 * Time: 下午1:05
 * To change this template use File | Settings | File Templates.
 */
public class Movie {
    private String name;
    private String director;
    private String rating;

    public Movie(String name, String director, String rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        StringBuilder movieString = new StringBuilder();
        return movieString.append(this.name).append("\t").append(this.director).append("\t").append(this.rating).toString();
    }
}