package finki.ukim.mk.library.service.impl;

import finki.ukim.mk.library.model.Book;
import finki.ukim.mk.library.model.User;
import finki.ukim.mk.library.model.enumerations.BookCategory;
import finki.ukim.mk.library.repository.BookRepository;
import finki.ukim.mk.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    //TODO
    @Override
    public Optional<Book> save(String name, BookCategory category, User author, int availableCopies) {
        return Optional.empty();
    }

    //TODO
    @Override
    public Optional<Book> edit(Long id, String name, BookCategory category, User author, int availableCopies) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
