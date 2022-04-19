package finki.ukim.mk.library.config;

import finki.ukim.mk.library.model.enumerations.BookCategory;
import finki.ukim.mk.library.model.enumerations.Role;
import finki.ukim.mk.library.model.exceptions.CountryNotFoundException;
import finki.ukim.mk.library.service.AuthorService;
import finki.ukim.mk.library.service.BookService;
import finki.ukim.mk.library.service.CountryService;
import finki.ukim.mk.library.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;

    public DataInitializer(CountryService countryService, BookService bookService, AuthorService authorService, UserService userService) {
        this.countryService = countryService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.userService = userService;
    }

    @PostConstruct
    public void initData() {
        this.userService.register("admin", "AdminName", "AdminSurname", "admin", Role.ROLE_LIBRARIAN);

        this.countryService.save("England", "Europe");
        this.countryService.save("Germany", "Europe");
        this.countryService.save("USA", "North America");
        this.countryService.save("Russia", "Europe");

        this.authorService.save("Arthur", "Conan Doyle", this.countryService.findById(1L).orElseThrow(() -> new CountryNotFoundException(1L)));
        this.authorService.save("Agatha", "Christie", this.countryService.findById(1L).orElseThrow(() -> new CountryNotFoundException(1L)));
        this.authorService.save("J.", "K. Rowling", this.countryService.findById(1L).orElseThrow(() -> new CountryNotFoundException(1L)));
        this.authorService.save("Sebastian", "Fitzek", this.countryService.findById(2L).orElseThrow(() -> new CountryNotFoundException(2L)));
        this.authorService.save("Edgar", "Allan Poe", this.countryService.findById(3L).orElseThrow(() -> new CountryNotFoundException(3L)));
        this.authorService.save("Jack", "London", this.countryService.findById(3L).orElseThrow(() -> new CountryNotFoundException(3L)));
        this.authorService.save("William", "Shakespeare", this.countryService.findById(1L).orElseThrow(() -> new CountryNotFoundException(1L)));
        this.authorService.save("Leo", "Tolstoy", this.countryService.findById(4L).orElseThrow(() -> new CountryNotFoundException(4L)));

        this.bookService.save("Midnight Murders", BookCategory.THRILLER, 2L, 150);
        this.bookService.save("Sherlock Holmes", BookCategory.THRILLER, 1L, 50);
        this.bookService.save("The Raven", BookCategory.CLASSICS, 5L, 70);
        this.bookService.save("Passenger 23", BookCategory.DRAMA, 4L, 100);
        this.bookService.save("Harry Potter", BookCategory.FANTASY, 3L, 305);
        this.bookService.save("Fantastic Beasts and Where to find them", BookCategory.FANTASY, 3L, 207);
        this.bookService.save("The Call of the Wild", BookCategory.NOVEL, 6L, 59);
        this.bookService.save("Romeo and Juliet", BookCategory.DRAMA, 7L, 150);
        this.bookService.save("War and Peace", BookCategory.DRAMA, 8L, 250);

    }
}
