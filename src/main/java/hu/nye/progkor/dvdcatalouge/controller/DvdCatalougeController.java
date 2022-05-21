package hu.nye.progkor.dvdcatalouge.controller;

import java.util.List;

import hu.nye.progkor.dvdcatalouge.model.Movie;
import hu.nye.progkor.dvdcatalouge.model.exception.NotFoundException;
import hu.nye.progkor.dvdcatalouge.service.DvdCatalougeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller class.
 */
@Controller
@RequestMapping("/movie")
public class DvdCatalougeController {

    private static final String MOVIE_LIST_TEMPLATE_NAME = "movie/list";
    private static final String MOVIE_LIST_TEMPLATE_NAME_P = "movie/profile";
    private static final String MOVIE_ATTRIBUTE_NAME = "movie";

    private final DvdCatalougeService dvdCatalougeService;

    public DvdCatalougeController(final DvdCatalougeService dvdCatalougeService) {
        this.dvdCatalougeService = dvdCatalougeService;
    }

    /**
     * Get all movie.
     */
    @GetMapping
    public String getAllMovie(final Model model) {
        final List<Movie> movies = dvdCatalougeService.getAllMovie();
        model.addAttribute("movies", movies);
        return MOVIE_LIST_TEMPLATE_NAME;
    }

    /**
     * Get movie id.
     */
    @GetMapping("/{id}")
    public String getMovie(final Model model, final @PathVariable int id) {
        final Movie movie = dvdCatalougeService.getMovie(id);
        model.addAttribute(MOVIE_ATTRIBUTE_NAME, movie);
        return MOVIE_LIST_TEMPLATE_NAME_P;
    }

    /**
     * Delete selected movie.
     */
    @GetMapping("/{id}/delete")
    public String deleteMovie(final Model model, final @PathVariable("id") int id) {
        try {
            dvdCatalougeService.deleteMovie(id);
        } catch (NotFoundException e) {
            // Ignored
        }
        final List<Movie> movies = dvdCatalougeService.getAllMovieProfile();
        model.addAttribute("movies", movies);
        return MOVIE_LIST_TEMPLATE_NAME_P;
    }

    /**
     * Put movie to profile.
     */
    @GetMapping("/{id}/put")
    public String addMovie(final Model model, final @PathVariable("id") int id) {
        try {
            dvdCatalougeService.addMovie(id);
        } catch (NotFoundException e) {
            // Ignored
        }
        final List<Movie> movies = dvdCatalougeService.getAllMovieProfile();
        model.addAttribute("movies", movies);
        return MOVIE_LIST_TEMPLATE_NAME_P;
    }

    /**
     * Get all movie from profile.
     */
    @GetMapping("/profile")
    public String getAllMovieProfile(final Model model) {
        final List<Movie> movies2 = dvdCatalougeService.getAllMovieProfile();
        model.addAttribute("movies", movies2);
        return MOVIE_LIST_TEMPLATE_NAME_P;
    }
}