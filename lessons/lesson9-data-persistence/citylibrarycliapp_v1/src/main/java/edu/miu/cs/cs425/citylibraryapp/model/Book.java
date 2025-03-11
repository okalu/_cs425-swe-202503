package edu.miu.cs.cs425.citylibraryapp.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.StringJoiner;
import java.util.List;

@Entity
@Table(name = "books")
@NamedQuery(name ="Book.findScienceBooks", query = "SELECT b FROM Book b where b.isbn LIKE '978'")
@NamedNativeQuery(name ="Book.findScienceBooks2", query = "SELECT b.book_id, b.isbn FROM books b where b.isbn LIKE '978'")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer bookId;
    @Column(unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePublished;
    @ManyToOne
    @JoinColumn(name = "publish_id", nullable = true)
    private Publisher publisher;
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;

    public Book(Integer bookId, String isbn, String title, LocalDate datePublished, Publisher publisher) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.datePublished = datePublished;
        this.publisher = publisher;
    }

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("bookId=" + bookId)
                .add("isbn='" + isbn + "'")
                .add("title='" + title + "'")
                .add("datePublished=" + datePublished)
                .add("publisher=" + publisher)
                .toString();
    }
}
