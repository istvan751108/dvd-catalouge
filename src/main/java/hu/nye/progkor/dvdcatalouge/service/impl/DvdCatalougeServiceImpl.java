package hu.nye.progkor.dvdcatalouge.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.nye.progkor.dvdcatalouge.model.Movie;
import hu.nye.progkor.dvdcatalouge.model.Type;
import hu.nye.progkor.dvdcatalouge.model.exception.NotFoundException;
import hu.nye.progkor.dvdcatalouge.service.DvdCatalougeService;
import org.springframework.stereotype.Service;

/**
 * Service impl.
 */
@Service
public class DvdCatalougeServiceImpl implements DvdCatalougeService {

    private static final List<Movie> DATABASE = new ArrayList<>();
    private static final List<Movie> DATABASE2 = new ArrayList<>();

    static {
        DATABASE.add(new Movie(1, "Kill Bill 2", "Miramax", 2010, Type.Dráma));
        DATABASE.add(new Movie(2, "RAMBÓ", "Paramount", 2008, Type.Akciófilm));
        DATABASE.add(new Movie(3, "AZ ELVESZETT FRIGYLÁDA FOSZTOGATÓI", "Fox", 2003, Type.Kaland));
        DATABASE.add(new Movie(4, "HÓFEHÉRKE ÉS A HÉT TÖRPE", "Disney", 2004, Type.Animáció));
    }

    public DvdCatalougeServiceImpl(List<Movie> movies) {
    }


    @Override
    public List<Movie> getAllMovie() {
        return Collections.unmodifiableList(DATABASE);
    }

    @Override
    public Movie getMovie(final int id) {
        return DATABASE.stream()
                .filter(movie -> movie.getId() == (id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void addMovie(final int id) {
        final Movie movie = getMovie(id);
        DATABASE2.add(movie);
    }

    @Override
    public void deleteMovie(final int id) {
        final Movie movie = getMovie(id);
        DATABASE2.remove(movie);
    }

    @Override
    public List<Movie> getAllMovieProfile() {
        return Collections.unmodifiableList(DATABASE2);
    }

}