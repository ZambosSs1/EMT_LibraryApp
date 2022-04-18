package finki.ukim.mk.library.controller;

import finki.ukim.mk.library.model.Book;
import finki.ukim.mk.library.model.dto.BookDto;
import finki.ukim.mk.library.model.exceptions.BookNotFoundException;
import finki.ukim.mk.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping({"/", "/books"})
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity <Book> save (@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity <Book> edit (@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/mark/{id}")
    public ResponseEntity markById(@PathVariable Long id){
        try {
            this.bookService.markById(id);
            return ResponseEntity.ok().build();
        }catch (BookNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);
        if (this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
