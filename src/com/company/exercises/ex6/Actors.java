package com.company.exercises.ex6;

import com.company.model.cinema.Actor;
import com.company.util.Provider;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Actors {

    public static void main(String[] args) {

        List<Actor> actorsWithSpecificNames = getActorsWithSpecificNames();
        System.out.println(actorsWithSpecificNames);
        System.out.println(actorsWithSpecificNames.size());

    }

    public static List<Actor> getActorsWithSpecificNames() {
        return Provider.getMovies().stream()
                .map(movie -> movie.getCast())
                .flatMap(actors -> actors.stream())
                .distinct()
                .filter(actor -> actor.getName().matches("^K.*|^J.*"))
                .sorted(Comparator.comparing(Actor::getSex))
                .collect(Collectors.toList());
    }

}
