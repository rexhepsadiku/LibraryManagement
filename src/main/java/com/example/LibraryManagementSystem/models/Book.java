package com.example.LibraryManagementSystem.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "author")
    private String author;
    @Column(name = "release_day")
    private String release_day;
}
