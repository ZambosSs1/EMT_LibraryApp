package finki.ukim.mk.library.service.impl;

import finki.ukim.mk.library.model.Author;
import finki.ukim.mk.library.model.Country;
import finki.ukim.mk.library.repository.AuthorRepository;
import finki.ukim.mk.library.service.AuthorService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        Author author = this.authorRepository.findByNameOrSurname(name, surname);
        if(author == null){
            author = new Author(name, surname, country);
        }
        return Optional.of(this.authorRepository.save(author));
    }
}
