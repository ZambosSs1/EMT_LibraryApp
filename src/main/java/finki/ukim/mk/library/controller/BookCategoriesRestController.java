package finki.ukim.mk.library.controller;

import finki.ukim.mk.library.model.enumerations.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/categories")
public class BookCategoriesRestController {

    @GetMapping
    public List<BookCategory> getCategories(){
        return List.of(BookCategory.values());
    }
}
