package finki.ukim.mk.library.config;

import finki.ukim.mk.library.model.enumerations.BookCategory;
import finki.ukim.mk.library.model.enumerations.Role;
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

        this.countryService.save("Serbia", "Europe");
        this.countryService.save("Macedonia", "Europe");
        this.countryService.save("Russia", "Europe");
        this.countryService.save("Canada", "North America");
        this.countryService.save("USA", "North America");
        this.countryService.save("Argentina", "South America");
        this.countryService.save("China", "Asia");

        this.authorService.save("Arthur", "Connan Doyle", this.countryService.findById(1L).get());
        this.authorService.save("Agatha", "Christie", this.countryService.findById(1L).get());
        this.authorService.save("Steven", "King", this.countryService.findById(5L).get());
        this.authorService.save("Sebastian", "Fizcek", this.countryService.findById(6L).get());
        this.authorService.save("Grigor", "Prlicev", this.countryService.findById(2L).get());

        this.bookService.save("Midnight Murders", BookCategory.THRILLER, 2L, 15);

    }
}
