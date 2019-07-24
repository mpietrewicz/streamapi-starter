package com.company;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Sex;

import java.util.function.Predicate;

public class Predicates {

    public static Predicate<Actor> sexM = p -> p.getSex().equals(Sex.M);
    public static Predicate<Actor> sexF = p -> p.getSex().equals(Sex.F);

}
