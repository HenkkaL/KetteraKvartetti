package refApp;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import refApp.services.formatters.BibTeXFormatter;
import refApp.services.formatters.Formatter;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(App.class, args);
    }
}
