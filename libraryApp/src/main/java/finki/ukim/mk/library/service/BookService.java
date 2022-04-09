package finki.ukim.mk.library.service;

import finki.ukim.mk.library.model.Book;
import finki.ukim.mk.library.model.User;
import finki.ukim.mk.library.model.dto.BookDto;
import finki.ukim.mk.library.model.enumerations.BookCategory;

import java.util.*;

public interface BookService{

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save (BookDto bookDto);

    Optional<Book> edit (Long id, String name, BookCategory category, User author, int availableCopies);

    void deleteById(Long id);



}
