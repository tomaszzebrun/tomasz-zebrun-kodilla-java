package com.kodilla.patterns.prototype.library;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Library extends Prototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
            for (Book book : books) {
                clonedLibrary.books.add(book);
            }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        String result = books.stream()
                .map(b -> b.toString())
                .collect(joining("\n", "", ""));
        return "Library{" +
                "name='" + name + '\'' +
                " books=\n" + result +
                "}";
    }
}
