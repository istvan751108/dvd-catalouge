package hu.nye.progkor.dvdcatalouge.service;

import java.util.List;

import hu.nye.progkor.dvdcatalouge.model.Movie;

/**
 * Service interface.
 */
public interface DvdCatalougeService {

    List<Movie> getAllMovie();

    Movie getMovie(int id);

    void addMovie(int id);

    void deleteMovie(int id);

    List<Movie> getAllMovieProfile();
}