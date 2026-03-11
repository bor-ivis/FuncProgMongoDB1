package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchMethods {

    //Hur många filmer gjordes 1975    ~Högre ordnings funktion~
    public long howManyMovies(List<Movie> movieList) {
        //return movieList.stream().filter(m -> m.getYear() == 1975).count();
        return movieList.stream().filter(movieFromYear(1975)).count();
    }

    //Hitta längden på den film som var längst
    public int lengthOfLongestMovie(List <Movie> movieList){
        return movieList.stream().mapToInt(m -> m.getRuntime()).max().orElse(0);
    }
    //Hur många unika genrer hade filmerna från 1975   ~Högre ordnings funktion~
    public long howManyUniqueGenres(List<Movie> movieList){
        //return movieList.stream().filter(m -> m.getYear()==1975).map(Movie::getGenres).distinct().count();
        return movieList.stream().filter(movieFromYear(1975)).map(Movie::getGenres).distinct().count();
    }
    //Vilka skådisar som spelade i den film som hade högst imdb-rating.
    public List<String> actorsInHighestRatedMovie (List<Movie> movieList){
        return movieList.stream().max(Comparator.comparingDouble(Movie::getImdbRating)).map(Movie::getCast).orElse(null);
    }
    //Vad är titeln på den film som hade minst antal skådisar listade
    public String movieWithTheFewestActorsListed (List<Movie> movieList){
        return movieList.stream().min(Comparator.comparing(m -> m.getCast().size())).map(Movie::getTitle).orElse("");
    }
    //Hur många skådisar var med i mer än 1 film?
    public long amountOfActorsInMoreThanOneMovie (List<Movie> movieList){
        return movieList.stream().flatMap(m -> m.getCast().stream()).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream().
                filter(count -> count > 1).count();
    }
    //Vad hette den skådis som var med i flest filmer?
    public String actorInTheMostMovies (List<Movie> movieList){
        return movieList.stream().flatMap(m -> m.getCast().stream()).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().
                max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }
    //Hur många unika språk har filmerna
    public long allUniqueLanguages (List<Movie> movieList){
        return movieList.stream().map(m -> m.getLanguages()).distinct().count();
    }
    //Finns det några dubletter av film titlar
    public Boolean anyDoubletteTitles (List<Movie> movieList){
        return movieList.stream().collect(Collectors.groupingBy(Movie::getTitle, Collectors.counting())).
                values().stream().anyMatch(count -> count > 1);
    }
    //En högre ordnings funktion för getYear()==1975 eftersom den används två gånger i uppgiften
    public Predicate<Movie> movieFromYear(int year){
        return m -> m.getYear()== year;
    }
}
