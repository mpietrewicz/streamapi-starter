package com.company;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Sex;

import java.util.function.Predicate;

public class Predicates {

    public static Predicate<Actor> sexM = actor -> actor.getSex().equals(Sex.M);
    public static Predicate<Actor> sexF = actor  -> actor.getSex().equals(Sex.F);

}
