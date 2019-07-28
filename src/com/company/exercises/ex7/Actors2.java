package com.company.exercises.ex7;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.model.cinema.Sex;
import com.company.util.Provider;
import java.util.Collection;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Actors2 {

    public static void main(String[] args) {

        getActorsWithSpecificNames().get(Sex.F).stream().peek(System.out::println).count();
        getActorsWithSpecificNames().get(Sex.M).stream().peek(System.out::println).count();

    }

    private static Map<Sex, List<Actor>> getActorsWithSpecificNames() {
        return Provider.getMovies().stream()
                .map(Movie::getCast)
                .flatMap(Collection::stream)
                .distinct()
                .filter(actor -> actor.getName().matches("^K.*|^J.*"))
                .sorted(Comparator.comparing(Actor::getName))
                .collect(Collectors.groupingBy(Actor::getSex));

    }

}
