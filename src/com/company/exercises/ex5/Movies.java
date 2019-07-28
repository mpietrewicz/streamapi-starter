package com.company.exercises.ex5;

import com.company.Predicates;
import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.util.Provider;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Movies {

    public static void main(String[] args) {

        List<Movie> menMovies = getMenMovies();
        System.out.println("Lista filmów bez kobiecej obsady: " +menMovies);
        System.out.println("Liczba filmów bez kobiecej obsady: " +menMovies.size());

    }

    private static List<Movie> getMenMovies() {
        return Provider.getMovies().stream()
                .filter(movie -> movie.getCast().stream().allMatch(Predicates.sexM))
                .collect(Collectors.toList());
    }

}
