import org.example.Movie;
import org.example.SearchMethods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SearchMethodsTest {

    private SearchMethods searchMethods = new SearchMethods();
    private List<Movie> testMovies;

    @BeforeEach
    void setUp() {
        searchMethods = new SearchMethods();
        // Test data av 5 riktiga filmer med fejkade datum
        testMovies = List.of(

                new Movie("1", "Mortal Kombat", 1975, List.of("Action", "Fantasy"), "Simon McQuoid",
                        List.of("Lewis Tan", "Jessica McNamee"), 6.1, List.of("English"), 110
                ),
                new Movie("2", "Troy", 1975, List.of("Action", "Drama"), "Wolfgang Petersen",
                        List.of("Brad Pitt"), 7.3, List.of("English"), 196
                ),
                new Movie("3", "Pulp Fiction", 1975,List.of("Crime","Drama"), "Quentin Tarantino",
                        List.of("John Travolta", "Sameul L. Jackson"), 8.8, List.of("English"), 154
                ),
                new Movie("4", "The Godfather", 1975, List.of("Psychological Drama"), "Francis Ford Coppola",
                        List.of("Marlin Brando", "Al Pacino"), 9.2, List.of("English", "Italian"), 175
                ),
                new Movie("5", "Fight Club", 1975, List.of("Thriller"), "David Fincher",
                        List.of("Brad Pitt", "Edward Norton"), 8.8, List.of("English"), 139
                ));
    }
    @Test
    void testHowManyMovies() {
        assertEquals(5, searchMethods.howManyMovies(testMovies));
    }
    @Test
    void testLengthOfLongestMovie() {
        assertEquals(196, searchMethods.lengthOfLongestMovie(testMovies));
    }
    @Test
    void testHowManyUniqueGenres() {
        assertEquals(6, searchMethods.howManyUniqueGenres(testMovies));
    }
    @Test
    void testActorsInHighestRatedMovie(){
        assertEquals(List.of("Marlin Brando", "Al Pacino"),  searchMethods.actorsInHighestRatedMovie(testMovies));
    }
    @Test
    void testMovieWithTheFewestActorsListed(){
        assertEquals("Troy", searchMethods.movieWithTheFewestActorsListed(testMovies));
    }
    @Test
    void testAllUniqueLanguages(){
        assertEquals(2, searchMethods.allUniqueLanguages(testMovies));
    }
    @Test
    void testAnyDoubletteTitles(){
        assertFalse(searchMethods.anyDoubletteTitles(testMovies));
    }
    @Test
    void testAmountOfActorsInMoreThanOneMovie(){
        assertEquals(1, searchMethods.amountOfActorsInMoreThanOneMovie(testMovies)); //Brad Pitt i Fight Club och Troy
    }
    @Test
    void testActorInTheMostMovies(){
        assertEquals("Brad Pitt", searchMethods.actorInTheMostMovies(testMovies));
    }
    }

