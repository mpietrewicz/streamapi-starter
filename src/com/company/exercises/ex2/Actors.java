package com.company.exercises.ex2;

import com.company.Predicates;
import com.company.model.cinema.Actor;
import com.company.model.cinema.Sex;
import com.company.util.Provider;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Actors {

    public static void main(String[] args) {

        List<Actor> actors = getActors();
        System.out.println("Lista aktorów: " +actors);
        System.out.println("Liczba aktorów: " +actors.size());

    }

    private static List<Actor> getActors() {

        Predicate<Actor> sexM = p -> p.getSex().equals(Sex.M);

        List<Actor> actors = Provider.getMovies()
                .stream()
                .map(movie -> movie.getCast())
                .flatMap(cast -> cast.stream())
                .filter(Predicates.sexM)
                .distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());

        return actors;
    }

}
