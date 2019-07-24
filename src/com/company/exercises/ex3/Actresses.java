package com.company.exercises.ex3;

import com.company.Predicates;
import com.company.model.cinema.Actor;
import com.company.util.Provider;

import java.util.List;
import java.util.stream.Collectors;

public class Actresses {

    public static void main(String[] args) {

        System.out.println(getActressesOfMovie(3));

    }

    private static List<Actor> getActressesOfMovie(int movieNumber) {
        List<Actor> actressesOfMovie = Provider.getMovies()
                .stream()
                .filter(movie -> movie.getNr() == movieNumber)
                .map(movie -> movie.getCast())
                .flatMap(cast -> cast.stream())
                .filter(Predicates.sexF)
                .sorted(Actor::compareTo)
                .distinct()
                .collect(Collectors.toList());

        return actressesOfMovie;
    }

}
