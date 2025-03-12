package edu.miu.cs.cs425.fairfieldlibraryapp.service;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Book;

public interface BookService {

    public abstract Iterable<Book> getAllBooks();
    public abstract Book saveBook(Book book);
    public abstract Book getBookById(Integer bookId);
//    Book updateBookById(Integer bookId);
    Book getBookByISBN(String isbn);

}
