package finki.ukim.mk.library.controller;

import finki.ukim.mk.library.model.Book;
import finki.ukim.mk.library.model.dto.BookDto;
import finki.ukim.mk.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity <Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    private ResponseEntity <Book> save(@RequestParam BookDto bookDto){
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/{id}")
//    private ResponseEntity <Book> findById(@PathVariable Long id){
//        return this.bookService.findById(id)
//                .map(book -> ResponseEntity.ok().body(book))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }



}
