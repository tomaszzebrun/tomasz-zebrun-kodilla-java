package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;
import static java.util.stream.Collectors.joining;

public class ChallengesMain {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        String tmp = movieStore.getMovies().entrySet().stream()
                        .flatMap(title -> title.getValue().stream())
                        .collect(joining("!","",""));
        System.out.println(tmp);
    }
}
