package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("tekst", s -> "ABC" + s + "ABC"));
        System.out.println(poemBeautifier.beautify("tekst", s -> s.toUpperCase()));
        System.out.println(poemBeautifier.beautify("tekst", s -> s + "_" +s.substring(2,4)));
        System.out.println(poemBeautifier.beautify("tekst", s -> {
            String tmp = "";
            final String separator = "_";
            tmp = s.substring(2,4);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tmp);
            stringBuilder.append(separator);
            stringBuilder.append(s);
            stringBuilder.append(separator);
            stringBuilder.append(tmp);
            return stringBuilder.toString();
        }));

    }
}
