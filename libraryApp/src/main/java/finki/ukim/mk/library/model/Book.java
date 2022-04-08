package finki.ukim.mk.library.model;

import finki.ukim.mk.library.model.enumerations.BookCategory;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private BookCategory category;

    @ManyToOne
    private User author;

    private int availableCopies;

    public Book() {}

    public Book(String name, BookCategory category, User author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
