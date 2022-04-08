package finki.ukim.mk.library.service;

import finki.ukim.mk.library.model.Country;

import java.util.*;

public interface CountryService {

    List<Country> findAll();
    Optional<Country> findById(Long id);
    List<Country> findByContinent(String continent);

}
