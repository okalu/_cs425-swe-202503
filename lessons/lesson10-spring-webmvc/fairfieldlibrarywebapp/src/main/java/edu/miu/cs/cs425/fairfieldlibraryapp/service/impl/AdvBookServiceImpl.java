package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Book;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.BookRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvBookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public AdvBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        System.out.println("Executing Advanced service impl...");
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }

//    @Override
//    public Book addNewBook(Book book) {
//        book.setTitle(book.getTitle() + "101");
//        return bookRepository.save(book);
//    }

    @Override
    public Book getBookById(Integer bookId) {
        return null;
    }

//    @Override
//    public Book updateBookById(Integer bookId) {
//        return null;
//    }

    @Override
    public Book getBookByISBN(String isbn) {
        return null;
    }
}
