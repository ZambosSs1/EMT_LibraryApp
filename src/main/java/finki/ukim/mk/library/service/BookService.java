package finki.ukim.mk.library.service;

import finki.ukim.mk.library.model.Book;
import finki.ukim.mk.library.model.User;
import finki.ukim.mk.library.model.dto.BookDto;
import finki.ukim.mk.library.model.enumerations.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;

public interface BookService{

    List<Book> findAll();

    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> findById(Long id);

    void markById(Long id);

    Optional<Book> save (BookDto bookDto);

    Optional<Book> save (String name, BookCategory category, Long authorId, int availableCopies);

    Optional<Book> edit (Long id, BookDto bookDto);

    void deleteById(Long id);



}
