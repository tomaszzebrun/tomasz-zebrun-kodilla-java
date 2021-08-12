package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Library number 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "Author " + n,
                        LocalDate.of(2017 + n, 8, 1))));
        Library cloneLibrary = null;
        try {
            cloneLibrary = library.shallowCopy();
            cloneLibrary.setName("Library number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
            deepCloneLibrary.setName("Library number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        // somthing remove
        Book toRemove = library.getBooks().iterator().next();
        library.getBooks().remove(toRemove);
        toRemove = library.getBooks().iterator().next();
        library.getBooks().remove(toRemove);
        toRemove = library.getBooks().iterator().next();
        library.getBooks().remove(toRemove);

        //Then
        System.out.println(library);
        System.out.println(cloneLibrary);
        System.out.println(deepCloneLibrary);
        assertEquals(7, library.getBooks().size());
        assertEquals(7, cloneLibrary.getBooks().size());
        assertEquals(10, deepCloneLibrary.getBooks().size());
        assertNotEquals(deepCloneLibrary.getBooks(), library.getBooks());
    }
}
