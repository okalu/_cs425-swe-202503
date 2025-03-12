package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

@NamedQuery(name = "Book.findBookByISBN", query = "select b from Book b where b.isbn = ?1")
//@NamedNativeQuery(name="findBooksByAuthorName", query="")
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(nullable = false, unique = true)
    private String isbn;
    @NotNull(message = "Book title must not be null")
    @NotEmpty // != ""
    @NotBlank // != "   "
    private String title;
    private LocalDate datePublished;
    private Integer numberOfCopiesInStock;
    @Embedded
    private Price price;
    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = true)
    private Publisher publisher;
    @ManyToMany
    @JoinTable(
            name="books_authors",
            joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name="author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;

    public Book() {
    }

    public Book(Integer bookId, String isbn, String title,
                LocalDate datePublished, Integer numberOfCopiesInStock,
                Price price, Publisher publisher, List<Author> authors) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.datePublished = datePublished;
        this.numberOfCopiesInStock = numberOfCopiesInStock;
        this.price = price;
        this.publisher = publisher;
        this.authors = authors;
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

    public Integer getNumberOfCopiesInStock() {
        return numberOfCopiesInStock;
    }

    public void setNumberOfCopiesInStock(Integer numberOfCopiesInStock) {
        this.numberOfCopiesInStock = numberOfCopiesInStock;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("bookId=" + bookId)
                .add("isbn='" + isbn + "'")
                .add("title='" + title + "'")
                .add("datePublished=" + datePublished)
                .add("numberOfCopiesInStock=" + numberOfCopiesInStock)
                .toString();
    }
}
