package finki.ukim.mk.library.service;

import finki.ukim.mk.library.model.Author;
import finki.ukim.mk.library.model.Country;

import java.util.*;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(String name, String surname, Country country);
}
