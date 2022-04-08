package finki.ukim.mk.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
public class LibraryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
    }

}
