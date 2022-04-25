package finki.ukim.mk.library.service.impl;

import finki.ukim.mk.library.model.Author;
import finki.ukim.mk.library.model.Book;
import finki.ukim.mk.library.model.dto.BookDto;
import finki.ukim.mk.library.model.enumerations.BookCategory;
import finki.ukim.mk.library.model.exceptions.AuthorNotFoundException;
import finki.ukim.mk.library.model.exceptions.BookNotFoundException;
import finki.ukim.mk.library.repository.AuthorRepository;
import finki.ukim.mk.library.repository.BookRepository;
import finki.ukim.mk.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void markById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        int newAvailableCopies = book.getAvailableCopies() - 1;
        book.setAvailableCopies(newAvailableCopies);

        this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Book newBook = new Book(bookDto.getName(), bookDto.getCategory(), author,bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(newBook));
    }

    @Override
    public Optional<Book> save(String name, BookCategory category, Long authorId, int availableCopies) {
        if (this.authorRepository.findById(authorId).isEmpty()){
            throw new AuthorNotFoundException(authorId);
        }
        Author author = this.authorRepository.findById(authorId).get();
        Book newBook = new Book(name, category, author, availableCopies);
        return Optional.of(this.bookRepository.save(newBook));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
