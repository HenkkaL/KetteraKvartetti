/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.domain.factories;

import java.util.List;
import java.util.Map;
import refApp.domain.Article;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Reference;
import refApp.domain.Tag;

/**
 *
 * @author pyykkomi
 */
public class ReferenceFactory {

    public Reference create(String type, Map<String, String> params, String id, List<Tag> tags, List<Author> authors) {
        switch (type.toLowerCase()) {
            case "article":
                return new Article(
                        params.get("title"),
                        authors,
                        params.get("journal"),
                        params.get("year"),
                        params.get("month"),
                        params.get("volume"),
                        params.get("number"),
                        params.get("pages_start").length() > 0 ? formPageNo(params.get("pages_start"),
                                        params.get("pages_end")) : "",
                        params.get("note"),
                        id,
                        tags);
            case "book":
                return new Book(params.get("title"),
                        authors,
                        params.get("publisher"),
                        params.get("year"),
                        params.get("month"),
                        params.get("edition"),
                        params.get("volume"),
                        params.get("series"),
                        params.get("address"),
                        params.get("note"),
                        id,
                        tags);
            case "inproceedings":
                return new Inproceedings(params.get("title"),
                        authors,
                        params.get("book_title"),
                        params.get("year"),
                        params.get("month"),
                        params.get("editor"),
                        params.get("volume"), 
                        params.get("series"), 
                        params.get("pages_start").length() > 0 ? formPageNo(params.get("pages_start"), 
                        params.get("pages_end")) : "", 
                        params.get("organization"), 
                        params.get("publisher"), 
                        params.get("address"), 
                        params.get("note"), 
                        id, 
                        tags);
            default:
                throw new UnsupportedOperationException("Unsupported format");
        }
    }

    private String formPageNo(String start, String end) {
        return start + "-" + end;
    }

}
