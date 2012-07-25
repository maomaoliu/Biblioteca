package tw.movie;

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