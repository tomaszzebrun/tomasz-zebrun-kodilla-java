package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books = new HashMap<>();
        Iterator<Book> iteratorBookSet = bookSet.iterator();
        while (iteratorBookSet.hasNext()) {
            Book currentBook = iteratorBookSet.next();
            String currentBookSignature = currentBook.getSignature();
            String currentBookAuthor = currentBook.getAuthor();
            String currentBookTitle = currentBook.getTitle();
            int currentBookPublicationYear = currentBook.getPublicationYear();
            BookSignature bookSignature = new BookSignature(currentBookSignature);
            com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book book =
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book
                            (currentBookAuthor, currentBookTitle, currentBookPublicationYear);
            books.put(bookSignature, book);
        }
        return medianPublicationYear(books);
    }

}
