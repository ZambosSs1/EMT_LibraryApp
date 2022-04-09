package finki.ukim.mk.library.model.dto;

import finki.ukim.mk.library.model.enumerations.BookCategory;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {

    private String name;

    private BookCategory category;

    private String author;

    private int availableCopies;

    public BookDto() {}

    public BookDto(String name, BookCategory category, String author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
