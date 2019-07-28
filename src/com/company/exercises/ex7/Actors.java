package com.company.exercises.ex7;

import com.company.Predicates;
import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.model.cinema.Sex;
import com.company.util.Provider;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Actors {

    public static void main(String[] args) {

        System.out.println(getActorsWithSpecificNames());

    }

    private static Map<Sex, List<Actor>> getActorsWithSpecificNames() {
        Map<Sex, List<Actor>> actorsWithSpecificNames = new HashMap<>();

        actorsWithSpecificNames.put(Sex.M, getActors(Predicates.sexM));
        actorsWithSpecificNames.put(Sex.F, getActors(Predicates.sexF));

        return actorsWithSpecificNames;
    }

    private static List<Actor> getActors(Predicate<Actor> sex) {
        return Provider.getMovies().stream()
                .map(Movie::getCast)
                .flatMap(Collection::stream)
                .distinct()
                .filter(actor -> actor.getName().matches("^K.*|^J.*"))
                .filter(sex)
                .sorted(Comparator.comparing(Actor::getName))
                .collect(Collectors.toList());
    }

}
