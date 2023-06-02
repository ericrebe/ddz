package org.informatics.service;

import org.informatics.models.Book;
import org.informatics.models.BookForSelling;

import java.util.*;

public class BookServiceImpl implements BookService{
    private List<Book> soldBooksReport;
    private Map<Book, Integer> booksRating;

    public BookStoreServiceImpl() {
        soldBooksReport = new ArrayList<>();
        booksRating = new HashMap<>();
    }

    @Override
    public boolean addBookToSoldReport(Book book) {
        return soldBooksReport.add(book);
    }

    @Override
    public void addBookForSelling(BookForSelling bookForSelling, int rating) {
        booksRating.put(bookForSelling.getBook(), rating);
    }

    @Override
    public void printSoldBooksReport() {
        for (Book book : soldBooksReport) {
            System.out.println(book.getName());
        }
    }

    @Override
    public void printBooksRating() {
        for (Map.Entry<Book, Integer> entry : booksRating.entrySet()) {
            Book book = entry.getKey();
            int rating = entry.getValue();
            System.out.println(book.getName() + ": " + rating);
        }
    }

    @Override
    public Set<BookForSelling> getBooksForSellingByPrice(double maxPrice) {
        Set<BookForSelling> books = new HashSet<>();
        for (Book book : soldBooksReport
        ) {
            if (book instanceof BookForSelling) {
                BookForSelling bookForSelling = (BookForSelling) book;
                if (bookForSelling.getPrice() < maxPrice) {
                    books.add(bookForSelling);
                }
            }
        }
        return books;
    }
}
