package refApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import refApp.services.formatters.BibTeXFormatter;
import refApp.services.formatters.Formatter;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
//      Book book = new Book();
//      System.out.println(book.sayHello());
        SpringApplication.run(App.class, args);
    }
}
