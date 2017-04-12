package refApp.services;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import refApp.domain.Article;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Reference;

/**
 * Service class for references
 */
@Service
public class ReferenceService {

    /**
     * Method for adding a reference
     *
     * @param allReferences list where the references are added // HUOM! Tämä
     * muutettava kun tietokantaan tallennus toiminnassa
     * @param params user given values for a reference
     */
    public void addReference(List<Reference> allReferences, Map<String, String> params) {
        switch (params.get("type")) {
            case "article":
                allReferences.add(new Article(params.get("title"), new Author(params.get("author")), params.get("article_journal"), params.get("year"), params.get("article_month"), params.get("article_volume"), params.get("article_number"), params.get("article_pages_start").length() > 0 ? formPageNo(params.get("article_pages_start"), params.get("article_pages_end")) : null, params.get("note"), params.get("reference_id")));
                break;
            case "book":
                allReferences.add(new Book(params.get("title"), new Author(params.get("author")), params.get("book_publisher"), params.get("year"), params.get("book_month"), params.get("book_edition"), params.get("book_volume"), params.get("book_series"), params.get("book_address"), params.get("book_note"), params.get("reference_id")));
                break;
            case "inproceedings":
                allReferences.add(new Inproceedings(params.get("title"), new Author(params.get("author")), params.get("inproceedings_book_title"), params.get("year"), params.get("inproceedings_month"), params.get("inproceedings_editor"), params.get("inproceedings_volume"), params.get("inproceedings_series"), params.get("inproceedings_pages_start").length() > 0 ? formPageNo(params.get("inproceedings_pages_start"), params.get("inproceedings_pages_end")) : null, params.get("inproceedings_organization"), params.get("inproceedings_publisher"), params.get("inproceedings_address"), params.get("inproceedings_note"), params.get("reference_id")));
                break;
        }
    }
    
    private String formPageNo(String start, String end) {
        return start + "-" + end;
    }
}

