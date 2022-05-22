package hu.nye.progkor.dvdcatalouge.service.impl;

import hu.nye.progkor.dvdcatalouge.model.Type;
import hu.nye.progkor.dvdcatalouge.model.Movie;
import hu.nye.progkor.dvdcatalouge.model.exception.NotFoundException;
import hu.nye.progkor.dvdcatalouge.service.DvdCatalougeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DvdCatalougeServiceImplTest {

    private static final Movie KILLBILL = new Movie(1, "Kill Bill 2", "Miramax",2010, Type.Dráma);
    private static final Movie RAMBO = new Movie(2, "RAMBÓ", "Paramount", 2008, Type.Akciófilm);
    private static final Movie INDIANA1 = new Movie(3, "AZ ELVESZETT FRIGYLÁDA FOSZTOGATÓI", "Fox", 2003, Type.Kaland);
    private static final Movie SNOWWHITE = new Movie(4, "HÓFEHÉRKE ÉS A HÉT TÖRPE", "Disney",2004, Type.Animáció);
    private static final List<Movie> MOVIES = List.of(
            KILLBILL,
            RAMBO,
            INDIANA1,
            SNOWWHITE
    );
    private static final List<Movie> PROFILEMOVIES = List.of(

    );
    public static final int UNKNOWN_MOVIE_ID = -1;


    private DvdCatalougeService underTest;

    @BeforeEach
    void setUp() {
        underTest = new DvdCatalougeServiceImpl(MOVIES);
    }

    @Test
    void getAllMovieShouldReturnAllMovie() {
        // when
        final List<Movie> actual = underTest.getAllMovie();
        // then
        assertThat(actual).isEqualTo(MOVIES);
    }

    @Test
    void getMovieShouldReturnMovieWhenGivenIdOfExistingMovie() {
        // when
        final Movie actual = underTest.getMovie(KILLBILL.getId());
        // then
        assertThat(actual).isEqualTo(KILLBILL);
    }

    @Test
    void getMovieShouldThrowNotFoundExceptionWhenGivenIdOfNotExistingMovie() {
        // when then
        assertThrows(NotFoundException.class, () -> underTest.getMovie( UNKNOWN_MOVIE_ID));
    }

    @Test
    void getAllMovieProfileShouldReturnAllMovieFromProfile() {
        // when
        final List<Movie> actual = underTest.getAllMovieProfile();
        // then
        assertThat(actual).isEqualTo(PROFILEMOVIES);
    }

}
