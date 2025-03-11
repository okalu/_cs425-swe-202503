package edu.miu.cs.cs425.citylibraryapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
