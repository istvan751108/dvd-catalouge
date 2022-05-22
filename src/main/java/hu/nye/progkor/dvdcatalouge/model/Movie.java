package hu.nye.progkor.dvdcatalouge.model;

import java.util.Objects;

/**
 * Dvd model.
 */
public class Movie {

    private int id;
    private String title;
    private String publisher;
    private int year;
    private Type type;

    public Movie() {
    }

    /**
     * Dvd constructor.
     */
    public Movie(int id, String title, String publisher, int year, Type type) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return id == movie.id && year == movie.year
                && Objects.equals(title, movie.title) && Objects.equals(publisher, movie.publisher)
                && type == movie.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, publisher, year, type);
    }

    @Override
    public String toString() {
        return "Movie{"
                +
                "id=" + id
                +
                ", title='" + title + '\''
                +
                ", publisher='" + publisher + '\''
                +
                ", year=" + year
                +
                ", type=" + type
                +
                '}';
    }
}