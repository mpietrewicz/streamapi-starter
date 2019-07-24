package com.company.exercises.ex4;

import com.company.model.cinema.Movie;
import com.company.util.Provider;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Title {

    public static void main(String[] args) {

        System.out.println(getTitle(3, "Nancy Meyers"));
    }

    private static String getTitle(int movieNumber, String director) {
        int i = 0;
        return Provider.getMovies()
                .stream()
                .filter(movie -> movie.getDirector().equals(director))
                .sorted((o1, o2) -> o1.getNr() - o2.getNr())
                .map(Movie::getTitle)
                .skip(movieNumber - 1)
                .findFirst()
                .orElse("Nie znaliezono filmu");
    }

}
